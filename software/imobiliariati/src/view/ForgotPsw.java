/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ImobiliariaController;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;

/**
 *
 * @author sab40
 */
public class ForgotPsw extends javax.swing.JFrame {

    /**
     * Creates new form Welcome
     */
    public ForgotPsw() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(700, 400);
        ImageIcon ic = new ImageIcon("C:\\xampp\\htdocs\\imobiliariati\\software\\imobiliariati\\src\\view\\UI\\favicon.png");
        setIconImage(ic.getImage());
        setTitle("Esqueci minha senha");
        tfEmail.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient2 = new view.UI.PanelGradient();
        panelLogin1 = new view.UI.PanelLogin();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfSenha = new javax.swing.JPasswordField();
        btLogin = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        tfRepeteSenha = new javax.swing.JPasswordField();
        panelGradient1 = new view.UI.PanelGradient();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btGoToCadastro = new javax.swing.JButton();

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
        jLabel3.setText("Login");

        jLabel4.setText("Email:");

        jLabel5.setText("Nova senha:");

        tfSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSenhaActionPerformed(evt);
            }
        });

        btLogin.setBackground(new java.awt.Color(0, 0, 0));
        btLogin.setForeground(new java.awt.Color(255, 255, 255));
        btLogin.setText("Mudar");
        btLogin.setBorder(null);
        btLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });

        jLabel8.setText("Repita a senha:");

        tfRepeteSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRepeteSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLogin1Layout = new javax.swing.GroupLayout(panelLogin1);
        panelLogin1.setLayout(panelLogin1Layout);
        panelLogin1Layout.setHorizontalGroup(
            panelLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogin1Layout.createSequentialGroup()
                .addGroup(panelLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLogin1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel3))
                    .addGroup(panelLogin1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(panelLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5)
                                .addComponent(tfSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addComponent(tfRepeteSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                            .addComponent(jLabel4)
                            .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLogin1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(btLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        panelLogin1Layout.setVerticalGroup(
            panelLogin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogin1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfRepeteSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        getContentPane().add(panelLogin1);
        panelLogin1.setBounds(350, 0, 350, 400);

        panelGradient1.setPreferredSize(new java.awt.Dimension(350, 400));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/UI/logo200x200.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Copyright ©- Todos os Direitos Reservados imobiliariaTI - 2024");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Não tem uma conta?");

        btGoToCadastro.setText("Cadastrar");
        btGoToCadastro.setBorder(null);
        btGoToCadastro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btGoToCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGoToCadastroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGradient1Layout = new javax.swing.GroupLayout(panelGradient1);
        panelGradient1.setLayout(panelGradient1Layout);
        panelGradient1Layout.setHorizontalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient1Layout.createSequentialGroup()
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGradient1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelGradient1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(btGoToCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelGradient1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel2)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        panelGradient1Layout.setVerticalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btGoToCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addComponent(jLabel2)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        getContentPane().add(panelGradient1);
        panelGradient1.setBounds(0, 0, 350, 400);
    }// </editor-fold>//GEN-END:initComponents

    private void btGoToCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGoToCadastroActionPerformed
        Cadastro cad = new Cadastro();
        cad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btGoToCadastroActionPerformed

    private void tfSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSenhaActionPerformed

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        String email = tfEmail.getText();
        char [] senha = tfSenha.getPassword();
        String psw = new String(senha);
        
        ResultSet rs = new ImobiliariaController().consultarImobiliariaByEmailAndSenha(email, psw);
        try {
            if (rs != null && rs.next()){
                Integer idImobiliaria = rs.getInt("id");
                InserirImovel im = new InserirImovel(idImobiliaria);
                im.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Email ou senha incorretos, tente novamente");
                tfEmail.requestFocus();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro, contate os desenvolvedores e passe o seguinte codigo: "+ex);
        }
    }//GEN-LAST:event_btLoginActionPerformed

    private void tfRepeteSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRepeteSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRepeteSenhaActionPerformed

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
            java.util.logging.Logger.getLogger(ForgotPsw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPsw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPsw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPsw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPsw().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btGoToCadastro;
    private javax.swing.JButton btLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private view.UI.PanelGradient panelGradient1;
    private view.UI.PanelGradient panelGradient2;
    private view.UI.PanelLogin panelLogin1;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JPasswordField tfRepeteSenha;
    private javax.swing.JPasswordField tfSenha;
    // End of variables declaration//GEN-END:variables
}
