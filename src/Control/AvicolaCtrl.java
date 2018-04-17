/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.AvicolaDao;
import Modelo.Avicola;
import Utilidadades.Conexion;
import java.sql.Connection;

/**
 *
 * @author Usuario
 */
public class AvicolaCtrl {
    
    static AvicolaDao avicolaDao = new AvicolaDao();
    
    public static void registar(Avicola avicola) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            avicolaDao.registrar(conexion, avicola);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
    
    public static Avicola consultar(Avicola avicola) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            Avicola nuevo = avicolaDao.consultar(conexion, avicola);
            return nuevo;
        } catch (Exception exce) {
            conn.cerrarConecion();
            return null;
        }
    }
    
    public static void modificar(Avicola avicola) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            avicolaDao.modificar(conexion, avicola);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
    
    public static void eliminar(Avicola avicola) {
        Conexion conn = Conexion.getInstance();
        try {
            Connection conexion = conn.conectar();
            avicolaDao.eliminar(conexion, avicola);
        } catch (Exception exce) {
            conn.cerrarConecion();
        }
    }
}