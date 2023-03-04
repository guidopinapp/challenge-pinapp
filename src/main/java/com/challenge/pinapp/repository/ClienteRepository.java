package com.challenge.pinapp.repository;

import com.challenge.pinapp.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query(value = "select TIMESTAMPDIFF(YEAR,?1,CURDATE()) AS edad", nativeQuery = true)
    Integer obtenerEdad(LocalDate fechaNacimiento);

}
