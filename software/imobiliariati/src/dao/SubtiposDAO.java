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
    
    private ConnectionDB connDB = null;
    
    public SubtiposDAO () {
        this.connDB = new ConnectionDB();
    }
    
    public Integer insertSubtipos(Subtipos subtipo) {
        Connection conn = connDB.conectar();
        try {
            String sql = "INSERT INTO subtipos (nome) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, subtipo.getNome());
            
            return stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Não foi possível inserir subtipo: "+e);
            return 0;
        } finally {
            connDB.desconectar();
        }
    }
    
    public ResultSet selectSubtipos() {
        Connection conn = connDB.conectar();
        try {
            String sql = "SELECT * FROM subtipos";
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Nao foi possivel selecionar subtipos: "+e);
            return null;
        }
    }
    
    public ResultSet selectSubtiposByNome (Subtipos subtipo) {
        Connection conn = connDB.conectar();
        try {
            String sql = "SELECT * FROM subtipos WHERE nome = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, subtipo.getNome());
            
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Nao foi possivel encontrar subtipos: "+e.getMessage());
            return null;
        }
    }

    public ResultSet selectSubtiposByTipo(String tipo) {
        Connection conn = connDB.conectar();
        try {
            String sql = "SELECT * FROM subtipos WHERE nome LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, tipo + "%");
            
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Nao foi possivel encontrar subtipos: "+e.getMessage());
            return null;
        }
    }
}
