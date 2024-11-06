/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import model.Imovel;
import controller.ImagemController;
import controller.ImovelController;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author Matheus
 */
public class FTPFileSender {
    
    FTPConnector ftp = null;
    FTPClient ftpConn = null;
    
    public boolean sendFile (Integer id, ArrayList<String> fileList, ArrayList<String> filePathList) {
        ftp = new FTPConnector();
        ftpConn = ftp.conectar();
        String idImovel = id.toString();
        
        try {
            
            ftpConn.changeWorkingDirectory("imoveis-images");
            
            if (!directoryExists(idImovel)){
                ftpConn.makeDirectory(idImovel);
                ftpConn.changeWorkingDirectory(idImovel);
            } else {
                ftpConn.changeWorkingDirectory(idImovel);
            }
            
        } catch (IOException ex) {
            System.out.println("Erro ao criar/mudar diretorio: "+ex.getMessage());
        }
            
        try {

            ftpConn.setFileType(FTPClient.BINARY_FILE_TYPE);
            
            for (int i = 0; i < filePathList.size(); i++) {
                try (FileInputStream sendFile = new FileInputStream(filePathList.get(i))) {
                    if (ftpConn.storeFile(id+"_"+fileList.get(i), sendFile)) {
                        System.out.println("Arquivo enviado com sucesso!!!");
                    } else {
                        System.out.println("Erro ao enviar arquivo!!!");
                        return false;
                    }

                } catch (IOException ex) {
                    System.out.println("Erro no InputStream: "+ex.getMessage());
                    return false;
                }
            }
            
            return true;
            
        } catch (IOException e) {
            
            System.out.println("Erro ao executar o upload do arquivo!!! "+e.getMessage());
            return false;
        } finally {
            ftp.desconectar();
        }
    }
    
    private boolean directoryExists (String dirPath) {
        boolean dirExists = false;
        
        try {
            dirExists = ftpConn.changeWorkingDirectory(dirPath);
            ftpConn.changeToParentDirectory();
        } catch (IOException e) {
            System.out.println("Erro: "+e.getMessage());
        }
        
        return dirExists;
    }
    
    public boolean uploadFile (Imovel imovel, ArrayList<String> fileList, ArrayList<String> filePathList) {
        boolean flag = true;
        boolean cadImovel = new ImovelController().cadastrarImovel(imovel.getIdImobiliaria(), imovel.getIdSubtipo(), imovel.getQuartos(), imovel.getSuites(), imovel.getVagas(), imovel.getBanheiros(), imovel.getStatusImovel(), imovel.getTipo(), imovel.getTipoNegocio(), imovel.getBairro(), imovel.getCidade(), imovel.getEndereco(), imovel.getCep(), imovel.getDescricao(), imovel.getTamanho(), imovel.getValor(), imovel.getTaxaCondominio(), imovel.getIptu());
        Integer idImovel = null;
        
        ResultSet rs;
        
        try {
            rs = new ImovelController().consultarImovel(imovel);
            rs.next();
            idImovel = rs.getInt("id_imovel");
        } catch (SQLException e) {
            System.out.println("Não foi possível consultar imovel: "+e);
        }

        if (cadImovel) {
            if (new FTPFileSender().sendFile(idImovel, fileList, filePathList)) {
                for (String fileName : fileList) {
                    try {
                        ResultSet rsImage = new ImagemController().consultarImagemByName(idImovel, fileName);
                        if (rsImage.next()) {
                            JOptionPane.showMessageDialog(null, "Imagem: "+fileName+" já cadastrada");
                        } else {
                            new ImagemController().inserirImagem(idImovel, fileName);
                            flag = false;
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "ERRO! Passe o código para os desenvolvedores: "+ex.getMessage());
                        System.out.println("Não foi possível encontrar imagem: "+ex.getMessage());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível enviar as imagens.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar Imóvel, preencha todos os campos!!!.");
        }
        
        return flag;
    }
}
