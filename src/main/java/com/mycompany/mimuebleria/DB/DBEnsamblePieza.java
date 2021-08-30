/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.DB;

import com.mycompany.miMuebleria.Ensamble_Pieza;
import com.mycompany.miMuebleria.MiMuebleriaException;
import com.mycompany.miMuebleria.archivo.ERROR;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author yefri
 */
public class DBEnsamblePieza {

    private double costoEnsamblePieza;
    ArrayList<ERROR> errores = new ArrayList<>();

    ArrayList<Ensamble_Pieza> ensamblesPiezas = new ArrayList<>();

    public void agregarEnsamblePieza(String mueble, String pieza, String cantidad) throws SQLException, MiMuebleriaException {
        costoEnsamblePieza = 0;
        try {
            if (comprobarMueble(mueble) && comprobarPieza(pieza, cantidad) && costoEnsamblePieza > 0) {
                Ensamble_Pieza ensamblePieza = new Ensamble_Pieza(mueble, pieza, cantidad, costoEnsamblePieza);
                ensamblesPiezas.add(ensamblePieza);
                PreparedStatement insert = (PreparedStatement) Conexion.conexion().prepareStatement("INSERT IGNORE INTO ensamble_pieza(mueble,tipo,cantidad,costo) VALUES(?,?,?,?)");
                insert.setString(1, ensamblePieza.getMueble());
                insert.setString(2, ensamblePieza.getPieza());
                insert.setString(3, String.valueOf(ensamblePieza.getCantidad()));
                insert.setString(4, String.valueOf(ensamblePieza.getCosto()));
                insert.execute();
            } else {
                errores.add(new ERROR("FORMATO: " + mueble + ", " + pieza + ", " + cantidad, "Datos incorrectos para  ensamble de  pieza"));
            }
        } catch (MiMuebleriaException e) {
            errores.add(new ERROR("FORMATO: " + e, "Error al agregar ensamble de pieza a DB"));
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
            errores.add(new ERROR("FORMATO: " + mueble, "Mueble para ensamble de pieza inexistente"));
        }
        return muebleExistente;
    }

    public boolean comprobarPieza(String pieza, String numero) {
        int num = Integer.valueOf(numero);
        boolean piezaExistente = false;
        int count = 0;
        try {
            PreparedStatement consultaCantidadPieza = (PreparedStatement) Conexion.conexion().prepareStatement("SELECT COUNT(*) FROM pieza WHERE tipo=?");
            consultaCantidadPieza.setString(1, pieza);
            ResultSet result = consultaCantidadPieza.executeQuery();
            result.next();
            count = result.getInt(1);
            if (count >= num) {
                if (costoPieza(pieza, num)) {
                    piezaExistente = true;
                } else {
                    piezaExistente = false;
                }
            } else {
                errores.add(new ERROR("FORMATO: " + pieza + ": " + num, "No existe el numero de piezas solicitadas"));
                piezaExistente = false;
            }
        } catch (NumberFormatException | SQLException | MiMuebleriaException e) {
            errores.add(new ERROR("FORMATO: " +e, "Error al comprobar piezas"));
        }
        return piezaExistente;
    }

    public boolean costoPieza(String pieza, int num) throws SQLException {
        boolean PiezasExistente = false;
        try {
            PreparedStatement consultaPieza = (PreparedStatement) Conexion.conexion().prepareStatement("SELECT costo FROM pieza WHERE tipo=?");
            consultaPieza.setString(1, pieza);
            ResultSet result1 = consultaPieza.executeQuery();
            if (result1.next()) {
                costoEnsamblePieza = Double.valueOf(result1.getString(1)) * num;
                PiezasExistente = true;
            } else{
                errores.add(new ERROR("FORMATO: "+pieza, "no se pudo comprobar el costo de pieza"));
            }
        } catch (MiMuebleriaException ex) {
            errores.add(new ERROR("FORMATO: " +ex, "Error al consultar precio de pieza"));
        }
        return PiezasExistente;
    }

}
