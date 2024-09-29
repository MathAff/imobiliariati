/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author Matheus
 */
public class ConnectionDB {
    
    private Connection conn = null;
    
    public Connection conectar (){
        String server = "db4free.net/";
        String dbName = "imobiliariati";
        String dbUser = "imobiliariati";
        String dbPsw = "1f7.2;C1Kj7;";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Inclua as bibliotecas antes!!!!");
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + server + dbName, dbUser, dbPsw);
            System.out.println("Conectado!!!");
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao banco: "+e);
        }
        return conn;
    }
    
}
