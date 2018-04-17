/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Lote;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ubicacion
 */
public class LoteDao {

    public void registrar(Connection conn, Lote lote) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;
        try {
            sql = "INSERT INTO LOTE ( ID, UBICACION, AREA) VALUES (?, ?, ?) ";
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, lote.getId());
            stmt.setString(2, lote.getUbicacion());
            stmt.setDouble(2, lote.getArea());
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

    public Lote consultar(Connection conn, Lote objConsulta) throws SQLException {
        Lote lote = new Lote();
        ResultSet result = null;
        String sql = "SELECT ID, "
                + "UBICACION, "
                + "AREA "
                + "FROM LOTE "
                + "WHERE ID = ? ";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, objConsulta.getId());
            result = stmt.executeQuery();
            if (result.next()) {
                lote.setId(result.getInt("ID"));
                lote.setUbicacion(result.getString("UBICACION"));
                lote.setArea(result.getDouble("AREA"));
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return lote;
    }

    public void modificar(Connection conn, Lote lote) throws SQLException {
        String sql = "UPDATE LOTE SET UBICACION = ?, AREA = ? WHERE (ID = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, lote.getUbicacion());
            stmt.setDouble(2, lote.getArea());
            stmt.setInt(3, lote.getId());
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

    public void eliminar(Connection conn, Lote lote) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;

        try {
            sql = "DELETE FROM LOTE WHERE (ID = ?) ";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, lote.getId());
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