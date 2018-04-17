/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Cosecha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author GranoCortar
 */
public class CosechaDao {

    public void registrar(Connection conn, Cosecha cosecha) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;
        try {
            sql = "INSERT INTO COSECHA ( CONSECUTIVO_COSECHA, GRANO_A_CORTAR, TIPO_CORTE, FECHA_INICIO, "
                    + "FECHA_FINALIZACION, SITIO_A_CORTAR, CONSECUTIVO) VALUES (?, ?, ?, ?, ?, ?, ?) ";
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, cosecha.getConsecutivoCosecha());
            stmt.setString(2, cosecha.getGranoCortar());
            stmt.setString(3, cosecha.getTipoCorte());
            stmt.setString(4, cosecha.getFechaInicio());
            stmt.setString(5, cosecha.getFechaFinalizacion());
            stmt.setString(6, cosecha.getSitioCortar());
            stmt.setInt(7, cosecha.getConsecutivo());
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

    public Cosecha consultar(Connection conn, Cosecha objConsulta) throws SQLException {
        Cosecha cosecha = new Cosecha();
        ResultSet result = null;
        String sql = "SELECT CONSECUTIVO_COSECHA, "
                + "GRANO_A_CORTAR, "
                + "TIPO_CORTE, "
                + "DATE_FORMAT(FECHA_INICIO,'%d/%m/%Y') FECHA_INICIO, "
                + "DATE_FORMAT(FECHA_FINALIZACION,'%d/%m/%Y') FECHA_FINALIZACION, "
                + "SITIO_A_CORTAR, "
                + "CONSECUTIVO "
                + "FROM COSECHA "
                + "WHERE CONSECUTIVO_COSECHA = ? ";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, objConsulta.getConsecutivoCosecha());
            result = stmt.executeQuery();
            if (result.next()) {
                cosecha.setConsecutivoCosecha(result.getInt("CONSECUTIVO_COSECHA"));
                cosecha.setGranoCortar(result.getString("GRANO_A_CORTAR"));
                cosecha.setTipoCorte(result.getString("TIPO_CORTE"));
                cosecha.setFechaInicio(result.getString("FECHA_INICIO"));
                cosecha.setFechaFinalizacion(result.getString("FECHA_FINALIZACION"));
                cosecha.setSitioCortar(result.getString("SITIO_A_CORTAR"));
                cosecha.setConsecutivo(result.getInt("CONSECUTIVO"));
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return cosecha;
    }

    public void modificar(Connection conn, Cosecha cosecha) throws SQLException {
        String sql = "UPDATE COSECHA SET GRANO_A_CORTAR = ?, TIPO_CORTE = ?, FECHA_INICIO = ?, "
                + "FECHA_FINALIZACION = ?, SITIO_A_CORTAR = ?, CONSECUTIVO = ? WHERE (CONSECUTIVO_COSECHA = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cosecha.getGranoCortar());
            stmt.setString(2, cosecha.getTipoCorte());
            stmt.setString(3, cosecha.getFechaInicio());
            stmt.setString(4, cosecha.getFechaFinalizacion());
            stmt.setString(5, cosecha.getSitioCortar());
            stmt.setInt(6, cosecha.getConsecutivo());
            stmt.setInt(7, cosecha.getConsecutivoCosecha());
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

    public void eliminar(Connection conn, Cosecha cosecha) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;

        try {
            sql = "DELETE FROM COSECHA WHERE (CONSECUTIVO_COSECHA = ?) ";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cosecha.getConsecutivoCosecha());
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