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
public class Cliente {

    private int id;
    private String nome = "";
    private String cpf = "";
    private String endereco = "";
    private String numeroDeTelefone = "";
    private String email = "";
    private String genero = "";
    private String estadoCivil = "";
    private String dataDeNascimento = "";
    private Date criadoEm;
    private Date atualizadoEm;
    private boolean ativo = false;

    public static final String TABLE_NAME = "tb_cliente";

    public Cliente(
            int id,
            String nome,
            String email,
            String cpf,
            String endereco,
            String numeroDeTelefone,
            String genero,
            String estadoCivil,
            String dataDeNascimento,
            Date criadoEm,
            Date atualizadoEm,
            boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.endereco = endereco;
        this.numeroDeTelefone = numeroDeTelefone;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
        this.dataDeNascimento = dataDeNascimento;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
        this.ativo = ativo;
    }

    public Cliente(
            String nome,
            String email,
            String cpf,
            String endereco,
            String numeroDeTelefone,
            String genero,
            String estadoCivil,
            String dataDeNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.endereco = endereco;
        this.numeroDeTelefone = numeroDeTelefone;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
        this.dataDeNascimento = dataDeNascimento;
    }

    public Cliente() {
    }

    /**
     * Atualiza cliente
     * @param c
     */
    public void set(Cliente c) {
        this.id = c.id;
        this.nome = c.nome;
        this.email = c.email;
        this.cpf = c.cpf;
        this.endereco = c.endereco;
        this.numeroDeTelefone = c.numeroDeTelefone;
        this.genero = c.genero;
        this.estadoCivil = c.estadoCivil;
        this.dataDeNascimento = c.dataDeNascimento;
        this.criadoEm = c.criadoEm;
        this.atualizadoEm = c.atualizadoEm;
        this.ativo = c.ativo;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumeroDeTelefone() {
        return numeroDeTelefone;
    }

    public void setNumeroDeTelefone(String numeroDeTelefone) {
        this.numeroDeTelefone = numeroDeTelefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
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

    /**
     * Verifica se o objeto tem informações ou não
     * @return boolean
     */
    public boolean isEmpty() {
        return (this.id == 0 &&
                this.nome.isEmpty() &&
                this.email.isEmpty() &&
                this.cpf.isEmpty() &&
                this.endereco.isEmpty() &&
                this.numeroDeTelefone.isEmpty() &&
                this.genero.isEmpty() &&
                this.estadoCivil.isEmpty() &&
                this.dataDeNascimento.isEmpty());
    }

}
