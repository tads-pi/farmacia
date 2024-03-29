/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia.view.screens;

import farmacia.view.Sizes;
import farmacia.view.interfaces.ILoginListener;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import farmacia.view.interfaces.ISellingsPanel;
import farmacia.view.libs.StepsTrace;
import farmacia.view.screens.sellingsPanels.SellingsPanel;
import farmacia.view.screens.sellingsPanels.ShowCPFPanel;

import javax.swing.JOptionPane;

/**
 *
 * @author kcalixto
 */
public class SellingsInternalFrame extends javax.swing.JInternalFrame implements ILoginListener, ISellingsPanel {

    private int STEP = STEP_GET_CPF;

    private StepsTrace stepsTrace = new StepsTrace();
    private ArrayList<ILoginListener> listeners = new ArrayList<ILoginListener>();

    /**
     * Creates new form SellingsInternalFrame
     */
    public SellingsInternalFrame() {
        initComponents();
        startCpfTrack();
    }

    /**
     * Adiciona outro JInternalFrame como listener da ação de logout
     * 
     * {@link farmacia.view.MainFrame#logout()}
     * @param IItemsPanel
     * @return void
     * 
     */
    public void addListener(ILoginListener toAdd) {
        listeners.add(toAdd);
    }

    /**
     * Inicia fluxo de venda para um cliente
     */
    public void startCpfTrack() {
        // Listenning logout button
        getCPFPanel.addLoginListener(this);
        // Listenning buttons pressed
        getCPFPanel.addSellingsListener(this);
        showCPFPanel.addSellingsListener(this);
        registerCPFPanel.addSellingsListener(this);
        sellingsPanel.addSellingsListener(this);
        confirmSelling.addSellingsListener(this);

        // Starting screen with first Step
        this.clearPanel();
        handleSteps(STEP);
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

        jPanel1 = new javax.swing.JPanel();
        getCPFPanel = new farmacia.view.screens.sellingsPanels.GetCPFPanel();
        showCPFPanel = new farmacia.view.screens.sellingsPanels.ShowCPFPanel();
        registerCPFPanel = new farmacia.view.screens.sellingsPanels.RegisterCPFPanel();
        sellingsPanel = new farmacia.view.screens.sellingsPanels.SellingsPanel();
        confirmSelling = new farmacia.view.screens.sellingsPanels.ConfirmSelling();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setMaximizable(true);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMaximumSize(Sizes.INTERNAL_FRAME_SIZE);
        setMinimumSize(Sizes.INTERNAL_FRAME_SIZE);
        setPreferredSize(Sizes.INTERNAL_FRAME_SIZE);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));
        jPanel1.setMinimumSize(Sizes.INTERNAL_FRAME_SIZE);
        jPanel1.setPreferredSize(Sizes.INTERNAL_FRAME_SIZE);
        jPanel1.setSize(Sizes.INTERNAL_FRAME_SIZE);
        jPanel1.setLayout(new java.awt.CardLayout());
        jPanel1.add(getCPFPanel, "card2");
        jPanel1.add(showCPFPanel, "card3");

        registerCPFPanel.setPreferredSize(new java.awt.Dimension(640, 640));
        jPanel1.add(registerCPFPanel, "card4");
        jPanel1.add(sellingsPanel, "card5");
        jPanel1.add(confirmSelling, "card6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private farmacia.view.screens.sellingsPanels.ConfirmSelling confirmSelling;
    private farmacia.view.screens.sellingsPanels.GetCPFPanel getCPFPanel;
    private javax.swing.JPanel jPanel1;
    private farmacia.view.screens.sellingsPanels.RegisterCPFPanel registerCPFPanel;
    private farmacia.view.screens.sellingsPanels.SellingsPanel sellingsPanel;
    private farmacia.view.screens.sellingsPanels.ShowCPFPanel showCPFPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void login(boolean isGerente) {
        this.setVisible(true);
    }

    @Override
    public void logout() {
        for (ILoginListener ll : listeners) {
            ll.logout();
        }
        this.setVisible(false);

        clearFields();
    }

    @Override
    public void confirmPressed(int newStep) {
        handleSteps(newStep);
    }

    @Override
    public void cancelPressed(int newStep) {
        handleSteps(newStep);
    }

    private void handleSteps(int newStep) {
        stepsTrace.add(STEP);

        int YES = 0;
        int NO = 1;
        int CANCEL = 2;

        this.STEP = newStep;
        switch (STEP) {
            case STEP_GET_CPF:
                clearPanel();
                getCPFPanel.setVisible(true);

                break;
            case STEP_SHOW_CPF:
                clearPanel();
                showCPFPanel.setVisible(true);
                showCPFPanel.LoadUserInfo();

                break;
            case STEP_CPF_REGISTER:
                clearPanel();
                registerCPFPanel.setVisible(true);
                registerCPFPanel.LoadUserInfo();
                break;
            case STEP_SELLINGS:
                clearPanel();
                sellingsPanel.setVisible(true);

                break;
            case STEP_CONFIRM_SELLING:
                clearPanel();
                confirmSelling.setVisible(true);
                // clear all cached data after completition
                clearFields();
                break;
            case STEP_CANCEL_SELLING:
                int cancel = JOptionPane.showConfirmDialog(this, "Cancelar Compra?");

                if (cancel == YES) {
                    clearPanel();
                    getCPFPanel.setVisible(true);
                    // clear all cached data after completition
                    clearFields();
                } else {
                    // Do Nothing
                }

                break;
            case LAST_STEP:
                handleSteps(stepsTrace.getLastStep());

                break;
            default:
                throw new InvalidParameterException("invalid step");
        }
    }

    private void clearFields() {
        getCPFPanel.clearFields();
        registerCPFPanel.clearFields();
    }

    private void clearPanel() {
        getCPFPanel.setVisible(false);
        showCPFPanel.setVisible(false);
        registerCPFPanel.setVisible(false);
        sellingsPanel.setVisible(false);
        confirmSelling.setVisible(false);
    }

    public SellingsPanel getSellingsPanel() {
        return this.sellingsPanel;
    }
    public ShowCPFPanel getShowCPFPanel() {
        return this.showCPFPanel;
    }
}
