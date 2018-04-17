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
public class Remision implements Serializable {
    
    private int consecutivo;
    private int consecutivoRemision;
    private String fechaRemision;
    private String avicolaDestino;
    private String gradoDespachado;
    private String tipoDespacho;
    private String placaVehiculoTransportador;

    public Remision() {
        super();
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public int getConsecutivoRemision() {
        return consecutivoRemision;
    }

    public void setConsecutivoRemision(int consecutivoRemision) {
        this.consecutivoRemision = consecutivoRemision;
    }

    public String getFechaRemision() {
        return fechaRemision;
    }

    public void setFechaRemision(String fechaRemision) {
        this.fechaRemision = fechaRemision;
    }

    public String getAvicolaDestino() {
        return avicolaDestino;
    }

    public void setAvicolaDestino(String avicolaDestino) {
        this.avicolaDestino = avicolaDestino;
    }

    public String getGradoDespachado() {
        return gradoDespachado;
    }

    public void setGradoDespachado(String gradoDespachado) {
        this.gradoDespachado = gradoDespachado;
    }

    public String getTipoDespacho() {
        return tipoDespacho;
    }

    public void setTipoDespacho(String tipoDespacho) {
        this.tipoDespacho = tipoDespacho;
    }

    public String getPlacaVehiculoTransportador() {
        return placaVehiculoTransportador;
    }

    public void setPlacaVehiculoTransportador(String placaVehiculoTransportador) {
        this.placaVehiculoTransportador = placaVehiculoTransportador;
    }
}