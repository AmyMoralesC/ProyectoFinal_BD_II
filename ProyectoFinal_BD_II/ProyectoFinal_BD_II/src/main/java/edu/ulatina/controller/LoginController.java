/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ulatina.controller;

import edu.ulatina.data.ServicioEmpleado;
import edu.ulatina.model.Empleado;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Amy
 */
@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController {
    
    List<Empleado> listaEmpleadoTO = new ArrayList<>();
    private Empleado empleado = new Empleado();
    private Empleado selectedEmpleado;
    
    public LoginController() {}
    
    public void ingresar() {
    
    
    
    }
    
}
