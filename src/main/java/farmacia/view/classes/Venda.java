/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmacia.view.classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import farmacia.view.interfaces.IDao;

/**
 *
 * @author kaua.ccalixto
 */
public class Venda implements IDao {
    private int id;
    private Cliente cliente;
    private ArrayList<ItemVenda> carrinho;
    private double total;
    private Date criadoEm;
    private Date atualizadoEm;
    private boolean ativo;

    public static final String TABLE_NAME = "tb_venda";

    public Venda() {
    }

    public Venda(int id, Cliente cliente, ArrayList<ItemVenda> carrinho, double total, Date criadoEm, Date atualizadoEm,
            boolean ativo) {
        this.id = id;
        this.cliente = cliente;
        this.carrinho = carrinho;
        this.total = total;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
        this.ativo = ativo;
    }

    public Venda(
            int id,
            int id_cliente,
            double total,
            Date criadoEm,
            Date atualizadoEm,
            boolean ativo) {
        this.id = id;
        this.cliente.setId(id_cliente);
        this.total = total;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ItemVenda> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(ArrayList<ItemVenda> carrinho) {
        this.carrinho = carrinho;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getCriadoEm() {
        return this.criadoEm;
    }

    public void setCriadoEm(Date criadoEm) {
        this.criadoEm = criadoEm;
    }

    public Date getAtualizadoEm() {
        return this.atualizadoEm;
    }

    public void setAtualizadoEm(Date atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Venda parseAttributes(ResultSet rs) throws Exception {
        Venda v = new Venda();
        v.id = rs.getInt("id");
        Cliente cliente = new Cliente();
        cliente.setId(rs.getInt("id_cliente"));
        v.setCliente(cliente);
        v.total = rs.getDouble("total");
        v.criadoEm = rs.getDate("criado_em");
        v.atualizadoEm = rs.getDate("atualizado_em");
        v.ativo = rs.getBoolean("ativo");
        return v;
    }

    public String insertQuery() {
        return "insert into " + TABLE_NAME + "(id_cliente, total) values (?,?)";
    }

    public String updateQuery() {
        return "update " + TABLE_NAME + " set id_cliente = ?, total = ? where id = ?";
    }

    public String deleteQuery() {
        return "delete from " + TABLE_NAME + " where id = ?";
    }

    public String getQuery(byte operation) throws Exception {
        switch (operation) {
            case INSERT:
                return insertQuery();
            case UPDATE:
                return updateQuery();
            case DELETE:
                return deleteQuery();
        }
        throw new Exception("invalid operation: " + operation);
    }

    public void setStatements(PreparedStatement st, byte operation) throws SQLException {
        switch (operation) {
            case INSERT:
                st.setInt(1, this.getCliente().getId());
                st.setDouble(2, this.getTotal());
                break;
            case UPDATE:
                st.setInt(1, this.getCliente().getId());
                st.setDouble(2, this.getTotal());
                st.setInt(3, this.getId());
                break;
            case DELETE:
                st.setInt(1, this.getId());
                break;
        }
    }

    public String getTableName() {
        return TABLE_NAME;
    }
}
