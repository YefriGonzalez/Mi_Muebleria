/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.miMuebleria.servlet;

import com.mycompany.miMuebleria.MiMuebleriaException;
import com.mycompany.miMuebleria.archivo.LectorArchivoTexto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

/**
 *
 * @author yefri
 */
@MultipartConfig
@WebServlet(name = "CargaArchivo_Servlet", urlPatterns = {"/CargaArchivo_Servlet"})
public class CargaArchivo_Servlet extends HttpServlet {


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.io.FileNotFoundException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException {
        try {
            Part part = request.getPart("fileCarga");
            InputStream inputStream = part.getInputStream();
            InputStream inputStream1 = part.getInputStream();
            InputStream inputStream2 = part.getInputStream();
            InputStream inputStream3 = part.getInputStream();
            InputStream inputStream4 = part.getInputStream();
            InputStream inputStream5 = part.getInputStream();
            LectorArchivoTexto lectorArchivo = new LectorArchivoTexto();
            lectorArchivo.leerArchivo(inputStream);
            lectorArchivo.leerArchivo1(inputStream1);
            lectorArchivo.leerArchivo5(inputStream5);
            lectorArchivo.leerArchivo2(inputStream2);
            lectorArchivo.leerArchivo3(inputStream3);
            lectorArchivo.leerArchivo4(inputStream4);
            response.sendRedirect("fabricajsp.jsp");
        } catch (MiMuebleriaException | IOException | SQLException | ServletException e) {
            response.sendRedirect("fabricajsp.jsp");
        }
    }
}
