/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.view.interfaces;

/**
 *
 * @author kcalixto
 */
public interface ILoginListener {
    /**
     * Executa processos de login efetuado
     * 
     * @param void
     * @return void
     */
    void login(boolean isGerente);

    /**
     * Executa processos de logout efetuado
     * 
     * @param void
     * @return void
     */
    void logout();
}
