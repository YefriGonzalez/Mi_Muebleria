/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.miMuebleria.Reportes;

import com.sun.imageio.plugins.common.InputStreamAdapter;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author yefri
 */
@WebServlet(name = "DownloadServlet", urlPatterns = {"/DownloadServlet"})
public class DownloadServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Part filepart=request.getPart("path");
        String archivo=filepart.getHeader("Content-type");
        InputStream fileStream=filepart.getInputStream();
        try (BufferedInputStream in = new BufferedInputStream(fileStream)) {
            response.setContentType("text/csv");
            response.setHeader("Content-diposition", "attachament: filename=ReporteVentas.csv");
            int data = in.read();
            while (data != -1) {
                response.getOutputStream().write(data);
                data = in.read();
            }
        } catch (Exception e) {
        }
    }

}
