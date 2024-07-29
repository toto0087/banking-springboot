package com.project.crud.model.impl;

import com.project.crud.domain.dto.PersonasListDto;
import com.project.crud.domain.dto.ResponseDto;
import com.project.crud.model.service.IPersona;
import com.project.crud.model.Persona;
import com.project.crud.domain.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersona {

    @Autowired
    private IPersonaRepository personaRepository;

    public PersonasListDto getAllPersonas() {
        List<Persona> personas = personaRepository.findAll();
        return new PersonasListDto(personas);
    }

    public Persona getPersonaById(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    public Persona savePersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public ResponseDto deletePersona(Long id) {
        ResponseDto responseDto = new ResponseDto();
        try {
            personaRepository.deleteById(id);
            responseDto.setSuccess(true);
        } catch (Exception e) {
            responseDto.setSuccess(false);
        }
        return responseDto;
    }
}
