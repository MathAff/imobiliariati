/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.ImobiliariaDAO;

/**
 *
 * @author sab40
 */
public class Imobiliaria {
    Integer id;
    String nome, telefone, email, cnpj;

    public Imobiliaria(Integer id, String nome, String telefone, String email, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cnpj = cnpj;
    }
    
    public Imobiliaria () {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public Integer cadastrarImobiliaria(Imobiliaria imobiliaria) {
        return new ImobiliariaDAO().insertImobiliaria(imobiliaria);
    }
    
    public Integer mudarImobiliaria (Imobiliaria imobiliaria) {
        return new ImobiliariaDAO().updateImobiliaria(imobiliaria);
    }
}
