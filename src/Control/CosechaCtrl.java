/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.CosechaDao;
import Modelo.Cosecha;
import Utilidadades.Conexion;
import java.sql.Connection;

/**
 *
 * @author Usuario
 */
public class CosechaCtrl {
    
    static CosechaDao cosechaDao = new CosechaDao();
    
    public static void registar(Cosecha cosecha) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            cosechaDao.registrar(conexion, cosecha);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
    
    public static Cosecha consultar(Cosecha cosecha) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            Cosecha nuevo = cosechaDao.consultar(conexion, cosecha);
            return nuevo;
        } catch (Exception exce) {
            conn.cerrarConecion();
            return null;
        }
    }
    
    public static void modificar(Cosecha cosecha) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            cosechaDao.modificar(conexion, cosecha);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
    
    public static void eliminar(Cosecha cosecha) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            cosechaDao.eliminar(conexion, cosecha);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
}