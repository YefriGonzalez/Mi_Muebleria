/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.miMuebleria.servlet;

import com.mycompany.miMuebleria.MiMuebleriaException;
import com.mycompany.mimuebleria.DB.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author yefri
 */
@WebServlet(name = "DevolucionServlet", urlPatterns = {"/DevolucionServlet"})
public class DevolucionServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String muebleDev = request.getParameter("tipoMuebleDevolucion");
        String nitDev = request.getParameter("nitClienteDevolucion");
        try {
            if (muebleDev != null && nitDev != null && !nitDev.contains("-")) {
                PreparedStatement consutltaDevolucion = (PreparedStatement) Conexion.conexion().prepareStatement("SELECT *FROM venta WHERE mueble='" + muebleDev + "' AND fecha>=date_add(NOW(), INTERVAL -7 DAY)");
                consutltaDevolucion.execute();

                PreparedStatement insertDevolucion = (PreparedStatement) Conexion.conexion().prepareStatement("INSERT INTO devolucion(mueble,nitVenta,fecha) VALUES(?,?,?)");
                insertDevolucion.setString(1, muebleDev);
                insertDevolucion.setString(2, nitDev);
                insertDevolucion.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
                insertDevolucion.execute();

                PreparedStatement deleteVenta = (PreparedStatement) Conexion.conexion().prepareStatement("DELETE FROM venta WHERE mueble='" + muebleDev + "' AND nitVenta='" + nitDev + "'");
                deleteVenta.execute();
                response.sendRedirect("ventasJsp.jsp");
            } else {
                response.sendRedirect("muebleria/ErroresVentas.jsp?error=Datos vacion de devolucion");
            }

        } catch (MiMuebleriaException | SQLException ex) {
            response.sendRedirect("muebleria/ErroresVentas.jsp?error=Datos incorrectos");
        }
    }

}
