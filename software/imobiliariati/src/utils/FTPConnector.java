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
    
    public FTPClient conectar () {
        try {
            FTPClient ftp = new FTPClient();
            ftp.connect("ftpupload.net");
            ftp.login("if0_37394250", "OHCZFZ4DkB");
            return ftp;
        } catch (IOException e) {
            System.out.println("Nao foi possivel conectar ao ftp: "+e);
            return null;
        }
    }
    
}
