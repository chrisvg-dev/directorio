package com.GetechnologiesMx.prueba.controller;

import com.GetechnologiesMx.prueba.dto.FacturaDto;
import com.GetechnologiesMx.prueba.dto.Message;
import com.GetechnologiesMx.prueba.dto.PersonaDto;
import com.GetechnologiesMx.prueba.models.Factura;
import com.GetechnologiesMx.prueba.models.Persona;
import com.GetechnologiesMx.prueba.services.Directorio;
import com.GetechnologiesMx.prueba.services.Ventas;
import com.GetechnologiesMx.prueba.services.VentasImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
@CrossOrigin(origins = "*")
public class FacturaRestService {
    private static final Logger log = LoggerFactory.getLogger(FacturaRestService.class);
    @Autowired private VentasImpl ventas;
    @Autowired private Directorio directorio;

    @GetMapping("/{identificacion}")
    public ResponseEntity<List<Factura>> listarFacturas(@PathVariable String identificacion){
        log.info( identificacion );
        Persona persona = this.directorio.findPersonaByIdentificacion(identificacion);
        return ResponseEntity.ok( this.ventas.findFacturasByPersona( persona ) );
    }

    @PostMapping
    public ResponseEntity<Message> store(@RequestBody FacturaDto facturaDto){
        if (facturaDto.getMonto() < 1 || facturaDto.getMonto() == null){
            return new ResponseEntity<Message>( new Message("Debes ingresar un monto valido para la factura"), HttpStatus.BAD_REQUEST );
        }
        if (facturaDto.getIdentificacion().isEmpty() || facturaDto.getIdentificacion() == null){
            return new ResponseEntity<Message>( new Message("Debes asignarle un propietario a la factura"), HttpStatus.BAD_REQUEST );
        }

        if (!this.directorio.existsByIdentificacion( facturaDto.getIdentificacion() )) {
            return new ResponseEntity<Message>( new Message("La identificacion ingresada no esta registrada..."), HttpStatus.BAD_REQUEST );
        }

        Factura f = this.ventas.storeFactura(facturaDto);

        if (f != null) {
            return new ResponseEntity<Message>( new Message("Registro exitoso"), HttpStatus.CREATED );
        }

        return ResponseEntity.badRequest().build();
    }

}
