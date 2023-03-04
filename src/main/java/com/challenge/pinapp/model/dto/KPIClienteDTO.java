package com.challenge.pinapp.model.dto;

public class KPIClienteDTO {
    private int promedioEdad;
    private DesviacionEstandarClienteDTO desviacionEstandar;

    public KPIClienteDTO(int promedioEdad, DesviacionEstandarClienteDTO desviacionEstandar) {
        this.promedioEdad = promedioEdad;
        this.desviacionEstandar = desviacionEstandar;
    }

    public int getPromedioEdad() {
        return promedioEdad;
    }

    public void setPromedioEdad(int promedioEdad) {
        this.promedioEdad = promedioEdad;
    }

    public DesviacionEstandarClienteDTO getDesviacionEstandar() {
        return desviacionEstandar;
    }

    public void setDesviacionEstandar(DesviacionEstandarClienteDTO desviacionEstandar) {
        this.desviacionEstandar = desviacionEstandar;
    }
}
