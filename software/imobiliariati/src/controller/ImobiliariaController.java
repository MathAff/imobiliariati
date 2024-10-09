/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.ResultSet;

import model.Imobiliaria;
import dao.ImobiliariaDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author sab40
 */
public class ImobiliariaController {
    
    public boolean cadastrarImobiliariaController (String nome, String telefone, String email, String cnpj, String senha) {
        if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty() || cnpj.isEmpty() || cnpj.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Preencha os campos corretamente");
            return false;
        } else {
            Imobiliaria imobiliaria = new Imobiliaria (nome, telefone, email, cnpj, senha);
            try {
                ResultSet rs = new ImobiliariaDAO().selectImobiliariaByCnpj(imobiliaria);
                if (rs.isBeforeFirst()){
                    JOptionPane.showMessageDialog(null, "CNPJ já cadastrado, tente outra vez...");
                    System.out.println("resultado encontrado");
                    return false;
                } else {
                    System.out.println("Resultado não encontrado");
                    imobiliaria.cadastrarImobiliaria(imobiliaria);
                    return true;
                }
            } catch (SQLException e) {
                return false;
            }
        }
    }
    
    public boolean mudarImobiliariaController (String nome, String telefone, String email, String cnpj, String senha) {
        if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty() || cnpj.isEmpty()) {
            Imobiliaria imobiliaria = new Imobiliaria (nome, telefone, email, cnpj, senha);
            
            imobiliaria.mudarImobiliaria(imobiliaria);
            return true;
        } else {
            return false;
        }
    }
    
    public ResultSet consultarImobiliariaByEmailAndSenha (String email, String senha) {
        Imobiliaria imobiliaria = new Imobiliaria ();
        
        imobiliaria.setEmail(email);
        imobiliaria.setSenha(senha);
        return imobiliaria.consultarImobiliariaByEmailAndSenha(imobiliaria);
    }
    
}
