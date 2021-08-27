/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.miMuebleria;

/**
 *
 * @author yefri
 */
public class Ensamble_Pieza {

    private Pieza pieza;
    private int cantidad;
    private Mueble mueble;

    public Ensamble_Pieza(String pieza, String cantidad, String mueble) {
        try {
            this.pieza = (Pieza) (Object) (pieza);
            this.cantidad = Integer.valueOf(cantidad);
            this.mueble = (Mueble) (Object) mueble;
        } catch (NumberFormatException e) {
        }
    }

    public Pieza getPieza() {
        return pieza;
    }

    public void setPieza(String pieza) {
        try {
            this.pieza = (Pieza)(Object)pieza;
        } catch (Exception e) {
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        try {
            this.cantidad = Integer.valueOf(cantidad);
        } catch (NumberFormatException e) {
        }
    }

    public Mueble getMueble() {
        return mueble;
    }

    public void setMueble(String mueble) {
        try {
            this.mueble = (Mueble)(Object)mueble;
        } catch (Exception e) {
        }
    }

}
