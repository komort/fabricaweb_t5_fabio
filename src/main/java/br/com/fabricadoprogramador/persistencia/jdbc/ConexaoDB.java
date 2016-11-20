/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fabricadoprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabio
 */
public class ConexaoDB {

    final String driver = "com.mysql.jdbc.Driver";
    final String ipservidor = "localhost";
    final String portaServidor = "3306";
    final String banco = "fabricaweb";
    final String url = "jdbc:mysql://" + ipservidor + ":" + portaServidor + "/" + banco;
    final String usuario = "root";
    final String senha = "";

    public Connection conectar() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, url, banco);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "PROBLEMAS COM O DRIVER DE ACESSO", "ATENÇÃO", 0);
            return null;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "PROBLEMAS COM A URL, USUARIO OU SENHA DO BANCO DE DADOS", "ATENÇÃO", 0);
            return null;
        }
    }

}
