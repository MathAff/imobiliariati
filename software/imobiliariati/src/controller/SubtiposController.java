/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.ResultSet;
import model.Subtipos;


/**
 *
 * @author Matheus
 */
public class SubtiposController {
    
    public ResultSet selecionarSubtiposController() {
        return new Subtipos().consultarSubtipos();
    }
    
    public ResultSet selecionarSubtiposByNomeController(String nome) {
        Subtipos subtipo = new Subtipos();
        subtipo.setNome(nome);
        return new Subtipos().consultarSubtiposByNome(subtipo);
    }
    
    public ResultSet selecionarSubtiposByTipoController (String tipo) {
        return new Subtipos().consultarSubtiposByTipo(tipo);
    }
    
    public ResultSet selecionarSubtipoById(Integer id) {
        Subtipos sub = new Subtipos();
        sub.setId(id);
        return new Subtipos().consultarSubtipoById(sub);
    }
}
