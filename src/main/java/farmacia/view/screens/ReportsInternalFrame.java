package farmacia.view.screens;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import farmacia.view.Sizes;
import farmacia.view.classes.ItemVenda;
import farmacia.view.classes.Venda;
import farmacia.view.interfaces.IReportsPanel;
import farmacia.view.interfaces.ISellingsPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author kcalixto
 */
public class ReportsInternalFrame extends javax.swing.JInternalFrame implements ISellingsPanel, IReportsPanel {

    /**
     * Creates new form ReportsInternalFrame
     */
    public ReportsInternalFrame() {
        initComponents();
        startComponents();
        loadTabelaVendas(getVendas());
    }

    public void startComponents() {
        tabelaItemVendas.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // do nothing
            }

            @Override
            public void mouseMoved(MouseEvent e) {

                // Set the tooltip to an empty string
                tabelaItemVendas.setToolTipText("");

                try {
                    // Get the table cell value where the mouse is located
                    String value = (String) tabelaItemVendas.getValueAt(tabelaItemVendas.rowAtPoint(e.getPoint()),
                            tabelaItemVendas.columnAtPoint(e.getPoint()));
                    // If the length of the value is greater than some number...
                    if (value.length() > 20) {
                        tabelaItemVendas.setToolTipText(value);
                    }
                } catch (java.lang.ClassCastException parseError) {
                    switch (parseError.getLocalizedMessage()) {
                        case "class java.lang.Integer cannot be cast to class java.lang.String (java.lang.Integer and java.lang.String are in module java.base of loader 'bootstrap')":
                            // Get the table cell value where the mouse is located
                            int intValue = (Integer) tabelaItemVendas.getValueAt(
                                    tabelaItemVendas.rowAtPoint(e.getPoint()),
                                    tabelaItemVendas.columnAtPoint(e.getPoint()));
                            // If the length of the value is greater than some number...
                            tabelaItemVendas.setToolTipText(intValue + "");
                            break;
                        case "class java.lang.Double cannot be cast to class java.lang.String (java.lang.Double and java.lang.String are in module java.base of loader 'bootstrap')":
                            // Get the table cell value where the mouse is located
                            Double doubleValue = (Double) tabelaItemVendas.getValueAt(
                                    tabelaItemVendas.rowAtPoint(e.getPoint()),
                                    tabelaItemVendas.columnAtPoint(e.getPoint()));
                            // If the length of the value is greater than some number...
                            tabelaItemVendas.setToolTipText(doubleValue + "");
                            break;
                    }
                } catch (Exception error) {
                    System.out.println("error: " + error);
                }
            }
        });
    }

    public void loadTabelaVendas(ArrayList<Venda> vendas) {
        System.out.println("filling table vendas with " + vendas.size() + " items");
        DefaultTableModel model = (DefaultTableModel) tabelaVendas.getModel();
        model.getDataVector().removeAllElements();

        double total = 0.0;
        for (Venda v : vendas) {
            total += v.getTotal();
            model.addRow(new Object[] { v.getId(), v.getCliente().getCpf(), v.getCriadoEm(), v.getTotal() + " R$" });
        }
        totalLabel.setText(String.format("%.2f", total) + " R$");

        tabelaVendas.setModel(model);
        System.out.println("filled table vendas successfully");
    }

    public void loadTabelaItemVendas(ArrayList<ItemVenda> cart) {
        System.out.println("filling table item_vendas with " + cart.size() + " items");
        DefaultTableModel model = (DefaultTableModel) tabelaItemVendas.getModel();
        model.getDataVector().removeAllElements();

        for (ItemVenda iv : cart) {
            model.addRow(new Object[] { iv.getId(), iv.getProduto().getNome(), iv.getQuantidade(),
                    iv.getValorUnitario(), iv.getValorTotal() });
        }

        tabelaItemVendas.setModel(model);
        System.out.println("filled table item_vendas successfully");
    }

    public void clearTables() {
        DefaultTableModel model;

        model = (DefaultTableModel) tabelaItemVendas.getModel();
        // model.getDataVector().removeAllElements();
        model.setRowCount(0);

        model = (DefaultTableModel) tabelaVendas.getModel();
        // model.getDataVector().removeAllElements();
        model.setRowCount(0);
    }

    public ArrayList<Venda> getVendas() {
        ArrayList<Venda> response = vendasDao.findAll();
        for (int i = 0; i < response.size(); i++) {
            response.get(i).setCliente(clienteDAO.findById(response.get(i).getCliente().getId()));
        }
        return response;
    }

    public ArrayList<Venda> getVendasByDate(String startDate, String endDate) {
        ArrayList<Venda> response = vendasDao.findByDate(startDate, endDate);
        for (int i = 0; i < response.size(); i++) {
            response.get(i).setCliente(clienteDAO.findById(response.get(i).getCliente().getId()));
        }
        return response;
    }

    public ArrayList<ItemVenda> getItemVendas(int selectedVendaID) {
        ArrayList<ItemVenda> response = itemVendaDAO.loadReport(selectedVendaID);
        return response;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logo1 = new farmacia.view.libs.Logo();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVendas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaItemVendas = new javax.swing.JTable();
        searchClientButton = new farmacia.view.libs.buttons.ConfirmButton();
        searchDateButton = new farmacia.view.libs.buttons.ConfirmButton();
        startDateInput = new javax.swing.JFormattedTextField();
        endDateInput = new javax.swing.JFormattedTextField();
        dateLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();

        setMaximumSize(Sizes.INTERNAL_FRAME_SIZE);
        setMinimumSize(Sizes.INTERNAL_FRAME_SIZE);
        setPreferredSize(Sizes.INTERNAL_FRAME_SIZE);
        setSize(Sizes.INTERNAL_FRAME_SIZE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tabelaVendas.setBackground(new java.awt.Color(255, 255, 255));
        tabelaVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "CPF DE CLIENTE", "DATA E HORA", "CAIXA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaVendas.setMaximumSize(new java.awt.Dimension(660, 600));
        tabelaVendas.setShowGrid(false);
        jScrollPane1.setViewportView(tabelaVendas);
        if (tabelaVendas.getColumnModel().getColumnCount() > 0) {
            tabelaVendas.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabelaItemVendas.setBackground(new java.awt.Color(255, 255, 255));
        tabelaItemVendas.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        tabelaItemVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nome Do Produto", "QNTD.", "VL UN.", "VL T."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaItemVendas.setBounds(new java.awt.Rectangle(0, 0, 350, 64));
        tabelaItemVendas.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        tabelaItemVendas.setMinimumSize(new java.awt.Dimension(350, 64));
        tabelaItemVendas.setRowHeight(20);
        tabelaItemVendas.setShowHorizontalLines(false);
        tabelaItemVendas.setShowVerticalLines(false);
        jScrollPane2.setViewportView(tabelaItemVendas);
        if (tabelaItemVendas.getColumnModel().getColumnCount() > 0) {
            tabelaItemVendas.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        searchClientButton.setText("CONSULTAR");
        searchClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchClientButtonActionPerformed(evt);
            }
        });

        searchDateButton.setText("OK");
        searchDateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDateButtonActionPerformed(evt);
            }
        });

        try {
            startDateInput.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        startDateInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        try {
            endDateInput.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        endDateInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        dateLabel.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(0, 0, 0));
        dateLabel.setText("Até");

        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("TOTAL:");

        totalLabel.setBackground(new java.awt.Color(0, 0, 0));
        totalLabel.setForeground(new java.awt.Color(0, 0, 0));
        totalLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalLabel.setText("asfa");
        totalLabel.setToolTipText("");
        totalLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        totalLabel.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(startDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(searchClientButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(dateLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(endDateInput)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(searchDateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(logo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchDateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(totalLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchClientButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchDateButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchDateButtonActionPerformed
        if (startDateInput.getText().isEmpty() || endDateInput.getText().isEmpty())
            return;
        clearTables();
        loadTabelaVendas(getVendasByDate(startDateInput.getText(), endDateInput.getText()));
    }// GEN-LAST:event_searchDateButtonActionPerformed

    private void searchClientButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchClientButtonActionPerformed
        int selectedVendaID = getSelectedVendaId();
        loadTabelaItemVendas(getItemVendas(selectedVendaID));
    }// GEN-LAST:event_searchClientButtonActionPerformed

    public int getSelectedVendaId() {
        DefaultTableModel model = (DefaultTableModel) tabelaVendas.getModel();
        int index = tabelaVendas.getSelectedRow();

        int ID_VENDA_INDEX = 0;
        if (index != -1) {
            return (Integer) model.getValueAt(index, ID_VENDA_INDEX);
        } else {
            System.out.println("Nenhum item selecionado");
            return -1;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateLabel;
    private javax.swing.JFormattedTextField endDateInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private farmacia.view.libs.Logo logo1;
    private farmacia.view.libs.buttons.ConfirmButton searchClientButton;
    private farmacia.view.libs.buttons.ConfirmButton searchDateButton;
    private javax.swing.JFormattedTextField startDateInput;
    private javax.swing.JTable tabelaItemVendas;
    private javax.swing.JTable tabelaVendas;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
    @Override
    // ignore
    public void confirmPressed(int newStep) {
    }

    @Override
    // ignore
    public void cancelPressed(int newStep) {
    }
}
