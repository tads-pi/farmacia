/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmacia.view.classes;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kaua.ccalixto
 */
public class teste {
    public static void main(String args[]){
        int fakeId = 0;
        double fakeTotal = 100.00;
        Date fakeDate = new Date();
        
        Cliente clienteX = new Cliente(fakeId, "calixto da zs", "", "", "", "", "", "", "");
        
        Produto batatinha = new Produto(fakeId, "batatinha", 0.55, TiposDeProdutos.kilos, new Date(), true);
        ItemVenda vendaBatatinha = new ItemVenda(fakeId, batatinha, 1.0, batatinha.getValorUnitario(), (batatinha.getValorUnitario() * 1.0), new Date());
        
        ArrayList<ItemVenda> meuCarrinho = new ArrayList<>();
        
        meuCarrinho.add(vendaBatatinha);
        

        Venda venda = new Venda(fakeId, clienteX, meuCarrinho, fakeTotal, fakeDate, true);
        System.out.printf("O cliente '%s' comprou '%s %s' dia '%s'", venda.getCliente().getNome(), venda.getCarrinho().get(0).getQuantidade() + "", venda.getCarrinho().get(0).getProduto().getNome(), venda.getData().toString());
        
    }
}
