package com.mycompany.miMuebleria;

import com.mycompany.miMuebleria.archivo.LectorArchivoTexto;

/**
 *
 * @author yefri
 */
public class Pieza {

    private String tipoPieza;
    private double costoPieza;
    private int id;
    public Pieza(String tipoPieza,String id, String costoPieza) {
        try {
            this.id=Integer.valueOf(id);
            this.tipoPieza = tipoPieza;
            this.costoPieza = Double.valueOf(costoPieza);
        } catch (NumberFormatException e) {
        }

    }

    public String getTipoPieza() {
        return tipoPieza;
    }

    public void setTipoPieza(String tipoPieza) {
        this.tipoPieza = tipoPieza;
    }

    public double getCostoPieza() {
        return costoPieza;
    }

    public void setCostoPieza(String costoPieza) {
        try {
            this.costoPieza = Double.valueOf(costoPieza);
        } catch (NumberFormatException e) {
        }
    }

    public int getId() {
        return id;
    }

    public void setId(String id) {
        try {
            this.id = Integer.valueOf(id);
        } catch (Exception e) {
        }
    }

}
