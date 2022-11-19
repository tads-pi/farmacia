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

    private String ip = "127.0.0.1";
    private String database = "db_farmacia";
    private String user = "root";
    private String password = "secret";
    private String port = "3306";

    public Environment() {}

    public String getRoute() {
        return ip + ":" + port;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}