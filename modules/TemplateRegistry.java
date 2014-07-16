/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modules;

import javax.json.JsonObject;

/**
 *
 * @author Danny
 */
public class TemplateRegistry {
    private int last_update;
    // TODO: Change this to use a Semaphore
    private boolean update_in_progress;
    private Block last_block;
    private final CoinRPC RPC;

    public TemplateRegistry(CoinRPC rpc) {
        RPC = rpc;
    }
    
    public int getLastUpdate(){
        return this.last_update;
    }
    
    public Block getLastBlock(){
        return this.last_block;
    }
    
    public void UpdateBlock(){
        // Block has been already detected
        if(update_in_progress){return;}
        
        // Ensure we don't run this multiple times at once
        update_in_progress = true;
        last_update = mining.interfaces.TimeStampper.getCurrentUnixTime();
        
        // Do the update
        // TODO: Port event code from Python Callbacks:
        /*
            d = self.bitcoin_rpc.getblocktemplate()
            d.addCallback(self._update_block)
            d.addErrback(self._update_block_failed)
        */
        JsonObject newBlockTemplate = RPC.getBlockTemplate();  
        do_block_update(newBlockTemplate);
    }
    
    private void do_block_update(JsonObject data){
        int start = mining.interfaces.TimeStampper.getCurrentUnixTime();
        
    }
    
    
}
