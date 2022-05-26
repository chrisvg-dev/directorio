package com.GetechnologiesMx.prueba.services;

import com.GetechnologiesMx.prueba.dto.FacturaDto;
import com.GetechnologiesMx.prueba.models.Factura;
import com.GetechnologiesMx.prueba.models.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Ventas {
    List<Factura> findFacturasByPersona(Persona persona);
    Factura storeFactura(FacturaDto factura);

}
