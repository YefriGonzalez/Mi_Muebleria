/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.DB;

import com.mycompany.miMuebleria.MiMuebleriaException;
import com.mycompany.miMuebleria.Usuario;
import com.mycompany.miMuebleria.archivo.ERROR;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author yefri
 */
public class DBUsuario {
    private ArrayList<ERROR> errores=new ArrayList<>();
    private static ArrayList<ERROR> errores1=new ArrayList<>();
    
    public Usuario Validar(String username, String password) throws MiMuebleriaException, SQLException {
        Usuario usuario = null;
        PreparedStatement consulta = (PreparedStatement) (Conexion.conexion()).prepareStatement("SELECT *FROM usuario WHERE usuario=? AND password=? COLLATE utf8mb4_bin");
        consulta.setString(1, username);
        consulta.setString(2, password);

        ResultSet result = consulta.executeQuery();
        if (result.next()) {
            usuario = new Usuario(username, password, result.getString(3), result.getString(4));
            return usuario;
        } else {
            errores.add(new ERROR("FORMATO: ", "Error al comprobar tipo  de usuario"));
            return null;
        }
    }

    public static void agregarUsuario(Usuario usuario) throws MiMuebleriaException {
        if (usuario.getPassword().length() >= 6) {
            try {
                PreparedStatement insert = (PreparedStatement) (Conexion.conexion()).prepareStatement("INSERT IGNORE INTO usuario(usuario,password,tipo,estado) VALUES(?,?,?,?)");
                insert.setString(1, usuario.getUsername());
                insert.setString(2, usuario.getPassword());
                insert.setString(3, String.valueOf(usuario.getTipo()));
                insert.setString(4, String.valueOf(usuario.getEstado()));
                insert.execute();
            } catch (SQLException e) {
                errores1.add(new ERROR("FORMATO: " +e.getMessage(), "Error al insertar usuario"));
            }
        } else{
            errores1.add(new ERROR("FORMATO: "+usuario.getPassword(), "Contraseña no compatible"));
        }

    }
}
