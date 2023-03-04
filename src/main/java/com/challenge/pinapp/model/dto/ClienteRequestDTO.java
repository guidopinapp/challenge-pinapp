package com.challenge.pinapp.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;


public class ClienteRequestDTO {

    private Integer idCliente;

    @NotNull(message = "el nombre es requerido")
    private String nombre;

    @NotNull(message =  "el apellido es requerido")
    private String apellido;

    private Integer edad;

    @NotNull(message = "La fecha de nacimiento es requerida")
    @JsonProperty("fecha_nacimiento")
    private LocalDate fechaNacimiento;

    public ClienteRequestDTO(Integer idCliente, String nombre, String apellido, Integer edad, LocalDate fechaNacimiento) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
