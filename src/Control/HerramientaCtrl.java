/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.HerramientaDao;
import Modelo.Herramienta;
import Utilidadades.Conexion;
import java.sql.Connection;

/**
 *
 * @author Usuario
 */
public class HerramientaCtrl {
    
    static HerramientaDao herramientaDao = new HerramientaDao();
    
    public static void registar(Herramienta herramienta) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            herramientaDao.registrar(conexion, herramienta);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
    
    public static Herramienta consultar(Herramienta herramienta) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            Herramienta nuevo = herramientaDao.consultar(conexion, herramienta);
            return nuevo;
        } catch (Exception exce) {
            conn.cerrarConecion();
            return null;
        }
    }
    
    public static void modificar(Herramienta herramienta) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            herramientaDao.modificar(conexion, herramienta);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
    
    public static void eliminar(Herramienta herramienta) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            herramientaDao.eliminar(conexion, herramienta);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
}