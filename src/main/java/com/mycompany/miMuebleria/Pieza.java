package com.mycompany.miMuebleria;

/**
 *
 * @author yefri
 */
public class Pieza {

    private String tipoPieza;
    private double costoPieza;

    public Pieza(String tipoPieza, String costoPieza) {
        try {
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

}
