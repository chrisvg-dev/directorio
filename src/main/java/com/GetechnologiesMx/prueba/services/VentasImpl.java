package com.GetechnologiesMx.prueba.services;

import com.GetechnologiesMx.prueba.dto.FacturaDto;
import com.GetechnologiesMx.prueba.models.Factura;
import com.GetechnologiesMx.prueba.models.Persona;
import com.GetechnologiesMx.prueba.repository.FacturaRepository;
import com.GetechnologiesMx.prueba.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class VentasImpl implements Ventas {

    @Autowired private FacturaRepository facturaRepository;
    @Autowired private PersonaRepository personaRepository;

    @Override
    public List<Factura> findFacturasByPersona(Persona persona) {
        return this.facturaRepository.findByPersona(persona);
    }

    @Override
    public Factura storeFactura(FacturaDto factura) {
        Factura nuevaFactura = Factura.builder()
                .fecha(LocalDate.now())
                .monto( factura.getMonto() )
                .persona( personaRepository.findByIdentificacion( factura.getIdentificacion() ).orElse(null) )
                .build();
        return this.facturaRepository.save(nuevaFactura);
    }

}
