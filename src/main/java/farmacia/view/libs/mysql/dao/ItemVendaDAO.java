package farmacia.view.libs.mysql.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import farmacia.view.classes.ItemVenda;
import farmacia.view.classes.Produto;
import farmacia.view.interfaces.IDao;
import farmacia.view.libs.mysql.BD;

public class ItemVendaDAO implements IDao {

    public ItemVenda itemVenda;
    public BD bd;
    private PreparedStatement st;
    private ResultSet rs;
    private String sql;

    private static final String TABLE_NAME = "tb_item_venda";

    public ItemVendaDAO() {
        bd = new BD();
        itemVenda = new ItemVenda();
    }

    public ArrayList<ItemVenda> findAll() {
        ArrayList<ItemVenda> response = new ArrayList<>();
        sql = "SELECT * FROM " + TABLE_NAME + " WHERE ativo;";
        try {
            if (bd.getConnection()) {
                st = bd.c.prepareStatement(sql);

                rs = st.executeQuery();
                while (rs.next()) {
                    Produto produto = new Produto();
                    produto.setId(rs.getInt("id_produto"));

                    ItemVenda c = new ItemVenda(
                            rs.getInt("id_item_venda"),
                            rs.getInt("id_venda"),
                            produto,
                            rs.getDouble("quantidade"),
                            rs.getDouble("valor_unitario"),
                            rs.getDouble("valor_total"),
                            rs.getDate("criado_em"),
                            rs.getDate("atualizado_em"),
                            rs.getBoolean("ativo"));
                    response.add(c);
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

    public ArrayList<ItemVenda> findByIdVenda(int idVenda) {
        ArrayList<ItemVenda> response = new ArrayList<>();
        sql = "SELECT * FROM " + TABLE_NAME + " WHERE ativo AND id_venda = ?;";
        try {
            if (bd.getConnection()) {
                st = bd.c.prepareStatement(sql);

                st.setInt(1, idVenda);

                rs = st.executeQuery();
                while (rs.next()) {
                    Produto produto = new Produto();
                    produto.setId(rs.getInt("id_produto"));

                    ItemVenda c = new ItemVenda(
                            rs.getInt("id_item_venda"),
                            rs.getInt("id_venda"),
                            produto,
                            rs.getDouble("quantidade"),
                            rs.getDouble("valor_unitario"),
                            rs.getDouble("valor_total"),
                            rs.getDate("criado_em"),
                            rs.getDate("atualizado_em"),
                            rs.getBoolean("ativo"));
                    response.add(c);
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

    public ArrayList<ItemVenda> loadReport(int idVenda) {
        ArrayList<ItemVenda> response = new ArrayList<>();
        sql = "SELECT * FROM " + TABLE_NAME + " iv INNER JOIN " + ProdutosDAO.TABLE_NAME
                + " p USING(id_produto) WHERE iv.ativo AND p.ativo AND iv.id_venda = ?;";
        try {
            if (bd.getConnection()) {
                st = bd.c.prepareStatement(sql);

                st.setInt(1, idVenda);

                rs = st.executeQuery();
                while (rs.next()) {
                    Produto produto = new Produto(
                        rs.getInt("id_produto"),
                        rs.getString("nome"),
                        rs.getDouble("valor_unitario"),
                        rs.getString("tipo_de_produto"),
                        rs.getDate("p.criado_em"),
                        rs.getDate("p.atualizado_em"),
                        rs.getBoolean("p.ativo"));

                    ItemVenda c = new ItemVenda(
                            rs.getInt("id_item_venda"),
                            rs.getInt("id_venda"),
                            produto,
                            rs.getDouble("quantidade"),
                            rs.getDouble("valor_unitario"),
                            rs.getDouble("valor_total"),
                            rs.getDate("criado_em"),
                            rs.getDate("atualizado_em"),
                            rs.getBoolean("ativo"));
                    response.add(c);
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

    public int execute(ItemVenda iv, int op) {
        try {
            if (bd.getConnection()) {
                if (op == INSERT) {
                    sql = "INSERT INTO " + TABLE_NAME
                            + " (id_produto, id_venda, quantidade, valor_unitario, valor_total) values (?,?,?,?,?)";
                    st = bd.c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                    st.setInt(1, iv.getProduto().getId());
                    st.setInt(2, iv.getIdVenda());
                    st.setDouble(3, iv.getQuantidade());
                    st.setDouble(4, iv.getValorUnitario());
                    st.setDouble(5, iv.getValorTotal());

                } else if (op == UPDATE) {
                    sql = "UPDATE " + TABLE_NAME
                            + " set id_produto = ?, id_venda = ?, quantidade = ?, valor_unitario = ?, valor_total = ? where id_item_venda= ?";
                    st = bd.c.prepareStatement(sql);

                    st.setInt(1, iv.getProduto().getId());
                    st.setInt(2, iv.getIdVenda());
                    st.setDouble(3, iv.getQuantidade());
                    st.setDouble(4, iv.getValorUnitario());
                    st.setDouble(5, iv.getValorTotal());
                    st.setInt(6, iv.getId());

                } else if (op == DELETE) {
                    sql = "UPDATE " + TABLE_NAME + " SET ativo = 0 WHERE id_item_venda = ?";
                    st = bd.c.prepareStatement(sql);
                    st.setInt(1, iv.getId());
                }
                if (st.executeUpdate() == 0) {
                    System.out.println("error: operation failed");
                }

                try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        Long longId = generatedKeys.getLong(1);
                        iv.setId(longId.intValue());
                    } else {
                        throw new SQLException("Creating user failed, no ID obtained.");
                    }
                }

                System.out.println("sql done.");
            }
        } catch (SQLException e) {
            System.out.println("error: " + e.getMessage());
            bd.close();
        }
        return iv.getId();
    }

    public void close() {
        if (bd.getConnection()) {
            bd.close();
        }
    }
}
