/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package httpserver;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jon
 */
public class HttpRequest {
    
    String type;
    String protocol;
    String url;
    String location;
    Map<String, String> params;
    
    static HttpRequest fromString(String incomingRequestString){
        
        //SPLITS APART THE URL
        
        incomingRequestString.split(" ");
        
        String[] components = incomingRequestString.split("");
        
        if(components.length != 3){
            return null;
        }
        
        HttpRequest req = new HttpRequest();
        
        req.type = components[0];
        req.url = components[1];
        req.protocol = components[2];
        req.params = new HashMap<String, String>();
        
        //THIS IS WHERE YOU SPLIT THINGS UP
        
        if(req.url.indexOf("?") >= 0){
            String params = req.url.substring(req.url.indexOf("?") + 1);
            req.params = new HashMap<String, String>();
            for(String pair : params.split("=")){
                String[] keyVal = pair.split("=");
                if(keyVal.length == 2){
                    req.params.put(keyVal[0], keyVal[1]);
                }
            }
        }
        
        return req;
        
    }
    
}
