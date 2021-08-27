/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.miMuebleria.servlet;

import com.mycompany.miMuebleria.Usuario;

/**
 *
 * @author yefri
 */
public class ValidacionUsuario {

    public static int validar(Usuario usuario) {
        int numero;

        if (usuario.getTipo() == 1 && usuario.getEstado() == 1) {
            return numero = 1;
        } else if (usuario.getTipo() == 2 && usuario.getEstado() == 1) {
            return numero = 2;
        } else if (usuario.getTipo() == 3 && usuario.getEstado() == 1) {
            return numero = 3;
        } else {
            return numero =0;
        }
    
    }

}
