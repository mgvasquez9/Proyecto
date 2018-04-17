/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.ColaboradorDao;
import Modelo.Colaborador;
import Utilidadades.Conexion;
import java.sql.Connection;

/**
 *
 * @author Usuario
 */
public class ColaboradorCtrl {
    
    static ColaboradorDao colaboradorDao = new ColaboradorDao();
    
    public static void registar(Colaborador colaborador) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            colaboradorDao.registrar(conexion, colaborador);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
    
    public static Colaborador consultar(Colaborador colaborador) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            Colaborador nuevo = colaboradorDao.consultar(conexion, colaborador);
            return nuevo;
        } catch (Exception exce) {
            conn.cerrarConecion();
            return null;
        }
    }
    
    public static void modificar(Colaborador colaborador) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            colaboradorDao.modificar(conexion, colaborador);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
    
    public static void eliminar(Colaborador colaborador) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            colaboradorDao.eliminar(conexion, colaborador);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
}