/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.CamionDao;
import Modelo.Camion;
import Utilidadades.Conexion;
import java.sql.Connection;

/**
 *
 * @author Usuario
 */
public class CamionCtrl {
    
    static CamionDao camionDao = new CamionDao();
    
    public static void registar(Camion camion) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            camionDao.registrar(conexion, camion);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
    
    public static Camion consultar(Camion camion) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            Camion nuevo = camionDao.consultar(conexion, camion);
            return nuevo;
        } catch (Exception exce) {
            conn.cerrarConecion();
            return null;
        }
    }
    
    public static void modificar(Camion camion) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            camionDao.modificar(conexion, camion);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
    
    public static void eliminar(Camion camion) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            camionDao.eliminar(conexion, camion);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
}