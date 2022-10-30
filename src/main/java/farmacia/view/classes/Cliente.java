/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmacia.view.classes;

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

    public Cliente(
            String nome,
            String cpf,
            String endereco,
            String numeroDeTelefone,
            String email,
            String genero,
            String estadoCivil,
            String dataDeNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.numeroDeTelefone = numeroDeTelefone;
        this.email = email;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
        this.dataDeNascimento = dataDeNascimento;
    }

    public Cliente(
            int id,
            String nome,
            String cpf,
            String endereco,
            String numeroDeTelefone,
            String email,
            String genero,
            String estadoCivil,
            String dataDeNascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.numeroDeTelefone = numeroDeTelefone;
        this.email = email;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
        this.dataDeNascimento = dataDeNascimento;
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

}
