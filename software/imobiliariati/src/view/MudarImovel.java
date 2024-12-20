/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ImovelController;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import utils.Endereco;
import utils.ViaCepService;
import controller.SubtiposController;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;

/**
 *
 * @author Matheus
 */
public class MudarImovel extends javax.swing.JFrame {
    
    private ListaImoveis lstIm = null;
    private final Integer idImovel;
    
    public MudarImovel(Integer idImovel, ListaImoveis lstIm) {
        this.idImovel = idImovel;
        this.lstIm = lstIm;
        initComponents();
        initCbBSubtipos();
        initFields();
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        ImageIcon ic = new ImageIcon(getClass().getResource("/view/UI/favicon.png"));
        setIconImage(ic.getImage());
        setTitle("Mudar imóvel");        
    }
    public MudarImovel() {
        this.idImovel = 1;
        
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        ImageIcon ic = new ImageIcon(getClass().getResource("/view/UI/favicon.png"));
        setIconImage(ic.getImage());
        setTitle("Mudar imóvel");
        initComponents();
        initCbBSubtipos();
        initFields();
        
    }
    
    private void initCbBSubtipos() {
        ResultSet rs = new SubtiposController().selecionarSubtiposController();
        
        try {
            if (rs.next()) {
                CbBSubTipoImovel.addItem(rs.getString("nome"));
                while (rs.next()) {
                    CbBSubTipoImovel.addItem(rs.getString("nome"));
                }
            } else {
                System.out.println("Nenhum resultado encontrado");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro! Contate os desenvolvedores e mande o código: "+e);
        }
    }
    
    private void initFields() {
        try {
            ResultSet rsImovel = new ImovelController().consultarImovelById(idImovel), rsSubtipo = null;

            if (rsImovel.next()) {
                rsSubtipo = new SubtiposController().selecionarSubtipoById(rsImovel.getInt("id_subtipo"));
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível acessar os dados, tente mais tarde...");
                lstIm.setVisible(true);
                this.dispose();
            }


            if (rsSubtipo.next()) { 
                tfCep.setText(rsImovel.getString("cep"));
                tfBairro.setText(rsImovel.getString("bairro"));
                tfCidade.setText(rsImovel.getString("cidade"));
                tfRua.setText(rsImovel.getString("endereco").split("[_-]")[2]);
                tfNumero.setText(rsImovel.getString("endereco").split("[_-]")[3]);
                spTamImovel.setValue(rsImovel.getInt("tamanho"));
                CbBTipoImovel.setSelectedItem(rsImovel.getString("tipo"));
                CbBSubTipoImovel.setSelectedItem(rsSubtipo.getObject("nome"));
                spNumeroQuartos.setValue(rsImovel.getInt("quartos"));
                spNumeroSuites.setValue(rsImovel.getInt("suites"));
                spNumeroBanheiros.setValue(rsImovel.getInt("banheiros"));
                spNumeroVagas.setValue(rsImovel.getInt("vagas"));
                tfValorImovel.setText(rsImovel.getString("valor"));
                tfTxCondominio.setText(rsImovel.getString("taxa_condominio"));
                tfIptu.setText(rsImovel.getString("iptu"));
                cbBTipoNegocio.setSelectedItem(rsImovel.getString("tipo_negocio"));
                cbBStatusImovel.setSelectedItem(getStatusImovelEnPt(rsImovel.getString("status_imovel")));
                taDescricao.setText(rsImovel.getString("descricao"));            
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível acessar os dados, tente mais tarde...");
                lstIm.setVisible(true);
                lstIm.
                dispose();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro, contacte os desenvolvedores e passe o erro: "+ex);
            lstIm.setVisible(true);
            dispose();
        }
    }
    
    private String getStatusImovelEnPt(String status) {
        switch (status) {
            case "Available" -> {
                return "Disponível";
            }
            case "Unavailable" -> {
                return "Indisponível";
            }
            case "Sold" -> {
                return "Vendido";
            }
            case "Rented" -> {
                return "Alugado";
            } default -> {
                return null;
            }
        }
    }
    
    private String getStatusImovelPtEn(String status) {
        switch (status) {
            case "Disponível" -> {
                return "Available";
            }
            case "Indisponível" -> {
                return "Unavailable";
            }
            case "Vendido" -> {
                return "Sold";
            }
            case "Alugado" -> {
                return "Rented";
            } default -> {
                return null;
            }
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfBairro = new javax.swing.JTextField();
        tfCidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfCep = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        tfNumero = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        tfRua = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        spTamImovel = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CbBTipoImovel = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        CbBSubTipoImovel = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        spNumeroQuartos = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        spNumeroSuites = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        spNumeroBanheiros = new javax.swing.JSpinner();
        spNumeroVagas = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tfValorImovel = new javax.swing.JTextField();
        tfTxCondominio = new javax.swing.JTextField();
        tfIptu = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        cbBTipoNegocio = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        cbBStatusImovel = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Bairro:");

        jLabel4.setText("Cidade:");

        jLabel5.setText("Número");

        try {
            tfCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCepFocusLost(evt);
            }
        });
        tfCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCepActionPerformed(evt);
            }
        });

        jLabel2.setText("CEP:");

        tfNumero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel6.setText("Rua:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(78, 78, 78))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Tamanho do Imóvel");

        jLabel7.setText("Tipo do imóvel");

        CbBTipoImovel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Tipo do Imóvel", "Casa", "Apartamento", "Terreno" }));
        CbBTipoImovel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CbBTipoImovelFocusLost(evt);
            }
        });
        CbBTipoImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbBTipoImovelActionPerformed(evt);
            }
        });

        jLabel8.setText("SubTipo");

        CbBSubTipoImovel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o SubTipo" }));
        CbBSubTipoImovel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CbBSubTipoImovelFocusLost(evt);
            }
        });
        CbBSubTipoImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbBSubTipoImovelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbBTipoImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spTamImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbBSubTipoImovel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(60, 60, 60))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spTamImovel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(CbBTipoImovel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(CbBSubTipoImovel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        spNumeroQuartos.setMaximumSize(new java.awt.Dimension(100, 100));

        jLabel9.setText("Número de quartos");

        jLabel10.setText("Número de suítes");

        jLabel11.setText("Número de banheiros");

        jLabel12.setText("Número de vagas");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spNumeroBanheiros, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spNumeroQuartos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spNumeroVagas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spNumeroSuites, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(76, 76, 76))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spNumeroQuartos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spNumeroSuites, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spNumeroBanheiros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spNumeroVagas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setText("Valor Imóvel");

        jLabel14.setText("Taxa de Condomínio");

        jLabel16.setText("IPTU");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfIptu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfValorImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfTxCondominio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(tfValorImovel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(tfTxCondominio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(tfIptu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setText("Mudar a descricao:");

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        taDescricao.setColumns(20);
        taDescricao.setLineWrap(true);
        taDescricao.setRows(5);
        taDescricao.setWrapStyleWord(true);
        jScrollPane3.setViewportView(taDescricao);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Concluir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(23, 23, 23))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setText("Tipo de Negócio");

        cbBTipoNegocio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Alugel", "Venda", "Locação", "Permuta" }));

        jLabel18.setText("Status do Imóvel:");

        cbBStatusImovel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Status", "Disponível", "Indisponível", "Vendido", "Alugado" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbBStatusImovel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbBTipoNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cbBTipoNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cbBStatusImovel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
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

    private void tfCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCepActionPerformed

    private void tfCepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCepFocusLost
        String cep = tfCep.getText();
        String replace = cep.replace("-", "").replace(" ","");
        if (!replace.isEmpty()) {
            Endereco end = new ViaCepService().getEndereco(cep);

            String cidade = end.getLocalidade();
            String bairro = end.getBairro();

            tfRua.setText(end.getLogradouro());
            tfBairro.setText(bairro);
            tfCidade.setText(cidade);
            
        }
        
    }//GEN-LAST:event_tfCepFocusLost

    private void CbBTipoImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbBTipoImovelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbBTipoImovelActionPerformed

    private void CbBSubTipoImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbBSubTipoImovelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbBSubTipoImovelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Integer idSubtipo = null;
        
        String tipoImovel = (String) CbBTipoImovel.getSelectedItem();
        String cep = tfCep.getText(), bairro = tfBairro.getText(), rua = tfRua.getText(), cidade = tfCidade.getText(), numero = tfNumero.getText();
        Integer tamImovel = (Integer) spTamImovel.getValue();
        Integer nQuartos = (Integer) spNumeroQuartos.getValue();
        Integer nSuites = (Integer) spNumeroSuites.getValue();
        Integer nBanheiros = (Integer) spNumeroBanheiros.getValue();
        Integer nVagas = (Integer) spNumeroVagas.getValue();
        String valorImovel = tfValorImovel.getText();
        String txCondominio = tfTxCondominio.getText();
        String valorIptu = tfIptu.getText();
        String tipoNegocio = (String) cbBTipoNegocio.getSelectedItem();
        String statusImovel = getStatusImovelPtEn((String) cbBStatusImovel.getSelectedItem());
        String descricao = taDescricao.getText();
        String endereco = cidade + "_" + bairro + "_" + rua + "_" + numero;
        
        String subtipoImovel = (String) CbBSubTipoImovel.getSelectedItem();
        System.out.println(subtipoImovel);
        
        try {
            ResultSet rs = new SubtiposController().selecionarSubtiposByNomeController(subtipoImovel);
            if (rs.next()) {
                idSubtipo = rs.getInt("id_subtipo");
                System.out.println(idSubtipo);
            } else {
                System.out.println("Nao achou subtipos");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO! Contate os desenvolvedores e passe o erro: "+e);
        }
        
        if (valorImovel.matches("^(\\d{1,9}(?:[.,]\\d{0,2})?)?$") && txCondominio.matches("^(\\d{1,9}(?:[.,]\\d{0,2})?)?$") && valorIptu.matches("^(\\d{1,9}(?:[.,]\\d{0,2})?)?$")) {
            Float valor = null;
            Float condominio = null;
            Float iptu = null;
            if (!valorImovel.isEmpty()) {
                valor = Float.valueOf(valorImovel.replace(".", "").replace(",", "."));
            } 
            if (!txCondominio.isEmpty()) {
                condominio = Float.valueOf(txCondominio.replace(".", "").replace(",", "."));
            } 
            if (!valorIptu.isEmpty()) {
                iptu = Float.valueOf(valorIptu.replace(".", "").replace(",", "."));
            }
            
            System.out.println(valor);
            System.out.println(iptu);
            System.out.println(txCondominio);

            boolean mudImovel = new ImovelController().mudarImovel(idImovel, idSubtipo, nQuartos, nSuites, nVagas, nBanheiros, statusImovel, tipoImovel, tipoNegocio, bairro, cidade, endereco, cep, descricao, tamImovel, valor, condominio, iptu);

            if (mudImovel) {
                JOptionPane.showMessageDialog(null, "Imóvel mudado com sucesso!!!");
                lstIm.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível mudar Imóvel, preencha todos os campos!!!.");
            }
        } else {
            System.out.println(valorImovel);
            System.out.println(txCondominio);
            System.out.println(valorIptu);
            tfValorImovel.requestFocus();
            JOptionPane.showMessageDialog(null, "Não foi possível mudar Imóvel, digite uma quantia válida.");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CbBSubTipoImovelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CbBSubTipoImovelFocusLost
    }//GEN-LAST:event_CbBSubTipoImovelFocusLost

    private void tfValorImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfValorImovelActionPerformed
    }//GEN-LAST:event_tfValorImovelActionPerformed

    private void tfTxCondominioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTxCondominioActionPerformed
    }//GEN-LAST:event_tfTxCondominioActionPerformed

    private void tfIptuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIptuActionPerformed
    }//GEN-LAST:event_tfIptuActionPerformed

    private void tfValorImovelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfValorImovelFocusGained
    }//GEN-LAST:event_tfValorImovelFocusGained

    private void tfTxCondominioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfTxCondominioFocusGained
    }//GEN-LAST:event_tfTxCondominioFocusGained

    private void tfIptuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfIptuFocusGained
    }//GEN-LAST:event_tfIptuFocusGained
    private void tfValorImovelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfValorImovelFocusLost
     
    }//GEN-LAST:event_tfValorImovelFocusLost
    private void tfTxCondominioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfTxCondominioFocusLost
 
    }//GEN-LAST:event_tfTxCondominioFocusLost
    private void tfIptuFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfIptuFocusLost
    }//GEN-LAST:event_tfIptuFocusLost

    private void CbBTipoImovelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CbBTipoImovelFocusLost
        String tipo = (String) CbBTipoImovel.getSelectedItem();
        
        CbBSubTipoImovel.removeAllItems();
        CbBSubTipoImovel.addItem("Selecione o SubTipo");
        
        if (tipo != null || !CbBSubTipoImovel.getItemAt(1).startsWith(tipo)){
            ResultSet rs = new SubtiposController().selecionarSubtiposByTipoController(tipo);
            try {
                if (rs.next()) {
                    CbBSubTipoImovel.addItem(rs.getString("nome"));
                    while (rs.next()) {
                        CbBSubTipoImovel.addItem(rs.getString("nome"));
                    }
                } else {
                    System.out.println("Nenhum resultado encontrado");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro! Contate os desenvolvedores e mande o código: "+e);
            }
        }
    }//GEN-LAST:event_CbBTipoImovelFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        lstIm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(MudarImovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MudarImovel().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbBSubTipoImovel;
    private javax.swing.JComboBox<String> CbBTipoImovel;
    private javax.swing.JComboBox<String> cbBStatusImovel;
    private javax.swing.JComboBox<String> cbBTipoNegocio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner spNumeroBanheiros;
    private javax.swing.JSpinner spNumeroQuartos;
    private javax.swing.JSpinner spNumeroSuites;
    private javax.swing.JSpinner spNumeroVagas;
    private javax.swing.JSpinner spTamImovel;
    private javax.swing.JTextArea taDescricao;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JFormattedTextField tfCep;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfIptu;
    private javax.swing.JFormattedTextField tfNumero;
    private javax.swing.JTextField tfRua;
    private javax.swing.JTextField tfTxCondominio;
    private javax.swing.JTextField tfValorImovel;
    // End of variables declaration//GEN-END:variables
}
