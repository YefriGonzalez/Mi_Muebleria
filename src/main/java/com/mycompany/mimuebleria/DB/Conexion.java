/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mimuebleria.DB;

import com.mycompany.miMuebleria.MiMuebleriaException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author yefri
 */
public class Conexion {

    private static final String USER = "root2";
    private static final String PASSWORD = "Root2021.";
    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/Mi_Muebleria"; 
    public static Connection conexion()throws MiMuebleriaException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL_MYSQL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            out.println(e.getMessage()+"");
        } 
        return connection;
    }
}
