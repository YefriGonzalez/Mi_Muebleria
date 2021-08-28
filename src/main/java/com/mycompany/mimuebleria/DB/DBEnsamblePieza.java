/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.DB;

import com.mycompany.miMuebleria.Ensamble_Pieza;
import com.mycompany.miMuebleria.MiMuebleriaException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yefri
 */
public class DBEnsamblePieza {

    public void validarDatosExistentes(Ensamble_Pieza ensamblePieza) throws SQLException, MiMuebleriaException {
        try {
            if (comprobarMueble(ensamblePieza.getMueble().getTipoMueble()) && comprobarPieza(ensamblePieza.getPieza().getTipoPieza(), ensamblePieza.getCantidad())) {
                PreparedStatement insert = (PreparedStatement) Conexion.conexion().prepareStatement("INSERT INTO ensamble_pieza(mueble,tipoPieza,cantidad) VALUES(?,?,?)");
                insert.setString(1, ensamblePieza.getMueble().getTipoMueble());
                insert.setString(2, ensamblePieza.getPieza().getTipoPieza());
                insert.setInt(3, ensamblePieza.getCantidad());
            }
        } catch (MiMuebleriaException e) {

        }

    }

    public boolean comprobarMueble(String mueble) throws SQLException {
        boolean muebleExistente = false;
        try {
            PreparedStatement consultaMueble = (PreparedStatement) Conexion.conexion().prepareStatement("SELECT *FROM mueble WHERE nombreMueble=?");
            consultaMueble.setString(1, mueble);
            ResultSet result = consultaMueble.executeQuery();
            muebleExistente = result.next();
        } catch (MiMuebleriaException ex) {
            Logger.getLogger(DBEnsamblePieza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return muebleExistente;
    }

    public boolean comprobarPieza(String pieza, int numero) {
        boolean piezaExistente = false;
        int count = 0;
        try {
            PreparedStatement consultaPieza = (PreparedStatement) Conexion.conexion().prepareStatement("SELECT *FROM pieza WHERE tipo=?");
            consultaPieza.setString(1, pieza);
            ResultSet result = consultaPieza.executeQuery();
            while (result.next()) {
                count = result.getInt(1);
            }
            if (count == numero && result.next()) {
                //FALTA ELIMINAR LAS PIEZAS USADAS
                piezaExistente = true;
            } else {
                piezaExistente = false;
            }
        } catch (Exception e) {

        }

        return piezaExistente;
    }

}
