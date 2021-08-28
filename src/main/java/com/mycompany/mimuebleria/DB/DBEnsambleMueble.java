
package com.mycompany.mimuebleria.DB;

import com.mycompany.miMuebleria.EnsambleMueble;
import com.mycompany.miMuebleria.MiMuebleriaException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yefri
 */
public class DBEnsambleMueble {

    public void agregarEnsambleMueble(EnsambleMueble ensambleMueble) throws SQLException{
        if (verificarUsuario(ensambleMueble.getUsuario().getUsername()) && verificarMueble(ensambleMueble.getMueble().getTipoMueble())) {
            try {
                PreparedStatement insert=(PreparedStatement)Conexion.conexion().prepareStatement("INSER INTO ensamble_mueble(mueble,usuarioEnsamble,fecha,costo) VALUES=(?,?,?,?)");
                insert.setString(1, ensambleMueble.getMueble().getTipoMueble());
                insert.setString(2, ensambleMueble.getUsuario().getUsername());
                insert.setDate(3, (Date.valueOf(ensambleMueble.getFecha())));
                insert.setString(4, String.valueOf(ensambleMueble.getCosto()));
            } catch (Exception e) {
            }
        }
        
    }
    
    
    public boolean verificarUsuario(String usuario) throws SQLException{
        boolean usuarioExistente=false;
        try {
            PreparedStatement consulta=(PreparedStatement)Conexion.conexion().prepareStatement("SELECT *FROM usuario WHERE=?");
            consulta.setString(1, usuario);
            ResultSet result=consulta.executeQuery();
            usuarioExistente=result.next();
        } catch (MiMuebleriaException ex) {
            Logger.getLogger(DBEnsambleMueble.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarioExistente;
    }
    
    public boolean verificarMueble(String mueble){
        boolean muebleExistente=false;
        try {
            PreparedStatement consulta=(PreparedStatement)Conexion.conexion().prepareStatement("SELECT *FROM ensamble_pieza WHERE=?");
            consulta.setString(1, mueble);
            ResultSet result=consulta.executeQuery();
            muebleExistente=result.next();
        } catch (SQLException e) {
        } catch (MiMuebleriaException ex) {
            Logger.getLogger(DBEnsambleMueble.class.getName()).log(Level.SEVERE, null, ex);
        }
        return muebleExistente;
    }
    
}
