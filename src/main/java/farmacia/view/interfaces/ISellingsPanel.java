/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.view.interfaces;

import farmacia.view.classes.Cliente;
import farmacia.view.libs.mysql.dao.ClienteDAO;
import farmacia.view.libs.mysql.dao.FuncionarioDAO;

/**
 * Interface do fluxo de venda contendo o número dos passos e DAO de cliente {@link farmacia.view.libs.mysql.dao.ClienteDAO}
 *
 * @author kcalixto
 */
public interface ISellingsPanel {
    public static final int STEP_GET_CPF = 0;
    public static final int STEP_SHOW_CPF = 1;
    public static final int STEP_CPF_REGISTER = 2;
    public static final int STEP_SELLINGS = 3;
    public static final int STEP_CONFIRM_SELLING = 4;
    public static final int STEP_CANCEL_SELLING = 5;

    public static final int LAST_STEP = 9;

    public Cliente clienteAtual = new Cliente();
    public ClienteDAO clienteDAO = new ClienteDAO();
    public FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    /**
     * Executa processos de ir para próximo passo
     * 
     * @param void
     * @return void
     */
    void confirmPressed(int newStep);

    /**
     * Executa processos de ir para passo anterior
     * 
     * @param void
     * @return void
     */
    void cancelPressed(int newStep);
}
