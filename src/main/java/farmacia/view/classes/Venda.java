/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmacia.view.classes;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kaua.ccalixto
 */
public class Venda {
    private int id;
    private Cliente cliente;
    private ArrayList<ItemVenda> carrinho;
    private double total;
    private Date data;
    private boolean ativo;

    public Venda(int id, Cliente cliente, ArrayList<ItemVenda> carrinho, double total, Date data, boolean ativo) {
        this.id = id;
        this.cliente = cliente;
        this.carrinho = carrinho;
        this.total = total;
        this.data = data;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
