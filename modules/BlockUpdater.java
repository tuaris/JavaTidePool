/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modules;

import java.util.Date;
import mining.interfaces.TimeStampper;

/**
 *
 * @author Danny
 * 
 * Polls upstream's getinfo() and detecting new block on the network.
 * This will call registry.update_block when new prevhash appear.
 *
 * This is just fail back alternative when something
 * with ./coind -blocknotify will go wrong. 
 */
public class BlockUpdater {
    private final CoinRPC RPC;
    private final TemplateRegistry REGISTRY;

    public BlockUpdater(TemplateRegistry registry, CoinRPC rpc) {
        REGISTRY = registry;
        RPC = rpc;
    }
    
    // Shedules an update to be run later
    protected void schedule(){
        Date next_run = get_next_time();
    }
    
    // Calculates the next run time
    private Date get_next_time(){
        return new Date();
    }
    
    /*
     This is slightly misleading in it's name. It will not always run update.
     It will instead do the following:
     	1) Check if a new block was found on the network
        2) Run an update if a new block was found
    	3) OR, run an update on the transaction refresh interval
    */
    public void Run(){
        boolean doUpdate = false;
        String prevhash;
        String current_prevhash;
        
        try{
            // Get the current prevhash from the pool registry if one exists
            if(REGISTRY.getLastBlock() != null){
                current_prevhash = REGISTRY.getLastBlock().getPrevHash();
            }
            else{
                current_prevhash = null;
            }
            
            // Get the current prevhash from the coin deamon
            prevhash = RPC.getPrevhash();
            prevhash = Util.ReverseHash(prevhash);
            
            // We must have a prevhash
            if (prevhash.isEmpty()){
                throw new Exception("Prevhash is NULL, is coin deamon syncronized to network?");
            }

            /*
             Detects new a block by comparing the new prevhash with the current prevhash
             If a new block is detected, run an update imidietly.
             If no new block is detected, update only if it's time to refresh the transactions (merkele refresh)            
            */
            if (prevhash.equals(current_prevhash)){
                doUpdate = true;
            }
            else if(TimeStampper.getTime() - REGISTRY.getLastUpdate() >= Settings.getMerkleRefreshInterval()){
                doUpdate = true;
            }
            
            // Runs a Block/Getwork update if needed
            if(doUpdate){
                REGISTRY.UpdateBlock();
            }
        }
        catch(Exception e){
            
        }
        finally{
            schedule();
        }
    }
    
}
