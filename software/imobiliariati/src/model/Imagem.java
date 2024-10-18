/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;

import dao.ImagemDAO;

/**
 *
 * @author Matheus
 */
public class Imagem {
    Integer id;
    Integer idImovel;
    String nomeArquivo;

    public Imagem(Integer idImovel, String nomeArquivo) {
        this.idImovel = idImovel;
        this.nomeArquivo = nomeArquivo;
    }

    public Imagem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(Integer idImovel) {
        this.idImovel = idImovel;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }
    
    public Integer inserirImagem (Imagem image) {
        return new ImagemDAO().insertImagem(image);
    }
    
    public ResultSet consultarImagemByName (Imagem image) {
        return new ImagemDAO().selectImagemByName(image);
    }
    
}
