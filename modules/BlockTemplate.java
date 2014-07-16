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
public class BlockTemplate {
    private final int JOBID;
    private final Coinbaser COINBASER;

    public BlockTemplate(Coinbaser coinbaser, int jobID) {
        COINBASER = coinbaser;
        JOBID = jobID;
    }
    
    public void fill_from_rpc(JsonObject data){
        
    }
    
}
