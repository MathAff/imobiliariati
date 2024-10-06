/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.AnuncioDAO;

/**
 *
 * @author Matheus
 */
public class Anuncio {
    Integer id, idImovel, idImobiliaria;
    String dataAnuncio;

    public Anuncio(Integer id, Integer idImovel, Integer idImobiliaria, String dataAnuncio) {
        this.id = id;
        this.idImovel = idImovel;
        this.idImobiliaria = idImobiliaria;
        this.dataAnuncio = dataAnuncio;
    }
    
    public Anuncio () {
        
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

    public void setIdImovel(Integer imovel) {
        this.idImovel = imovel;
    }

    public Integer getIdImobiliaria() {
        return idImobiliaria;
    }

    public void setIdImobiliaria(Integer idImobiliaria) {
        this.idImobiliaria = idImobiliaria;
    }

    public String getDataAnuncio() {
        return dataAnuncio;
    }

    public void setDataAnuncio (String dataAnuncio) {
        this.dataAnuncio = dataAnuncio;
    }
    
    public int cadastrarAnuncio (Anuncio anuncio) {
        return new AnuncioDAO().inserirAnuncio(anuncio);
    }
    
    public int mudarAnuncio (Anuncio anuncio) {
        return new AnuncioDAO().updateAnuncio(anuncio);
    }
    
    
}
