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
public class Settings {
    private static int MERKLE_REFRESH_INTERVAL;
    private static int PREVHASH_REFRESH_INTERVAL;
    
    public static int getMerkleRefreshInterval(){
        return MERKLE_REFRESH_INTERVAL;
    }
    public static int getPrevhashRefreshInterval(){
        return PREVHASH_REFRESH_INTERVAL;
    }
}
