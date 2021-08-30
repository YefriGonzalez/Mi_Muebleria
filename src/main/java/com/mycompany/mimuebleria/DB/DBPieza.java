/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.DB;

import com.mycompany.miMuebleria.MiMuebleriaException;
import com.mycompany.miMuebleria.Pieza;
import com.mycompany.miMuebleria.archivo.ERROR;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author yefri
 */
public class DBPieza {
    private static ArrayList<ERROR> errores=new ArrayList<>();
    public static void agregarPieza(Pieza pieza) throws SQLException{
        try {
            PreparedStatement insert=(PreparedStatement)Conexion.conexion().prepareStatement("INSERT IGNORE INTO pieza(tipo,id,costo) VALUES(?,?,?)");
            insert.setString(1, pieza.getTipoPieza());
            insert.setString(2, String.valueOf(pieza.getId()));
            insert.setString(3, String.valueOf(pieza.getCostoPieza()));
            insert.execute();
        } catch (MiMuebleriaException ex) {
            errores.add(new ERROR("FORMATO: " +pieza.getTipoPieza(), "Error al insertar pieza"));
        }
    }
}
