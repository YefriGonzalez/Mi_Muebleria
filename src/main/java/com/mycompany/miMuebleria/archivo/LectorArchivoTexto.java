package com.mycompany.miMuebleria.archivo;

import com.mycompany.miMuebleria.Cliente;
import com.mycompany.miMuebleria.EnsambleMueble;
import com.mycompany.miMuebleria.Ensamble_Pieza;
import com.mycompany.miMuebleria.Mueble;
import com.mycompany.miMuebleria.Pieza;
import com.mycompany.miMuebleria.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author yefri
 */
public class LectorArchivoTexto {
    private static final String INICIO_USUARIO = "USUARIO(";
    private static final String INICIO_PIEZA="PIEZA(";
    private static final String INICIO_MUEBLE="MUEBLE(";
    private static final String INICIO_ENSAMBLE_PIEZA="ENSAMBLE_PIEZAS(";
    private static final String INICIO_ENSAMBLE_MUEBLE="ENSAMBLAR_MUEBLE(";
    private static final String INICIO_CLIENTE="CLIENTE(";
    public void leerArchivo(File file) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            
        }
    }
    
    public void separarCamposUsuario(String linea){
        if (linea.contains(INICIO_USUARIO)) {
            String lineaDeCampos = linea.substring(INICIO_USUARIO.length(), linea.length() - 1);
            String[] campos = lineaDeCampos.split(",");
            Usuario usuario;
            usuario = new Usuario(campos[0],campos[1], campos[2],"1");
        }
    }
    
    public void separarCamposPieza(String linea){
        if (linea.contains(INICIO_PIEZA)) {
            String lineaDeCampos = linea.substring(INICIO_PIEZA.length(), linea.length() - 1);
            String[] campos = lineaDeCampos.split(",");
            Pieza pieza = new Pieza(campos[0],campos[1]);
        }
    }
    
    public void separarCamposMueble(String linea){
        if (linea.contains(INICIO_MUEBLE)) {
            String lineaDeCampos = linea.substring(INICIO_MUEBLE.length(), linea.length() - 1);
            String[] campos = lineaDeCampos.split(",");
            Mueble mueble = new Mueble(campos[0],campos[1]);
        }
    }
    
    public void separarCamposEnsamblePiezas(String linea){
        if (linea.contains(INICIO_ENSAMBLE_PIEZA)) {
            String lineaDeCampos = linea.substring(INICIO_ENSAMBLE_PIEZA.length(), linea.length() - 1);
            String[] campos = lineaDeCampos.split(",");
            Ensamble_Pieza ensablePieza = new Ensamble_Pieza(campos[0],campos[1],campos[2]);
        }
    }
    public void separarCamposEnsambleMueble(String linea){
        if (linea.contains(INICIO_ENSAMBLE_MUEBLE)) {
            String lineaDeCampos = linea.substring(INICIO_ENSAMBLE_MUEBLE.length(), linea.length() - 1);
            String[] campos = lineaDeCampos.split(",");
            EnsambleMueble ensableMueble = new EnsambleMueble(campos[0],campos[1],campos[2]);
        }
    }
    
    public void separarCamposCliente(String linea){
        if (linea.contains(INICIO_CLIENTE)) {
            String lineaDeCampos = linea.substring(INICIO_ENSAMBLE_MUEBLE.length(), linea.length() - 1);
            String[] campos = lineaDeCampos.split(",");
            if(campos[3]!=null){
                Cliente cliente= new Cliente(campos[0],campos[1],campos[2],campos[3],campos[4]);
            } else if (campos[3]==null) {
                Cliente cliente=new Cliente(campos[0],campos[1],campos[2]);
            }
        }
    }
    
}
