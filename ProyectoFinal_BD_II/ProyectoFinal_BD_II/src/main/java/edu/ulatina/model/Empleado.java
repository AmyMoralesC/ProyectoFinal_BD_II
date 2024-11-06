/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ulatina.model;

import java.io.Serializable;
//import java.util.Objects; //Aún no lo borren, puede que lo ocupe

/**
 *
 * @author Amy
 */
public class Empleado implements Serializable {

    private int cedula;
    private String nombre;
    private String telefono;
    private String correo;
    private String contra;
    private String codigoEmpl;

    public Empleado() {}

    public Empleado(int cedula, String nombre, String telefono, String correo, String contra, String codigoEmpl) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.contra = contra;
        this.codigoEmpl = codigoEmpl;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getCodigoEmpl() {
        return codigoEmpl;
    }

    public void setCodigoEmpl(String codigoEmpl) {
        this.codigoEmpl = codigoEmpl;
    }

}
