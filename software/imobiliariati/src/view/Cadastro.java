/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ImobiliariaController;
import java.awt.HeadlessException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author sab40
 */
public class Cadastro extends javax.swing.JFrame {

    /**
     * Creates new form Welcome
     */
    public Cadastro() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(700, 500);
        ImageIcon ic = new ImageIcon(getClass().getResource("/view/UI/favicon.png"));
        setIconImage(ic.getImage());
        setTitle("Cadastre Imobiliária");
        tfCnpj.requestFocus();
    }
    
    protected void limpaCampos() {
        tfCnpj.setText("");
        tfNome.setText("");
        tfEmail.setText("");
        tfTelefone.setText("");
        tfSenha.setText("");
        tfRepeteSenha.setText("");
        tfCnpj.requestFocus();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient2 = new view.UI.PanelGradient();
        panelLogin1 = new view.UI.PanelLogin();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btCadastra = new javax.swing.JButton();
        tfRepeteSenha = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfCnpj = new javax.swing.JFormattedTextField();
        tfEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfSenha = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        tfTelefone = new javax.swing.JFormattedTextField();
        panelGradient1 = new view.UI.PanelGradient();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btGoToLogin = new javax.swing.JButton();

        javax.swing.GroupLayout panelGradient2Layout = new javax.swing.GroupLayout(panelGradient2);
        panelGradient2.setLayout(panelGradient2Layout);
        panelGradient2Layout.setHorizontalGroup(
            panelGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 183, Short.MAX_VALUE)
        );
        panelGradient2Layout.setVerticalGroup(
            panelGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        panelLogin1.setPreferredSize(new java.awt.Dimension(350, 400));

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 0, 36)); // NOI18N
        jLabel3.setText("Cadastrar");

        jLabel4.setText("CNPJ:");

        jLabel5.setText("Telefone:");

        btCadastra.setBackground(new java.awt.Color(0, 0, 0));
        btCadastra.setForeground(new java.awt.Color(255, 255, 255));
        btCadastra.setText("Cadastrar");
        btCadastra.setBorder(null);
        btCadastra.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCadastra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastraActionPerformed(evt);
            }
        });

        tfRepeteSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRepeteSenhaActionPerformed(evt);
            }
        });

        jLabel7.setText("Repita a Senha:");

        jLabel8.setText("Nome:");

        try {
            tfCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCnpj.setToolTipText("");
        tfCnpj.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel9.setText("Email:");

        tfSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSenhaActionPerformed(evt);
            }
        });

        jLabel10.setText("Senha:");

        try {
            tfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("+55 (##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfTelefone.setToolTipText("");
        tfTelefone.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tfTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTelefoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLogin1Layout = new javax.swing.GroupLayout(panelLogin1);
        panelLogin1.setLayout(panelLogin1Layout);
        panelLogin1Layout.setHorizontalGroup(
            panelLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogin1Layout.createSequentialGroup()
                .addGroup(panelLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLogin1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(panelLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10)
                            .addComponent(tfSenha)
                            .addComponent(tfCnpj)
                            .addComponent(tfNome)
                            .addComponent(tfEmail)
                            .addComponent(tfTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                            .addComponent(tfRepeteSenha)))
                    .addGroup(panelLogin1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel3))
                    .addGroup(panelLogin1Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(btCadastra, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        panelLogin1Layout.setVerticalGroup(
            panelLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogin1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfRepeteSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCadastra, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        getContentPane().add(panelLogin1);
        panelLogin1.setBounds(350, 0, 350, 500);

        panelGradient1.setPreferredSize(new java.awt.Dimension(350, 400));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/UI/logo200x200.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Copyright ©- Todos os Direitos Reservados imobiliariaTI - 2024");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Já possuí uma conta?");

        btGoToLogin.setText("Login");
        btGoToLogin.setBorder(null);
        btGoToLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btGoToLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGoToLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGradient1Layout = new javax.swing.GroupLayout(panelGradient1);
        panelGradient1.setLayout(panelGradient1Layout);
        panelGradient1Layout.setHorizontalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGradient1Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGradient1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btGoToLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(61, 61, 61))
        );
        panelGradient1Layout.setVerticalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116)
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btGoToLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        getContentPane().add(panelGradient1);
        panelGradient1.setBounds(0, 0, 350, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastraActionPerformed
        String nome = tfNome.getText(), cnpj = tfCnpj.getText(), email = tfEmail.getText(), telefone = tfTelefone.getText();
        char[] senha = tfSenha.getPassword(), repeteSenha = tfRepeteSenha.getPassword();
        
        String psw = new String (senha), repeatPsw = new String (repeteSenha);
        
        if (psw.equals(repeatPsw)) {
            
            try {
                boolean cadastro = new ImobiliariaController().cadastrarImobiliariaController(nome, telefone, email, cnpj, psw);
                if (cadastro) {
                    JOptionPane.showMessageDialog(null, "Imobiliaria cadastrada com sucesso!!!");
                    limpaCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Tente novamente");
                    tfCnpj.requestFocus();
                }
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar Imobiliaria!!!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "As senhas não coincidem.");
            tfSenha.requestFocus();
        }
    }//GEN-LAST:event_btCadastraActionPerformed

    private void tfRepeteSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRepeteSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRepeteSenhaActionPerformed

    private void tfSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSenhaActionPerformed

    private void tfTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTelefoneActionPerformed

    private void btGoToLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGoToLoginActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btGoToLoginActionPerformed

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
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastra;
    private javax.swing.JButton btGoToLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private view.UI.PanelGradient panelGradient1;
    private view.UI.PanelGradient panelGradient2;
    private view.UI.PanelLogin panelLogin1;
    private javax.swing.JFormattedTextField tfCnpj;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfNome;
    private javax.swing.JPasswordField tfRepeteSenha;
    private javax.swing.JPasswordField tfSenha;
    private javax.swing.JFormattedTextField tfTelefone;
    // End of variables declaration//GEN-END:variables
}
