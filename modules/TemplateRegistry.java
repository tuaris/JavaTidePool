/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modules;

/**
 *
 * @author Danny
 */
public class TemplateRegistry {
    private int last_update;
    private Block last_block;
    
    public int getLastUpdate(){
        return this.last_update;
    }
    
    public Block getLastBlock(){
        return this.last_block;
    }
    
    public void UpdateBlock(){
        
    }
}
