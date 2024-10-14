/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;

import dao.SubtiposDAO;

/**
 *
 * @author Matheus
 */
public class Subtipos {
    Integer id, idSubtipo;
    String nome;

    public Subtipos () {
        
    }
    
    public Subtipos(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdSubtipo() {
        return idSubtipo;
    }

    public void setIdSubtipo(Integer idSubtipo) {
        this.idSubtipo = idSubtipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public ResultSet consultarSubtipos () {
        return new SubtiposDAO().selectSubtipos();
    }
    
    public ResultSet consultarSubtiposByNome (Subtipos subtipo) {
        return new SubtiposDAO().selectSubtiposByNome(subtipo);
    }
    
}
