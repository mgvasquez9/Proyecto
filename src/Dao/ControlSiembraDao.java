/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.ControlSiembra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author FechaInicio
 */
public class ControlSiembraDao {

    public void registrar(Connection conn, ControlSiembra controlSiembra) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;
        try {
            sql = "INSERT INTO CONTROL_SIEMBRA ( CONSECUTIVO_CONTROL_SIEMBRA, FECHA_INICIO, FECHA_FINALIZACION,"
                    + "TIPO_CONTROL, TIPO_INSUMO, CANTIDAD_INSUMO, SITIO_APLICACION, DESCRIPCION, "
                    + "CONSECHA_APLICAR, CONSECUTIVO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, controlSiembra.getConsecutivoControlSiembra());
            stmt.setString(2, controlSiembra.getFechaInicio());
            stmt.setString(3, controlSiembra.getFechaFinalizacion());
            stmt.setString(4, controlSiembra.getTipoControl());
            stmt.setString(5, controlSiembra.getTipoInsumo());
            stmt.setDouble(6, controlSiembra.getCantidadInsumo());
            stmt.setInt(7, controlSiembra.getSitioAplicacion());
            stmt.setString(8, controlSiembra.getDescripcion());
            stmt.setInt(9, controlSiembra.getCosechaAplicar());
            stmt.setInt(10, controlSiembra.getConsecutivo());
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

    public ControlSiembra consultar(Connection conn, ControlSiembra objConsulta) throws SQLException {
        ControlSiembra controlSiembra = new ControlSiembra();
        ResultSet result = null;
        String sql = "SELECT CONSECUTIVO_CONTROL_SIEMBRA, "
                + "TO_CHAR(FECHA_INICIO,'DD/MM/YYYY') FECHA_INICIO, "
                + "TO_CHAR(FECHA_FINALIZACION,'DD/MM/YYYY') FECHA_FINALIZACION, "
                + "TIPO_CONTROL, "
                + "TIPO_INSUMO, "
                + "CANTIDAD_INSUMO, "
                + "SITIO_APLICACION, "
                + "DESCRIPCION, "
                + "CONSECHA_APLICAR, "
                + "CONSECUTIVO "
                + "WHERE CONSECUTIVO_CONTROL_SIEMBRA = ? ";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, objConsulta.getConsecutivoControlSiembra());
            result = stmt.executeQuery();
            if (result.next()) {
                controlSiembra.setConsecutivoControlSiembra(result.getInt("CONSECUTIVO_CONTROL_SIEMBRA"));
                controlSiembra.setFechaInicio(result.getString("FECHA_INICIO"));
                controlSiembra.setFechaFinalizacion(result.getString("FECHA_FINALIZACION"));
                controlSiembra.setTipoControl(result.getString("TIPO_CONTROL"));
                controlSiembra.setTipoInsumo(result.getString("TIPO_INSUMO"));
                controlSiembra.setCantidadInsumo(result.getDouble("CANTIDAD_INSUMO"));
                controlSiembra.setSitioAplicacion(result.getInt("SITIO_APLICACION"));
                controlSiembra.setDescripcion(result.getString("DESCRIPCION"));
                controlSiembra.setCosechaAplicar(result.getInt("CONSECHA_APLICAR"));
                controlSiembra.setConsecutivo(result.getInt("CONSECUTIVO"));
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return controlSiembra;
    }

    public void modificar(Connection conn, ControlSiembra controlSiembra) throws SQLException {
        String sql = "UPDATE CONTROL_SIEMBRA SET FECHA_INICIO = ?, FECHA_FINALIZACION = ?, TIPO_CONTROL = ?, "
                + "TIPO_INSUMO = ?, CANTIDAD_INSUMO = ?, SITIO_APLICACION = ?, DESCRIPCION = ?, "
                + "CONSECHA_APLICAR = ?, CONSECUTIVO = ? WHERE (CONSECUTIVO_CONTROL_SIEMBRA = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, controlSiembra.getFechaInicio());
            stmt.setString(2, controlSiembra.getFechaFinalizacion());
            stmt.setString(3, controlSiembra.getTipoControl());
            stmt.setString(4, controlSiembra.getTipoInsumo());
            stmt.setDouble(5, controlSiembra.getCantidadInsumo());
            stmt.setInt(6, controlSiembra.getSitioAplicacion());
            stmt.setString(7, controlSiembra.getDescripcion());
            stmt.setInt(8, controlSiembra.getCosechaAplicar());
            stmt.setInt(9, controlSiembra.getConsecutivo());
            stmt.setInt(10, controlSiembra.getConsecutivoControlSiembra());
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

    public void eliminar(Connection conn, ControlSiembra controlSiembra) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;

        try {
            sql = "DELETE FROM CONTROL_SIEMBRA WHERE (CONSECUTIVO_CONTROL_SIEMBRA = ?) ";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, controlSiembra.getConsecutivoControlSiembra());
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