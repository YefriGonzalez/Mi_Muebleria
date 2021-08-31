/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.miMuebleria.interfaces;

import com.mycompany.miMuebleria.Pieza;
import java.util.List;

/**
 *
 * @author yefri
 */
public interface CRUDPIEZA {
    public List listar();
    public Pieza list(int id);
    public boolean edit(Pieza pieza);
    public boolean eliminar(int id);
}
