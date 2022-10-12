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
    
    private String name = "";
    private String email = "";
    private String cpf = "";
    private String birthDateString = "";
    private String contactNumber = "";
    private String gender = "";
    
    public User(){}
    
    public User(
        String name,
        String email,
        String cpf,
        String birthDateString,
        String contactNumber,
        String gender
    ){
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthDateString = birthDateString;
        this.contactNumber = contactNumber;
        this.gender = gender;
    }
    
    public boolean isEmpty(){
        return (
            name.isEmpty()
            && email.isEmpty()
            && cpf.isEmpty()
            && birthDateString.isEmpty()
            && contactNumber.isEmpty()
            && gender.isEmpty()
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

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String Gender) {
        this.gender = Gender;
    }
    
}
