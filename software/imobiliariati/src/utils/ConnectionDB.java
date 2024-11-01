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
        ConnectionCredentials cc = new ConnectionCredentials();
        String server = cc.getServer();
        String dbName = cc.getDbName();
        String dbUser = cc.getDbUser();
        String dbPsw = cc.getDbPsw();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Inclua as bibliotecas antes!!!!");
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + server + dbName, dbUser, dbPsw);
            System.out.println("Conectado");
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao banco: "+e);
        }
        return conn;
    }
    
    public boolean desconectar() {
        if (conn!=null) {
            try {
                if(!conn.isClosed()) {
                    conn.close();
                    System.out.println("Fechou a conexao");
                }
                
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexao: "+e.getMessage());
            } finally {
                conn = null;
            }
            return true;
        } else {
            return false;
        }
    }
    
}
