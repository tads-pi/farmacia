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

    private String ip = "52.67.74.131";
    private String database = "db_farmacia";

    public static final String DEVELOPMENT = "dev";
    public static final String PRODUCTION = "prod";

    private Config cfg;

    public Environment(String env) {
        loadEnv(env);
    }

    public Environment() {
        // boolean isProduction = System.getenv("ENV") != null;
        // if (isProduction) {
            loadEnv(Environment.PRODUCTION);
        // } else {
        //     loadEnv(Environment.DEVELOPMENT);
        // }
    }

    public void loadEnv(String env) {
        try {
            Config c = new Config();
            if (env.equals(DEVELOPMENT)) {
                c = new Config(
                        "dev",
                        "password",
                        "3307"
                );
            }

            this.cfg = c;
        } catch (Exception e) {
            System.out.println("error at config env: " + e);
        }
    }

    public String getIp() {
        return ip + ":" + getCfg().getPort();
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public Config getCfg() {
        return cfg;
    }
}
