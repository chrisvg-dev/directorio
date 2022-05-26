package com.GetechnologiesMx.prueba.repository;

import com.GetechnologiesMx.prueba.models.Factura;
import com.GetechnologiesMx.prueba.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
    List<Factura> findByPersona(Persona p);
}