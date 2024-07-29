package com.project.crud.domain.dto.dtoList;

import com.project.crud.domain.dto.PersonaDto;
import com.project.crud.model.Persona;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonasListDto {
    private List<PersonaDto> personaList;
}
