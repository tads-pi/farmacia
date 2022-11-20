/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmacia.view.classes;

import java.util.Date;

/**
 *
 * @author kaua.ccalixto
 */
public class ItemVenda {
    private int id;
    private int id_venda;
    private Produto produto;
    private double quantidade;
    private double valorUnitario;
    private double valorTotal;
    private Date criadoEm;
    private Date atualizadoEm;
    private boolean ativo;

    public ItemVenda(int id, int id_venda, Produto produto, double quantidade, double valorUnitario, double valorTotal,
            Date criadoEm,
            Date atualizadoEm,
            boolean ativo) {
        this.id = id;
        this.id_venda = id_venda;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
        this.ativo = ativo;
    }

    public ItemVenda(Produto produto, double quantidade, double valorUnitario, double valorTotal) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
    }

    public ItemVenda() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVenda() {
        return id_venda;
    }

    public void setIdVenda(int id_venda) {
        this.id_venda = id_venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
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
}
