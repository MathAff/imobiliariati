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
    
    private ConnectionDB connDB = null;
    
    public ImovelDAO () {
        connDB = new ConnectionDB();
    }

    public ResultSet selectImovel(Imovel imovel) {
        Connection conn = connDB.conectar();
        
        try {
            String sql = "SELECT * FROM imoveis WHERE id_imobiliaria = ? AND id_subtipo = ? AND tipo = ? AND tamanho = ? AND quartos = ? AND suites = ? AND vagas = ? AND banheiros = ? AND valor = ? AND taxa_condominio = ? AND iptu = ? AND tipo_negocio = ? AND bairro = ? AND cidade = ? AND endereco = ? AND cep = ? AND descricao = ? AND status_imovel = ?";
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
            
            System.out.println("Encontrou o imovel");
            
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("nao foi possivel encontrar imovel: "+e.getMessage());
            return null;
        }
    }
    
    public int insertImovel (Imovel imovel) {
        Connection conn = connDB.conectar();
        
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
        } finally {
            connDB.desconectar();
        }
    }
    
    public ResultSet selectAll () {
        Connection conn = connDB.conectar();
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
        Connection conn = connDB.conectar();
            try {
                String sql = "SELECT * FROM imoveis WHERE id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.CONCUR_UPDATABLE, ResultSet.TYPE_SCROLL_SENSITIVE);
                
                stmt.setString(1, imovel.getId().toString());
                
                return stmt.executeQuery();
            } catch (SQLException e) {
                System.out.println("Erro ao procurar imovel: "+e);
                return null;
            }
    }
    
    public Integer updateImovel (Imovel imovel) {
        Connection conn = connDB.conectar();
        try {
            String sql = "UPDATE imoveis SET id_subtipo = ?, tipo = ?, tamanho = ?, quartos = ?, suites = ?, vagas = ?, banheiros = ?, valor = ?, taxa_condominio = ?, iptu = ?, tipo_negocio = ?, bairro = ?, cidade = ?, endereco = ?, cep = ?, descricao = ?, status_imovel = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, imovel.getIdSubtipo().toString());
            stmt.setString(2, imovel.getTipo());
            stmt.setString(3, String.valueOf(imovel.getTamanho()));
            stmt.setString(4, imovel.getQuartos().toString());
            stmt.setString(5, imovel.getSuites().toString());
            stmt.setString(6, imovel.getVagas().toString());
            stmt.setString(7, imovel.getBanheiros().toString());
            stmt.setString(8, String.valueOf(imovel.getValor()));
            stmt.setString(9, String.valueOf(imovel.getTaxaCondominio()));
            stmt.setString(10, String.valueOf(imovel.getIptu()));
            stmt.setString(11, imovel.getTipoNegocio());
            stmt.setString(12, imovel.getBairro());
            stmt.setString(13, imovel.getCidade());
            stmt.setString(14, imovel.getEndereco());
            stmt.setString(15, imovel.getCep());
            stmt.setString(16, imovel.getDescricao());
            stmt.setString(17, imovel.getStatusImovel());
            stmt.setString(18, imovel.getId().toString());
            
            return stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao mudar imovel: " + e);
            return 0;
        } finally {
            connDB.desconectar();
        }
    }
    
    public Integer deleteImovel (Imovel imovel) {
        Connection conn = connDB.conectar();
        try {
            String sql = "DELETE FROM imoveis WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, imovel.getId().toString());
            
            return stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar imovel: "+e);
            return 0;
        } finally {
            connDB.desconectar();
        }
    }
    
    public ResultSet selectImovelByIdImobiliaria(Imovel im) {
        Connection conn = connDB.conectar();
        try {
            String sql = "SELECT * FROM imoveis WHERE id_imobiliaria = ?";
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.CONCUR_UPDATABLE, ResultSet.TYPE_SCROLL_SENSITIVE);
            
            stmt.setString(1, im.getIdImobiliaria().toString());
            
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Nao foi possivel selecionar imoveis: "+e);
            return null;
        }
    }
}
