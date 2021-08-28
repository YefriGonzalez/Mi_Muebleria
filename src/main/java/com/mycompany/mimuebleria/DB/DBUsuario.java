/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.DB;

import com.mycompany.miMuebleria.MiMuebleriaException;
import com.mycompany.miMuebleria.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author yefri
 */
public class DBUsuario {

    public Usuario Validar(String username, String password) throws MiMuebleriaException, SQLException {
        Usuario usuario = null;
        PreparedStatement consulta = (PreparedStatement) (Conexion.conexion()).prepareStatement("SELECT *FROM usuario WHERE usuario=? AND password=?");
        consulta.setString(1, username);
        consulta.setString(2, password);

        ResultSet result = consulta.executeQuery();
        if (result.next()) {
            usuario = new Usuario(username, password, result.getString(3), result.getString(4));
            return usuario;
        } else {
            return null;
        }
    }

    public static void agregarUsuario(Usuario usuario) throws MiMuebleriaException {
        if (usuario.getPassword().length() >= 6) {
            try {
                PreparedStatement insert = (PreparedStatement) (Conexion.conexion()).prepareStatement("INSERT INTO usuario(usuario,password,tipo,estado) VALUES(?,?,?,?)");
                insert.setString(1, usuario.getUsername());
                insert.setString(2, usuario.getPassword());
                insert.setString(3, String.valueOf(usuario.getTipo()));
                insert.setString(4, String.valueOf(usuario.getEstado()));

                insert.execute();
            } catch (SQLException e) {
            }
        }

    }
}
