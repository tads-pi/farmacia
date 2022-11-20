package farmacia.view.libs.mysql;

import java.sql.*;

public class BD {
    public Connection c = null;
    private final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://" + Environment.route + "/" + Environment.databaseName;
    private final String login = Environment.user;
    private final String senha = Environment.password;

    /**
     * Verifica se existe conexão o com banco de dados
     * 
     * @return boolean
     */
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

    /**
     * Desliga conexão com o banco de dados
     */
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
