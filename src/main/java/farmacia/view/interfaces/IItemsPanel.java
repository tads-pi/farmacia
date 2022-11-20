/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.view.interfaces;

import farmacia.view.libs.mysql.dao.InventarioDAO;
import farmacia.view.libs.mysql.dao.ProdutosDAO;

/**
 *
 * @author kcalixto
 */
public interface IItemsPanel {
    public ProdutosDAO produtosDAO = new ProdutosDAO();
    public InventarioDAO inventarioDAO = new InventarioDAO();

    /**
     * Executa processos necessários para atualizar as tabelas
     * 
     * @param void
     * @return void
     */
    void reloadTable();
}
