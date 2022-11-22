/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package farmacia.view.screens;

import farmacia.view.Sizes;
import farmacia.view.classes.Inventario;
import farmacia.view.classes.Produto;
import farmacia.view.interfaces.IItemsPanel;
import farmacia.view.libs.TableUtils;
import farmacia.view.libs.mysql.dao.InventarioDAO;
import farmacia.view.libs.mysql.dao.ProdutosDAO;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kcalixto
 */
public class ItemsInternalFrame extends javax.swing.JInternalFrame implements IItemsPanel {

    private ArrayList<IItemsPanel> reloadListeners = new ArrayList<IItemsPanel>();

    /**
     * Adiciona outro JInternalFrame como listener da ação de recarregar tabela
     * 
     * {@link farmacia.view.screens.ReportsInternalFrame#reloadTable}
     * {@link farmacia.view.screens.sellingsPanels.SellingsPanel#reloadTable}
     * @param IItemsPanel
     * @return void
     * 
     */
    public void addReloadListener(IItemsPanel toAdd) {
        reloadListeners.add(toAdd);
    }
    /**
     * Creates new form SellingsInternalFrame
     */
    public ItemsInternalFrame() {
        initComponents();
        TableUtils.addToolTip(jTable1);
        nomeCadastroTxt.setLineWrap(true);
        loadTable(loadInventario());
        removeScrollBars();
    }

    /**
     * Remove all scrollBars design
     */
    private void removeScrollBars(){
        jScrollPane2.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        jScrollPane2.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
        jScrollPane3.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        jScrollPane3.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
    }

    /**
     * @return Todos os inventarios
     */
    public ArrayList<Inventario> loadInventario() {
        ArrayList<Inventario> response = inventarioDAO.findAll();
        System.out.println("Loaded " + response.size() + " produtos");
        return response;
    }

    /**
     * Carrega a tabela com o inventario informado
     * @param inventario
     */
    public void loadTable(ArrayList<Inventario> inventario) {
        System.out.println("filling table inventario with "+inventario.size()+" items");
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.getDataVector().removeAllElements();

        for (Inventario i : inventario) {
            model.addRow(
                    new Object[] { i.getId(), i.getProduto().getNome(), i.getProduto().getValorUnitario(), i.getQuantidade() });
        }
        System.out.println("filled table inventario successfully");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RegistersPanelParent = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        nomeCadastroTxt = new javax.swing.JTextArea();
        buttonCadastrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        editButton = new javax.swing.JButton();
        qntcadastroTxt = new javax.swing.JFormattedTextField();
        precoTxt = new javax.swing.JFormattedTextField();
        buttonDelete = new javax.swing.JButton();
        logo1 = new farmacia.view.libs.Logo();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximizable(true);
        setMaximumSize(Sizes.INTERNAL_FRAME_SIZE);
        setMinimumSize(Sizes.INTERNAL_FRAME_SIZE);
        setNormalBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setPreferredSize(Sizes.INTERNAL_FRAME_SIZE);

        RegistersPanelParent.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nome", "Preço", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Cadastrar/Editar item");

        jLabel5.setText("Nome");

        nomeCadastroTxt.setColumns(20);
        nomeCadastroTxt.setRows(5);
        jScrollPane3.setViewportView(nomeCadastroTxt);

        buttonCadastrar.setText("cadastrar");
        buttonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarActionPerformed(evt);
            }
        });

        jLabel6.setText("Preço");

        jLabel7.setText("QNTD");

        editButton.setText("editar");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        qntcadastroTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        precoTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        buttonDelete.setText("Excluir");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RegistersPanelParentLayout = new javax.swing.GroupLayout(RegistersPanelParent);
        RegistersPanelParent.setLayout(RegistersPanelParentLayout);
        RegistersPanelParentLayout.setHorizontalGroup(
            RegistersPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistersPanelParentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RegistersPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegistersPanelParentLayout.createSequentialGroup()
                        .addGroup(RegistersPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(RegistersPanelParentLayout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(RegistersPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6)
                                    .addComponent(buttonCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7)
                                    .addComponent(qntcadastroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(precoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5))
                        .addGap(158, 239, Short.MAX_VALUE))
                    .addGroup(RegistersPanelParentLayout.createSequentialGroup()
                        .addGroup(RegistersPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                            .addGroup(RegistersPanelParentLayout.createSequentialGroup()
                                .addComponent(logo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(RegistersPanelParentLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(buttonDelete)))
                        .addContainerGap())))
        );
        RegistersPanelParentLayout.setVerticalGroup(
            RegistersPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistersPanelParentLayout.createSequentialGroup()
                .addComponent(logo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegistersPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(RegistersPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(editButton)
                        .addComponent(buttonDelete)))
                .addGap(4, 4, 4)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegistersPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, RegistersPanelParentLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qntcadastroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(RegistersPanelParent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(RegistersPanelParent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private int currentEditingInventarioId = 0;
    /**
     * Define o id de cliente que está sendo editado no momento
     * @param id
     */
    private void setCurrentEditingInventarioId(int id){
        this.currentEditingInventarioId = id;
    }
    private int getCurrentEditingInventarioId(){
        return currentEditingInventarioId;
    }

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        Inventario inventario = inventarioDAO.findById(getSelectedInventarioId());
        fillFields(inventario);
    }//GEN-LAST:event_editButtonActionPerformed

    private void fillFields(Inventario i){
        nomeCadastroTxt.setText(i.getProduto().getNome());
        precoTxt.setText(i.getProduto().getValorUnitario() + "");
        qntcadastroTxt.setText(i.getQuantidade() + "");
        setCurrentEditingInventarioId(getSelectedInventarioId());

        buttonCadastrar.setText("salvar");
    }
    private void clearFields(){
        nomeCadastroTxt.setText("");
        precoTxt.setText("");
        qntcadastroTxt.setText("");

        setCurrentEditingInventarioId(0);
        buttonCadastrar.setText("cadastrar");
    }

    private void buttonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonCadastrarActionPerformed
        // TODO arrumar tipo de produto aqui
        boolean editInProgress = getCurrentEditingInventarioId() != 0;
        if(editInProgress){
            Inventario inventario = inventarioDAO.findById(getCurrentEditingInventarioId());
            inventario.setQuantidade(Double.parseDouble(qntcadastroTxt.getText()));
            inventarioDAO.execute(inventario, InventarioDAO.UPDATE);

            Produto produto = inventario.getProduto();
            produto.setNome(nomeCadastroTxt.getText());
            produto.setValorUnitario(Double.parseDouble(precoTxt.getText()));
            produtosDAO.execute(produto, InventarioDAO.UPDATE);

            clearFields();
        }else{
            Produto newProduto = new Produto(nomeCadastroTxt.getText(), Double.parseDouble(precoTxt.getText()), "mg");
            newProduto.setId(produtosDAO.execute(newProduto, ProdutosDAO.INSERT));
    
            Inventario inventario = new Inventario(newProduto, Double.parseDouble(qntcadastroTxt.getText()));
            inventarioDAO.execute(inventario, InventarioDAO.INSERT);
        }
        loadTable(loadInventario());
    
        for (IItemsPanel ll : reloadListeners) {
            ll.reloadTable();
        }
    }// GEN-LAST:event_buttonCadastrarActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
        Inventario inventario = inventarioDAO.findById(getSelectedInventarioId());
        inventarioDAO.execute(inventario, InventarioDAO.DELETE);
        produtosDAO.execute(inventario.getProduto(), ProdutosDAO.DELETE);
        loadTable(loadInventario());

        for (IItemsPanel ll : reloadListeners) {
            ll.reloadTable();
        }
    }// GEN-LAST:event_jButton4ActionPerformed

    public int getSelectedInventarioId() {
        int index = jTable1.getSelectedRow();
        DefaultTableModel md = (DefaultTableModel) jTable1.getModel();

        if (index != -1) {
            return (Integer) md.getValueAt(index, 0);
        } else {
            System.out.println("Nenhum item selecionado");
            return -1;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel RegistersPanelParent;
    private javax.swing.JButton buttonCadastrar;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private farmacia.view.libs.Logo logo1;
    private javax.swing.JTextArea nomeCadastroTxt;
    private javax.swing.JFormattedTextField precoTxt;
    private javax.swing.JFormattedTextField qntcadastroTxt;
    // End of variables declaration//GEN-END:variables
    @Override
    /**
     * Executa processos necessários para atualizar as tabelas
     * 
     * @param void
     * @return void
     */
    public void reloadTable() {
        loadTable(loadInventario());
    }
}
