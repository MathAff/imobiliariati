/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.ConnectionDB;
import model.Anuncio;

/**
 *
 * @author Matheus
 */
public class AnuncioDAO {
    
    public Integer inserirAnuncio (Anuncio anuncio) {
        Connection conn = new ConnectionDB().conectar();
        try {
            String sql = "INSERT INTO anuncios (id_imvel, id_imobiliaria, data_anuncio) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, anuncio.getId().toString());
            stmt.setString(2, anuncio.getIdImobiliaria().toString());
            stmt.setString(3, anuncio.getDataAnuncio());
            
            return stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Nao foi possivel inserir anuncio: "+e);
            return 0;
        }
    }
    
    public Integer updateAnuncio (Anuncio anuncio) {
        Connection conn = new ConnectionDB().conectar();
        try {
            String sql = "UPDATE anuncios SET id_imovel = ?, id_imobiliaria = ?, data_anuncio = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, anuncio.getIdImovel().toString());
            stmt.setString(2, anuncio.getIdImobiliaria().toString());
            stmt.setString(3, anuncio.getDataAnuncio());
            stmt.setString(4, anuncio.getId().toString());
            
            return stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Nao foi possivel mudar o anuncio: "+e);
            return 0;
        }
    }
}