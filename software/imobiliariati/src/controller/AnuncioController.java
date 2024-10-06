/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Anuncio;

/**
 *
 * @author sab40
 */
public class AnuncioController {
    
    public boolean cadastrarAnuncioController (Integer id, Integer idImovel, Integer idImobiliaria, String dataAnuncio) {
        if (id.toString().equals("") || idImovel.toString().equals("") || idImobiliaria.toString().equals("") || dataAnuncio.isEmpty()) {
            Anuncio anuncio = new Anuncio(id, idImovel, idImobiliaria, dataAnuncio);
            
            anuncio.cadastrarAnuncio(anuncio);
            
            return true;
        } else {
            return false;
        }
    }
    
    public boolean mudarAnuncioController (Integer id, Integer idImovel, Integer idImobiliaria, String dataAnuncio) {
        if (id.toString().equals("") || idImovel.toString().equals("") || idImobiliaria.toString().equals("") || dataAnuncio.isEmpty()) {
            Anuncio anuncio = new Anuncio(id, idImovel, idImobiliaria, dataAnuncio);
            
            anuncio.mudarAnuncio(anuncio);
            
            return true;
        } else {
            return false;
        }
    }
    
}
