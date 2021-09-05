/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.miMuebleria.servlet;

import com.mycompany.miMuebleria.MiMuebleriaException;
import com.mycompany.mimuebleria.DB.Conexion;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
@WebServlet(name = "CancelarUsuarioServlet", urlPatterns = {"/CancelarUsuarioServlet"})
public class CancelarUsuarioServlet extends HttpServlet {

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
        String user = request.getParameter("usuarioCancelar");
        try {
            if (!user.isEmpty()) {
                PreparedStatement cancelarUsuario = (PreparedStatement) Conexion.conexion().prepareStatement("UPDATE usuario set estado=0 WHERE usuario='" + user + "';");
                cancelarUsuario.executeUpdate();
                response.sendRedirect("administracionJsp.jsp");
            } else {
            
            }
        } catch (MiMuebleriaException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cancelar Usuario");
        }
    }

}
