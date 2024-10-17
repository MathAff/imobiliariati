/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Imagem;


public class ImagemController {
    public Integer inserirImagem(Integer idImovel, String nomeArquivo) {
        Imagem image = new Imagem(idImovel, nomeArquivo);
        return image.inserirImagem(image);
    }
}
