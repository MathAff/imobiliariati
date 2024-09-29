/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import utils.ConnectionDB;
import model.Imovel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Matheus
 */
public class ImovelDAO {
    
    public int insertImovel (Imovel imovel) {
        Connection conn = new ConnectionDB().conectar();
        
        try {
            String sql = "INSERT INTO imoveis (id_imobiliaria, id_proprietario, id_subtipo, tipo, tamanho, quartos, suites, vagas, banheiros, valor, taxa_condominio, iptu, tipo_negocio, bairro, cidade, endereco, cep, descricao, status_imovel)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, imovel.getIdImobiliaria().toString());
            stmt.setString(2, imovel.getIdProprietario().toString());
            stmt.setString(3, imovel.getIdSubtipo().toString());
            stmt.setString(4, imovel.getTipo());
            stmt.setString(5, String.valueOf(imovel.getTamanho()));
            stmt.setString(6, imovel.getQuartos().toString());
            stmt.setString(7, imovel.getSuites().toString());
            stmt.setString(8, imovel.getVagas().toString());
            stmt.setString(9, imovel.getBanheiros().toString());
            stmt.setString(10, String.valueOf(imovel.getValor()));
            stmt.setString(11, String.valueOf(imovel.getTaxaCondominio()));
            stmt.setString(12, String.valueOf(imovel.getIptu()));
            stmt.setString(13, imovel.getTipoNegocio());
            stmt.setString(14, imovel.getBairro());
            stmt.setString(15, imovel.getCidade());
            stmt.setString(16, imovel.getEndereco());
            stmt.setString(17, imovel.getCep());
            stmt.setString(18, imovel.getDescricao());
            stmt.setString(19, imovel.getStatusImovel());
            
            return stmt.executeUpdate();
        } catch (SQLException e) {
            return 0;
        }
    }
    
    public ResultSet selectAll () {
        Connection conn = new ConnectionDB().conectar();
        try {
            String sql = "SELECT * FROM imoveis";
            PreparedStatement stmt = conn.prepareStatement(sql);
            return stmt.executeQuery();
        } catch (SQLException e) {
            return null;
        }
    }
    
    public ResultSet selectById (Integer id) {
        Connection conn = new ConnectionDB().conectar();
            try {
                String sql = "SELEC * FROM imoveis WHERE id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, id.toString());
                return stmt.executeQuery();
            } catch (SQLException e) {
                return null;
            }
    }
    
}
