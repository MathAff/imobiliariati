/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Imobiliaria;
import utils.ConnectionDB;

/**
 *
 * @author sab40
 */
public class ImobiliariaDAO {
    
    public Integer insertImobiliaria (Imobiliaria imobiliaria) {
        Connection conn = new ConnectionDB().conectar();
        try {
            String sql = "INSERT INTO imobiliarias (nome, email, telefone, cnpj) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, imobiliaria.getNome());
            stmt.setString(2, imobiliaria.getEmail());
            stmt.setString(3, imobiliaria.getTelefone());
            stmt.setString(4, imobiliaria.getCnpj());
            
            return stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar imobiliaria: "+e);
            return 0;
        }
    }
    
    public Integer updateImobiliaria (Imobiliaria imobiliaria) {
        Connection conn = new ConnectionDB().conectar();
        try {
            String sql = "UPDATE imobiliarias SET nome = ?, email = ?, telefone = ?, cnpj = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, imobiliaria.getNome());
            stmt.setString(2, imobiliaria.getEmail());
            stmt.setString(3, imobiliaria.getTelefone());
            stmt.setString(4, imobiliaria.getCnpj());
            stmt.setString(4, imobiliaria.getId().toString());
            
            return stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao mudar imobiliaria: "+e);
            return 0;
        }
    }
    
}
