/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.view.libs.mysql.dao;

import farmacia.view.classes.Venda;
import farmacia.view.interfaces.IDao;
import farmacia.view.libs.mysql.BD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author kcalixto
 */
public class SellingsHistoryDAO implements IDao {

    public BD bd;
    private PreparedStatement st;
    private ResultSet rs;
    private String sql;

    public SellingsHistoryDAO() {
        bd = new BD();
    }

    public SellingsHistoryDAO(BD bd) {
        this.bd = bd;
    }

    public ArrayList<Venda> findAll() {
        ArrayList<Venda> response = new ArrayList<>();
        sql = "select * from " + Venda.TABLE_NAME + ";";
        try {
            if (bd.getConnection()) {
                st = bd.c.prepareStatement(sql);
                rs = st.executeQuery();
                while (rs.next()) {
                    response.add(new Venda().parseAttributes(rs));
                }
            }
            System.out.println("sql done.");
        } catch (Exception e) {
            bd.close();
            e.printStackTrace();
            System.out.println("error: " + e);
        }
        return response;
    }

    public void execute(Venda object, byte operation) {
        try {
            if (bd.getConnection()) {
                st = bd.c.prepareStatement(object.getQuery(operation));
                object.setStatements(st, operation);
            }
            if (st.executeUpdate() == 0) {
                System.out.println("error: operation failed");
            }
            System.out.println("sql done.");
        } catch (SQLException e) {
            bd.close();
            e.printStackTrace();
            System.out.println("sql-error: " + e);
        } catch (Exception e) {
            bd.close();
            e.printStackTrace();
            System.out.println("error: " + e);
        }
    }

    public void close() {
        if (bd.getConnection()) {
            bd.close();
        }
    }
}
