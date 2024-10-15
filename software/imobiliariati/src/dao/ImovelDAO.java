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
import javax.swing.JOptionPane;

/**
 *
 * @author Matheus
 */
public class ImovelDAO {
    
    public int insertImovel (Imovel imovel) {
        Connection conn = new ConnectionDB().conectar();
        
        try {
            String sql = "INSERT INTO imoveis (id_imobiliaria, id_subtipo, tipo, tamanho, quartos, suites, vagas, banheiros, valor, taxa_condominio, iptu, tipo_negocio, bairro, cidade, endereco, cep, descricao, status_imovel)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, imovel.getIdImobiliaria().toString());
            stmt.setString(2, imovel.getIdSubtipo().toString());
            stmt.setString(3, imovel.getTipo());
            stmt.setString(4, String.valueOf(imovel.getTamanho()));
            stmt.setString(5, imovel.getQuartos().toString());
            stmt.setString(6, imovel.getSuites().toString());
            stmt.setString(7, imovel.getVagas().toString());
            stmt.setString(8, imovel.getBanheiros().toString());
            stmt.setString(9, String.valueOf(imovel.getValor()));
            stmt.setString(10, String.valueOf(imovel.getTaxaCondominio()));
            stmt.setString(11, String.valueOf(imovel.getIptu()));
            stmt.setString(12, imovel.getTipoNegocio());
            stmt.setString(13, imovel.getBairro());
            stmt.setString(14, imovel.getCidade());
            stmt.setString(15, imovel.getEndereco());
            stmt.setString(16, imovel.getCep());
            stmt.setString(17, imovel.getDescricao());
            stmt.setString(18, imovel.getStatusImovel());
            
            return stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir imovel: "+e);
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
            System.out.println("Erro ao procurar imoveis: "+e);
            return null;
        }
    }
    
    public ResultSet selectById (Imovel imovel) {
        Connection conn = new ConnectionDB().conectar();
            try {
                String sql = "SELEC * FROM imoveis WHERE id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                
                stmt.setString(1, imovel.getId().toString());
                
                return stmt.executeQuery();
            } catch (SQLException e) {
                System.out.println("Erro ao procurar imovel: "+e);
                return null;
            }
    }
    
    public Integer updateImovel (Imovel imovel) {
        Connection conn = new ConnectionDB().conectar();
        try {
            String sql = "UPDATE imoveis SET id_imobiliaria = ?, id_subtipo = ?, tipo = ?, tamanho = ?, quartos = ?, suites = ?, vagas = ?, banheiros = ?, valor = ?, taxa_condominio = ?, iptu = ?, tipo_negocio = ?, bairro = ?, cidade = ?, endereco = ?, cep = ?, descricao = ?, status_imovel = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, imovel.getIdImobiliaria().toString());
            stmt.setString(2, imovel.getIdSubtipo().toString());
            stmt.setString(3, imovel.getTipo());
            stmt.setString(4, String.valueOf(imovel.getTamanho()));
            stmt.setString(5, imovel.getQuartos().toString());
            stmt.setString(6, imovel.getSuites().toString());
            stmt.setString(7, imovel.getVagas().toString());
            stmt.setString(8, imovel.getBanheiros().toString());
            stmt.setString(9, String.valueOf(imovel.getValor()));
            stmt.setString(10, String.valueOf(imovel.getTaxaCondominio()));
            stmt.setString(11, String.valueOf(imovel.getIptu()));
            stmt.setString(12, imovel.getTipoNegocio());
            stmt.setString(13, imovel.getBairro());
            stmt.setString(14, imovel.getCidade());
            stmt.setString(15, imovel.getEndereco());
            stmt.setString(16, imovel.getCep());
            stmt.setString(17, imovel.getDescricao());
            stmt.setString(18, imovel.getStatusImovel());
            
            return stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir imovel: " + e);
            return 0;
        }
    }
    
    public Integer deleteImovel (Imovel imovel) {
        Connection conn = new ConnectionDB().conectar();
        try {
            String sql = "DELETE FROM imoveis WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, imovel.getId().toString());
            
            return stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar imovel: "+e);
            return 0;
        }
    }
}
