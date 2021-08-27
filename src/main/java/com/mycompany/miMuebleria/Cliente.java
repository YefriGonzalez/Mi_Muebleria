/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.miMuebleria;

/**
 *
 * @author yefri
 */
public class Cliente {

    private String nombre;
    private Integer NIT;
    private String direccion;
    private String municipio;
    private String departamento;

    public Cliente(String nombre, String nit, String direccion, String municipio, String departamento) {
        try {
            this.nombre = nombre;
            this.NIT = Integer.valueOf(nit);
            this.direccion = direccion;
            this.municipio = municipio;
            this.departamento = departamento;
        } catch (NumberFormatException e) {
        }
    }

    public Cliente(String nombre, String nit, String direccion) {
        try {
            this.nombre = nombre;
            this.NIT = Integer.valueOf(nit);
            this.direccion = direccion;
        } catch (NumberFormatException e) {
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        try {
            this.NIT = Integer.valueOf(NIT);
        } catch (NumberFormatException e) {
        }

    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

}
