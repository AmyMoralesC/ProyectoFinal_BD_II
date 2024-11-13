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
public class Recibo implements Serializable {
    
    private int codigo;
    private int cantidad;
    private int precioTotal;
    private int productoCodigo;

    public Recibo() {
    }

    public Recibo(int codigo, int cantidad, int precioTotal, int productoCodigo) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
        this.productoCodigo = productoCodigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getProductoCodigo() {
        return productoCodigo;
    }

    public void setProductoCodigo(int productoCodigo) {
        this.productoCodigo = productoCodigo;
    }
            
    
}
