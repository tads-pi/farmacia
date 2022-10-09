/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.view.interfaces;

import farmacia.view.entities.User;
import farmacia.view.libs.connection.Connection;

/**
 *
 * @author kcalixto
 */
public class UserData extends javax.swing.JPanel {
    public static User user = new User();
    
    public static void setUser(User user){
        UserData.user = user;
    }
    
    public static void saveCpf(String cpf){
        UserData.user.setCpf(cpf);
    }
    
    public static User getUser(){
        return UserData.user;
    }
    
    public static boolean searchUser(String cpf){
        Connection conn = new Connection();
        User user = conn.getUserByCPF(cpf);
        UserData.user = user;
        
        return !user.isEmpty();      
    }
}
