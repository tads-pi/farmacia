package farmacia.view.libs.mysql.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import farmacia.view.classes.Cliente;
import farmacia.view.interfaces.IDao;
import farmacia.view.libs.mysql.BD;

public class ClienteDAO implements IDao{

    public Cliente cliente;
    public BD bd;
    private PreparedStatement st;
    private ResultSet rs;
    private String sql;

    public static final String TABLE_NAME = "tb_cliente";

    public ClienteDAO() {
        bd = new BD();
        cliente = new Cliente();
    }

    /**
     * @return todos os clientes
     */
    public ArrayList<Cliente> findAll() {
        ArrayList<Cliente> response = new ArrayList<>();
        sql = "select * from " + TABLE_NAME + ";";
        try {
            if (bd.getConnection()) {
                st = bd.c.prepareStatement(sql);

                rs = st.executeQuery();
                while (rs.next()) {
                    Cliente c = new Cliente(
                            rs.getInt("id_cliente"),
                            rs.getString("nome"),
                            rs.getString("cpf"),
                            rs.getString("endereco"),
                            rs.getString("numero_de_telefone"),
                            rs.getString("email"),
                            rs.getString("genero"),
                            rs.getString("estado_civil"),
                            rs.getString("data_de_nascimento"),
                            rs.getDate("criado_em"),
                            rs.getDate("atualizado_em"),
                            rs.getBoolean("ativo")
                    );
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

    /**
     * @param id
     * @return cliente pelo id
     */
    public Cliente findById(int id) {
        Cliente cliente = new Cliente();
        sql = "SELECT * FROM " + TABLE_NAME + " WHERE ativo AND id_cliente = ?;";
        try {
            if (bd.getConnection()) {
                st = bd.c.prepareStatement(sql);

                st.setInt(1, id);

                rs = st.executeQuery();
                while (rs.next()) {
                    cliente = new Cliente(
                            rs.getInt("id_cliente"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("cpf"),
                            rs.getString("endereco"),
                            rs.getString("numero_de_telefone"),
                            rs.getString("genero"),
                            rs.getString("estado_civil"),
                            rs.getString("data_de_nascimento"),
                            rs.getDate("criado_em"),
                            rs.getDate("atualizado_em"),
                            rs.getBoolean("ativo")
                    );
                }
                ;

                return cliente;
            }
            return cliente;
        } catch (SQLException erro) {
            System.out.println("error: " + erro.getMessage());
            bd.close();
            return cliente;
        }
    }
    
    /**
     * @param cpf
     * @return cliente pelo cpf
     */
    public Cliente findByCpf(String cpf) {
        Cliente cliente = new Cliente();
        sql = "SELECT * FROM " + TABLE_NAME + " WHERE ativo AND cpf = ?;";
        try {
            if (bd.getConnection()) {
                st = bd.c.prepareStatement(sql);

                st.setString(1, cpf);

                rs = st.executeQuery();
                while (rs.next()) {
                    cliente = new Cliente(
                            rs.getInt("id_cliente"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("cpf"),
                            rs.getString("endereco"),
                            rs.getString("numero_de_telefone"),
                            rs.getString("genero"),
                            rs.getString("estado_civil"),
                            rs.getString("data_de_nascimento"),
                            rs.getDate("criado_em"),
                            rs.getDate("atualizado_em"),
                            rs.getBoolean("ativo")
                    );
                }
                ;

                return cliente;
            }
            return cliente;
        } catch (SQLException erro) {
            System.out.println("error: " + erro.getMessage());
            bd.close();
            return cliente;
        }
    }

    /**
     * Pode executar ações de INSERT, UPDATE e DELETE para o cliente informado
     * @param c objeto da operação
     * @param op número da operação que deve executar 
     * @see farmacia.view.interfaces.IDao variáveis das operações
     */
    public void execute(Cliente c, int op) {
        try {
            if (bd.getConnection()) {
                if (op == INSERT) {
                    sql = "INSERT INTO " + TABLE_NAME+ " (nome, email, cpf, endereco, numero_de_telefone, genero, estado_civil, data_de_nascimento) values (?,?,?,?,?,?,?,STR_TO_DATE(?, \"%d/%m/%Y\"))";
                    st = bd.c.prepareStatement(sql);

                    st.setString(1, c.getNome());
                    st.setString(2, c.getEmail());
                    st.setString(3, c.getCpf());
                    st.setString(4, c.getEndereco());
                    st.setString(5, c.getNumeroDeTelefone());
                    st.setString(6, c.getGenero());
                    st.setString(7, c.getEstadoCivil());
                    st.setString(8, c.getDataDeNascimento());

                } else if (op == UPDATE) {
                    sql = "UPDATE " + TABLE_NAME
                            + " set nome = ?, email = ?, cpf = ?, endereco = ?, numero_de_telefone = ?, genero = ?, estado_civil = ?, data_de_nascimento = STR_TO_DATE(?, \"%d/%m/%Y\"), ativo = ? where id_cliente = ?";
                    st = bd.c.prepareStatement(sql);

                    st.setString(1, c.getNome());
                    st.setString(2, c.getEmail());
                    st.setString(3, c.getCpf());
                    st.setString(4, c.getEndereco());
                    st.setString(5, c.getNumeroDeTelefone());
                    st.setString(6, c.getGenero());
                    st.setString(7, c.getEstadoCivil());
                    st.setString(8, c.getDataDeNascimento());
                    int ativo = 0;
                    if(c.isAtivo()) ativo = 1;
                    st.setInt(9, ativo);
                    st.setInt(10, c.getId());

                } else if (op == DELETE) {
                    sql = "UPDATE " + TABLE_NAME + " SET ativo = 0 WHERE id_cliente = ?";
                    st = bd.c.prepareStatement(sql);
                    st.setInt(1, c.getId());
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
