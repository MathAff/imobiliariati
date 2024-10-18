/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
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
                    System.out.println("Erro ao no InputStream: "+ex.getMessage());
                    return false;
                } finally {
                    ftp.desconectar();
                }
            }
            
            return true;
            
        } catch (IOException e) {
            
            System.out.println("Erro ao executar o upload do arquivo!!! "+e.getMessage());
            return false;
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
}
