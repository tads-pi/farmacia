/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.view.libs;

/**
 *
 * @author kcalixto
 */
public class Validators {
    public boolean isValidLogin(String login, char[] password){
        return true;
    }
    
    public boolean isValidCpf(String cpf){
        if(cpf.equals("1")){   
            return false;
        }else{
            return true;
        }
    }
    
    public boolean isRegisteredCPF(String cpf){
        if(cpf.equals("2")){   
            return false;
        }else{
            return true;
        }
    }
}
