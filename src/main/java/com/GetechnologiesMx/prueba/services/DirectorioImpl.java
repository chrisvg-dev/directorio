package com.GetechnologiesMx.prueba.services;

import com.GetechnologiesMx.prueba.dto.PersonaDto;
import com.GetechnologiesMx.prueba.models.Persona;
import com.GetechnologiesMx.prueba.repository.FacturaRepository;
import com.GetechnologiesMx.prueba.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DirectorioImpl implements Directorio {
    @Autowired private PersonaRepository personaRepository;
    @Autowired private FacturaRepository facturaRepository;

    @Override
    public List<Persona> findPersonas() {
        return this.personaRepository.findAll();
    }

    @Override
    public Persona findPersonaByIdentificacion(String identificacion) {
        return this.personaRepository.findByIdentificacion(identificacion).orElse(null);
    }

    @Override
    public String deletePersonaByIdentificacion(String identificacion) {
        Persona persona = this.personaRepository.findByIdentificacion(identificacion).orElse(null);
        if (persona != null) {
            this.facturaRepository.findByPersona(persona).stream()
                    .forEach( factura -> {
                        this.facturaRepository.deleteById( factura.getId() );
                    } );
            this.personaRepository.deleteByIdentificacion(identificacion);
            return "Registro eliminado";
        }
        return "Error al eliminar el registro";
    }

    @Override
    public Persona storePersona(PersonaDto persona) {
        Persona nuevaPersona = Persona.builder()
                .nombre( persona.getNombre() )
                .apellidoPaterno(persona.getApellidoPaterno() )
                .apellidoMaterno(persona.getApellidoMaterno() )
                .identificacion( persona.getIdentificacion() )
                .build();
        return this.personaRepository.save(nuevaPersona);
    }

    @Override
    public boolean existsByIdentificacion(String identificacion) {
        return this.personaRepository.existsByIdentificacion(identificacion);
    }
}
