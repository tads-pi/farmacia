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
    private String login = "";
    private String senha = "";
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
            String login,
            String senha,
            Date criadoEm,
            Date atualizadoEm,
            boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
        this.ativo = ativo;
    }

    public Funcionario(
            int id,
            String nome,
            String email,
            String cpf,
            String cargo,
            String login,
            String senha,
            boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
        this.ativo = ativo;
    }

    public Funcionario(
            int id,
            String nome,
            String email,
            String cpf,
            String cargo,
            String login,
            String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
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

    public int getCargoIndex() {
        for (int i = 0; i < constants.cargosArr.length; i++) {
            if (this.getCargo().equals(constants.cargosArr[i]))
                return i;
        }
        return -1;
    }

    public Date getCriadoEm() {
        return criadoEm;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public boolean isGerente() {
        if (getCargo().equals(constants.gerente)) {
            return true;
        }
        return false;
    }

    /**
     * Verifica se o objeto tem informações ou não
     * 
     * @return boolean
     */
    public boolean isEmpty() {
        return (this.id == 0 &&
                this.nome.isEmpty() &&
                this.email.isEmpty() &&
                this.cpf.isEmpty() &&
                this.login.isEmpty() &&
                this.senha.isEmpty());
    }
}
