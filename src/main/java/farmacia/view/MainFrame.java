/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.view;

import farmacia.view.screens.ItemsInternalFrame;
import farmacia.view.screens.LoginPanel;
import farmacia.view.screens.SellingsInternalFrame;
import farmacia.view.interfaces.ILoginListener;
import farmacia.view.screens.ReportsInternalFrame;
import farmacia.view.screens.ClienteRelatorio;
import farmacia.view.screens.FuncionariosInternalFrame;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kcalixto
 */
public class MainFrame extends javax.swing.JFrame implements ILoginListener {

    private LoginPanel loginPanel = new LoginPanel();

    private SellingsInternalFrame sellingsInternalFrame = new SellingsInternalFrame();
    private ItemsInternalFrame itemsInternalFrame = new ItemsInternalFrame();
    private ReportsInternalFrame reportsInternalFrame = new ReportsInternalFrame();
    private ClienteRelatorio usersInternalFrame = new ClienteRelatorio();
    private FuncionariosInternalFrame funcionariosInternalFrame = new FuncionariosInternalFrame();
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        setLocationRelativeTo(null);
        LoginPanel();
    }

    @Override
    /**
     * Executa processos de login efetuado
     * 
     * @param void
     * @return void
     */
    public void login() {
        StartSellingsFrame();
        StartItemsFrame();
        StartHistoryFrame();
        StartUsersInternalFrame();
        StartFuncionariosFrame();
        
        // set visible
        loginPanel.setVisible(false);
        desktopFrame.setVisible(true);
        menuBar.setVisible(true);
        sellingsInternalFrame.setVisible(true);

        // Reload Listeners trigger whenever there's an action that needs to reload all
        // tables
        itemsInternalFrame.addReloadListener(sellingsInternalFrame.getSellingsPanel());
        itemsInternalFrame.addReloadListener(reportsInternalFrame);

        sellingsInternalFrame.getSellingsPanel().addReloadListener(itemsInternalFrame);
        sellingsInternalFrame.getSellingsPanel().addReloadListener(reportsInternalFrame);

        reportsInternalFrame.addReloadListener(itemsInternalFrame);
        reportsInternalFrame.addReloadListener(sellingsInternalFrame.getSellingsPanel());

        sellingsInternalFrame.getShowCPFPanel().addReloadListener(usersInternalFrame);
    }

    @Override
    /**
     * Executa processos de logout efetuado
     * 
     * @param void
     * @return void
     */
    public void logout() {
        loginPanel.setVisible(true);
        desktopFrame.setVisible(false);
        menuBar.setVisible(false);
    }

    /**
     * Inicia JInternalFrame contendo o fluxo de venda
     * 
     * @see farmacia.view.screens.sellingsPanels.GetCPFPanel
     * @see farmacia.view.screens.sellingsPanels.RegisterCPFPanel
     * @see farmacia.view.screens.sellingsPanels.ShowCPFPanel
     * @see farmacia.view.screens.sellingsPanels.SellingsPanel
     * @see farmacia.view.screens.sellingsPanels.ConfirmSelling
     */
    public void StartSellingsFrame() {
        try {
            desktopFrame.add(sellingsInternalFrame);
            sellingsInternalFrame.show();
            sellingsInternalFrame.addListener(this);
            sellingsInternalFrame.setVisible(false);
            sellingsInternalFrame.setMaximum(true);
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
    }

    /**
     * Inicia JInternalFrame contendo estoque/inventário dos produtos
     * 
     * @see farmacia.view.screens.ItemsInternalFrame
     */
    public void StartItemsFrame() {
        try {
            desktopFrame.add(itemsInternalFrame);
            itemsInternalFrame.show();
            itemsInternalFrame.setVisible(false);
            itemsInternalFrame.setMaximum(true);
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
    }

    /**
     * Inicia JInternalFrame contendo funcionarios
     * 
     * @see farmacia.view.screens.ItemsInternalFrame
     */
    public void StartFuncionariosFrame() {
        try {
            desktopFrame.add(funcionariosInternalFrame);
            funcionariosInternalFrame.show();
            funcionariosInternalFrame.setVisible(false);
            funcionariosInternalFrame.setMaximum(true);
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
    }

    /**
     * Inicia JInternalFrame contendo histórico de vendas
     * 
     * @see farmacia.view.screens.ReportsInternalFrame
     */
    public void StartHistoryFrame() {
        try {
            desktopFrame.add(reportsInternalFrame);
            reportsInternalFrame.show();
            reportsInternalFrame.setVisible(false);
            reportsInternalFrame.setMaximum(true);
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
    }

    public void StartUsersInternalFrame() {
        try {
            desktopFrame.add(usersInternalFrame);
            usersInternalFrame.show();
            usersInternalFrame.setVisible(false);
            usersInternalFrame.setMaximum(true);
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
    }
    /**
     * Inicia JInternalFrame contendo tela de login para Admins
     * 
     * @see farmacia.view.screens.LoginPanel
     * @deprecated
     */
    public void LoginPanel() {
        this.add(loginPanel);
        loginPanel.setVisible(true);
        loginPanel.addListener(this);

        desktopFrame.setVisible(false);
        menuBar.setVisible(false);

        // TODO -> Criar tabela de admins e DAO para poder utilizar a tela de login.
        // Gambiarra para desativar a tela de login forçando login automático ao
        // carregar o projeto.
        if (!constants.SHOW_LOGIN_SCREEN) {
            loginPanel.login();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopFrame = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        sellingsMenuItem = new javax.swing.JMenu();
        itemsMenuItem = new javax.swing.JMenu();
        historyMenuItem = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(Sizes.FRAME_SIZE);
        setName("DrugStore"); // NOI18N
        setSize(new java.awt.Dimension(650, 1000));

        desktopFrame.setBackground(new java.awt.Color(255, 255, 255));
        desktopFrame.setMinimumSize(Sizes.INTERNAL_FRAME_SIZE);
        desktopFrame.setPreferredSize(Sizes.INTERNAL_FRAME_SIZE);
        desktopFrame.setLayout(null);

        menuBar.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        menuBar.setMargin(new java.awt.Insets(0, 15, 0, 0));
        menuBar.setMaximumSize(new java.awt.Dimension(640, 25));
        menuBar.setMinimumSize(new java.awt.Dimension(640, 25));
        menuBar.setPreferredSize(new java.awt.Dimension(640, 25));

        sellingsMenuItem.setText("Tela de Vendas|");
        sellingsMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sellingsMenuItemMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sellingsMenuItemMouseExited(evt);
            }
        });
        menuBar.add(sellingsMenuItem);

        itemsMenuItem.setText("Tela de Cadastro/Consulta de Items|");
        itemsMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemsMenuItemMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                itemsMenuItemMouseExited(evt);
            }
        });
        menuBar.add(itemsMenuItem);

        historyMenuItem.setText("Histórico de Vendas|");
        historyMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historyMenuItemMouseClicked(evt);
            }
        });
        menuBar.add(historyMenuItem);

        jMenu1.setText("Clientes|");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenu1MouseExited(evt);
            }
        });
        menuBar.add(jMenu1);

        jMenu2.setText("Funcionários");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        menuBar.add(jMenu2);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        clearScreen();
        usersInternalFrame.setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseExited
        try {
            usersInternalFrame.setSelected(false);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu1MouseExited

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        clearScreen();
        funcionariosInternalFrame.setVisible(true);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void sellingsMenuItemMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_sellingsMenuItemMouseExited
        sellingsMenuItem.setSelected(false);
    }// GEN-LAST:event_sellingsMenuItemMouseExited

    private void itemsMenuItemMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_itemsMenuItemMouseExited
        itemsMenuItem.setSelected(false);
    }// GEN-LAST:event_itemsMenuItemMouseExited

    private void sellingsMenuItemMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_sellingsMenuItemMouseClicked
        clearScreen();
        sellingsInternalFrame.setVisible(true);
    }// GEN-LAST:event_sellingsMenuItemMouseClicked

    private void itemsMenuItemMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_itemsMenuItemMouseClicked
        clearScreen();
        itemsInternalFrame.setVisible(true);
    }// GEN-LAST:event_itemsMenuItemMouseClicked

    private void historyMenuItemMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_historyMenuItemMouseClicked
        clearScreen();
        reportsInternalFrame.setVisible(true);
    }// GEN-LAST:event_historyMenuItemMouseClicked

    private void clearScreen() {
        reportsInternalFrame.setVisible(false);
        itemsInternalFrame.setVisible(false);
        sellingsInternalFrame.setVisible(false);
        usersInternalFrame.setVisible(false);
        funcionariosInternalFrame.setVisible(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopFrame;
    private javax.swing.JMenu historyMenuItem;
    private javax.swing.JMenu itemsMenuItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu sellingsMenuItem;
    // End of variables declaration//GEN-END:variables

}
