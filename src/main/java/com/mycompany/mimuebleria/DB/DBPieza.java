    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.DB;


import com.mycompany.miMuebleria.MiMuebleriaException;
import com.mycompany.miMuebleria.Pieza;
import com.mycompany.miMuebleria.archivo.ERROR;
import com.mycompany.miMuebleria.interfaces.CRUDPIEZA;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author yefri
 */
public class DBPieza implements CRUDPIEZA{
    private static ArrayList<ERROR> errores=new ArrayList<>();
    public static void agregarPieza(Pieza pieza) throws SQLException{
        try {
            PreparedStatement insert=(PreparedStatement)Conexion.conexion().prepareStatement("INSERT IGNORE INTO pieza(tipo,id,costo) VALUES(?,?,?)");
            insert.setString(1, pieza.getTipoPieza());
            insert.setString(2, String.valueOf(pieza.getId()));
            insert.setString(3, String.valueOf(pieza.getCostoPieza()));
            insert.execute();
        } catch (MiMuebleriaException ex) {
            errores.add(new ERROR("FORMATO: " +pieza.getTipoPieza(), "Error al insertar pieza"));
        }
    }
    @Override
     public List listar() {
        ArrayList<Pieza> piezas=new ArrayList<>();
        try {
            PreparedStatement consulta=(PreparedStatement)Conexion.conexion().prepareStatement("SELECT *FROM pieza");
            ResultSet result=consulta.executeQuery();
            while (result.next()) {
                Pieza pieza=new Pieza(result.getString(1),result.getString(2),result.getString(3));
                piezas.add(pieza);
            }
        } catch (MiMuebleriaException | SQLException ex) {
            
        }
        return piezas;
    }

    @Override
    public Pieza list(int id) {
        Pieza pieza=null;
        try {
            PreparedStatement consulta=(PreparedStatement)Conexion.conexion().prepareStatement("SELECT *FROM pieza WHERE id="+id);
            ResultSet result=consulta.executeQuery();
            if (result.next()) {
                pieza=new Pieza(result.getString(1),result.getString(2), result.getString(3));    
            }
        } catch (SQLException | MiMuebleriaException ex) {
            
        }
        return pieza;
    }

    @Override
    public boolean edit(String tipoPieza,String id,String costo) {
        boolean cambio=false;
        try {
            PreparedStatement update=(PreparedStatement)Conexion.conexion().prepareStatement("UPDATE pieza set tipo='"+tipoPieza+"',costo='"+costo+"' WHERE id="+id);
            update.execute();
            cambio=true;
        } catch (SQLException | MiMuebleriaException ex) {
            errores.add(new ERROR("DELETE", "Error al modificar pieza"));
        }
        return cambio;
    }

    @Override
    public boolean eliminar(int id) {
        boolean delet=false;
        try {
            PreparedStatement delete=(PreparedStatement)Conexion.conexion().prepareStatement("DELETE FROM pieza WHERE id="+id);
            delete.executeUpdate();
            delet=true;
        } catch (SQLException | MiMuebleriaException ex) {
            errores.add(new ERROR("DELETE", "Error al eliminar pieza"));
        }
        return delet;
    }
    
}
