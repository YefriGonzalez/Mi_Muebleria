/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.DB;

import com.mycompany.miMuebleria.Mueble;
import java.sql.PreparedStatement;

/**
 *
 * @author yefri
 */
public class DBMueble {
    
    
    
    public static void agregarMueble(Mueble mueble){
       try {
            PreparedStatement insert=(PreparedStatement)(Conexion.conexion()).prepareStatement("INSERT INTO mueble(nombreMueble,precio) VALUES(?,?)");
            insert.setString(1, mueble.getTipoMueble());
            insert.setString(2, String.valueOf(mueble.getPrecioVenta()));
            insert.execute();
        } catch (Exception e) {
        } 
    }
    
}
