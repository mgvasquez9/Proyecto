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
public class Remsion implements Serializable {
    
    private int consecutivo;
    private int consecutivoRevision;
    private String fechaRemision;
    private String avicolaDestino;
    private String gradoDespachado;
    private String tipoDespacho;
    private String placaVehiculoTransportador;

    public Remsion() {
        super();
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public int getConsecutivoRevision() {
        return consecutivoRevision;
    }

    public void setConsecutivoRevision(int consecutivoRevision) {
        this.consecutivoRevision = consecutivoRevision;
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