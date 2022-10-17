/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.view.libs;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author kcalixto
 */
public class Logo extends javax.swing.JPanel {
    public Logo(){
        init();
    }
    
    public void init(){
        this.setBackground(Color.white);

        JLabel plus = new JLabel();
        JLabel drug = new JLabel();
        JLabel store = new JLabel();
        
        plus.setText("+");
        drug.setText("Drug");
        store.setText("Store");
        
        plus.setForeground(FarmaciaColors.logoBlue);
        drug.setForeground(FarmaciaColors.logoGreen);
        store.setForeground(FarmaciaColors.logoDarkBlue);
        
        Font grossFont = new Font("Arial Black", Font.BOLD, 36);
        Font defaultFont = new Font("Arial", Font.BOLD, 24);
        
        plus.setFont(grossFont);
        drug.setFont(defaultFont);
        store.setFont(defaultFont);
        
        plus.setVisible(true);
        drug.setVisible(true);
        store.setVisible(true);
        
        this.add(plus);
        this.add(drug);
        this.add(store);
    }
}
