/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class Combinada implements Serializable {
    
    private int consecutivo;
    private double costo;
    private String nombreOperario;
    private int ordenAlquiler;
    private String referencia;

    public Combinada() {
        super();
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getNombreOperario() {
        return nombreOperario;
    }

    public void setNombreOperario(String nombreOperario) {
        this.nombreOperario = nombreOperario;
    }

    public int getOrdenAlquiler() {
        return ordenAlquiler;
    }

    public void setOrdenAlquiler(int ordenAlquiler) {
        this.ordenAlquiler = ordenAlquiler;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
}
