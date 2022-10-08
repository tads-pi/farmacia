/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.view.screens;

import farmacia.view.constants;
import farmacia.view.libs.Validators;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import farmacia.view.interfaces.ILoginListener;

/**
 *
 * @author kcalixto
 */
public class LoginPanel extends javax.swing.JPanel {

    private ArrayList<ILoginListener> listeners = new ArrayList<ILoginListener>();
    private Validators v = new Validators();

    /**
     * Creates new form LoginPanel
     */
    public LoginPanel() {
        initComponents();
        loadLogo();
    }

    public void addListener(ILoginListener toAdd) {
        listeners.add(toAdd);
    }

    public void login() {
        System.out.println("called login action");

        // Notify everybody that may be interested.
        for (ILoginListener ll : listeners) {
            ll.login();
        }
    }

    public void loadLogo() {
        try {
            System.out.println("working!");
            ImageIcon imageIcon = new javax.swing.ImageIcon(getClass().getResource("/farmacia/view/resources/logo.jpg"));
            Image modifiedImage = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(),
                    Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(modifiedImage);

            imageLabel.setIcon(imageIcon);
        } catch (Exception e) {
            System.out.println("err: " + e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginInput = new javax.swing.JTextField();
        loginLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        confirmButton = new farmacia.view.libs.buttons.ConfirmButton();
        passwordInput = new javax.swing.JPasswordField();
        errorLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 650, 660));
        setMaximumSize(new java.awt.Dimension(650, 660));
        setMinimumSize(new java.awt.Dimension(650, 660));
        setPreferredSize(new java.awt.Dimension(650, 660));
        setVerifyInputWhenFocusTarget(false);

        loginInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        loginInput.setMaximumSize(new java.awt.Dimension(217, 24));
        loginInput.setMinimumSize(new java.awt.Dimension(217, 24));
        loginInput.setPreferredSize(new java.awt.Dimension(217, 24));
        loginInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginInputKeyPressed(evt);
            }
        });

        loginLabel.setBackground(new java.awt.Color(65, 65, 65));
        loginLabel.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        loginLabel.setForeground(new java.awt.Color(65, 65, 65));
        loginLabel.setText("login");

        passwordLabel.setBackground(new java.awt.Color(65, 65, 65));
        passwordLabel.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(65, 65, 65));
        passwordLabel.setText("senha");

        imageLabel.setMaximumSize(new java.awt.Dimension(124, 31));
        imageLabel.setMinimumSize(new java.awt.Dimension(124, 31));
        imageLabel.setPreferredSize(new java.awt.Dimension(124, 31));
        imageLabel.setSize(new java.awt.Dimension(124, 31));

        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        passwordInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordInputKeyReleased(evt);
            }
        });

        errorLabel.setFont(new java.awt.Font("Monospaced", 1, 10)); // NOI18N
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginLabel)
                    .addComponent(passwordLabel)
                    .addComponent(passwordInput, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imageLabel, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginInput, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(216, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(loginLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        if (v.isValidLogin(loginInput.getText(), passwordInput.getPassword())) {
            login();
        }else{
            errorLabel.setText(constants.INVALID_LOGIN_OR_PASSWORD);
        }
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void loginInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginInputKeyPressed
        if (!loginInput.getText().isEmpty() &&
                evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            passwordInput.requestFocus();
        }
    }//GEN-LAST:event_loginInputKeyPressed

    private void passwordInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordInputKeyReleased
        if (passwordInput.getPassword().length > 0
                && evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            confirmButton.doClick();
        }
    }//GEN-LAST:event_passwordInputKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private farmacia.view.libs.buttons.ConfirmButton confirmButton;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JTextField loginInput;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JLabel passwordLabel;
    // End of variables declaration//GEN-END:variables

}
