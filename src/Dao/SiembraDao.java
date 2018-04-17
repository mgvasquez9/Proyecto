/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Siembra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author TipoSiembra
 */
public class SiembraDao {

    public void registrar(Connection conn, Siembra siembra) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;
        try {
            sql = "INSERT INTO SIEMBRA ( CONSECUTIVO_SIEMBRA, TIPO_SIEMBRA, GRANO_SEMBRAR, FECHA_INICIO, "
                    + "FECHA_FINALIZACION, SITIO_A_SEMBRAR, ID) VALUES (?, ?, ?, ?, ?, ?, ?) ";
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, siembra.getConsecutivoSiembra());
            stmt.setString(2, siembra.getTipoSiembra());
            stmt.setString(3, siembra.getGranoSiembra());
            stmt.setString(4, siembra.getFechaInicio());
            stmt.setString(5, siembra.getFechaFinalizacion());
            stmt.setString(6, siembra.getSitioSiembra());
            stmt.setInt(7, siembra.getId());
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

    public Siembra consultar(Connection conn, Siembra objConsulta) throws SQLException {
        Siembra siembra = new Siembra();
        ResultSet result = null;
        String sql = "SELECT CONSECUTIVO_SIEMBRA, "
                + "TIPO_SIEMBRA, "
                + "GRANO_SEMBRAR, "
                + "FECHA_INICIO, "
                + "FECHA_FINALIZACION, "
                + "SITIO_A_SEMBRAR, "
                + "ID "
                + "FROM SIEMBRA "
                + "WHERE CONSECUTIVO_SIEMBRA = ? ";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, objConsulta.getConsecutivoSiembra());
            result = stmt.executeQuery();
            if (result.next()) {
                siembra.setConsecutivoSiembra(result.getInt("CONSECUTIVO_SIEMBRA"));
                siembra.setTipoSiembra(result.getString("TIPO_SIEMBRA"));
                siembra.setGranoSiembra(result.getString("GRANO_SEMBRAR"));
                siembra.setFechaInicio(result.getString("FECHA_INICIO"));
                siembra.setFechaFinalizacion(result.getString("FECHA_FINALIZACION"));
                siembra.setSitioSiembra(result.getString("SITIO_A_SEMBRAR"));
                siembra.setId(result.getInt("ID"));
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return siembra;
    }

    public void modificar(Connection conn, Siembra siembra) throws SQLException {
        String sql = "UPDATE SIEMBRA SET TIPO_SIEMBRA = ?, GRANO_SEMBRAR = ?, FECHA_INICIO = ?, "
                + "FECHA_FINALIZACION = ?, SITIO_A_SEMBRAR = ?, ID = ? WHERE (CONSECUTIVO_SIEMBRA = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, siembra.getTipoSiembra());
            stmt.setString(2, siembra.getGranoSiembra());
            stmt.setString(3, siembra.getFechaInicio());
            stmt.setString(4, siembra.getFechaFinalizacion());
            stmt.setString(5, siembra.getSitioSiembra());
            stmt.setInt(6, siembra.getId());
            stmt.setInt(7, siembra.getConsecutivoSiembra());
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

    public void eliminar(Connection conn, Siembra siembra) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;

        try {
            sql = "DELETE FROM SIEMBRA WHERE (CONSECUTIVO_SIEMBRA = ?) ";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, siembra.getConsecutivoSiembra());
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