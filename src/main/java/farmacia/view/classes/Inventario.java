/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmacia.view.classes;

import java.sql.Date;

/**
 *
 * @author kaua.ccalixto
 */
public class Inventario {
    private int id;
    private Produto produto;
    private double quantidade;
    private Date criadoEm;
    private Date atualizadoEm;
    private boolean ativo;

    public Inventario(int id, Produto produto, double quantidade, Date criadoEm, Date atualizadoEm,
            boolean ativo) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
        this.ativo = ativo;
    }

    public Inventario(Produto produto, double quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Inventario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduto() {
        return this.produto;
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
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
}
