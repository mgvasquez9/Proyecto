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
public class ControlSiembra implements Serializable {
    
    private int consecutivo;
    private double cantidadInsumo;
    private int cosechaAplicar;
    private int consecutivoControlSiembra;
    private String descripcion;
    private String fechaFinalizacion;
    private String fechaInicio;
    private int sitioAplicacion;
    private String tipoControl;
    private String tipoInsumo;

    public ControlSiembra() {
        super();
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public double getCantidadInsumo() {
        return cantidadInsumo;
    }

    public void setCantidadInsumo(double cantidadInsumo) {
        this.cantidadInsumo = cantidadInsumo;
    }

    public int getCosechaAplicar() {
        return cosechaAplicar;
    }

    public void setCosechaAplicar(int cosechaAplicar) {
        this.cosechaAplicar = cosechaAplicar;
    }

    public int getConsecutivoControlSiembra() {
        return consecutivoControlSiembra;
    }

    public void setConsecutivoControlSiembra(int consecutivoControlSiembra) {
        this.consecutivoControlSiembra = consecutivoControlSiembra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public int getSitioAplicacion() {
        return sitioAplicacion;
    }

    public void setSitioAplicacion(int sitioAplicacion) {
        this.sitioAplicacion = sitioAplicacion;
    }

    public String getTipoControl() {
        return tipoControl;
    }

    public void setTipoControl(String tipoControl) {
        this.tipoControl = tipoControl;
    }

    public String getTipoInsumo() {
        return tipoInsumo;
    }

    public void setTipoInsumo(String tipoInsumo) {
        this.tipoInsumo = tipoInsumo;
    }
}
