/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import utils.ConnectionDB;
import java.sql.Connection;

/**
 *
 * @author Matheus
 */
public class Main {
    public static void main(String[] args) {
        Connection connection = new ConnectionDB().conectar();
    }
}
