/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
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
    
    public ImagemDAO() {
        this.connDB = new ConnectionDB();
    }
    
    public Integer insertImagem(Imagem image) {
        Connection conn = new ConnectionDB().conectar();
        try {
            String sql = "INSERT INTO imagens (id_imovel, nome_arquivo) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, image.getIdImovel().toString());
            stmt.setString(2, image.getNomeArquivo());
            
            return stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir imagem: "+e.getMessage());
            return null;
        } finally {
            connDB.desconectar();
        }
    }
    
}
