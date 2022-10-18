/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.view.libs.validators;

import java.util.ArrayList;

/**
 *
 * @author kcalixto
 */
public class InvalidResponseBody {
    private ArrayList<String> FIELDS = new ArrayList<String>();
            
    public void addErrorField(String name){
        this.FIELDS.add(name);
    }
    
    public String getErrorFields(){
        String str = "Campos Inválidos:\n";
        
        for(String s : this.FIELDS){
            str += "- "+s;
            str += "\n";
        }
        
        return str;
    }
    
    public String getLabeledErrorFields(){
        String str = "Campos Inválidos:<br>";
        
        for(String s : this.FIELDS){
            str += "- "+s;
            str += "<br>";
        }
        
        return "<html><body>"+str+"<body><html>";
    }
    
    
    public boolean haveErrors(){
        return this.FIELDS.size() > 0;
    }
}
