package com.mycompany.miMuebleria;

import com.mycompany.miMuebleria.archivo.LectorArchivoTexto;
import com.mycompany.mimuebleria.DB.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author yefri
 */
public class Pieza {

    private String tipoPieza;
    private double costoPieza;
    private int id;

    public Pieza(String tipoPieza, String id, String costoPieza) throws MiMuebleriaException, SQLException {
        PreparedStatement consulta = (PreparedStatement) Conexion.conexion().prepareStatement("SELECT COUNT(*) FROM pieza");

        ResultSet result = consulta.executeQuery();
        result.next();
        int num = result.getInt(1) + 1;
        LectorArchivoTexto.setCantidadPieza(num);

        try {
            this.id = Integer.valueOf(id);
            this.tipoPieza = tipoPieza;
            this.costoPieza = Double.valueOf(costoPieza);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error de numero");
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
