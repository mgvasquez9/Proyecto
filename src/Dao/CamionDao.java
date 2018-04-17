/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Camion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Placa
 */
public class CamionDao {

    public void registrar(Connection conn, Camion camion) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;
        try {
            sql = "INSERT INTO CAMION ( CONSECUTIVO, PLACA, NOMBRE_Y_APELLIDOS_CONDUCTOR, EMPRESA_AFILIADA, "
                    + "CAPACIDAD) VALUES (?, ?, ?, ?, ?) ";
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, camion.getConsecutivo());
            stmt.setString(2, camion.getPlaca());
            stmt.setString(3, camion.getNombresApellidosConductor());
            stmt.setString(4, camion.getEmpresaAfiliada());
            stmt.setDouble(5, camion.getCapacidad());
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

    public Camion consultar(Connection conn, Camion objConsulta) throws SQLException {
        Camion camion = new Camion();
        ResultSet result = null;
        String sql = "SELECT CONSECUTIVO, "
                + "PLACA, "
                + "NOMBRE_Y_APELLIDOS_CONDUCTOR, "
                + "EMPRESA_AFILIADA, "
                + "CAPACIDAD "
                + "WHERE CONSECUTIVO = ? ";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, objConsulta.getConsecutivo());
            result = stmt.executeQuery();
            if (result.next()) {
                camion.setConsecutivo(result.getInt("CONSECUTIVO"));
                camion.setPlaca(result.getString("PLACA"));
                camion.setNombresApellidosConductor(result.getString("NOMBRE_Y_APELLIDOS_CONDUCTOR"));
                camion.setEmpresaAfiliada(result.getString("EMPRESA_AFILIADA"));
                camion.setCapacidad(result.getDouble("CAPACIDAD"));
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return camion;
    }

    public void modificar(Connection conn, Camion camion) throws SQLException {
        String sql = "UPDATE CAMION SET PLACA = ?, NOMBRE_Y_APELLIDOS_CONDUCTOR = ?, EMPRESA_AFILIADA = ?, "
                + "CAPACIDAD = ? WHERE (CONSECUTIVO = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, camion.getPlaca());
            stmt.setString(2, camion.getNombresApellidosConductor());
            stmt.setString(3, camion.getEmpresaAfiliada());
            stmt.setDouble(4, camion.getCapacidad());
            stmt.setInt(5, camion.getConsecutivo());
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

    public void eliminar(Connection conn, Camion camion) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;

        try {
            sql = "DELETE FROM CAMION WHERE (CONSECUTIVO = ?) ";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, camion.getConsecutivo());
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