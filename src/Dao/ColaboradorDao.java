/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Colaborador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nombres
 */
public class ColaboradorDao {

    public void registrar(Connection conn, Colaborador colaborador) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;
        try {
            sql = "INSERT INTO COLABORADOR ( IDENTIFICACION_COLABORADOR, NOMBRES, APELLIDOS, CARGO, "
                    + "SALARIO, DIRECCION, TELEFONO) VALUES (?, ?, ?, ?, ?, ?, ?) ";
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, colaborador.getIdentificacionColaborador());
            stmt.setString(2, colaborador.getNombres());
            stmt.setString(3, colaborador.getApellidos());
            stmt.setString(4, colaborador.getCargo());
            stmt.setDouble(5, colaborador.getSalario());
            stmt.setString(6, colaborador.getDireccion());
            stmt.setInt(7, colaborador.getTelefono());
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

    public Colaborador consultar(Connection conn, Colaborador objConsulta) throws SQLException {
        Colaborador colaborador = new Colaborador();
        ResultSet result = null;
        String sql = "SELECT IDENTIFICACION_COLABORADOR, "
                + "NOMBRES, "
                + "APELLIDOS, "
                + "CARGO, "
                + "SALARIO, "
                + "DIRECCION, "
                + "TELEFONO "
                + "WHERE IDENTIFICACION_COLABORADOR = ? ";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, objConsulta.getIdentificacionColaborador());
            result = stmt.executeQuery();
            if (result.next()) {
                colaborador.setIdentificacionColaborador(result.getInt("IDENTIFICACION_COLABORADOR"));
                colaborador.setNombres(result.getString("NOMBRES"));
                colaborador.setApellidos(result.getString("APELLIDOS"));
                colaborador.setCargo(result.getString("CARGO"));
                colaborador.setSalario(result.getDouble("SALARIO"));
                colaborador.setDireccion(result.getString("DIRECCION"));
                colaborador.setTelefono(result.getInt("TELEFONO"));
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return colaborador;
    }

    public void modificar(Connection conn, Colaborador colaborador) throws SQLException {
        String sql = "UPDATE COLABORADOR SET NOMBRES = ?, APELLIDOS = ?, CARGO = ?, "
                + "SALARIO = ?, DIRECICON = ?, TELEFONO = ? WHERE (IDENTIFICACION_COLABORADOR = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, colaborador.getNombres());
            stmt.setString(2, colaborador.getApellidos());
            stmt.setString(3, colaborador.getCargo());
            stmt.setDouble(4, colaborador.getSalario());
            stmt.setString(5, colaborador.getDireccion());
            stmt.setInt(6, colaborador.getTelefono());
            stmt.setInt(7, colaborador.getIdentificacionColaborador());
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

    public void eliminar(Connection conn, Colaborador colaborador) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;

        try {
            sql = "DELETE FROM COLABORADOR WHERE (IDENTIFICACION_COLABORADOR = ?) ";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, colaborador.getIdentificacionColaborador());
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