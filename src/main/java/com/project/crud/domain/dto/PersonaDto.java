package com.project.crud.domain.dto;

import com.project.crud.model.repository.entity.Cuenta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDto {
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String email;
    private List<Cuenta> cuenta;
}
