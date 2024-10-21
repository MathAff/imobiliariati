/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.ResultSet;

import model.Imovel;

/**
 *
 * @author Matheus
 */
public class ImovelController {
    
    public boolean cadastrarImovel (Integer idImobiliaria, Integer idSubtipo, Integer quartos, Integer suites, Integer vagas, Integer banheiros, String statusImovel, String tipo, String tipoNegocio, String bairro, String cidade, String endereco, String cep, String descricao, float tamanho, float valor, float taxaCondominio, float iptu) {
        if (String.valueOf(valor).matches("^\\d{11,}[.,]?\\d{3,}$")) {
            System.out.println("Valor muito alto, vamo abaixar isso aí");
            return false;
        }
        if (idImobiliaria == null || idImobiliaria.toString().isEmpty() || idSubtipo == null || idSubtipo.toString().isEmpty() || tipo == null || tipo.isEmpty() || String.valueOf(tamanho).isEmpty() || tamanho <= 0 || valor <= 0 || taxaCondominio < 0 || iptu < 0 || quartos == null || suites == null || vagas == null || banheiros == null || String.valueOf(valor).isEmpty() || String.valueOf(taxaCondominio).isEmpty() || String.valueOf(iptu).isEmpty() || tipoNegocio == null || tipoNegocio.isEmpty() || bairro == null || cidade == null || endereco == null || cep == null || descricao == null || statusImovel == null || tipoNegocio.isEmpty()) {

                return false;
        } else {
            statusImovel = switch (statusImovel) {
                case "Disponível" -> "Available";
                case "Indisponível" -> "Unavailable";
                case "Vendido" -> "Sold";
                case "Alugado" -> "Rented";
                default -> "Avaiable";
            };
            new Imovel().cadastrarImovel(new Imovel(idImobiliaria, idSubtipo, quartos, suites, vagas, banheiros, statusImovel, tipo, tipoNegocio, bairro, cidade, endereco, cep, descricao, tamanho, valor, taxaCondominio, iptu));
            
            return true;
        }
    }
    
    public boolean mudarImovel (Integer idSubtipo, Integer quartos, Integer suites, Integer vagas, Integer banheiros, String statusImovel, String tipo, String tipoNegocio, String bairro, String cidade, String endereco, String cep, String descricao, float tamanho, float valor, float taxaCondominio, float iptu) {
        if (idSubtipo.toString().isEmpty() || tipo.isEmpty() || String.valueOf(tamanho).isEmpty() || quartos.toString().isEmpty() || suites.toString().isEmpty() || vagas.toString().isEmpty() || banheiros.toString().isEmpty() || String.valueOf(valor).isEmpty() || String.valueOf(taxaCondominio).isEmpty() || String.valueOf(iptu).isEmpty() || tipoNegocio.isEmpty() || bairro.isEmpty() || cidade.isEmpty() || endereco.isEmpty() || cep.isEmpty() || descricao.isEmpty() || statusImovel.isEmpty()) {
            Imovel imovel = new Imovel();
            
            imovel.setIdSubtipo(idSubtipo);
            imovel.setQuartos(quartos);
            imovel.setSuites(suites);
            imovel.setVagas(vagas);
            imovel.setBanheiros(banheiros);
            imovel.setStatusImovel(statusImovel);
            imovel.setTipo(tipo);
            imovel.setTipoNegocio(tipoNegocio);
            imovel.setBairro(bairro);
            imovel.setCidade(cidade);
            imovel.setCep(cep);
            imovel.setEndereco(endereco);
            imovel.setDescricao(descricao);
            imovel.setTamanho(tamanho);
            imovel.setValor(valor);
            imovel.setTaxaCondominio(taxaCondominio);
            imovel.setIptu(iptu);
            
            imovel.mudarImovel(imovel);
            
            return true;
        } else {
            return false;
        }
    }
    
    public ResultSet consultarImovel (Integer idImobiliaria, Integer idSubtipo, Integer quartos, Integer suites, Integer vagas, Integer banheiros, String statusImovel, String tipo, String tipoNegocio, String bairro, String cidade, String endereco, String cep, String descricao, float tamanho, float valor, float taxaCondominio, float iptu) {
        statusImovel = switch (statusImovel) {
            case "Disponível" -> "Available";
            case "Indisponível" -> "Unavailable";
            case "Vendido" -> "Sold";
            case "Alugado" -> "Rented";
            default -> "Avaiable";
        };
        
        Imovel imovel = new Imovel(idImobiliaria, idSubtipo, quartos, suites, vagas, banheiros, statusImovel, tipo, tipoNegocio, bairro, cidade, endereco, cep, descricao, tamanho, valor, taxaCondominio, iptu);
        return imovel.consultarImovel(imovel);
    }
    
    public ResultSet consultarImovelByImobiliaria (Integer idImobiliaria) {
        Imovel imovel = new Imovel();
        imovel.setIdImobiliaria(idImobiliaria);
        return imovel.consultarImovelByImobiliaria (imovel);
    }

    public Integer deletarImovel(Integer idImovel) {
        Imovel imovel = new Imovel();
        imovel.setId(idImovel);
        return imovel.deletarImovel(imovel);
    }
    
    public ResultSet consultarImovelById(Integer id) {
        Imovel im = new Imovel();
        im.setId(id);
        return im.consultarImovelById(im);
    }
}