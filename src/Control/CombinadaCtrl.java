/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.CombinadaDao;
import Modelo.Combinada;
import Utilidadades.Conexion;
import java.sql.Connection;

/**
 *
 * @author Usuario
 */
public class CombinadaCtrl {
    
    static CombinadaDao combinadaDao = new CombinadaDao();
    
    public static void registar(Combinada combinada) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            combinadaDao.registrar(conexion, combinada);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
    
    public static Combinada consultar(Combinada combinada) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            Combinada nuevo = combinadaDao.consultar(conexion, combinada);
            return nuevo;
        } catch (Exception exce) {
            conn.cerrarConecion();
            return null;
        }
    }
    
    public static void modificar(Combinada combinada) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            combinadaDao.modificar(conexion, combinada);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
    
    public static void eliminar(Combinada combinada) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            combinadaDao.eliminar(conexion, combinada);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
}