/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.view.classes;

import java.sql.Date;

import farmacia.view.constants;

/**
 *
 * @author kcalixto
 */
public class Funcionario {
    private int id;
    private String nome = "";
    private String email = "";
    private String cpf = "";
    private String cargo = "";
    private Date criadoEm;
    private Date atualizadoEm;
    private boolean ativo = false;

    public static final String TABLE_NAME = "tb_cliente";

    public Funcionario(
            int id,
            String nome,
            String email,
            String cpf,
            String cargo,
            Date criadoEm,
            Date atualizadoEm,
            boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.cargo = cargo;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
        this.ativo = ativo;
    }

    public Funcionario(
            String nome,
            String email,
            String cpf,
            String cargo,
            String dataDeNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.cargo = cargo;
    }


    public Funcionario(
            int id,
            String nome,
            String email,
            String cpf,
            String cargo,
            boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.cargo = cargo;
        this.ativo = ativo;
    }

    public Funcionario(
            int id,
            String nome,
            String email,
            String cpf,
            String cargo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.cargo = cargo;
    }

    public Funcionario() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getCargoIndex(){
        for (int i = 0; i < constants.cargosArr.length; i++) {
            if(this.getCargo().equals(constants.cargosArr[i])) return i;
        }
        return -1;
    }

    public Date getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(Date criadoEm) {
        this.criadoEm = criadoEm;
    }

    public Date getAtualizadoEm() {
        return atualizadoEm;
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
