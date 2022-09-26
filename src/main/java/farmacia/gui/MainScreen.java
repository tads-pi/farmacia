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
        SellingsPanel = new farmacia.gui.sellings.Sellings();
        StockPanelParent = new javax.swing.JPanel();
        StockPanel = new farmacia.gui.stock.Stock();
        RegistersPanelParent = new javax.swing.JPanel();
        RegisterPanel = new farmacia.gui.register.Register();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(640, 640));
        setResizable(false);

        MainPanel.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        MainPanel.setLocation(new java.awt.Point(-32641, -32641));
        MainPanel.setMaximumSize(new java.awt.Dimension(640, 640));
        MainPanel.setMinimumSize(new java.awt.Dimension(640, 640));
        MainPanel.setPreferredSize(new java.awt.Dimension(640, 640));
        MainPanel.setRequestFocusEnabled(false);

        TabbedPane.setBounds(new java.awt.Rectangle(0, 0, 640, 640));
        TabbedPane.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        TabbedPane.setMaximumSize(new java.awt.Dimension(640, 640));
        TabbedPane.setMinimumSize(new java.awt.Dimension(640, 640));
        TabbedPane.setPreferredSize(new java.awt.Dimension(640, 620));

        javax.swing.GroupLayout SellingsPanelLayout = new javax.swing.GroupLayout(SellingsPanel);
        SellingsPanel.setLayout(SellingsPanelLayout);
        SellingsPanelLayout.setHorizontalGroup(
            SellingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );
        SellingsPanelLayout.setVerticalGroup(
            SellingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout SellingsPanelParentLayout = new javax.swing.GroupLayout(SellingsPanelParent);
        SellingsPanelParent.setLayout(SellingsPanelParentLayout);
        SellingsPanelParentLayout.setHorizontalGroup(
            SellingsPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SellingsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        SellingsPanelParentLayout.setVerticalGroup(
            SellingsPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SellingsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        TabbedPane.addTab("Tela de Vendas", SellingsPanelParent);

        javax.swing.GroupLayout StockPanelLayout = new javax.swing.GroupLayout(StockPanel);
        StockPanel.setLayout(StockPanelLayout);
        StockPanelLayout.setHorizontalGroup(
            StockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );
        StockPanelLayout.setVerticalGroup(
            StockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout StockPanelParentLayout = new javax.swing.GroupLayout(StockPanelParent);
        StockPanelParent.setLayout(StockPanelParentLayout);
        StockPanelParentLayout.setHorizontalGroup(
            StockPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(StockPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        StockPanelParentLayout.setVerticalGroup(
            StockPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(StockPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        TabbedPane.addTab("Estoque", StockPanelParent);

        javax.swing.GroupLayout RegisterPanelLayout = new javax.swing.GroupLayout(RegisterPanel);
        RegisterPanel.setLayout(RegisterPanelLayout);
        RegisterPanelLayout.setHorizontalGroup(
            RegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );
        RegisterPanelLayout.setVerticalGroup(
            RegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout RegistersPanelParentLayout = new javax.swing.GroupLayout(RegistersPanelParent);
        RegistersPanelParent.setLayout(RegistersPanelParentLayout);
        RegistersPanelParentLayout.setHorizontalGroup(
            RegistersPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RegisterPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        RegistersPanelParentLayout.setVerticalGroup(
            RegistersPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RegisterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        TabbedPane.addTab("Tela de Cadastros", RegistersPanelParent);

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MainPanelLayout.createSequentialGroup()
                    .addComponent(TabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MainPanelLayout.createSequentialGroup()
                    .addComponent(TabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 40, Short.MAX_VALUE)))
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
    private farmacia.gui.register.Register RegisterPanel;
    private javax.swing.JPanel RegistersPanelParent;
    private farmacia.gui.sellings.Sellings SellingsPanel;
    private javax.swing.JPanel SellingsPanelParent;
    private farmacia.gui.stock.Stock StockPanel;
    private javax.swing.JPanel StockPanelParent;
    private javax.swing.JTabbedPane TabbedPane;
    // End of variables declaration//GEN-END:variables
}
