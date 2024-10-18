/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Imagem;
import utils.ConnectionDB;

/**
 *
 * @author Matheus
 */
public class ImagemDAO {
    
    private ConnectionDB connDB = null;
    
    public Integer insertImagem(Imagem image) {
        connDB = new ConnectionDB();
        Connection conn = connDB.conectar();
        try {
            String sql = "INSERT INTO imagens (id_imovel, nome_arquivo) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, image.getIdImovel().toString());
            stmt.setString(2, image.getNomeArquivo());
            
            System.out.println("Inserido com sucesso, teoricamente");
            return stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir imagem: "+e.getMessage());
            return null;
        } finally {
            connDB.desconectar();
        }
    }
    
    public ResultSet selectImagemByName(Imagem image) {
        Connection conn = new ConnectionDB().conectar();
        try {
            String sql = "SELECT * FROM imagens WHERE nome_arquivo = ? AND id_imovel = ?";
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            stmt.setString(1, image.getNomeArquivo());
            stmt.setString(2, image.getIdImovel().toString());
            return stmt.executeQuery();
            
        } catch (SQLException e) {
            
            System.out.println("Erro ao selecionar imagens: "+e.getMessage());
            return null;
            
        }
    }
    
}
