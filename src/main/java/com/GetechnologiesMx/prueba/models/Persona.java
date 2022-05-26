package com.GetechnologiesMx.prueba.models;

import com.GetechnologiesMx.prueba.dto.PersonaDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Table(name = "personas")
public class Persona implements Serializable {
    private static final long serialVersionUID = 1454627423540482434L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El nombre no debe estar vacío")
    private String nombre;
    @NotBlank(message = "El apellido paterno no debe estar vacío")
    private String apellidoPaterno;
    private String apellidoMaterno;
    @NotBlank(message = "La identificación es obligatoria")
    @Column(nullable = true, unique = true)
    private String identificacion;

    @OneToMany
    @JoinColumn(name = "fk_persona", referencedColumnName = "id")
    @JsonIgnoreProperties("persona")
    @Transient
    private List<Factura> facturas;

}
