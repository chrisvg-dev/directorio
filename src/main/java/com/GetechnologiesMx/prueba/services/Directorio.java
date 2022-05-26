package com.GetechnologiesMx.prueba.services;

import com.GetechnologiesMx.prueba.dto.PersonaDto;
import com.GetechnologiesMx.prueba.models.Persona;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface Directorio {
    List<Persona> findPersonas();
    Persona findPersonaByIdentificacion(String identificacion);
    String deletePersonaByIdentificacion(String identificacion);
    Persona storePersona(PersonaDto persona);
    boolean existsByIdentificacion(String identificacion);
}
