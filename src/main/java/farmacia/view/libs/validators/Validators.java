/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.view.libs.validators;

import farmacia.view.classes.Cliente;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kcalixto
 */
public class Validators {

    public InvalidResponseBody isValidLogin(String login, char[] password) {
        InvalidResponseBody response = new InvalidResponseBody();
        
         if (login.isEmpty()) {
            response.addErrorField("login");
        }
        if (password.length == 0) {
            response.addErrorField("senha");
        }
        
        return response;
    }

    public boolean isValidCliente(Cliente c) {
        return true;
    }

    private boolean isValidDate(String stringDate) {
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
            Date now = new Date();
            Date centuryAgo = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1900");
            
            if (date.after(now)
                    || date.before(centuryAgo)) {
                return false;
            }
        } catch (ParseException ex) {
            System.out.println("error parsing date format at views.libs.Validators.isValidDate");
        }

        return true;
    }

    public ArrayList<String> isValidRegister(
            String nameInput,
            String emailInput,
            String cpfInput,
            String birthDateInput,
            String contactNumberInput,
            String genderInput,
            String addressInput,
            String maritalStatusInput
    ) {
        ArrayList<String> invalidFields = new ArrayList<String>();

        if (nameInput.isEmpty()) {
            invalidFields.add("Nome Completo");
        }
        if (emailInput.isEmpty() || emailInput.contains(" ") || !emailInput.contains("@") || !emailInput.contains(".")) {
            invalidFields.add("Melhor Email");
        }
        if (!isValidCpf(cpfInput)) {
            invalidFields.add("CPF");
        }
        if (birthDateInput.isEmpty() || birthDateInput.equals("  /  /    ") || birthDateInput.charAt(0) == ' ' || !isValidDate(birthDateInput)) {
            invalidFields.add("Data de Nascimento");
        }
        if (contactNumberInput.isEmpty() || contactNumberInput.equals("(  )     -    ") || contactNumberInput.charAt(0) == ' ') {
            invalidFields.add("Telefone de Contato");
        }
        if (genderInput.isEmpty() || genderInput.equals(" ")) {
            invalidFields.add("Gênero");
        }
        if (addressInput.isEmpty() || addressInput.equals(" ") || addressInput.charAt(0) == ' ') {
            invalidFields.add("Endereço");
        }
        if (maritalStatusInput.isEmpty() || maritalStatusInput.equals(" ")  || maritalStatusInput.charAt(0) == ' ') {
            invalidFields.add("Estado Civíl");
        }

        return invalidFields;
    }
    
    public boolean isValidCpf(String cpfInput) {
        if (cpfInput.isEmpty() || cpfInput.equals("   .   .   -  ") || cpfInput.charAt(0) == ' ' || cpfInput.charAt(cpfInput.length() - 1) == ' ') {
            return false;
        }
        
        for(int i = 0; i < cpfInput.length(); i++){
            if(cpfInput.charAt(i) == ' '){
                return false;
            }
        }
        
        return true;
    }
}
