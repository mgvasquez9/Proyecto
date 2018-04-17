/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidadades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class UtilFile {
    private Properties propiedades = new Properties();

    public UtilFile() {
    }
    
    

    public Properties getPropiedades() {
        try {
            propiedades.load(new FileInputStream(
                    "C:\\Users\\Usuario.Usuario-PC\\Documents\\NetBeansProjects\\Sipagcv3\\archivo.properties"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UtilFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UtilFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        return propiedades;
    }
    
   

   
    
  
    
}
