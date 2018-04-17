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
public class Siembra implements Serializable {
    
    private int id;
    private int consecutivoSiembra;
    private String tipoSiembra;
    private String granoSiembra;
    private String fechaInicio;
    private String fechaFinalizacion;
    private String sitioSiembra;

    public Siembra() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConsecutivoSiembra() {
        return consecutivoSiembra;
    }

    public void setConsecutivoSiembra(int consecutivoSiembra) {
        this.consecutivoSiembra = consecutivoSiembra;
    }

    public String getTipoSiembra() {
        return tipoSiembra;
    }

    public void setTipoSiembra(String tipoSiembra) {
        this.tipoSiembra = tipoSiembra;
    }

    public String getGranoSiembra() {
        return granoSiembra;
    }

    public void setGranoSiembra(String granoSiembra) {
        this.granoSiembra = granoSiembra;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(String fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getSitioSiembra() {
        return sitioSiembra;
    }

    public void setSitioSiembra(String sitioSiembra) {
        this.sitioSiembra = sitioSiembra;
    }
}
