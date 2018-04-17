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
public class Camion implements Serializable {
    
    private int consecutivo;
    private String placa;
    private String nombresApellidosConductor;
    private String empresaAfiliada;
    private double capacidad;

    public Camion() {
        super();
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNombresApellidosConductor() {
        return nombresApellidosConductor;
    }

    public void setNombresApellidosConductor(String nombresApellidosConductor) {
        this.nombresApellidosConductor = nombresApellidosConductor;
    }

    public String getEmpresaAfiliada() {
        return empresaAfiliada;
    }

    public void setEmpresaAfiliada(String empresaAfiliada) {
        this.empresaAfiliada = empresaAfiliada;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }
}
