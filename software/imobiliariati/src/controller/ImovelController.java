/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Imovel;

/**
 *
 * @author Matheus
 */
public class ImovelController {
    
    public boolean cadastrarImovel (Integer id, Integer idImobiliaria, Integer idProprietario, Integer idSubtipo, Integer quartos, Integer suites, Integer vagas, Integer banheiros, String statusImovel, String tipo, String tipoNegocio, String bairro, String cidade, String endereco, String cep, String descricao, float tamanho, float valor, float taxaCondominio, float iptu) {
        if (id.toString().isEmpty() || idImobiliaria.toString().isEmpty() || idProprietario.toString().isEmpty() || idSubtipo.toString().isEmpty() || tipo.isEmpty() || String.valueOf(tamanho).isEmpty() || quartos.toString().isEmpty() || suites.toString().isEmpty() || vagas.toString().isEmpty() || banheiros.toString().isEmpty() || String.valueOf(valor).isEmpty() || String.valueOf(taxaCondominio).isEmpty() || String.valueOf(iptu).isEmpty() || tipoNegocio.isEmpty() || bairro.isEmpty() || cidade.isEmpty() || endereco.isEmpty() || cep.isEmpty() || descricao.isEmpty() || statusImovel.isEmpty()) {
            Imovel imovel = new Imovel(id, idImobiliaria, idProprietario, idSubtipo, quartos, suites, vagas, banheiros, statusImovel, tipo, tipoNegocio, bairro, cidade, endereco, cep, descricao, tamanho, valor, taxaCondominio, iptu);
            
            imovel.cadastrarImovel(imovel);
            
            return true;
        } else {
            return false;
        }
    }
    
    public boolean mudarImovel (Integer id, Integer idImobiliaria, Integer idProprietario, Integer idSubtipo, Integer quartos, Integer suites, Integer vagas, Integer banheiros, String statusImovel, String tipo, String tipoNegocio, String bairro, String cidade, String endereco, String cep, String descricao, float tamanho, float valor, float taxaCondominio, float iptu) {
        if (id.toString().isEmpty() || idImobiliaria.toString().isEmpty() || idProprietario.toString().isEmpty() || idSubtipo.toString().isEmpty() || tipo.isEmpty() || String.valueOf(tamanho).isEmpty() || quartos.toString().isEmpty() || suites.toString().isEmpty() || vagas.toString().isEmpty() || banheiros.toString().isEmpty() || String.valueOf(valor).isEmpty() || String.valueOf(taxaCondominio).isEmpty() || String.valueOf(iptu).isEmpty() || tipoNegocio.isEmpty() || bairro.isEmpty() || cidade.isEmpty() || endereco.isEmpty() || cep.isEmpty() || descricao.isEmpty() || statusImovel.isEmpty()) {
            Imovel imovel = new Imovel(id, idImobiliaria, idProprietario, idSubtipo, quartos, suites, vagas, banheiros, statusImovel, tipo, tipoNegocio, bairro, cidade, endereco, cep, descricao, tamanho, valor, taxaCondominio, iptu);
            
            imovel.cadastrarImovel(imovel);
            
            return true;
        } else {
            return false;
        }
    }
}