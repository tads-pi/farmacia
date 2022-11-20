/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.view.libs.buttons;

import farmacia.view.libs.FarmaciaColors;

/**
 *
 * @author kcalixto
 */
public class ConfirmButton extends javax.swing.JButton{

    public ConfirmButton(String text){
        defaut();
        setText(text.toUpperCase());
    }

    public ConfirmButton(){
        defaut();
        setText("CONFIRMAR");
    }
    
    private void defaut(){
        setBackground(new java.awt.Color(225, 255, 238));
        setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        setForeground(new java.awt.Color(65, 65, 65));
        setBorder(null);
        setOpaque(false);
        setSize(new java.awt.Dimension(86, 23));
        setPreferredSize(new java.awt.Dimension(86, 23));
        
        setBackground(FarmaciaColors.confirmGreen);
        
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(FarmaciaColors.confirmDarkGreen);

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(FarmaciaColors.confirmGreen);
            }
    });
    }
}
