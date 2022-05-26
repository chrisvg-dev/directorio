package com.GetechnologiesMx.prueba.models;

import com.GetechnologiesMx.prueba.dto.FacturaDto;
import com.GetechnologiesMx.prueba.dto.PersonaDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    private Double monto;

    @ManyToOne
    @JoinColumn(name = "fk_persona", referencedColumnName = "id")
    @JsonIgnoreProperties({"persona", "facturas"})
    private Persona persona;

}
