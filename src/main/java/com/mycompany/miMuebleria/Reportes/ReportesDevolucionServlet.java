/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.miMuebleria.Reportes;

import com.mycompany.miMuebleria.MiMuebleriaException;
import com.mycompany.mimuebleria.DB.Conexion;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
@WebServlet(name = "ReportesDevolucionServlet", urlPatterns = {"/ReportesDevolucionServlet"})
public class ReportesDevolucionServlet extends HttpServlet {

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
        String fechaInicial = request.getParameter("fechaInicioReporteDevoluciones");
        String fechaFinal = request.getParameter("fechaFinalReporteDevoluciones");
        String filename = "ReporteDevoluciones.csv";
        try {
            FileWriter fw = new FileWriter(new File(filename));
            try {
                if (!fechaInicial.isEmpty() && !fechaFinal.isEmpty()) {
                    PreparedStatement consulta = (PreparedStatement) Conexion.conexion().prepareStatement("SELECT *FROM devolucion WHERE fecha>='" + fechaInicial + "' AND fecha<='" + fechaFinal + "';");
                    ResultSet result = consulta.executeQuery();
                    fw.append("Mueble");
                    fw.append(",");
                    fw.append("Nit");
                    fw.append(",");
                    fw.append("Fecha");
                    fw.append(",");
                    fw.append("Perdida");
                    fw.append("\n");
                    while (result.next()) {
                        fw.append(result.getString(1));
                        fw.append(",");
                        fw.append(result.getString(2));
                        fw.append(",");
                        fw.append(result.getString(3));
                        fw.append(",");
                        fw.append(result.getString(4));
                        fw.append("\n");
                    }
                    fw.flush();
                    fw.close();
                    request.getRequestDispatcher("DescargaArchivo/Download.jsp?archivo=" + filename + "&nombre=Reporte de Devoluciones Generado").forward(request, response);
                } else {
                    PreparedStatement consulta1 = (PreparedStatement) Conexion.conexion().prepareStatement("SELECT *FROM devolucion");
                    ResultSet result1 = consulta1.executeQuery();
                    fw.append("Mueble");
                    fw.append(",");
                    fw.append("Nit");
                    fw.append(",");
                    fw.append("Fecha");
                    fw.append(",");
                    fw.append("Perdida");
                    fw.append("\n");
                    while (result1.next()) {
                        fw.append(result1.getString(1));
                        fw.append(",");
                        fw.append(result1.getString(2));
                        fw.append(",");
                        fw.append(result1.getString(3));
                        fw.append(",");
                        fw.append(result1.getString(4));
                        fw.append("\n");

                    }
                    fw.flush();
                    fw.close();
                    request.getRequestDispatcher("DescargaArchivo/Download.jsp?archivo=" + filename + "&nombre=Reporte de devoluciones Generado").forward(request, response);
                }
            } catch (MiMuebleriaException | SQLException e) {
                response.sendRedirect("muebleria/ErrorAdmin.jsp?error=Error al Escribrir datos archivo");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
            response.sendRedirect("muebleria/ErrorAdmin.jsp?error=No se encuentra el archivo!");
        }
    }

}
