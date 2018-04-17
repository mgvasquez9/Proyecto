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
public class Cosecha implements Serializable {
    
    private int consecutivo;
    private int consecutivoCosecha;
    private String fechaFinalizacion;
    private String fechaInicio;
    private String granoCortar;
    private String sitioCortar;
    private String tipoCorte;

    public Cosecha() {
        super();
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public int getConsecutivoCosecha() {
        return consecutivoCosecha;
    }

    public void setConsecutivoCosecha(int consecutivoCosecha) {
        this.consecutivoCosecha = consecutivoCosecha;
    }

    public String getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(String fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getGranoCortar() {
        return granoCortar;
    }

    public void setGranoCortar(String granoCortar) {
        this.granoCortar = granoCortar;
    }

    public String getSitioCortar() {
        return sitioCortar;
    }

    public void setSitioCortar(String sitioCortar) {
        this.sitioCortar = sitioCortar;
    }

    public String getTipoCorte() {
        return tipoCorte;
    }

    public void setTipoCorte(String tipoCorte) {
        this.tipoCorte = tipoCorte;
    }
}
