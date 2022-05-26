package com.GetechnologiesMx.prueba.dto;

import com.GetechnologiesMx.prueba.models.Factura;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class PersonaDto {
    private Long id;
    @NotNull(message = "El nombre no debe estar vacío")
    private String nombre;
    @NotNull(message = "El apellido paterno no debe estar vacío")
    private String apellidoPaterno;
    private String apellidoMaterno;
    @NotNull(message = "La identificacion es obligatoria")
    private String identificacion;
}
