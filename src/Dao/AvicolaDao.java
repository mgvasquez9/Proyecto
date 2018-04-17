/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Avicola;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nombre
 */
public class AvicolaDao {

    public void registrar(Connection conn, Avicola avicola) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;
        try {
            sql = "INSERT INTO AVICOLA ( NIT, NOMBRE, DIRECCION, TELEFONO_CONTACTO, "
                    + "CONSECUTIVO) VALUES (?, ?, ?, ?, ?) ";
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, avicola.getNit());
            stmt.setString(2, avicola.getNombre());
            stmt.setString(3, avicola.getDireccion());
            stmt.setInt(4, avicola.getTelefonoContacto());
            stmt.setInt(5, avicola.getConsecutivo());
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

    public Avicola consultar(Connection conn, Avicola objConsulta) throws SQLException {
        Avicola avicola = new Avicola();
        ResultSet result = null;
        String sql = "SELECT NIT, "
                + "NOMBRE, "
                + "DIRECCION, "
                + "TELEFONO_CONTACTO, "
                + "CONSECUTIVO "
                + "WHERE NIT = ? ";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, objConsulta.getNit());
            result = stmt.executeQuery();
            if (result.next()) {
                avicola.setNit(result.getInt("NIT"));
                avicola.setNombre(result.getString("NOMBRE"));
                avicola.setDireccion(result.getString("DIRECCION"));
                avicola.setTelefonoContacto(result.getInt("TELEFONO_CONTACTO"));
                avicola.setConsecutivo(result.getInt("CONSECUTIVO"));
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return avicola;
    }

    public void modificar(Connection conn, Avicola avicola) throws SQLException {
        String sql = "UPDATE AVICOLA SET NOMBRE = ?, DIRECCION = ?, TELEFONO_CONTACTO = ?, "
                + "CONSECUTIVO = ? WHERE (NIT = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, avicola.getNombre());
            stmt.setString(2, avicola.getDireccion());
            stmt.setInt(3, avicola.getTelefonoContacto());
            stmt.setInt(4, avicola.getConsecutivo());
            stmt.setInt(5, avicola.getNit());
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

    public void eliminar(Connection conn, Avicola avicola) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;

        try {
            sql = "DELETE FROM AVICOLA WHERE (NIT = ?) ";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, avicola.getNit());
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