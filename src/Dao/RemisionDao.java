/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Remision;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author FechaRemision
 */
public class RemisionDao {

    public void registrar(Connection conn, Remision remision) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;
        try {
            sql = "INSERT INTO REMISION ( CONSECUTIVO_REVISION, FECHA_REMISION, AVICOLA_DESTINO, GRADO_DESPAHCADO, "
                    + "TIPO_DESPACHO, PLACA_VEHICULO_TRANAPORTADOR, CONSECUTIVO) VALUES (?, ?, ?, ?, ?, ?, ?) ";
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, remision.getConsecutivoRemision());
            stmt.setString(2, remision.getFechaRemision());
            stmt.setString(3, remision.getAvicolaDestino());
            stmt.setString(4, remision.getGradoDespachado());
            stmt.setString(5, remision.getTipoDespacho());
            stmt.setString(6, remision.getPlacaVehiculoTransportador());
            stmt.setInt(7, remision.getConsecutivo());
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

    public Remision consultar(Connection conn, Remision objConsulta) throws SQLException {
        Remision remision = new Remision();
        ResultSet result = null;
        String sql = "SELECT CONSECUTIVO_REVISION, "
                + "DATE_FORMAT(FECHA_REMISION,'%d/%m/%Y') FECHA_REMISION, "
                + "AVICOLA_DESTINO, "
                + "GRADO_DESPAHCADO, "
                + "TIPO_DESPACHO, "
                + "PLACA_VEHICULO_TRANAPORTADOR, "
                + "CONSECUTIVO "
                + "FROM REMISION "
                + "WHERE CONSECUTIVO_REVISION = ? ";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, objConsulta.getConsecutivoRemision());
            result = stmt.executeQuery();
            if (result.next()) {
                remision.setConsecutivoRemision(result.getInt("CONSECUTIVO_REVISION"));
                remision.setFechaRemision(result.getString("FECHA_REMISION"));
                remision.setAvicolaDestino(result.getString("AVICOLA_DESTINO"));
                remision.setGradoDespachado(result.getString("GRADO_DESPAHCADO"));
                remision.setTipoDespacho(result.getString("TIPO_DESPACHO"));
                remision.setPlacaVehiculoTransportador(result.getString("PLACA_VEHICULO_TRANAPORTADOR"));
                remision.setConsecutivo(result.getInt("CONSECUTIVO"));
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return remision;
    }

    public void modificar(Connection conn, Remision remision) throws SQLException {
        String sql = "UPDATE REMISION SET FECHA_REMISION = ?, AVICOLA_DESTINO = ?, GRADO_DESPAHCADO = ?, "
                + "TIPO_DESPACHO = ?, PLACA_VEHICULO_TRANAPORTADOR = ?, CONSECUTIVO = ? WHERE (CONSECUTIVO_REVISION = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, remision.getFechaRemision());
            stmt.setString(2, remision.getAvicolaDestino());
            stmt.setString(3, remision.getGradoDespachado());
            stmt.setString(4, remision.getTipoDespacho());
            stmt.setString(5, remision.getPlacaVehiculoTransportador());
            stmt.setInt(6, remision.getConsecutivo());
            stmt.setInt(7, remision.getConsecutivoRemision());
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

    public void eliminar(Connection conn, Remision remision) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;

        try {
            sql = "DELETE FROM REMISION WHERE (CONSECUTIVO_REVISION = ?) ";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, remision.getConsecutivoRemision());
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