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
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yefri
 */
@WebServlet(name = "Usuario_Servlet", urlPatterns = {"/usuario-servlet"})
public class Usuario_Servlet extends HttpServlet {

    
   
     /* Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        DBUsuario dbUsuario=new DBUsuario();
        try {
            Usuario usuario=dbUsuario.Validar(username, password);
            if(usuario!=null){
                int num=ValidacionUsuario.validar(usuario);
                if(num==1){
                    response.sendRedirect("fabricajsp.jsp");
                } else if(num==2){
                    response.sendRedirect("ventasJsp.jsp");
                } else if (num==3){
                    response.sendRedirect("administracionJsp.jsp");
                } else {
                    response.sendRedirect("index.jsp");
                }
            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (MiMuebleriaException ex) {
            Logger.getLogger(Usuario_Servlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
