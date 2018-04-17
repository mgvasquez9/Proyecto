/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Administracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class AdministracionDao {

    public void registrar(Connection conn, Administracion administracion) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;
        try {
            sql = "INSERT INTO ADMINISTRACION ( ID_USER, USUARIO, PASSWORD, ESTADO) "
                    + "VALUES (?, ?, ?, ?) ";
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, administracion.getIdUser());
            stmt.setString(2, administracion.getUsuario());
            stmt.setString(3, administracion.getPassword());
            stmt.setString(4, administracion.getEstado());
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

    public Administracion consultar(Connection conn, Administracion objConsulta) throws SQLException {
        Administracion administracion = new Administracion();
        ResultSet result = null;
        String sql = "SELECT AD.ID_USER, "
                + "AD.USUARIO, "
                + "AD.PASSWORD, "
                + "AD.ESTADO "
                + "FROM ADMINISTRACION AD "
                + "WHERE AD.ID_USER = ? ";

        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, objConsulta.getIdUser());
            result = stmt.executeQuery();
            if (result.next()) {

                administracion.setIdUser(result.getInt("ID_USER"));
                administracion.setUsuario(result.getString("USUARIO"));
                administracion.setPassword(result.getString("PASSWORD"));
                administracion.setEstado(result.getString("ESTADO"));
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        
        return administracion;
    }

    public Administracion consultarPorUsuario(Connection conn, Administracion objConsulta) throws SQLException {
        Administracion administracion = new Administracion();
        ResultSet result = null;
        String sql = "SELECT AD.ID_USER, "
                + "AD.USUARIO, "
                + "AD.PASSWORD, "
                + "AD.ESTADO "
                + "FROM ADMINISTRACION AD "
                + "WHERE AD.USUARIO = ? ";

        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, objConsulta.getUsuario());
            result = stmt.executeQuery();
            if (result.next()) {

                administracion.setIdUser(result.getInt("ID_USER"));
                administracion.setUsuario(result.getString("USUARIO"));
                administracion.setPassword(result.getString("PASSWORD"));
                administracion.setEstado(result.getString("ESTADO"));
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        
        return administracion;
    }

    public void modificar(Connection conn, Administracion administracion) throws SQLException {
        String sql = "UPDATE ADMINISTRACION SET USUARIO = ?, PASSWORD = ?, ESTADO = ? "
                + "WHERE (ID_USER = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, administracion.getUsuario());
            stmt.setString(2, administracion.getPassword());
            stmt.setString(3, administracion.getEstado());
            stmt.setInt(4, administracion.getIdUser());
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

    public void eliminar(Connection conn, Administracion administracion) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;

        try {
            sql = "DELETE FROM ADMINISTRACION WHERE (ID_USER = ?) ";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, administracion.getIdUser());
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
