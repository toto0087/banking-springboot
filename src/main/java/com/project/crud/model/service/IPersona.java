package com.project.crud.model.service;

import com.project.crud.domain.dto.PersonaDto;
import com.project.crud.domain.dto.dtolist.PersonasListDto;
import com.project.crud.domain.dto.ResponseDto;
import com.project.crud.model.repository.entity.Persona;

public interface IPersona {
    PersonasListDto getAllPersonas();
    PersonaDto getPersonaById(Long id);
    Persona savePersona(Persona persona);
    ResponseDto deletePersona(Long id);
}
