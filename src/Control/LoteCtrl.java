/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.LoteDao;
import Modelo.Lote;
import Utilidadades.Conexion;
import java.sql.Connection;

/**
 *
 * @author Usuario
 */
public class LoteCtrl {
    
    static LoteDao loteDao = new LoteDao();
    
    public static void registar(Lote lote) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            loteDao.registrar(conexion, lote);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
    
    public static Lote consultar(Lote lote) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            Lote nuevo = loteDao.consultar(conexion, lote);
            return nuevo;
        } catch (Exception exce) {
            conn.cerrarConecion();
            return null;
        }
    }
    
    public static void modificar(Lote lote) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            loteDao.modificar(conexion, lote);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
    
    public static void eliminar(Lote lote) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            loteDao.eliminar(conexion, lote);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
}