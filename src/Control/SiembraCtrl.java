/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.SiembraDao;
import Modelo.Siembra;
import Utilidadades.Conexion;
import java.sql.Connection;

/**
 *
 * @author Usuario
 */
public class SiembraCtrl {
    
    static SiembraDao siembraDao = new SiembraDao();
    
    public static void registar(Siembra siembra) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            siembraDao.registrar(conexion, siembra);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
    
    public static Siembra consultar(Siembra siembra) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            Siembra nuevo = siembraDao.consultar(conexion, siembra);
            return nuevo;
        } catch (Exception exce) {
            conn.cerrarConecion();
            return null;
        }
    }
    
    public static void modificar(Siembra siembra) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            siembraDao.modificar(conexion, siembra);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
    
    public static void eliminar(Siembra siembra) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            siembraDao.eliminar(conexion, siembra);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
}