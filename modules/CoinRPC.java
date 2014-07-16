/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modules;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author Danny
 */
public class CoinRPC {
    private String host;
    private String port;
    
    // TODO: Impliment correct methods
    public String getPrevhash(){        
        JsonObject obj = call_json("");         
        return obj.getJsonArray("data").getString(0, "");
    }
    public JsonObject getBlockTemplate(){
        JsonObject obj = call_json("");        
        return obj;
    }
    
    // TODO: Replace with JSON-RPC stuff
    private JsonObject call_json(String method, String params){
        JsonObject obj = null;
        URL url;
        
        // Build the URL to open
        // TODO: Move this to a better place
        try{
            url = new URL("http://" + host + ":" + port + "/" + method + params);
        }
        catch(MalformedURLException e){
            url = null;
        }
        
        try (InputStream is = url.openStream()){            
            JsonReader rdr = Json.createReader(is);
            obj = rdr.readObject();            
        }
        catch(Exception e){
            
        }
        return obj;        
    }
    private JsonObject call_json(String method){
        return call_json(method, "");
    }
}
