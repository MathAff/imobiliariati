/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import model.Imobiliaria;
import utils.ConnectionDB;

/**
 *
 * @author sab40
 */
public class ImobiliariaDAO {
    
    private ConnectionDB connDB = null;
    
    public ImobiliariaDAO () {
        this.connDB = new ConnectionDB();
    }
    
    public Integer updateImobiliariaSenha (Imobiliaria im) {
        Connection conn = connDB.conectar();
        try {
            String sql = "UPDATE imobiliarias SET email = ?, senha = ? WHERE email = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, im.getEmail());
            stmt.setString(2, im.getSenha());
            stmt.setString(3, im.getEmail());
            
            return stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Nao foi possivel mudar a senha: "+e);
            return null;
        }
    }
    
    public ResultSet selectImobiliariaById(Imobiliaria imobiliaria) {
        Connection conn = connDB.conectar();
        System.out.println(imobiliaria.getId());
        try {
            String sql = "SELECT * FROM imobiliarias WHERE id_imobiliaria = ?";
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.CONCUR_UPDATABLE, ResultSet.TYPE_SCROLL_SENSITIVE);
            
            stmt.setString(1, imobiliaria.getId().toString());
            
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Nao foi possivel selecionar imobiliarias: "+e);
            return null;
        }
    }
    
    public Integer insertImobiliaria (Imobiliaria imobiliaria) {
        Connection conn = connDB.conectar();
        try {
            String sql = "INSERT INTO imobiliarias (nome, email, telefone, cnpj, senha) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, imobiliaria.getNome());
            stmt.setString(2, imobiliaria.getEmail());
            stmt.setString(3, imobiliaria.getTelefone());
            stmt.setString(4, imobiliaria.getCnpj());
            stmt.setString(5, imobiliaria.getSenha());
            
            return stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar imobiliaria: "+e);
            return 0;
        } finally {
            connDB.desconectar();
        }
    }
    
    public Integer updateImobiliaria (Imobiliaria imobiliaria) {
        Connection conn = connDB.conectar();
        try {
            String sql = "UPDATE imobiliarias SET nome = ?, email = ?, telefone = ? WHERE id_imobiliaria = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, imobiliaria.getNome());
            stmt.setString(2, imobiliaria.getEmail());
            stmt.setString(3, imobiliaria.getTelefone());
            stmt.setString(4, imobiliaria.getId().toString());
            
            return stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao mudar imobiliaria: "+e);
            return 0;
        }
    }
    
    public ResultSet selectImobiliariaByEmailAndSenha (Imobiliaria imobiliaria) {
        Connection conn = connDB.conectar();
        try {
            String sql = "SELECT * FROM imobiliarias WHERE email = ? AND senha = ?";
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            
            stmt.setString(1, imobiliaria.getEmail());
            stmt.setString(2, imobiliaria.getSenha());
            
            ResultSet rs = stmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Nao foi possivel consultar imobiliaria: "+e);
            return null;
        }
    }
    
    public ResultSet selectImobiliariaByCnpj (Imobiliaria imobiliaria) {
        Connection conn = connDB.conectar();
        try {
            String sql = "SELECT * FROM imobiliarias WHERE cnpj = ? ";
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            stmt.setString(1, imobiliaria.getCnpj());
            
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Nao foi possivel consultar imobiliaria");
            return null;
        }
    }
}
