/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.view.libs.validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kcalixto
 */
public class Validators {

    /**
     * Valida se um login é válido com base nas informações de login e senha
     * TODO: conectar com banco de dados
     * 
     * @param login
     * @param password
     * 
     * @return InvalidResponseBody
     */
    public InvalidResponseBody isValidLogin(String login, String password) {
        InvalidResponseBody response = new InvalidResponseBody();

        if (login.isEmpty()) {
            response.addErrorField("login");
        }
        if (password.length() == 0) {
            response.addErrorField("senha");
        }

        return response;
    }

    /**
     * Valida se uma data de nascimento é válida
     * para ser válido a idade deve ser > 18 e < 150
     * 
     * @param stringDate
     * @return boolean
     */
    private boolean isValidDate(String stringDate) {
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
            long oneYearInMillis = 31556926000L;
            Date minorAge = new Date(System.currentTimeMillis() - (18 * oneYearInMillis));
            Date centuryAgo = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1870");

            if (date.before(centuryAgo)
                    || date.after(minorAge)) {
                return false;
            }
        } catch (ParseException ex) {
            System.out.println("error parsing date format at views.libs.Validators.isValidDate");
        }

        return true;
    }

    /**
     * Valida se os dados para cadastrar um cliente são válidos
     * 
     * @param nameInput
     * @param emailInput
     * @param cpfInput
     * @param birthDateInput
     * @param contactNumberInput
     * @param genderInput
     * @param addressInput
     * @param maritalStatusInput
     * @return ArrayList<String> contendo todos os campos inválidos
     */
    public ArrayList<String> isValidRegister(
            String nameInput,
            String emailInput,
            String cpfInput,
            String birthDateInput,
            String contactNumberInput,
            String genderInput,
            String addressInput,
            String maritalStatusInput) {
        ArrayList<String> invalidFields = new ArrayList<String>();

        if (nameInput.isEmpty()) {
            invalidFields.add("Nome Completo");
        }
        if (nameInput.length() > 45) {
            invalidFields.add("Nome deve ser menor que 45 caracteres");
        }
        if (emailInput.isEmpty() || emailInput.contains(" ") || !emailInput.contains("@")
                || !emailInput.contains(".")) {
            invalidFields.add("Melhor Email");
        }
        if (emailInput.length() > 45) {
            invalidFields.add("Email deve ser menor que 45 caracteres");
        }
        if (!isValidCpf(cpfInput)) {
            invalidFields.add("CPF");
        }
        if (birthDateInput.isEmpty() || birthDateInput.equals("  /  /    ") || birthDateInput.charAt(0) == ' ') {
            invalidFields.add("Data de Nascimento");
        }
        if (!isValidDate(birthDateInput)) {
            invalidFields.add("Data de Nascimento deve ser maior que 18 anos e menor que 150 anos");
        }
        if (contactNumberInput.isEmpty() || contactNumberInput.equals("(  )     -    ")
                || contactNumberInput.charAt(0) == ' ') {
            invalidFields.add("Telefone de Contato");
        }
        if (genderInput.isEmpty() || genderInput.equals(" ")) {
            invalidFields.add("Gênero");
        }
        if (addressInput.isEmpty() || addressInput.equals(" ") || addressInput.charAt(0) == ' ') {
            invalidFields.add("Endereço");
        }
        if (maritalStatusInput.isEmpty() || maritalStatusInput.equals(" ") || maritalStatusInput.charAt(0) == ' ') {
            invalidFields.add("Estado Civíl");
        }

        return invalidFields;
    }

    /**
     * Valida se os dados para cadastrar um funcionario são válidos
     * 
     * @param nameInput
     * @param emailInput
     * @param cpfInput
     * @param cargoInput
     * @return ArrayList<String> contendo todos os campos inválidos
     */
    public ArrayList<String> isValidRegisterFuncionario(
            String nameInput,
            String emailInput,
            String cpfInput,
            String cargo,
            String loginInput,
            String senhaInput) {
        ArrayList<String> invalidFields = new ArrayList<String>();

        if (nameInput.isEmpty()) {
            invalidFields.add("Nome Completo");
        }
        if (nameInput.length() > 45) {
            invalidFields.add("Nome deve ser menor que 45 caracteres");
        }
        if (loginInput.isEmpty()) {
            invalidFields.add("Login");
        }
        if (loginInput.length() > 45) {
            invalidFields.add("Login deve ser menor que 45 caracteres");
        }
        if (senhaInput.isEmpty()) {
            invalidFields.add("Senha");
        }
        if (senhaInput.length() > 45) {
            invalidFields.add("Senha deve ser menor que 45 caracteres");
        }
        if (emailInput.isEmpty() || emailInput.contains(" ") || !emailInput.contains("@")
                || !emailInput.contains(".")) {
            invalidFields.add("Melhor Email");
        }
        if (emailInput.length() > 45) {
            invalidFields.add("Email deve ser menor que 45 caracteres");
        }
        if (!isValidCpf(cpfInput)) {
            invalidFields.add("CPF");
        }
        if (cargo.isEmpty() || cargo.equals(" ") || cargo.charAt(0) == ' ') {
            invalidFields.add("cargo");
        }

        return invalidFields;
    }

    /**
     * Verifica se um cpf é válido
     * 
     * @param cpfInput
     * @return boolean
     */
    public boolean isValidCpf(String cpfInput) {
        if (cpfInput.isEmpty() || cpfInput.equals("   .   .   -  ") || cpfInput.charAt(0) == ' '
                || cpfInput.charAt(cpfInput.length() - 1) == ' ') {
            return false;
        }

        for (int i = 0; i < cpfInput.length(); i++) {
            if (cpfInput.charAt(i) == ' ') {
                return false;
            }
        }

        return true;
    }
}
