/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author Matheus
 */
public class FTPConnector {
    
    public FTPClient ftp = null;
    
    public FTPClient conectar () {
        try {
            ftp = new FTPClient();
            ftp.connect("localhost");
            ftp.login("usuario", "123");
            System.out.println("Conectado ao FTP");
            return ftp;
        } catch (IOException e) {
            System.out.println("Nao foi possivel conectar ao ftp: "+e);
            return null;
        }
    }
    
    public void desconectar () {
        if (ftp!=null) {
            try {
                if (ftp.isConnected()) {
                    ftp.logout();
                }
                ftp.disconnect();
            } catch (IOException e) {
                System.out.println("Erro ao desconectar: "+e.getMessage());
            } finally {
                System.out.println("Fechou a conexao");
                ftp = null;
            }  
        }
    }
    
}
