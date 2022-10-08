/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.view.libs.buttons;

import farmacia.view.libs.FarmaciaColors;
import java.awt.event.MouseEvent;

/**
 *
 * @author kcalixto
 */
public class CancelButton extends javax.swing.JButton{

    public CancelButton(String text){
        defaut();
        setText(text.toUpperCase());
    }

    public CancelButton(){
        defaut();
        setText("CANCELAR");
    }
    
    private void defaut(){
        setBackground(new java.awt.Color(225, 255, 238));
        setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        setForeground(new java.awt.Color(65, 65, 65));
        setBorder(null);
        setOpaque(false);
        setSize(new java.awt.Dimension(86, 23));
        setPreferredSize(new java.awt.Dimension(86, 23));
        
        setBackground(FarmaciaColors.cancelRed);
        
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(FarmaciaColors.cancelDarkRed);

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(FarmaciaColors.cancelRed);
            }
    });
    }
}
