/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Utilidadades.Utilidades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.JTextField;
import static Vista.Mensaje.jTextField1;

/**
 *
 * @author PC
 */
public class registroColaborador extends javax.swing.JFrame {

    int error = 0;

    /**
     * Creates new form registroColaborador
     */
    public registroColaborador() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        campoIdentificacionColaborador = new java.awt.TextField();
        campoNombresColaborador = new java.awt.TextField();
        campoApellidosRegistroColaborador = new java.awt.TextField();
        campoCargoRegistroColaborador = new java.awt.TextField();
        campoSalarioRegistroColaborador = new java.awt.TextField();
        campoDireccionRegistroColaborador = new java.awt.TextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoTelefonoRegistroColaborador = new java.awt.TextField();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro Colaborador");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        campoIdentificacionColaborador.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        campoIdentificacionColaborador.setName(""); // NOI18N
        campoIdentificacionColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoIdentificacionColaboradorActionPerformed(evt);
            }
        });
        campoIdentificacionColaborador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoIdentificacionColaboradorKeyTyped(evt);
            }
        });

        campoNombresColaborador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoNombresColaboradorFocusLost(evt);
            }
        });

        campoApellidosRegistroColaborador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoApellidosRegistroColaboradorFocusLost(evt);
            }
        });
        campoApellidosRegistroColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoApellidosRegistroColaboradorActionPerformed(evt);
            }
        });
        campoApellidosRegistroColaborador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoApellidosRegistroColaboradorKeyReleased(evt);
            }
        });

        campoCargoRegistroColaborador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoCargoRegistroColaboradorFocusLost(evt);
            }
        });
        campoCargoRegistroColaborador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoCargoRegistroColaboradorKeyReleased(evt);
            }
        });

        campoSalarioRegistroColaborador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoSalarioRegistroColaboradorKeyTyped(evt);
            }
        });

        campoDireccionRegistroColaborador.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                campoDireccionRegistroColaboradorCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        campoDireccionRegistroColaborador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoDireccionRegistroColaboradorFocusLost(evt);
            }
        });
        campoDireccionRegistroColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDireccionRegistroColaboradorActionPerformed(evt);
            }
        });
        campoDireccionRegistroColaborador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoDireccionRegistroColaboradorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoDireccionRegistroColaboradorKeyReleased(evt);
            }
        });

        jLabel1.setText("Identificacion");

        jLabel2.setText("Nombres");

        jLabel3.setText("Apellidos");

        jLabel4.setText("Cargo");

        jLabel5.setText("Salario");

        jLabel6.setText("Direccion");

        campoTelefonoRegistroColaborador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoTelefonoRegistroColaboradorKeyTyped(evt);
            }
        });

        jLabel7.setText("Telefono");

        jButton2.setText("Grabar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(campoIdentificacionColaborador, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(campoNombresColaborador, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(campoApellidosRegistroColaborador, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(campoCargoRegistroColaborador, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(campoSalarioRegistroColaborador, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(campoDireccionRegistroColaborador, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(campoTelefonoRegistroColaborador, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap(109, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(41, 41, 41)
                        .addComponent(jButton2))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoTelefonoRegistroColaborador, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(campoDireccionRegistroColaborador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoSalarioRegistroColaborador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoCargoRegistroColaborador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoApellidosRegistroColaborador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoNombresColaborador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoIdentificacionColaborador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(42, 42, 42))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoIdentificacionColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoNombresColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(campoApellidosRegistroColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoCargoRegistroColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoSalarioRegistroColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoDireccionRegistroColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(campoTelefonoRegistroColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        error = 0;
        if (campoIdentificacionColaborador.getText().length() == 0) {
            Mensaje mensaje = new Mensaje();
            mensaje.setVisible(true);
            mensaje.jTextField1.setText("Debe digitar un numero de identificación");
            error = 1; }  
        if (error == 0 && campoNombresColaborador.getText().length() == 0) {
            Mensaje mensaje = new Mensaje();
            mensaje.setVisible(true);
            mensaje.jTextField1.setText("Debe digitar el nombre");
            error = 1;  }
        if (error == 0 && campoApellidosRegistroColaborador.getText().length() == 0) {
            Mensaje mensaje = new Mensaje();
            mensaje.setVisible(true);
            mensaje.jTextField1.setText("Debe digitar el apellido");
            error = 1;  }
        if (error == 0 && campoCargoRegistroColaborador.getText().length() == 0) {
            Mensaje mensaje = new Mensaje();
            mensaje.setVisible(true);
            mensaje.jTextField1.setText("Debe digitar el cargo");
            error = 1;  }
        if (error == 0 && campoSalarioRegistroColaborador.getText().length() == 0) {
            Mensaje mensaje = new Mensaje();
            mensaje.setVisible(true);
            mensaje.jTextField1.setText("Debe digitar el salario");
            error = 1;  }
        //
        if (error == 0 && campoDireccionRegistroColaborador.getText().length() == 0) {
            Mensaje mensaje = new Mensaje();
            mensaje.setVisible(true);
            mensaje.jTextField1.setText("Debe digitar la dirección");
            error = 1;  }
        //
        if (error == 0 && campoTelefonoRegistroColaborador.getText().length() == 0) {
            Mensaje mensaje = new Mensaje();
            mensaje.setVisible(true);
            mensaje.jTextField1.setText("Debe digitar el telefono");
            error = 1;  }

        if (error == 0) {
            
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void campoIdentificacionColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoIdentificacionColaboradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoIdentificacionColaboradorActionPerformed

    private void campoIdentificacionColaboradorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoIdentificacionColaboradorKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            Mensaje mensaje = new Mensaje();
            mensaje.setVisible(true);
            mensaje.jTextField1.setText("Solo es posible diligenciar numeros");
          }

    }//GEN-LAST:event_campoIdentificacionColaboradorKeyTyped

    private void campoApellidosRegistroColaboradorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoApellidosRegistroColaboradorKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_campoApellidosRegistroColaboradorKeyReleased

    private void campoCargoRegistroColaboradorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCargoRegistroColaboradorKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_campoCargoRegistroColaboradorKeyReleased

    private void campoSalarioRegistroColaboradorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoSalarioRegistroColaboradorKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            Mensaje mensaje = new Mensaje();
            mensaje.setVisible(true);
            mensaje.jTextField1.setText("Por favor digite solo números, sin puntos decimales");

        }
    }//GEN-LAST:event_campoSalarioRegistroColaboradorKeyTyped

    private void campoDireccionRegistroColaboradorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDireccionRegistroColaboradorKeyReleased
        // TODO add your handling code here:
       

    }//GEN-LAST:event_campoDireccionRegistroColaboradorKeyReleased

    private void campoTelefonoRegistroColaboradorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTelefonoRegistroColaboradorKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            Mensaje mensaje = new Mensaje();
            mensaje.setVisible(true);
            mensaje.jTextField1.setText("Solo es posible diligenciar numeros");

        }
    }//GEN-LAST:event_campoTelefonoRegistroColaboradorKeyTyped

    private void campoDireccionRegistroColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDireccionRegistroColaboradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDireccionRegistroColaboradorActionPerformed

    private void campoDireccionRegistroColaboradorCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_campoDireccionRegistroColaboradorCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDireccionRegistroColaboradorCaretPositionChanged

    private void campoDireccionRegistroColaboradorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDireccionRegistroColaboradorKeyPressed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_campoDireccionRegistroColaboradorKeyPressed

    private void campoDireccionRegistroColaboradorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoDireccionRegistroColaboradorFocusLost
        String direccion = campoDireccionRegistroColaborador.getText();
        campoDireccionRegistroColaborador.setText(direccion.toUpperCase());
    }//GEN-LAST:event_campoDireccionRegistroColaboradorFocusLost

    private void campoNombresColaboradorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNombresColaboradorFocusLost
         // TODO add your handling code here:
        String nombres = campoNombresColaborador.getText();
        campoNombresColaborador.setText(nombres.toUpperCase());
    }//GEN-LAST:event_campoNombresColaboradorFocusLost

    private void campoApellidosRegistroColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoApellidosRegistroColaboradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoApellidosRegistroColaboradorActionPerformed

    private void campoApellidosRegistroColaboradorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoApellidosRegistroColaboradorFocusLost
         // TODO add your handling code here:
        String apellidos = campoApellidosRegistroColaborador.getText();
        campoApellidosRegistroColaborador.setText(apellidos.toUpperCase());
    }//GEN-LAST:event_campoApellidosRegistroColaboradorFocusLost

    private void campoCargoRegistroColaboradorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCargoRegistroColaboradorFocusLost
         // TODO add your handling code here:
        String salario = campoCargoRegistroColaborador.getText();
        campoCargoRegistroColaborador.setText(salario.toUpperCase());
    }//GEN-LAST:event_campoCargoRegistroColaboradorFocusLost

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
         setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        Utilidades.utilidades("¿Desea salir del sistema?", "Salir del sistema", rootPane);
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(registroColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registroColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registroColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registroColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registroColaborador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextField campoApellidosRegistroColaborador;
    private java.awt.TextField campoCargoRegistroColaborador;
    private java.awt.TextField campoDireccionRegistroColaborador;
    private java.awt.TextField campoIdentificacionColaborador;
    private java.awt.TextField campoNombresColaborador;
    private java.awt.TextField campoSalarioRegistroColaborador;
    private java.awt.TextField campoTelefonoRegistroColaborador;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
