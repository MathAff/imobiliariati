/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import utils.ConnectionDB;

/**
 *
 * @author Matheus
 */
public class Imovel {
    Integer id, idImobiliaria, idProprietario, idSubtipo, quartos, suites, vagas, banheiros;
    String tipo, tipoNegocio, bairro, cidade, endereco, cep, descricao, statusImovel;
    float tamanho, valor, taxaCondominio, iptu;

    public Imovel() {
        
    }

    public Imovel(Integer id, Integer idImobiliaria, Integer idProprietario, Integer idSubtipo, Integer quartos, Integer suites, Integer vagas, Integer banheiros, String statusImovel, String tipo, String tipoNegocio, String bairro, String cidade, String endereco, String cep, String descricao, float tamanho, float valor, float taxaCondominio, float iptu) {
        this.id = id;
        this.idImobiliaria = idImobiliaria;
        this.idProprietario = idProprietario;
        this.idSubtipo = idSubtipo;
        this.quartos = quartos;
        this.suites = suites;
        this.vagas = vagas;
        this.banheiros = banheiros;
        this.statusImovel = statusImovel;
        this.tipo = tipo;
        this.tipoNegocio = tipoNegocio;
        this.bairro = bairro;
        this.cidade = cidade;
        this.endereco = endereco;
        this.cep = cep;
        this.descricao = descricao;
        this.tamanho = tamanho;
        this.valor = valor;
        this.taxaCondominio = taxaCondominio;
        this.iptu = iptu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdImobiliaria() {
        return idImobiliaria;
    }

    public void setIdImobiliaria(Integer idImobiliaria) {
        this.idImobiliaria = idImobiliaria;
    }

    public Integer getIdProprietario() {
        return idProprietario;
    }

    public void setIdProprietario(Integer idProprietario) {
        this.idProprietario = idProprietario;
    }

    public Integer getIdSubtipo() {
        return idSubtipo;
    }

    public void setIdSubtipo(Integer idSubtipo) {
        this.idSubtipo = idSubtipo;
    }

    public Integer getQuartos() {
        return quartos;
    }

    public void setQuartos(Integer quartos) {
        this.quartos = quartos;
    }

    public Integer getSuites() {
        return suites;
    }

    public void setSuites(Integer suites) {
        this.suites = suites;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public Integer getBanheiros() {
        return banheiros;
    }

    public void setBanheiros(Integer banheiros) {
        this.banheiros = banheiros;
    }

    public String getStatusImovel() {
        return statusImovel;
    }

    public void setStatusImovel(String statusImovel) {
        this.statusImovel = statusImovel;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoNegocio() {
        return tipoNegocio;
    }

    public void setTipoNegocio(String tipoNegocio) {
        this.tipoNegocio = tipoNegocio;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getTamanho() {
        return tamanho;
    }

    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getTaxaCondominio() {
        return taxaCondominio;
    }

    public void setTaxaCondominio(float taxaCondominio) {
        this.taxaCondominio = taxaCondominio;
    }

    public float getIptu() {
        return iptu;
    }

    public void setIptu(float iptu) {
        this.iptu = iptu;
    }
    
    
    
}
