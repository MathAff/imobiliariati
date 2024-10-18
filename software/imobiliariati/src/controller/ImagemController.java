/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Imagem;


public class ImagemController {
    
    public Integer inserirImagem(Integer idImovel, String nomeArquivo) {
        String file = idImovel+"_"+nomeArquivo;
        ResultSet rs;
        
        try {
            rs = this.consultarImagemByName(idImovel, idImovel+"_"+nomeArquivo);
            
            if (!rs.next()) {
                Imagem image = new Imagem(idImovel, file);
                return image.inserirImagem(image);
            } else {
                return null;
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao criar ResultSet do select imagem: "+e.getMessage());
            return null;
        }
    }
    
    public ResultSet consultarImagemByName(Integer idImovel, String name) {
        Imagem image = new Imagem();
        
        image.setNomeArquivo(name);
        image.setIdImovel(idImovel);
        
        return image.consultarImagemByName(image);
    }
}
