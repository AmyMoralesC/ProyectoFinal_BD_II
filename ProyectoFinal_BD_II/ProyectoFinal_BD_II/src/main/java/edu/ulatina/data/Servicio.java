/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ulatina.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

/**
 *
 * @author Amy
 */
public class Servicio {
    
    protected Connection conexion = null;
    private String host = "localhost";
    private String puerto = "3306";
    private String sid = "FERREBOB";
    private String usuario = "root";
    private String clave = "***"; //Cambiar la clave para que funcione

    public void conectar() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        
        conexion = DriverManager.getConnection(
                "jdbc:mysql://" + host + ":" + puerto + "/" + sid + /*"?autoReconnect=true"*/ "?serverTimezone=UTC",
                usuario, clave);

    }
    
    public void cerrarStatement(PreparedStatement stmt) {
        try {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
                stmt = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cerrarResultSet(ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
                rs = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void desconectar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                conexion = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Connection getConexion() throws ClassNotFoundException, SQLException {
        this.conectar();
        return this.conexion;
    }
    
}
