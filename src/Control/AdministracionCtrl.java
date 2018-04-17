/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.AdministracionDao;
import Modelo.Administracion;
import Utilidadades.Conexion;
import java.sql.Connection;

/**
 *
 * @author Usuario
 */
public class AdministracionCtrl {

    static AdministracionDao adminDao = new AdministracionDao();

    public static void registar(Administracion administracion) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            adminDao.registrar(conexion, administracion);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }

    public static Administracion consultar(Administracion administracion) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            Administracion nuevo = adminDao.consultar(conexion, administracion);
            return nuevo;
        } catch (Exception exce) {
            conn.cerrarConecion();
            return null;
        }
    }

    public static void modificar(Administracion administracion) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            adminDao.modificar(conexion, administracion);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }

    public static void eliminar(Administracion administracion) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            adminDao.eliminar(conexion, administracion);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }

    public static boolean loguear(Administracion administracion) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            Administracion logueo = adminDao.consultarPorUsuario(conexion, administracion);
            if (administracion.getPassword().equals(logueo.getPassword())) {
                return true;
            } else {
                return false;
            }
        } catch (Exception exce) {
            conn.cerrarConecion();
            return false;
        }
    }
}