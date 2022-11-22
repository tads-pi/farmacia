/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.view.libs.mysql.dao;

import farmacia.view.classes.Produto;
import farmacia.view.interfaces.IDao;
import farmacia.view.libs.mysql.BD;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author kcalixto
 */
public class ProdutosDAO implements IDao {

    public Produto produto;
    public BD bd;
    private PreparedStatement st;
    private ResultSet rs;
    private String sql;

    public static final String TABLE_NAME = "tb_produto";

    public ProdutosDAO() {
        bd = new BD();
        produto = new Produto();
    }

    /**
     * @return todos os produtos
     */
    public ArrayList<Produto> findAll() {
        ArrayList<Produto> response = new ArrayList<>();
        sql = "select * from " + TABLE_NAME + " WHERE ativo ORDER BY nome;";
        try {
            if (bd.getConnection()) {
                st = bd.c.prepareStatement(sql);

                rs = st.executeQuery();
                while (rs.next()) {
                    Produto p = new Produto(
                            rs.getInt("id_produto"),
                            rs.getString("nome"),
                            rs.getDouble("valor_unitario"),
                            rs.getString("tipo_de_produto"),
                            rs.getDate("criado_em"),
                            rs.getDate("atualizado_em"),
                            rs.getBoolean("ativo"));
                    response.add(p);
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
     * @param nome
     * @return todos os produtos com nome parecido com o param informado
     */
    public Produto findByNome(String nome) {
        Produto produto = new Produto();
        sql = "select * from " + TABLE_NAME + " WHERE ativo AND nome LIKE %?% ORDER BY nome;";
        try {
            if (bd.getConnection()) {
                st = bd.c.prepareStatement(sql);

                st.setString(1, nome);

                rs = st.executeQuery();
                while (rs.next()) {
                    produto = new Produto(
                            rs.getInt("id_produto"),
                            rs.getString("nome"),
                            rs.getDouble("valor_unitario"),
                            rs.getString("tipo_de_produto"),
                            rs.getDate("criado_em"),
                            rs.getDate("atualizado_em"),
                            rs.getBoolean("ativo"));
                }
                ;

                return produto;
            }
            return produto;
        } catch (SQLException erro) {
            System.out.println("error: " + erro.getMessage());
            bd.close();
            return produto;
        }
    }

    /**
     * @param id
     * @return produto pelo id
     */
    public Produto findById(int id) {
        Produto produto = new Produto();
        sql = "select * from " + TABLE_NAME + " WHERE ativo AND id_produto = ?;";
        try {
            if (bd.getConnection()) {
                st = bd.c.prepareStatement(sql);

                st.setInt(1, id);

                rs = st.executeQuery();
                while (rs.next()) {
                    produto = new Produto(
                            rs.getInt("id_produto"),
                            rs.getString("nome"),
                            rs.getDouble("valor_unitario"),
                            rs.getString("tipo_de_produto"),
                            rs.getDate("criado_em"),
                            rs.getDate("atualizado_em"),
                            rs.getBoolean("ativo"));
                }
                ;

                return produto;
            }
            return produto;
        } catch (SQLException erro) {
            System.out.println("error: " + erro.getMessage());
            bd.close();
            return produto;
        }
    }

    /**
     * Pode executar ações de INSERT, UPDATE e DELETE para o Produto informado
     * @param p objeto da operação
     * @param op número da operação que deve executar
     * @see farmacia.view.interfaces.IDao variáveis das operações
     * @return id do Produto em caso de INSERT
     */
    public int execute(Produto p, int op) {
        try {
            if (bd.getConnection()) {
                if (op == INSERT) {
                    sql = "INSERT INTO " + TABLE_NAME + " (nome, valor_unitario, tipo_de_produto) values (?,?,?)";
                    st = bd.c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                    st.setString(1, p.getNome());
                    st.setDouble(2, p.getValorUnitario());
                    st.setString(3, p.getTipoDeProduto());

                } else if (op == UPDATE) {
                    sql = "UPDATE " + TABLE_NAME
                            + " set nome = ?, valor_unitario = ?, tipo_de_produto = ? WHERE id_produto = ?";
                    st = bd.c.prepareStatement(sql);

                    st.setString(1, p.getNome());
                    st.setDouble(2, p.getValorUnitario());
                    st.setString(3, p.getTipoDeProduto());
                    st.setInt(4, p.getId());

                } else if (op == DELETE) {
                    sql = "UPDATE " + TABLE_NAME + " SET ativo = 0 WHERE id_produto = ?";
                    st = bd.c.prepareStatement(sql);
                    st.setInt(1, p.getId());
                }
                if (st.executeUpdate() == 0) {
                    System.out.println("error: operation failed");
                }

                try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        Long longId = generatedKeys.getLong(1);
                        p.setId(longId.intValue());
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
        return p.getId();
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