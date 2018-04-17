/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidadades;

import java.util.Properties;

/**
 *
 * @author Usuario
 */
public class Principal {

    public static void main(String arg[]) {
        Properties prop = new UtilFile().getPropiedades();
        System.out.println(prop.getProperty("url"));
    }

}
