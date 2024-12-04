/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ulatina.controller;

import edu.ulatina.data.ServicioRecibo;
import edu.ulatina.model.Recibo;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jared
 */
@ManagedBean(name = "reciboController")
@SessionScoped
public class ReciboController implements Serializable {

    @ManagedProperty(value = "#{servicioRecibo}")
    private ServicioRecibo servicioRec;
    private Recibo recibo;
    private Recibo selectedRecibo;
    private List<Recibo> recibos;

    public void cargarRecibos() {
        if (servicioRec != null) {
            recibos = servicioRec.buscarTodosLosRecibos();
        }
    }

    // Getter para productos, cargando si es necesario
    public List<Recibo> getRecibos() {
        if (recibos == null) {
            cargarRecibos();
        }
        return recibos;
    }

    public ServicioRecibo getServicioRec() {
        return servicioRec;
    }

    public void setServicioRec(ServicioRecibo servicioRec) {
        this.servicioRec = servicioRec;
    }

    public Recibo getRecibo() {
        return recibo;
    }

    public void setRecibo(Recibo recibo) {
        this.recibo = recibo;
    }

    public Recibo getSelectedRecibo() {
        return selectedRecibo;
    }

    public void setSelectedRecibo(Recibo selectedRecibo) {
        this.selectedRecibo = selectedRecibo;
    }

}
