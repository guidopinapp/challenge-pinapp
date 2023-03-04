package com.challenge.pinapp.model.dto;

public class DesviacionEstandarClienteDTO {

    private String debajo_media_edad;
    private String encima_media_edad;

    public DesviacionEstandarClienteDTO(String debajo_media_edad, String encima_media_edad) {
        this.debajo_media_edad = debajo_media_edad;
        this.encima_media_edad = encima_media_edad;
    }

    public String getDebajo_media_edad() {
        return debajo_media_edad;
    }

    public void setDebajo_media_edad(String debajo_media_edad) {
        this.debajo_media_edad = debajo_media_edad;
    }

    public String getEncima_media_edad() {
        return encima_media_edad;
    }

    public void setEncima_media_edad(String encima_media_edad) {
        this.encima_media_edad = encima_media_edad;
    }
}
