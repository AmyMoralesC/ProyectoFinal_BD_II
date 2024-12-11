/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ulatina.data;

import edu.ulatina.model.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author jared
 */
@ManagedBean(name = "servicioProducto")
@ApplicationScoped
public class ServicioProducto extends Servicio {

    public boolean crearProducto(Producto producto) {
        boolean exito = false;
        PreparedStatement stmt = null;

        try {
            conectar();
            String sql = "EXEC sp_InsertarProducto @codigo=?, @nombre=?, @modelo=?, @ano=?, @cantidad=?, @n_fabrica=?, @precio=?";
            stmt = getConexion().prepareStatement(sql);
            stmt.setInt(1, producto.getCodigo());
            stmt.setString(2, producto.getNombre());
            stmt.setString(3, producto.getModelo());
            stmt.setInt(4, producto.getAno());
            stmt.setInt(5, producto.getCantidad());
            stmt.setString(6, producto.getNumeroFabrica());
            stmt.setInt(7, producto.getPrecio());
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
            String sql = "SELECT codigo, nombre, modelo, ano, cantidad, n_fabrica, precio FROM FERRETERIA.dbo.Producto";
            stmt = getConexion().prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nombre = rs.getString("nombre");
                String modelo = rs.getString("modelo");
                int ano = rs.getInt("ano");
                int cantidad = rs.getInt("cantidad");
                String numeroFa = rs.getString("n_fabrica");
                int precio = rs.getInt("precio");
                Producto producto = new Producto();
                producto.setCodigo(codigo);
                producto.setNombre(nombre);
                producto.setModelo(modelo);
                producto.setAno(ano);
                producto.setCantidad(cantidad);
                producto.setNumeroFabrica(numeroFa);
                producto.setPrecio(precio);

                listaProducto.add(producto);
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

    public boolean eliminarProducto(int codigo) {
        boolean exito = false;
        PreparedStatement stmt = null;

        try {
            conectar();
            // Llamada al procedimiento almacenado para eliminar un producto por su código.
            String sql = "EXEC sp_EliminarProducto @codigo=?";
            stmt = getConexion().prepareStatement(sql);

            // Asignamos el valor del código del producto al PreparedStatement.
            stmt.setInt(1, codigo);

            // Ejecutamos la consulta.
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

    public boolean editarProducto(Producto producto) {
        boolean exito = false;
        PreparedStatement stmt = null;

        try {
            conectar();
            String sql = "UPDATE Productos SET nombre = ?, modelo = ?, ano = ?, cantidad = ?, n_fabrica = ?, precio = ? WHERE codigo = ?";
            stmt = getConexion().prepareStatement(sql);
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getModelo());
            stmt.setInt(3, producto.getAno());
            stmt.setInt(4, producto.getCantidad());
            stmt.setString(5, producto.getNumeroFabrica());
            stmt.setInt(6, producto.getPrecio());
            stmt.setInt(7, producto.getCodigo());

            int rows = stmt.executeUpdate();
            exito = (rows > 0);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            cerrarStatement(stmt);
            desconectar();
        }

        return exito;
    }

}
