/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.miMuebleria.servlet;

import com.mycompany.miMuebleria.MiMuebleriaException;
import com.mycompany.mimuebleria.DB.DBEnsambleMueble;
import com.mycompany.mimuebleria.DB.DBEnsamblePieza;
import java.io.IOException;
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
@WebServlet(name = "EnsambleServlet", urlPatterns = {"/EnsambleServlet"})
public class EnsambleServlet extends HttpServlet {

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
        String tipoEnsamble = request.getParameter("tipoEnsamble");
        String user = request.getParameter("user");
        String tipoMueblePieza = request.getParameter("tipoMueblePieza");
        String tipoMuebleEnsamble = request.getParameter("tipoMuebleEnsamble");
        String tipoPieza = request.getParameter("tipoPieza");
        String cantPieza = request.getParameter("cantPiezas");
        String fecha = request.getParameter("fechaEnsamble");
        if (tipoEnsamble.equals("piezas") && tipoMueblePieza!=null && tipoPieza != null && cantPieza != null) {
            try {
                DBEnsamblePieza dbpieza = new DBEnsamblePieza();
                dbpieza.agregarEnsamblePieza(tipoMueblePieza, tipoPieza, cantPieza);
                response.sendRedirect("fabricajsp.jsp?user=" + user);
            } catch (SQLException | MiMuebleriaException ex) {
                response.sendRedirect("fabricajsp.jsp?user=" + user);
            }
        } else if (tipoEnsamble.equals("mueble") && tipoMuebleEnsamble != null && user != null && fecha!= null) {
            JOptionPane.showMessageDialog(null,fecha);
            try {
                DBEnsambleMueble dbmueble=new DBEnsambleMueble();
                dbmueble.agregarEnsambleMueble(tipoMuebleEnsamble, user, fecha);
                response.sendRedirect("fabricajsp.jsp?user=" + user);
            } catch (SQLException | MiMuebleriaException ex) {
                response.sendRedirect("fabricajsp.jsp?user=" + user);
            }
        }

    }
}
