package com.project.crud.model.service;

import com.project.crud.domain.dto.dtoList.PersonasListDto;
import com.project.crud.domain.dto.ResponseDto;
import com.project.crud.model.Persona;

public interface IPersona {
    PersonasListDto getAllPersonas();
    Persona getPersonaById(Long id);
    Persona savePersona(Persona persona);
    ResponseDto deletePersona(Long id);
}
