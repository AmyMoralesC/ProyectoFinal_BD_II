/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ulatina.controller;

import edu.ulatina.data.ServicioProducto;
import edu.ulatina.model.Producto;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jared
 */
@ManagedBean(name = "productosController")
@SessionScoped
public class ProductosController implements Serializable {

    @ManagedProperty(value = "#{servicioProducto}")
    private ServicioProducto servicioPro;
    private Producto producto;
    private Producto selectedProducto;
    private List<Producto> productos;

    // Metodo para cargar los productos
    public void cargarProductos() {
        if (servicioPro != null) {
            productos = servicioPro.buscarTodosLosProductos();
        }
    }

    // Getter para productos, cargando si es necesario
    public List<Producto> getProductos() {
        if (productos == null) {
            cargarProductos();
        }
        return productos;
    }

    public ServicioProducto getServicioPro() {
        return servicioPro;
    }

    public void setServicioPro(ServicioProducto servicioPro) {
        this.servicioPro = servicioPro;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Producto getSelectedProducto() {
        return selectedProducto;
    }

    public void setSelectedProducto(Producto selectedProducto) {
        this.selectedProducto = selectedProducto;
    }

}
