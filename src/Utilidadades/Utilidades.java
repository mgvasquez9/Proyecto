/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidadades;

import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 *
 * @author Usuario
 */
public class Utilidades {
    
    public static void utilidades (String mensaje, String tipoMensaje , JRootPane rootPane) {
        
        if (JOptionPane.showConfirmDialog(rootPane, mensaje, tipoMensaje, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }        
    }
    
}
