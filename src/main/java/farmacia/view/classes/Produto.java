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
public class Produto extends TiposDeProdutos {
    private int id = 0;
    private String nome;
    private double valorUnitario;
    private String tipoDeProduto;
    private Date criadoEm;
    private Date atualizadoEm;
    private boolean ativo;

    public Produto(int id, String nome, double valorUnitario, String tipoDeProduto, Date criadoEm, Date atualizadoEm,
            boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.tipoDeProduto = tipoDeProduto;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
        this.ativo = ativo;
    }

    public Produto(String nome, double valorUnitario, String tipoDeProduto) {
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.tipoDeProduto = tipoDeProduto;
    }

    public Produto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getTipoDeProduto() {
        return tipoDeProduto;
    }

    public void setTipoDeProduto(String tipoDeProduto) {
        this.tipoDeProduto = tipoDeProduto;
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
