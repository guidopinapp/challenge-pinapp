package com.challenge.pinapp.model.dto;

import com.sun.istack.NotNull;

import java.time.LocalDate;


public class ClienteResponseDTO {

    private Integer idCliente;
    private String nombre;
    private String apellido;
    private Integer edad;
    private LocalDate fechaNacimiento;

    public ClienteResponseDTO(Integer idCliente, String nombre, String apellido, Integer edad, LocalDate fechaNacimiento) {
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
