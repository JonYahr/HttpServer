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
public class AddressView implements View{
    
    AddressModel am = null;
    
    public AddressView (AddressModel am){
        this.am = am;
    }
    
    @Override
    public String makeHTML (){
        
        String html = "";
        
        if(am == null){
        
            html = "<html><body><form submit='/submit'>"
                        + "Name: <input type='text' name='name'><br>"
                        + "Street: <input type='text' name='street'><br>"
                        + "State: <input type='text' name='state'><br>"
                        + "Zip: <input type='text' name='zip'><br>"
                        + "<input type='submit' value='Submit'><br>"
                        + "</form>"
                        + "</body></html>";
        }else{
            //populate with am information
        }
        
        
        return html;
    }
    
}
