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

    /**
     * Executa inner join entre as tabelas de inventario e de produto, de forma que
     * o resultado seja um inventário com todos os dados do produto também
     * 
     * @return todos os inventários
     */
    public ArrayList<Inventario> findAll() {
        ArrayList<Inventario> response = new ArrayList<>();
        sql = "SELECT * FROM " + TABLE_NAME + " i INNER JOIN " + ProdutosDAO.TABLE_NAME
                + " p USING(id_produto) WHERE i.ativo AND p.ativo AND i.quantidade > 0;";
        try {
            if (bd.getConnection()) {
                st = bd.c.prepareStatement(sql);

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

                    Inventario i = new Inventario(
                            rs.getInt("id_inventario"),
                            produto,
                            rs.getDouble("quantidade"),
                            rs.getDate("i.criado_em"),
                            rs.getDate("i.atualizado_em"),
                            rs.getBoolean("i.ativo"));
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

    /**
     * Executa inner join entre as tabelas de inventario e de produto, de forma que
     * o resultado seja um inventário com todos os dados do produto também
     * 
     * @param search
     * @return inventario onde o produto.nome é semelhante ao search
     */
    public ArrayList<Inventario> search(String search) {
        ArrayList<Inventario> response = new ArrayList<>();
        sql = "SELECT * FROM " + TABLE_NAME + " i INNER JOIN " + ProdutosDAO.TABLE_NAME
                + " p USING(id_produto) WHERE i.ativo AND p.ativo AND i.quantidade > 0 AND p.nome LIKE ?;";
        System.err.println(sql);
        try {
            if (bd.getConnection()) {
                st = bd.c.prepareStatement(sql);

                st.setString(1, "%" + search + "%");

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

                    Inventario i = new Inventario(
                            rs.getInt("id_inventario"),
                            produto,
                            rs.getDouble("quantidade"),
                            rs.getDate("i.criado_em"),
                            rs.getDate("i.atualizado_em"),
                            rs.getBoolean("i.ativo"));
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

    /**
     * @param id
     * @return inventario pelo id
     */
    public Inventario findById(int id) {
        Inventario inventario = new Inventario();
        sql = "SELECT * FROM " + TABLE_NAME + " WHERE ativo AND quantidade > 0 AND id_inventario = ?;";
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

    /**
     * @param idProduto
     * @return inventario pelo produto.id_produto
     */
    public Inventario findByIdProduto(int idProduto) {
        Inventario inventario = new Inventario();
        sql = "SELECT * FROM " + TABLE_NAME + " WHERE ativo AND quantidade > 0 AND id_produto = ?;";
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

    /**
     * Executa venda do item, subtraindo da tabela de inventario a quantidade
     * vendida
     * 
     * @param idProduto produto.id_produto
     * @param amount    quantidade de produtos vendidos
     */
    public void soldItem(int idProduto, double amount) {
        try {
            if (bd.getConnection()) {
                sql = "UPDATE " + TABLE_NAME + " set quantidade = (quantidade - ?) where id_produto = ?";
                st = bd.c.prepareStatement(sql);

                st.setDouble(1, amount);
                st.setDouble(2, idProduto);

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

    /**
     * Pode executar ações de INSERT, UPDATE e DELETE para o inventario informado
     * 
     * @param i  objeto da operação
     * @param op número da operação que deve executar
     * @see farmacia.view.interfaces.IDao variáveis das operações
     */
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

    /**
     * Desliga conexão com o banco de dados
     */
    public void close() {
        if (bd.getConnection()) {
            bd.close();
        }
    }
}
