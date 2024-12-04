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
    private String puerto = "1433"; // Puerto por defecto para SQL Server
    private String baseDatos = "FERRETERIA"; // Cambia por el nombre de tu base de datos
    private String usuario = "AdministradorLogin "; // Cambia por tu usuario de SQL Server
    private String clave = "Si1234!"; // Cambia por tu contraseña de SQL Server

    public void conectar() throws ClassNotFoundException, SQLException {
        // Cargar el driver JDBC de SQL Server
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
        // Construir la URL de conexión para SQL Server
        String url = "jdbc:sqlserver://" + host + ":" + puerto + ";databaseName=" + baseDatos;

        // Establecer la conexión
        conexion = DriverManager.getConnection(url, usuario, clave);
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
