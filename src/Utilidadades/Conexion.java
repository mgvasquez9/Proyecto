package Utilidadades;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Usuario
 */
public enum Conexion {
    INSTANCE;
    private Connection conn;
    private DataSource ds = null;
    private Context ctx = null;

    private static Conexion conexion;

    //
    private Conexion() {
        if (conn == null) {
            Properties prop = new UtilFile().getPropiedades();
            try {
                conn = (Connection) DriverManager.getConnection(prop.getProperty("url")
                        + prop.getProperty("esquema"),
                        prop.getProperty("nombre_usuaruo"),
                        prop.getProperty("contrasena"));
            } catch (Exception e) {
                System.out.println("Error en Conexion() e:"+e.getMessage());
            }
        }
    }

    public synchronized static Conexion getInstance() {
        if (conexion == null) {
            return Conexion.INSTANCE;
        }
        return conexion;
    }

    public Connection conectar() throws SQLException {
        if (conn == null) {
            return conn = ds.getConnection();
        } else if (!conn.isValid(1)) {
            return conn = ds.getConnection();
        }
        return conn;
    }

    public boolean cerrarConecion() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
            return true;
        } catch (Exception e) {
            // LOG.error("ERROR cerrarConexion", e);
            return false;
        } finally {
            conn = null;
        }
    }
}
