/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.miMuebleria.servlet;

import com.mycompany.miMuebleria.MiMuebleriaException;
import com.mycompany.miMuebleria.Mueble;
import com.mycompany.mimuebleria.DB.DBMueble;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yefri
 */
@WebServlet(name = "CrearMuebleServlet", urlPatterns = {"/CrearMuebleServlet"})
public class CrearMuebleServlet extends HttpServlet {

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
        String nombreMueble = request.getParameter("nombreMueble");
        String precioVenta = request.getParameter("precioMueble");
        if (!precioVenta.isEmpty() && !nombreMueble.isEmpty()) {
            try {
                Mueble mueble = new Mueble(nombreMueble, precioVenta);
                DBMueble.agregarMueble(mueble);
                response.sendRedirect("administracionJsp.jsp");
            } catch (MiMuebleriaException | SQLException ex) {
                response.sendRedirect("muebleria/ErrorAdmin.jsp?error=Error al crear Mueble");
            }
        } else {
            response.sendRedirect("muebleria/ErrorAdmin.jsp?error=Campos vacios");
        }
    }

}
