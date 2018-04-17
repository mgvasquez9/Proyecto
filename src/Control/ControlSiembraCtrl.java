/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.ControlSiembraDao;
import Modelo.ControlSiembra;
import Utilidadades.Conexion;
import java.sql.Connection;

/**
 *
 * @author Usuario
 */
public class ControlSiembraCtrl {
    
    static ControlSiembraDao controlSiembraDao = new ControlSiembraDao();
    
    public static void registar(ControlSiembra controlSiembra) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            controlSiembraDao.registrar(conexion, controlSiembra);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
    
    public static ControlSiembra consultar(ControlSiembra controlSiembra) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            ControlSiembra nuevo = controlSiembraDao.consultar(conexion, controlSiembra);
            return nuevo;
        } catch (Exception exce) {
            conn.cerrarConecion();
            return null;
        }
    }
    
    public static void modificar(ControlSiembra controlSiembra) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            controlSiembraDao.modificar(conexion, controlSiembra);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
    
    public static void eliminar(ControlSiembra controlSiembra) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            controlSiembraDao.eliminar(conexion, controlSiembra);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
}