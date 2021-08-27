/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.miMuebleria;

import java.time.LocalDate;

/**
 *
 * @author yefri
 */
public class EnsambleMueble {

    Mueble mueble;
    Usuario usuario;
    LocalDate fecha;

    public EnsambleMueble(String mueble,String usuario, String fecha) {
        try {
            this.mueble = (Mueble) (Object) mueble;
            this.usuario = (Usuario) (Object) usuario;
            this.fecha = convertirFecha(fecha);
        } catch (Exception e) {
        }
    }

    public Mueble getMueble() {
        return mueble;
    }

    public void setMueble(String mueble) {
        try {
            this.mueble = (Mueble)(Object) mueble;
        } catch (Exception e) {
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        try {
            this.usuario = (Usuario) (Object) usuario;
        } catch (Exception e) {
        }
        
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        try {
            this.fecha = convertirFecha(fecha);   
        } catch (Exception e) {
        }
    }

    public static LocalDate convertirFecha(String fecha) {
        String[] fechaDividida = fecha.split("/");
        int dia = Integer.valueOf(fechaDividida[0]);
        int mes = Integer.valueOf(fechaDividida[1]);
        int anio = Integer.valueOf(fechaDividida[2]);
        return LocalDate.of(dia, mes, anio);
    }

}
