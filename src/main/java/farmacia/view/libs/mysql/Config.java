/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.view.libs.mysql;

/**
 *
 * @author kcalixto
 */
public class Config {
    private String user;
    private String password;
    private String port = "3306";
    
    public Config(){
        this.user = "root";
        this.password = "secret";
    }
    
    public Config(
            String user,
            String password,
            String port
    ){
        this.user = user;
        this.password = password;
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getPort() {
        return port;
    }
}
