package com.challenge.pinapp.repository;

import com.challenge.pinapp.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query(value = "select TIMESTAMPDIFF(YEAR,?1,CURDATE()) AS edad", nativeQuery = true)
    Integer obtenerEdad(LocalDate fechaNacimiento);

    @Query(value = "select round(sum(c.edad)/count(*),0) as promedio from clientes c", nativeQuery = true)
    Integer obtenerPromedioEdad();

    @Query(value = "select c.id_cliente, c.nombre, c.apellido, c.edad, c.fecha_nacimiento, DATE_ADD(c.fecha_nacimiento, INTERVAL 70 YEAR) as fecha_probable_muerte from clientes c",nativeQuery = true)
    List<Cliente> getClientes();

    @Query(value = "select count(*) from clientes",nativeQuery = true)
    Integer getCantidadClientes();
}
