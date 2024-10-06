/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Imobiliaria;

/**
 *
 * @author sab40
 */
public class ImobiliariaController {
    
    public boolean cadastrarImobiliariaController (Integer id, String nome, String telefone, String email, String cnpj) {
        if (id.toString().isEmpty() || nome.isEmpty() || telefone.isEmpty() || email.isEmpty() || cnpj.isEmpty()) {
            Imobiliaria imobiliaria = new Imobiliaria (id, nome, telefone, email, cnpj);
            
            imobiliaria.cadastrarImobiliaria(imobiliaria);
            return true;
        } else {
         return false;
        }
    }
    
    public boolean mudarImobiliariaController (Integer id, String nome, String telefone, String email, String cnpj) {
        if (id.toString().isEmpty() || nome.isEmpty() || telefone.isEmpty() || email.isEmpty() || cnpj.isEmpty()) {
            Imobiliaria imobiliaria = new Imobiliaria (id, nome, telefone, email, cnpj);
            
            imobiliaria.mudarImobiliaria(imobiliaria);
            return true;
        } else {
            return false;
        }
    } 
    
}
