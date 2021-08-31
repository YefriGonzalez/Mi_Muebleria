/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.miMuebleria.servlet;

import com.mycompany.miMuebleria.MiMuebleriaException;
import com.mycompany.miMuebleria.Pieza;
import com.mycompany.miMuebleria.archivo.ERROR;
import com.mycompany.miMuebleria.archivo.LectorArchivoTexto;
import com.mycompany.mimuebleria.DB.DBPieza;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yefri
 */
@WebServlet(name = "ControladorPiezaServlet", urlPatterns = {"/ControladorPiezaServlet"})
public class ControladorPiezaServlet extends HttpServlet {

    private ArrayList<ERROR> errores = new ArrayList<>();

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
        String tipoPieza = request.getParameter("nombreCrearPieza");
        try {
            String costo = request.getParameter("costoCrearPieza");
            String id = String.valueOf(LectorArchivoTexto.getCantidadPieza());
            if (tipoPieza != null && costo != null) {
                Pieza pieza = new Pieza(tipoPieza, id, costo);
                DBPieza.agregarPieza(pieza);
                response.sendRedirect("Piezas_Servlet");
            } else {
                errores.add(new ERROR("CREACION: ", "Campos vacios" ));
            }

        } catch (MiMuebleriaException | SQLException ex) {
            errores.add(new ERROR("CREACION: ", "Error al crear la pieza" + tipoPieza));
        }
    }

}
