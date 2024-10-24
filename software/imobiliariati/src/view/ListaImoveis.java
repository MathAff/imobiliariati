/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ImovelController;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class ListaImoveis extends javax.swing.JFrame {
    
    private Welcome wlcm;
    private Integer idImovel;
    private final Integer idImobiliaria;

    public ListaImoveis(Integer idImobiliaria, Welcome wlcm, String email) {
        initComponents();
        ImageIcon ic = new ImageIcon(getClass().getResource("/view/UI/favicon.png"));
        setIconImage(ic.getImage());
        
        setTitle("Lista de Imóveis");
        setLocationRelativeTo(null);
        setSize(700, 550);
        
        btDeletar.setEnabled(false);
        btChange.setEnabled(false);
        
        this.idImobiliaria = idImobiliaria;
        this.wlcm = wlcm;
        
        tbImoveis.setModel(createTabelModel());
        
        TableColumnModel columnModel = tbImoveis.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(0).setMaxWidth(50);
        columnModel.getColumn(0).setMinWidth(50);
    }
    
    public ListaImoveis () {
        initComponents();
        ImageIcon ic = new ImageIcon(getClass().getResource("/view/UI/favicon.png"));
        setIconImage(ic.getImage());
        
        setTitle("Lista de Imóveis");
        setLocationRelativeTo(null);
        setSize(700, 550);
        
        btDeletar.setEnabled(false);
        btChange.setEnabled(false);
        
        this.idImobiliaria = 3;
        
        tbImoveis.setModel(createTabelModel());
        
        TableColumnModel columnModel = tbImoveis.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(0).setMaxWidth(50);
        columnModel.getColumn(0).setMinWidth(50);
    }
    
    public final DefaultTableModel createTabelModel() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        try {
            ResultSet rs = new ImovelController().consultarImovelByImobiliaria(idImobiliaria);

            model.addColumn("id");
            model.addColumn("Endereco");
            
            while (rs.next()) {
                Object [] row = new Object[2];
                
                row[0] = rs.getInt("id");
                row[1] = rs.getString("endereco");
                
                model.addRow(row);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao percorrer ResultSet: "+ex);
            return null;
        }
        return model;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbImoveis = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btDeletar = new javax.swing.JButton();
        btChange = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbImoveis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "id", "Endereço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbImoveis.setShowGrid(true);
        tbImoveis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbImoveisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbImoveis);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btDeletar.setText("Deletar");
        btDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeletarActionPerformed(evt);
            }
        });

        btChange.setText("Mudar");
        btChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChangeActionPerformed(evt);
            }
        });

        jLabel1.setText("Selecione um imóvel para habilitar as opções");

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(19, 19, 19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btChange)
                                .addGap(18, 18, 18)
                                .addComponent(btDeletar)
                                .addGap(58, 58, 58))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btVoltar)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDeletar)
                    .addComponent(btChange))
                .addGap(9, 9, 9)
                .addComponent(btVoltar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(74, 74, 74))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbImoveisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbImoveisMouseClicked
        idImovel = Integer.valueOf(tbImoveis.getValueAt(tbImoveis.getSelectedRow(), 0).toString());
        if (tbImoveis.getSelectedRow() != -1) {
            btChange.setEnabled(true);
            btDeletar.setEnabled(true);
        } else {
            btChange.setEnabled(false);
            btDeletar.setEnabled(false);
        }
    }//GEN-LAST:event_tbImoveisMouseClicked

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        wlcm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeletarActionPerformed
        if (tbImoveis.getSelectedRow() != -1) {
            ImovelController imc = new ImovelController();

            if (imc.deletarImovel(idImovel) != 0) {
                JOptionPane.showMessageDialog(null, "Imovel deletado com sucesso!!!");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível deletar o imóvel");
            }
            
            tbImoveis.setModel(createTabelModel());
            
            TableColumnModel columnModel = tbImoveis.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(50);
            columnModel.getColumn(0).setMaxWidth(50);
            columnModel.getColumn(0).setMinWidth(50);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um item");
        }
    
    }//GEN-LAST:event_btDeletarActionPerformed

    private void btChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChangeActionPerformed
        System.out.println(idImovel.toString());
        new MudarImovel(this.idImovel, this).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btChangeActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaImoveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ListaImoveis().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btChange;
    private javax.swing.JButton btDeletar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbImoveis;
    // End of variables declaration//GEN-END:variables
}
