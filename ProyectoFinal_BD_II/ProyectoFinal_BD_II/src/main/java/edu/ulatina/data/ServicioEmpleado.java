/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ulatina.data;

import edu.ulatina.model.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amy
 */
public class ServicioEmpleado extends Servicio {
    
    public List<Empleado> buscarTodos() {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Empleado> listaRetorno = new ArrayList<Empleado>();

        try {
            conectar();
            String sql = "SELECT * FROM empleado";
            stmt = getConexion().prepareStatement(sql);
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("cedula");
                String nombre = rs.getString("nombre");
                String tel = rs.getString("telefono");
                String correo = rs.getString("correo");
                String contra = rs.getString("contra");
                String codigo = rs.getString("codigoEmpl");
                Empleado objEmpleado = new Empleado(id, nombre, tel, correo, contra, codigo);
                listaRetorno.add(objEmpleado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarResultSet(rs);
            cerrarStatement(stmt);
            desconectar();
        }

        return listaRetorno;
    }
    
}
