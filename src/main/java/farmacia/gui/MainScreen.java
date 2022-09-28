/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.gui;

import farmacia.gui.sellings.Sellings;

/**
 *
 * @author kcalixto
 */
public class MainScreen extends javax.swing.JFrame {

    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        TabbedPane = new javax.swing.JTabbedPane();
        SellingsPanelParent = new javax.swing.JPanel();
        sellings1 = new farmacia.gui.sellings.Sellings();
        StockPanelParent = new javax.swing.JPanel();
        stock1 = new farmacia.gui.stock.Stock();
        RegistersPanelParent = new javax.swing.JPanel();
        register1 = new farmacia.gui.register.Register();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        MainPanel.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        MainPanel.setMaximumSize(new java.awt.Dimension(640, 640));
        MainPanel.setMinimumSize(new java.awt.Dimension(640, 640));
        MainPanel.setPreferredSize(new java.awt.Dimension(640, 640));
        MainPanel.setRequestFocusEnabled(false);

        TabbedPane.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        TabbedPane.setMaximumSize(new java.awt.Dimension(640, 640));
        TabbedPane.setMinimumSize(new java.awt.Dimension(640, 640));
        TabbedPane.setPreferredSize(new java.awt.Dimension(640, 620));

        javax.swing.GroupLayout sellings1Layout = new javax.swing.GroupLayout(sellings1);
        sellings1.setLayout(sellings1Layout);
        sellings1Layout.setHorizontalGroup(
            sellings1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        sellings1Layout.setVerticalGroup(
            sellings1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 607, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout SellingsPanelParentLayout = new javax.swing.GroupLayout(SellingsPanelParent);
        SellingsPanelParent.setLayout(SellingsPanelParentLayout);
        SellingsPanelParentLayout.setHorizontalGroup(
            SellingsPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sellings1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SellingsPanelParentLayout.setVerticalGroup(
            SellingsPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sellings1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabbedPane.addTab("Tela de Vendas", SellingsPanelParent);

        javax.swing.GroupLayout stock1Layout = new javax.swing.GroupLayout(stock1);
        stock1.setLayout(stock1Layout);
        stock1Layout.setHorizontalGroup(
            stock1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        stock1Layout.setVerticalGroup(
            stock1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 607, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout StockPanelParentLayout = new javax.swing.GroupLayout(StockPanelParent);
        StockPanelParent.setLayout(StockPanelParentLayout);
        StockPanelParentLayout.setHorizontalGroup(
            StockPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(stock1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        StockPanelParentLayout.setVerticalGroup(
            StockPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(stock1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabbedPane.addTab("Estoque", StockPanelParent);

        javax.swing.GroupLayout register1Layout = new javax.swing.GroupLayout(register1);
        register1.setLayout(register1Layout);
        register1Layout.setHorizontalGroup(
            register1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        register1Layout.setVerticalGroup(
            register1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 607, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout RegistersPanelParentLayout = new javax.swing.GroupLayout(RegistersPanelParent);
        RegistersPanelParent.setLayout(RegistersPanelParentLayout);
        RegistersPanelParentLayout.setHorizontalGroup(
            RegistersPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(register1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        RegistersPanelParentLayout.setVerticalGroup(
            RegistersPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(register1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabbedPane.addTab("Tela de Cadastros", RegistersPanelParent);

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(TabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(TabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel RegistersPanelParent;
    private javax.swing.JPanel SellingsPanelParent;
    private javax.swing.JPanel StockPanelParent;
    private javax.swing.JTabbedPane TabbedPane;
    private farmacia.gui.register.Register register1;
    private farmacia.gui.sellings.Sellings sellings1;
    private farmacia.gui.stock.Stock stock1;
    // End of variables declaration//GEN-END:variables
}
