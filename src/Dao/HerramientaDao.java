/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Herramienta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author FechaCompra
 */
public class HerramientaDao {

    public void registrar(Connection conn, Herramienta herramienta) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;
        try {
            sql = "INSERT INTO HERRAMIENTA ( CONSECUTIVO_HERRAMIENTA, REFERENCIA, FECHA_COMPRA, ESTADO, "
                    + "DESCRIPCION, CONSECUTIVO ) VALUES (?, ?, ?, ?, ?, ?) ";
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, herramienta.getConsecutivoHerramienta());
            stmt.setString(2, herramienta.getReferencia());
            stmt.setString(3, herramienta.getFechaCompra());
            stmt.setString(4, herramienta.getEstado());
            stmt.setString(5, herramienta.getDescripcion());
            stmt.setInt(6, herramienta.getConsecutivo());
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

    public Herramienta consultar(Connection conn, Herramienta objConsulta) throws SQLException {
        Herramienta herramienta = new Herramienta();
        ResultSet result = null;
        String sql = "SELECT CONSECUTIVO_HERRAMIENTA, "
                + "REFERENCIA, "
                + "FECHA_COMPRA, "
                + "ESTADO, "
                + "DESCRIPCION, "
                + "CONSECUTIVO "
                + "FROM HERRAMIENTA "
                + "WHERE CONSECUTIVO_HERRAMIENTA = ? ";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, objConsulta.getConsecutivoHerramienta());
            result = stmt.executeQuery();
            if (result.next()) {
                herramienta.setConsecutivoHerramienta(result.getInt("CONSECUTIVO_HERRAMIENTA"));
                herramienta.setReferencia(result.getString("REFERENCIA"));
                herramienta.setFechaCompra(result.getString("FECHA_COMPRA"));
                herramienta.setEstado(result.getString("ESTADO"));
                herramienta.setDescripcion(result.getString("DESCRIPCION"));
                herramienta.setConsecutivo(result.getInt("CONSECUTIVO"));
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return herramienta;
    }

    public void modificar(Connection conn, Herramienta herramienta) throws SQLException {
        String sql = "UPDATE HERRAMIENTA SET REFERENCIA = ?, FECHA_COMPRA = ?, ESTADO = ?, "
                + "DESCRIPCION = ?, CONSECUTIVO = ? WHERE (CONSECUTIVO_HERRAMIENTA = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, herramienta.getReferencia());
            stmt.setString(2, herramienta.getFechaCompra());
            stmt.setString(3, herramienta.getEstado());
            stmt.setString(4, herramienta.getDescripcion());
            stmt.setInt(5, herramienta.getConsecutivo());
            stmt.setInt(6, herramienta.getConsecutivoHerramienta());
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

    public void eliminar(Connection conn, Herramienta herramienta) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;

        try {
            sql = "DELETE FROM HERRAMIENTA WHERE (CONSECUTIVO_HERRAMIENTA = ?) ";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, herramienta.getConsecutivoHerramienta());
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