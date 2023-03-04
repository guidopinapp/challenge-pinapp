package com.challenge.pinapp.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cliente")
    private Integer idCliente;
    private String nombre;
    private String apellido;
    private Integer edad;

    private LocalDate fechaNacimiento;

    private LocalDate fechaProbableMuerte;

    public Cliente (){
        
    }

    public Cliente(Integer idCliente, String nombre, String apellido, Integer edad, LocalDate fechaNacimiento, LocalDate fechaProbableMuerte) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaProbableMuerte = fechaProbableMuerte;
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

    public LocalDate getFechaProbableMuerte() {
        return fechaProbableMuerte;
    }

    public void setFechaProbableMuerte(LocalDate fechaProbableMuerte) {
        this.fechaProbableMuerte = fechaProbableMuerte;
    }
}
