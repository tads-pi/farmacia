/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.view.entities;

/**
 *
 * @author kcalixto
 */
public class User {

    private int id = 0;
    private String name = "";
    private String cpf = "";
    private String address = "";
    private String contactNumber = "";
    private String email = "";
    private String gender = "";
    private String maritalStatus = "";
    private String birthDateString = "";

    public User() {}

    public User(
            String name,
            String email,
            String cpf,
            String birthDateString,
            String contactNumber,
            String gender,
            String address,
            String maritalStatus
    ) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthDateString = birthDateString;
        this.contactNumber = contactNumber;
        this.gender = gender;
        this.address = address;
        this.maritalStatus = maritalStatus;
    }

    public User(
            int id,
            String name,
            String email,
            String cpf,
            String birthDateString,
            String contactNumber,
            String gender,
            String address,
            String maritalStatus
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthDateString = birthDateString;
        this.contactNumber = contactNumber;
        this.gender = gender;
        this.address = address;
        this.maritalStatus = maritalStatus;
    }
    
    public void set(User u){
        this.id = u.getId();
        this.name = u.getName();
        this.email = u.getEmail();
        this.cpf = u.getCpf();
        this.birthDateString = u.getBirthDateString();
        this.contactNumber = u.getContactNumber();
        this.gender = u.getGender();
        this.address = u.getAddress();
        this.maritalStatus = u.getMaritalStatus();
    }

    public boolean isEmpty() {
        return (id == 0
                && name.isEmpty()
                && email.isEmpty()
                && cpf.isEmpty()
                && birthDateString.isEmpty()
                && contactNumber.isEmpty()
                && gender.isEmpty()
                && address.isEmpty()
                && maritalStatus.isEmpty()
                );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getBirthDateString() {
        return birthDateString;
    }

    public void setBirthDateString(String birthDateString) {
        this.birthDateString = birthDateString;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String Gender) {
        this.gender = Gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String endereco) {
        this.address = endereco;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String estadoCivil) {
        this.maritalStatus = estadoCivil;
    }

    public void print(){
        System.out.println(""
                + "name:\t"
                + "email:\t"
                + "cpf:\t"
                + "birthDateString:\t"
                + "contactNumber:\t"
                + "gender:\t"
                + "address:\t"
                + "maritalStatus:\t"
                + "");
    }
}
