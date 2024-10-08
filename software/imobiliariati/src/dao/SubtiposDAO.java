/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import model.Subtipos;
import utils.ConnectionDB;

/**
 *
 * @author Matheus
 */
public class SubtiposDAO {
    
    public Integer insertSubtipos(Subtipos subtipo) {
        Connection conn = new ConnectionDB().conectar();
        try {
            String sql = "INSERT INTO subtipos (nome) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, subtipo.getNome());
            
            return stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Não foi possível inserir subtipo: "+e);
            return 0;
        }
    }
    
    public ResultSet selectSubtipos() {
        Connection conn = new ConnectionDB().conectar();
        try {
            String sql = "SELECT * FROM subtipos";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Nao foi possivel selecionar subtipos: "+e);
            return null;
        }
    }
    
}
