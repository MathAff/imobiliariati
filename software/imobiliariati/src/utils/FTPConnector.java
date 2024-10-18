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
            ftp.connect("127.0.0.1");
            ftp.login("usuario", "123");
            System.out.println("Conectado ao FTP");
            return ftp;
        } catch (IOException e) {
            System.out.println("Nao foi possivel conectar ao ftp: "+e);
            return null;
        }
    }
    
    public void desconectar () {
        try {
            ftp.logout();
            ftp.disconnect();
        } catch (IOException e) {
            System.out.println("Erro ao desconectar: "+e.getMessage());
        }
    }
    
}
