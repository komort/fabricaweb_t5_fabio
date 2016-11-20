/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fabricadoprogramador.persistencia.jdbc;

import br.com.fabricadoprogramador.persistencia.entidade.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Fabio
 */
public class UsuarioDAO {

    ConexaoDB mod;
    final Connection con = mod.conectar();
    PreparedStatement pst;
    final String inserir = "insert into usuario (nome, login, senha) values (?,?,?)";
    final String atualizar = "update usuario set nome=?, login=?, senha=? where id=?";

    public void cadastrar(Usuario usu) {
        try {
            pst = con.prepareStatement(inserir);
            pst.setString(1, usu.getNome());
            pst.setString(2, usu.getLogin());
            pst.setString(3, usu.getSenha());
            pst.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void alterar(Usuario usu) {
        try {
            pst = con.prepareStatement(atualizar);
            pst.setString(1, usu.getNome());
            pst.setString(2, usu.getLogin());
            pst.setString(3, usu.getSenha());
            pst.setInt(4, usu.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void deletar(){
        
    }

}
