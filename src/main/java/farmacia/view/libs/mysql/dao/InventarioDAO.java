package farmacia.view.libs.mysql.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import farmacia.view.classes.Inventario;
import farmacia.view.classes.Produto;
import farmacia.view.interfaces.IDao;
import farmacia.view.libs.mysql.BD;

public class InventarioDAO implements IDao {

    public Inventario inventario;
    public BD bd;
    private PreparedStatement st;
    private ResultSet rs;
    private String sql;

    private static final String TABLE_NAME = "tb_inventario";

    public InventarioDAO() {
        bd = new BD();
        inventario = new Inventario();
    }

    public ArrayList<Inventario> findAll() {
        ArrayList<Inventario> response = new ArrayList<>();
        sql = "SELECT * FROM " + TABLE_NAME + " WHERE ativo;";
        try {
            if (bd.getConnection()) {
                st = bd.c.prepareStatement(sql);

                rs = st.executeQuery();
                while (rs.next()) {
                    Produto produto = new Produto();
                    produto.setId(rs.getInt("id_produto"));

                    Inventario i = new Inventario(
                            rs.getInt("id_inventario"),
                            produto,
                            rs.getDouble("quantidade"),
                            rs.getDate("criado_em"),
                            rs.getDate("atualizado_em"),
                            rs.getBoolean("ativo"));
                    response.add(i);
                }
                ;

                return response;
            }
            return response;
        } catch (SQLException erro) {
            System.out.println("error: " + erro.getMessage());
            bd.close();
            return response;
        }
    }

    public Inventario findById(int id) {
        Inventario inventario = new Inventario();
        sql = "SELECT * FROM " + TABLE_NAME + " WHERE ativo AND id_inventario = ?;";
        try {
            if (bd.getConnection()) {
                st = bd.c.prepareStatement(sql);

                st.setInt(1, id);

                rs = st.executeQuery();
                while (rs.next()) {
                    Produto produto = new Produto();
                    produto.setId(rs.getInt("id_produto"));

                    inventario = new Inventario(
                            rs.getInt("id_inventario"),
                            produto,
                            rs.getDouble("quantidade"),
                            rs.getDate("criado_em"),
                            rs.getDate("atualizado_em"),
                            rs.getBoolean("ativo"));
                }
                ;

                return inventario;
            }
            return inventario;
        } catch (SQLException erro) {
            System.out.println("error: " + erro.getMessage());
            bd.close();
            return inventario;
        }
    }

    public Inventario findByIdProduto(int idProduto) {
        Inventario inventario = new Inventario();
        sql = "SELECT * FROM " + TABLE_NAME + " WHERE ativo AND id_produto = ?;";
        try {
            if (bd.getConnection()) {
                st = bd.c.prepareStatement(sql);

                st.setInt(1, idProduto);

                rs = st.executeQuery();
                while (rs.next()) {
                    Produto produto = new Produto();
                    produto.setId(rs.getInt("id_produto"));

                    Inventario i = new Inventario(
                            rs.getInt("id_inventario"),
                            produto,
                            rs.getDouble("quantidade"),
                            rs.getDate("criado_em"),
                            rs.getDate("atualizado_em"),
                            rs.getBoolean("ativo"));
                }
                ;

                return inventario;
            }
            return inventario;
        } catch (SQLException erro) {
            System.out.println("error: " + erro.getMessage());
            bd.close();
            return inventario;
        }
    }

    public void execute(Inventario i, int op) {
        try {
            if (bd.getConnection()) {
                if (op == INSERT) {
                    sql = "INSERT INTO " + TABLE_NAME + " (id_produto, quantidade) values (?,?)";
                    st = bd.c.prepareStatement(sql);

                    st.setInt(1, i.getProduto().getId());
                    st.setDouble(2, i.getQuantidade());

                } else if (op == UPDATE) {
                    sql = "UPDATE " + TABLE_NAME + " set id_produto = ?, quantidade = ? where id_inventario = ?";
                    st = bd.c.prepareStatement(sql);

                    st.setInt(1, i.getProduto().getId());
                    st.setDouble(2, i.getQuantidade());
                    st.setInt(3, i.getId());

                } else if (op == DELETE) {
                    sql = "UPDATE " + TABLE_NAME + " SET ativo = 0 WHERE id_inventario = ?";
                    st = bd.c.prepareStatement(sql);
                    st.setInt(1, i.getId());
                }
                if (st.executeUpdate() == 0) {
                    System.out.println("error: operation failed");
                }
                System.out.println("sql done.");
            }
        } catch (SQLException e) {
            System.out.println("error: " + e.getMessage());
            bd.close();
        }
    }

    public void close() {
        if (bd.getConnection()) {
            bd.close();
        }
    }
}
