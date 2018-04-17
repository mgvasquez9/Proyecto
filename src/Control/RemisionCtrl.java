/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.RemisionDao;
import Modelo.Remision;
import Utilidadades.Conexion;
import java.sql.Connection;

/**
 *
 * @author Usuario
 */
public class RemisionCtrl {
    
    static RemisionDao remisionDao = new RemisionDao();
    
    public static void registar(Remision remision) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            remisionDao.registrar(conexion, remision);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
    
    public static Remision consultar(Remision remision) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            Remision nuevo = remisionDao.consultar(conexion, remision);
            return nuevo;
        } catch (Exception exce) {
            conn.cerrarConecion();
            return null;
        }
    }
    
    public static void modificar(Remision remision) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            remisionDao.modificar(conexion, remision);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
    
    public static void eliminar(Remision remision) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            remisionDao.eliminar(conexion, remision);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
}