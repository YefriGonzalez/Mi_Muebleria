/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.miMuebleria.servlet;

import com.mycompany.miMuebleria.MiMuebleriaException;
import com.mycompany.miMuebleria.Usuario;
import com.mycompany.mimuebleria.DB.DBUsuario;
import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet(name = "CrearUsuarioServlet", urlPatterns = {"/CrearUsuarioServlet"})
public class CrearUsuarioServlet extends HttpServlet {

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
        String user = request.getParameter("userNew");
        String pass = request.getParameter("password");
        String tipo = request.getParameter("tipoUser");
        if (!user.isEmpty() && !pass.isEmpty() && !tipo.isEmpty()) {
            if (pass.length() >= 6) {
                try {
                    Usuario usuario = new Usuario(user, pass, tipo, "1");
                    DBUsuario.agregarUsuario(usuario);
                    response.sendRedirect("administracionJsp.jsp");
                } catch (MiMuebleriaException | SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                    response.sendRedirect("muebleria/ErrorAdmin.jsp?error=Error al crear usuario");
                }
            } else {
                response.sendRedirect("muebleria/ErrorAdmin.jsp?error=Contraseña menor a 6 caracteres");
            }
        } else {
            response.sendRedirect("muebleria/ErrorAdmin.jsp?error=Campos vacios");
        }
    }

}
