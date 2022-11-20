/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.view.screens.sellingsPanels;

import farmacia.view.interfaces.ISellingsPanel;
import java.util.ArrayList;

/**
 *
 * @author kcalixto
 */
public class ConfirmSelling extends javax.swing.JPanel implements ISellingsPanel {

    private ArrayList<ISellingsPanel> sellingsisteners = new ArrayList<ISellingsPanel>();

    /**
     * Creates new form GetCPFPanel
     */
    public ConfirmSelling() {
        initComponents();
    }

    /**
     * Adiciona outro JInternalFrame como listener das ações de CONTINUAR e CANCELAR
     * 
     * {@link farmacia.view.screens.SellingsInternalFrame#confirmPressed(int)}
     * {@link farmacia.view.screens.SellingsInternalFrame#cancelPressed(int)}
     * 
     * @param toAdd
     */
    public void addSellingsListener(ISellingsPanel toAdd) {
        sellingsisteners.add(toAdd);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        confirmButton = new farmacia.view.libs.buttons.ConfirmButton();
        confirmLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        logo1 = new farmacia.view.libs.Logo();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(640, 640));
        setMinimumSize(new java.awt.Dimension(640, 640));
        setPreferredSize(new java.awt.Dimension(640, 640));

        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });
        confirmButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                confirmButtonKeyPressed(evt);
            }
        });

        confirmLabel.setBackground(new java.awt.Color(0, 0, 0));
        confirmLabel.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        confirmLabel.setText("Compra efetuada com sucesso!");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 256)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 51));
        jLabel1.setText("✓");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(confirmLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(217, 217, 217))
                    .addComponent(logo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(logo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(confirmLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        for (ISellingsPanel ll : sellingsisteners) {
            ll.confirmPressed(STEP_GET_CPF);
        }
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void confirmButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmButtonKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            confirmButton.doClick();
        }
    }//GEN-LAST:event_confirmButtonKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private farmacia.view.libs.buttons.ConfirmButton confirmButton;
    private javax.swing.JLabel confirmLabel;
    private javax.swing.JLabel jLabel1;
    private farmacia.view.libs.Logo logo1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void confirmPressed(int newStep) {

    }

    @Override
    public void  cancelPressed(int newStep) {
    }
}
