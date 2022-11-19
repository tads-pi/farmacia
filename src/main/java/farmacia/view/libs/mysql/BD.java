package farmacia.view.libs.mysql;

import java.sql.*;

public class BD {

    private Environment env = new Environment();

    public Connection c = null;
    private final String driver = "com.mysql.jdbc.Driver";
    private final String dbname = env.getDatabase();
    private final String url = "jdbc:mysql://" + env.getRoute() + "/" + dbname;
    private final String login = env.getUser();
    private final String senha = env.getPassword();

    public boolean getConnection() {
        try {
            Class.forName(driver);
            c = DriverManager.getConnection(url, login, senha);
            return true;
        } catch (ClassNotFoundException erro) {
            close();
            System.out.println("Driver não encontrado\n" + erro.toString());
            return false;
        } catch (SQLException erro) {
            close();
            System.out.println("Problema de conexão com a fonte de dados\n" + erro.toString());
            return false;
        }

    }

    public void close() {
        try {
            if (c != null) {
                c.close();
                System.out.println("jdbc desconectado com sucesso.");
            }
        } catch (SQLException erro) {
            System.out.println("erro desconectando: " + erro);
        }
    }

}
