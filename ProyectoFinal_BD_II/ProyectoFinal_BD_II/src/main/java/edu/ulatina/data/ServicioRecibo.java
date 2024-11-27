/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ulatina.data;

import edu.ulatina.model.Producto;
import edu.ulatina.model.Recibo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jared
 */
public class ServicioRecibo extends Servicio{
    
    
    
     public boolean crearRecivo(Recibo recibo) {
        boolean exito = false;
        PreparedStatement stmt = null;

        try {
            conectar();
            String sql = "EXEC sp_RegistrarRecibo @codigo, @cantidad, @precioTotal, @ProductoCodigo;;";
            stmt = getConexion().prepareStatement(sql);
            stmt.setInt(1, recibo.getCodigo());
            stmt.setInt(2, recibo.getCantidad());
            stmt.setInt(3, recibo.getPrecioTotal());
            stmt.setInt(4, recibo.getProductoCodigo());
            int rows = stmt.executeUpdate();
            exito = (rows == 1);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            cerrarStatement(stmt);
            desconectar();
        }

        return exito;
    }

    public List<Producto> buscarTodosLosProductos() {
        List<Producto> listaProducto = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conectar();
            String sql = "SELECT codigo,cantidad, precioTotal, ProductoCodigo FROM FERRETERIA.dbo.Producto";
            stmt = getConexion().prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                int cantidad = rs.getInt("cantidad");
                int precioTo = rs.getInt("precioTota");
                int productoCo = rs.getInt("ProductoCodigo");
                Recibo recibo = new Recibo();
                recibo.setCodigo(codigo);
                recibo.setCantidad(cantidad);
                recibo.setPrecioTotal(precioTo);
                recibo.setProductoCodigo(productoCo);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            cerrarResultSet(rs);
            cerrarStatement(stmt);
            desconectar();
        }

        return listaProducto;
    }
}
