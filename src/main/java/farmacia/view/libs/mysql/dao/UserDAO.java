/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.view.libs.mysql.dao;

import farmacia.view.entities.User;
import farmacia.view.libs.mysql.BD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author kcalixto
 */
public class UserDAO {

    public User user;
    public BD bd;
    private PreparedStatement st;
    private ResultSet rs;
    private String sql;
    public static final byte INSERT = 1;
    public static final byte UPDATE = 2;
    public static final byte DELETE = 3;

    private static final String TABLE_NAME = "tb_users";

    public UserDAO() {
        bd = new BD();
        user = new User();
    }

    public ArrayList<User> findAll() {
        ArrayList<User> response = new ArrayList<>();
        sql = "select * from " + TABLE_NAME + ";";
        try {
            if (bd.getConnection()) {
                st = bd.c.prepareStatement(sql);

                rs = st.executeQuery();
                while (rs.next()) {
                    User u = new User(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("cpf"),
                            rs.getString("birth_date"),
                            rs.getString("contact_number"),
                            rs.getString("gender"),
                            rs.getString("address"),
                            rs.getString("marital_status"));
                    response.add(u);
                }
                ;

                return response;
            }
            return response;
        } catch (SQLException erro) {
            System.out.println("error: " + erro.getMessage());
            bd.close();
            System.exit(0);
            return response;
        }
    }

    public User findByCpf(String cpf) {
        User user = new User();
        sql = "select * from " + TABLE_NAME + " where cpf = ?;";
        try {
            if (bd.getConnection()) {
                st = bd.c.prepareStatement(sql);

                st.setString(1, cpf);

                rs = st.executeQuery();
                while (rs.next()) {
                    user = new User(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("cpf"),
                            rs.getString("birth_date"),
                            rs.getString("contact_number"),
                            rs.getString("gender"),
                            rs.getString("address"),
                            rs.getString("marital_status"));
                }
                ;

                return user;
            }
            return user;
        } catch (SQLException erro) {
            System.out.println("error: " + erro.getMessage());
            bd.close();
            System.exit(0);
            return user;
        }
    }

    public void execute(User u, int op) {
        try {
            if (bd.getConnection()) {
                if (op == INSERT) {
                    sql = "insert into " + TABLE_NAME
                            + "(name, email, cpf, address, contact_number, gender, marital_status, birth_date) values (?,?,?,?,?,?,?,STR_TO_DATE(?, \"%m/%d/%Y\"))";
                    st = bd.c.prepareStatement(sql);

                    st.setString(1, u.getName());
                    st.setString(2, u.getEmail());
                    st.setString(3, u.getCpf());
                    st.setString(4, u.getAddress());
                    st.setString(5, u.getContactNumber());
                    st.setString(6, u.getGender());
                    st.setString(7, u.getMaritalStatus());
                    st.setString(8, u.getBirthDateString());

                } else if (op == UPDATE) {
                    sql = "update " + TABLE_NAME
                            + " set name = ?, email = ?, cpf = ?, address = ?, contact_number = ?, gender = ?, marital_status = ?, birth_date = STR_TO_DATE(?, \"%m/%d/%Y\") where id = ?";
                    st = bd.c.prepareStatement(sql);

                    st.setString(1, u.getName());
                    st.setString(2, u.getEmail());
                    st.setString(3, u.getCpf());
                    st.setString(4, u.getAddress());
                    st.setString(5, u.getContactNumber());
                    st.setString(6, u.getGender());
                    st.setString(7, u.getMaritalStatus());
                    st.setString(8, u.getBirthDateString());
                    st.setInt(9, u.getId());

                } else if (op == DELETE) {
                    sql = "delete from " + TABLE_NAME + " where id = ?";
                    st = bd.c.prepareStatement(sql);
                    st.setInt(1, u.getId());
                }
                if (st.executeUpdate() == 0) {
                    System.out.println("error: operation failed");
                }
                System.out.println("sql done.");
            }
        } catch (SQLException e) {
            System.out.println("error: " + e.getMessage());
            System.exit(0);
            bd.close();
        }
    }

    public void close() {
        if (bd.getConnection()) {
            bd.close();
        }
    }
}
