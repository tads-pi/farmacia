package farmacia.view.libs.mysql.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import farmacia.view.classes.Funcionario;
import farmacia.view.interfaces.IDao;
import farmacia.view.libs.mysql.BD;

public class FuncionarioDAO implements IDao {
    public Funcionario funcionario;
    public BD bd;
    private PreparedStatement st;
    private ResultSet rs;
    private String sql;

    public static final String TABLE_NAME = "tb_funcionario";

    public FuncionarioDAO() {
        bd = new BD();
        funcionario = new Funcionario();
    }

    /**
     * @return todos os funcionarios
     */
    public ArrayList<Funcionario> findAll() {
        ArrayList<Funcionario> response = new ArrayList<>();
        sql = "SELECT * FROM " + TABLE_NAME + ";";
        try {
            if (bd.getConnection()) {
                st = bd.c.prepareStatement(sql);

                rs = st.executeQuery();
                while (rs.next()) {
                    Funcionario c = new Funcionario(
                            rs.getInt("id_funcionario"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("cpf"),
                            rs.getString("cargo"),
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
     * @return funcionario pelo id
     */
    public Funcionario findById(int id) {
        Funcionario funcionario = new Funcionario();
        sql = "SELECT * FROM " + TABLE_NAME + " WHERE ativo AND id_funcionario = ?;";
        try {
            if (bd.getConnection()) {
                st = bd.c.prepareStatement(sql);

                st.setInt(1, id);

                rs = st.executeQuery();
                while (rs.next()) {
                    funcionario = new Funcionario(
                            rs.getInt("id_funcionario"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("cpf"),
                            rs.getString("cargo"),
                            rs.getDate("criado_em"),
                            rs.getDate("atualizado_em"),
                            rs.getBoolean("ativo")
                    );
                }
                ;

                return funcionario;
            }
            return funcionario;
        } catch (SQLException erro) {
            System.out.println("error: " + erro.getMessage());
            bd.close();
            return funcionario;
        }
    }
    
    /**
     * @param cpf
     * @return funcionario pelo cpf
     */
    public Funcionario findByCpf(String cpf) {
        Funcionario funcionario = new Funcionario();
        sql = "SELECT * FROM " + TABLE_NAME + " WHERE ativo AND cpf = ?;";
        try {
            if (bd.getConnection()) {
                st = bd.c.prepareStatement(sql);

                st.setString(1, cpf);

                rs = st.executeQuery();
                while (rs.next()) {
                    funcionario = new Funcionario(
                            rs.getInt("id_funcionario"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("cpf"),
                            rs.getString("cargo"),
                            rs.getDate("criado_em"),
                            rs.getDate("atualizado_em"),
                            rs.getBoolean("ativo")
                    );
                }
                ;

                return funcionario;
            }
            return funcionario;
        } catch (SQLException erro) {
            System.out.println("error: " + erro.getMessage());
            bd.close();
            return funcionario;
        }
    }

    /**
     * Pode executar ações de INSERT, UPDATE e DELETE para o funcionario informado
     * @param c objeto da operação
     * @param op número da operação que deve executar 
     * @see farmacia.view.interfaces.IDao variáveis das operações
     */
    public void execute(Funcionario c, int op) {
        try {
            if (bd.getConnection()) {
                if (op == INSERT) {
                    sql = "INSERT INTO " + TABLE_NAME+ " (nome, email, cpf, cargo) values (?,?,?,?)";
                    st = bd.c.prepareStatement(sql);

                    st.setString(1, c.getNome());
                    st.setString(2, c.getEmail());
                    st.setString(3, c.getCpf());
                    st.setString(4, c.getCargo());

                } else if (op == UPDATE) {
                    sql = "UPDATE " + TABLE_NAME
                            + " set nome = ?, email = ?, cpf = ?, cargo = ?, ativo = ? where id_funcionario = ?";
                    st = bd.c.prepareStatement(sql);

                    st.setString(1, c.getNome());
                    st.setString(2, c.getEmail());
                    st.setString(3, c.getCpf());
                    st.setString(4, c.getCargo());
                    int ativo = 0;
                    if(c.isAtivo()) ativo = 1;
                    st.setInt(5, ativo);
                    st.setInt(6, c.getId());

                } else if (op == DELETE) {
                    sql = "UPDATE " + TABLE_NAME + " SET ativo = 0 WHERE id_funcionario = ?";
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


