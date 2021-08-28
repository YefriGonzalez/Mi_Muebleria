/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.DB;

import com.mycompany.miMuebleria.MiMuebleriaException;
import com.mycompany.miMuebleria.Pieza;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yefri
 */
public class DBPieza {
    
    public static void agregarPieza(Pieza pieza) throws SQLException{
        try {
            PreparedStatement insert=(PreparedStatement)Conexion.conexion().prepareStatement("INSERT INTO pieza(tipo,costo)");
            insert.setString(1, pieza.getTipoPieza());
            insert.setString(1, String.valueOf(pieza.getCostoPieza()));
            insert.execute();
        } catch (MiMuebleriaException ex) {
            Logger.getLogger(DBPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
