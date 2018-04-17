/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Combinada;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author OrdenAlquiler
 */
public class CombinadaDao {

    public void registrar(Connection conn, Combinada combinada) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;
        try {
            sql = "INSERT INTO COMBINADA ( CONSECUTIVO, ORDEN_ALQUILER, REFERENCIA, NOMBRE_OPERARIO, "
                    + "COSTO) VALUES (?, ?, ?, ?, ?) ";
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, combinada.getConsecutivo());
            stmt.setInt(2, combinada.getOrdenAlquiler());
            stmt.setString(3, combinada.getReferencia());
            stmt.setString(4, combinada.getNombreOperario());
            stmt.setDouble(5, combinada.getCosto());
            int rowcount = databaseUpdate(conn, stmt);
            if (rowcount != 1) {
                throw new SQLException("Error de PrimaryKey Error al acutalizar DB!");
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public Combinada consultar(Connection conn, Combinada objConsulta) throws SQLException {
        Combinada combinada = new Combinada();
        ResultSet result = null;
        String sql = "SELECT CONSECUTIVO, "
                + "ORDEN_ALQUILER, "
                + "REFERENCIA, "
                + "NOMBRE_OPERARIO, "
                + "COSTO "
                + "WHERE CONSECUTIVO = ? ";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, objConsulta.getConsecutivo());
            result = stmt.executeQuery();
            if (result.next()) {
                combinada.setConsecutivo(result.getInt("CONSECUTIVO"));
                combinada.setOrdenAlquiler(result.getInt("ORDEN_ALQUILER"));
                combinada.setReferencia(result.getString("REFERENCIA"));
                combinada.setNombreOperario(result.getString("NOMBRE_OPERARIO"));
                combinada.setCosto(result.getDouble("COSTO"));
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return combinada;
    }

    public void modificar(Connection conn, Combinada combinada) throws SQLException {
        String sql = "UPDATE COMBINADA SET ORDEN_ALQUILER = ?, REFERENCIA = ?, NOMBRE_OPERARIO = ?, "
                + "COSTO = ? WHERE (CONSECUTIVO = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, combinada.getOrdenAlquiler());
            stmt.setString(2, combinada.getReferencia());
            stmt.setString(3, combinada.getNombreOperario());
            stmt.setDouble(4, combinada.getCosto());
            stmt.setInt(5, combinada.getConsecutivo());
            int rowcount = databaseUpdate(conn, stmt);
            if (rowcount == 0) {
                throw new SQLException("El objeto no puede ser actualizado ! (PrimaryKey no encontrada!)");
            }
            if (rowcount > 1) {
                throw new SQLException("PrimaryKey error al actualizar en la DB! (Varios objetos afectados!)");
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public void eliminar(Connection conn, Combinada combinada) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;

        try {
            sql = "DELETE FROM COMBINADA WHERE (CONSECUTIVO = ?) ";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, combinada.getConsecutivo());
            int rowcount = databaseUpdate(conn, stmt);
            if (rowcount == 0) {
                throw new SQLException("El objeto no puede borrar! (PrimaryKey no encontrada!)");
            }
            if (rowcount > 1) {
                throw new SQLException("PrimaryKey error al borrar en la DB! (Varios objetos afectados!)");
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    protected int databaseUpdate(Connection conn, PreparedStatement stmt) throws SQLException {
        int result = stmt.executeUpdate();
        return result;
    }
}