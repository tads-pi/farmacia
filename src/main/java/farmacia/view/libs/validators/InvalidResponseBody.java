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

    /**
     * Adiciona uma string de campo inválido na lista
     * 
     * @param name
     */
    public void addErrorField(String name){
        this.FIELDS.add(name);
    }
    
    /**
     * Trata ArrayList<String> de campos inválidos para o front-end 
     * | Variação: {@link #getLabeledErrorFields()} utiliza <br> ao invés de \n para quebrar a linha
     * 
     * @return String contendo todos os campos inválidos tratados para o front-end
     */
    public String getErrorFields(){
        String str = "Campos Inválidos:\n";
        
        for(String s : this.FIELDS){
            str += "- "+s;
            str += "\n";
        }
        
        return str;
    }
    
    /**
     * Trata ArrayList<String> de campos inválidos para o front-end
     * | Variação: {@link #getErrorFields()} utiliza \n ao invés de <br> para quebrar a linha
     * 
     * @return String contendo todos os campos inválidos tratados para o front-end
     */
    public String getLabeledErrorFields(){
        String str = "Campos Inválidos:<br>";
        
        for(String s : this.FIELDS){
            str += "- "+s;
            str += "<br>";
        }
        
        return "<html><body>"+str+"<body><html>";
    }
    
    /**
     * Verifica se existem erros
     * 
     * @return boolean
     */
    public boolean haveErrors(){
        return this.FIELDS.size() > 0;
    }
}
