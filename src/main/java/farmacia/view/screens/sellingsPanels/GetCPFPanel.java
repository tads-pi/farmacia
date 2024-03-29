/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.view.screens.sellingsPanels;

import farmacia.view.constants;
import farmacia.view.interfaces.ILoginListener;
import farmacia.view.interfaces.ISellingsPanel;
import farmacia.view.libs.validators.Validators;
import java.util.ArrayList;

/**
 *
 * @author kcalixto
 */
public class GetCPFPanel extends javax.swing.JPanel implements ILoginListener, ISellingsPanel {

    private ArrayList<ILoginListener> loginListeners = new ArrayList<ILoginListener>();
    private ArrayList<ISellingsPanel> sellingsisteners = new ArrayList<ISellingsPanel>();
    private Validators v = new Validators();

    /**
     * Creates new form GetCPFPanel
     */
    public GetCPFPanel() {
        initComponents();
    }

    /**
     * Adiciona outro JInternalFrame como listener da ação de logout
     * | Neste caso em específico somente
     * {@link farmacia.view.screens.SellingsInternalFrame#logout()} é chamado quando
     * o botão LOGOUT é apertado
     * 
     * @param toAdd
     */
    public void addLoginListener(ILoginListener toAdd) {
        loginListeners.add(toAdd);
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cpfLabel = new javax.swing.JLabel();
        confirmButton = new farmacia.view.libs.buttons.ConfirmButton();
        errorLabel = new javax.swing.JLabel();
        logoutButton = new farmacia.view.libs.buttons.CancelButton();
        cpfInput = new javax.swing.JFormattedTextField();
        logo1 = new farmacia.view.libs.Logo();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(640, 640));
        setMinimumSize(new java.awt.Dimension(640, 640));

        cpfLabel.setBackground(new java.awt.Color(65, 65, 65));
        cpfLabel.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        cpfLabel.setForeground(new java.awt.Color(65, 65, 65));
        cpfLabel.setText("CPF de cliente");

        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        errorLabel.setFont(new java.awt.Font("Monospaced", 1, 10)); // NOI18N
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        logoutButton.setText("LOGOUT");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        logoutButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                logoutButtonKeyPressed(evt);
            }
        });

        try {
            cpfInput.setFormatterFactory(
                    new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cpfInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cpfInputKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(212, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cpfLabel)
                                        .addComponent(confirmButton, javax.swing.GroupLayout.Alignment.CENTER,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(errorLabel, javax.swing.GroupLayout.Alignment.CENTER,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 177,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cpfInput, javax.swing.GroupLayout.Alignment.CENTER,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 223,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(logo1, javax.swing.GroupLayout.Alignment.CENTER,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(205, 205, 205)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(163, 163, 163)
                                .addComponent(logo1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(cpfLabel)
                                .addGap(4, 4, 4)
                                .addComponent(cpfInput, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150,
                                        Short.MAX_VALUE)
                                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));
    }// </editor-fold>//GEN-END:initComponents

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_confirmButtonActionPerformed
        errorLabel.setText("");
        if (!v.isValidCpf(cpfInput.getText())) {
            errorLabel.setText(constants.INVALID_CPF);
            return;
        }

        clienteAtual.set(clienteDAO.findByCpf(this.cpfInput.getText().toString()));

        if (!clienteAtual.isEmpty()) {
            // Notify everybody that may be interested.
            for (ISellingsPanel ll : sellingsisteners) {
                ll.confirmPressed(STEP_SHOW_CPF);
            }
        } else {
            clienteAtual.setCpf(this.cpfInput.getText());

            for (ISellingsPanel ll : sellingsisteners) {
                ll.confirmPressed(STEP_CPF_REGISTER);
            }
        }
    }// GEN-LAST:event_confirmButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_logoutButtonActionPerformed
        logout();
    }// GEN-LAST:event_logoutButtonActionPerformed

    private void logoutButtonKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_logoutButtonKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ESCAPE) {
            logoutButton.doClick();
        }
    }// GEN-LAST:event_logoutButtonKeyPressed

    private void cpfInputKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_cpfInputKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            confirmButton.doClick();
        }
    }// GEN-LAST:event_cpfInputKeyPressed

    /**
     * Limpa campos
     */
    public void clearFields() {
        cpfInput.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private farmacia.view.libs.buttons.ConfirmButton confirmButton;
    private javax.swing.JFormattedTextField cpfInput;
    private javax.swing.JLabel cpfLabel;
    private javax.swing.JLabel errorLabel;
    private farmacia.view.libs.Logo logo1;
    private farmacia.view.libs.buttons.CancelButton logoutButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void confirmPressed(int newStep) {
    }

    @Override
    public void cancelPressed(int newStep) {
    }

    @Override
    public void login(boolean isGerente) {
    }

    @Override
    public void logout() {
        for (ILoginListener ll : loginListeners) {
            ll.logout();
        }
    }
}
