package com.GetechnologiesMx.prueba.repository;

import com.GetechnologiesMx.prueba.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Optional<Persona> findByIdentificacion(String identificacion);
    void deleteByIdentificacion(String identificacion);
    boolean existsByIdentificacion(String identicacion);
}
