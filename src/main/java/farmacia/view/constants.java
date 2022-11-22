/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.view;

import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author kcalixto
 */
public class constants {
    public static final String INVALID_LOGIN_OR_PASSWORD = "Login ou Senha inválidos";
    public static final String INVALID_CPF = "CPF inválido";

    public static final String[] estadosCivisArr = new String[] { "Solteiro (a)", "Casado (a)",
            "Divorciado (a)", "Viúvo (a)", "Separado (a) Judicialmente" };
    public static final DefaultComboBoxModel<String> estadosCivisModel = new DefaultComboBoxModel<>(estadosCivisArr);
    public static final String[] generosArr = new String[] { "-", "M", "F", "NB" };
    public static final DefaultComboBoxModel<String> generosModel = new DefaultComboBoxModel<>(generosArr);
    public static final String[] cargosArr = new String[] { "Vendedor(a)", "Auxiliar de Limpeza" };
    public static final DefaultComboBoxModel<String> cargosModel = new DefaultComboBoxModel<>(cargosArr);
    public static final DefaultComboBoxModel<String> cargosModel2 = new DefaultComboBoxModel<>(cargosArr);

    public static final boolean SHOW_LOGIN_SCREEN = false;
}
