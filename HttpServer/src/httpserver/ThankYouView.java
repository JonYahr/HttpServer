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


public class ThankYouView implements View{
    
    AddressModel am = null;
    
    public ThankYouView(AddressModel am){
        this.am = am;
    }
    
    @Override
    public String makeHTML() {
        
        String html = "<html><body>";
        
        html += "Thank you, " + am.name + "!";
        
        html += "</html></body>";
        
        return html;
    }
    
}

