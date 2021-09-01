/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.miMuebleria.servlet;

import com.mycompany.mimuebleria.DB.DBPieza;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "EditPiezaServlet", urlPatterns = {"/EditPiezaServlet"})
public class EditPiezaServlet extends HttpServlet {


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
        
        String tipoPieza=request.getParameter("tipoPieza");
        String id=request.getParameter("idPieza");
        String costo=request.getParameter("costoPieza");
        if (costo!=null && id!=null && tipoPieza!=null) {
            DBPieza db=new DBPieza();
            if (db.edit(tipoPieza, id, costo)) {
                response.sendRedirect("Piezas_Servlet");
            } else {
                response.sendRedirect("Piezas_Servlet");
                // obtener error 
            }
        } else {
            
        }
        
    }

}
