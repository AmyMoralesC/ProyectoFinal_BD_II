/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ulatina.controller;

import edu.ulatina.data.ServicioProducto;
import edu.ulatina.model.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
            if (productos == null) {
            productos = new ArrayList<>(); // Evita que sea nulo
        }
        }
    }

    // Getter para productos, cargando si es necesario
    public List<Producto> getProductos() {
        if (productos == null) {
            cargarProductos();
        }
        return productos;
    }

    public void crearProducto() {
        System.out.println("Datos del producto: " + producto);
        boolean isInserted = servicioPro.crearProducto(this.getProducto());

        if (isInserted) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Registro exitoso", "El producto ha sido añadido correctamente."));
            producto = new Producto();
            cargarProductos();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error en al añadir", "No se pudo añadir el producto. Inténtalo de nuevo."));
        }

    }

    public void deleteProducto() {
        System.out.println("Intentando eliminar el producto: " + selectedProducto); // Depuración
        if (selectedProducto != null) {
            boolean exito = servicioPro.eliminarProducto(selectedProducto.getCodigo());

            if (exito) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto eliminado exitosamente"));
                cargarProductos(); // Recargar la lista después de eliminar
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo eliminar el producto"));
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", "No hay producto seleccionado para eliminar"));
        }
    }

    public void editarProducto() {
        if (selectedProducto != null) {
            boolean exito = servicioPro.editarProducto(selectedProducto);

            if (exito) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto editado exitosamente"));
                cargarProductos(); // Recargar la lista para reflejar los cambios
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo editar el producto"));
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", "No hay producto seleccionado para editar"));
        }
    }

    public ServicioProducto getServicioPro() {
        return servicioPro;
    }

    public void setServicioPro(ServicioProducto servicioPro) {
        this.servicioPro = servicioPro;
    }

    public Producto getProducto() {
        if (producto == null) {
            producto = new Producto(); // Inicialización si es nulo
        }
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Producto getSelectedProducto() {
        if (selectedProducto == null) {
            selectedProducto = new Producto(); // Inicialización si es nulo
        }
        return selectedProducto;
    }

    public void setSelectedProducto(Producto selectedProducto) {
        this.selectedProducto = selectedProducto;
    }

}
