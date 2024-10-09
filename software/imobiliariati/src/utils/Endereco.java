/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Matheus
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Endereco {
    String cep;
    String bairro;
    String localidade;
    String logradouro;
    String estado;
    String uf;

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String rua) {
        this.logradouro = rua;
    }

    
    
    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
    
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Endereco{" + "cep=" + cep + ", bairro=" + bairro + ", estado=" + estado + ", uf=" + uf + '}';
    }
    
    
}
