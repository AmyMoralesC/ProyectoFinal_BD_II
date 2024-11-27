/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ulatina.model;

import java.io.Serializable;

/**
 *
 * @author jared
 */
public class Producto implements Serializable {
    
    private int codigo;
    private String nombre;
    private String modelo;
    private int ano;
    private int cantidad;
    private int numeroFabrica;
    private int precio;

    public Producto() {
    }

    public Producto(int codigo, String nombre, String modelo, int ano, int cantidad, int numeroFabrica, int precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.modelo = modelo;
        this.ano = ano;
        this.cantidad = cantidad;
        this.numeroFabrica = numeroFabrica;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getNumeroFabrica() {
        return numeroFabrica;
    }

    public void setNumeroFabrica(int numeroFabrica) {
        this.numeroFabrica = numeroFabrica;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
    
}
