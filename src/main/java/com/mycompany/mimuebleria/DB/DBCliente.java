/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.DB;

import com.mycompany.miMuebleria.Cliente;
import com.mycompany.miMuebleria.MiMuebleriaException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yefri
 */
public class DBCliente {

    public void AgregarCliente(Cliente cliente) throws MiMuebleriaException{
        if (!cliente.getNIT().contains("-") && cliente.getMunicipio()!=null) {
            try {
                PreparedStatement insertCliente=(PreparedStatement)Conexion.conexion().prepareStatement("INSERT INTO cliente(nombre,nit,direccion,municipio,departamento VALUES(?,?,?,?,?)");
                insertCliente.setString(1, cliente.getNombre());
                insertCliente.setString(2, cliente.getNIT());
                insertCliente.setString(3, cliente.getDireccion());
                insertCliente.setString(4, cliente.getMunicipio());
                insertCliente.setString(5, cliente.getDepartamento());
            } catch (MiMuebleriaException | SQLException ex) {
                Logger.getLogger(DBCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(!cliente.getNIT().contains("-") && cliente.getMunicipio()==null){
            try {
                PreparedStatement insertCliente=(PreparedStatement)Conexion.conexion().prepareStatement("INSERT INTO cliente(nombre,nit,direccion) VALUES(?,?,?,)");
                insertCliente.setString(1, cliente.getNombre());
                insertCliente.setString(2, cliente.getNIT());
                insertCliente.setString(3, cliente.getDireccion());
            } catch (MiMuebleriaException | SQLException ex) {
                Logger.getLogger(DBCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else{
            throw new MiMuebleriaException("");
        }
    }
}
