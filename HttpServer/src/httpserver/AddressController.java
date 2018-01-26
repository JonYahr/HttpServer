/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package httpserver;

/**
 *
 * @author Jon
 */
public class AddressController {
    
    AddressListModel database;
    
    public AddressController(AddressListModel database){
        
        this.database = database;
        
    }
    
    public View respondToLocationRequest (HttpRequest request){
        
        View view = null;
        if (request.location.equals("/address")){
            
            if(request.params.isEmpty()){
                view = new AddressView(null);
            }else{
                AddressModel am = new AddressModel();
                am.name = request.params.getOrDefault("name", "");
                
                am.street = request.params.getOrDefault("street", "");
                
                am.zipCode = new Integer(request.params.getOrDefault("zipCode", "0"));
                
                am.state = request.params.getOrDefault("state", "");
                
                if(am.isValid()){
                    database.add(am);
                    view = new ThankYouView(am);
                }else{
                    
                }
                
                view = new AddressView(null);
            }
        }
        return view;
    }
}
