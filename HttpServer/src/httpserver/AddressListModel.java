/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package httpserver;

import java.util.ArrayList;

/**
 *
 * @author Jon
 */
public class AddressListModel {
    
    public ArrayList<AddressModel> database;
    
    public AddressListModel (){
        database = new ArrayList<AddressModel>();
    }
    
    public void add(AddressModel model){
        database.add(model);
    }
    
}
