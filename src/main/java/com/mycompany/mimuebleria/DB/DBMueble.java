/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.DB;

import com.mycompany.miMuebleria.Mueble;
import com.mycompany.miMuebleria.archivo.ERROR;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author yefri
 */
public class DBMueble {
    private static ArrayList<ERROR> errores=new ArrayList<>();
    public static void agregarMueble(Mueble mueble){
       try {
            PreparedStatement insert=(PreparedStatement)(Conexion.conexion()).prepareStatement("INSERT IGNORE INTO mueble(nombreMueble,precio) VALUES(?,?)");
            insert.setString(1, mueble.getTipoMueble());
            insert.setString(2, String.valueOf(mueble.getPrecioVenta()));
            insert.execute();
        } catch (Exception e) {
            errores.add(new ERROR("FORMATO: " +mueble.toString(), "Error al insertar Mueble"));
        } 
    }
    
}
