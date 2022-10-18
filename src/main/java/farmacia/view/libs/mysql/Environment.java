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
public class Environment {
    private static String env = "dev";
    
    public String getEnv(){
        return this.env;
    }
    
    public boolean isProduction(){
        return env.equals("prod");
    }
}
