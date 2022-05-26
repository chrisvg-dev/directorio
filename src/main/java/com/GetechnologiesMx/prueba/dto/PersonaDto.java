package com.GetechnologiesMx.prueba.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

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
