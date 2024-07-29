package com.project.crud.model.impl;

import com.project.crud.config.exceptions.NoExisteLaPersonaException;
import com.project.crud.domain.dto.PersonaDto;
import com.project.crud.domain.dto.dtoList.PersonasListDto;
import com.project.crud.domain.dto.ResponseDto;
import com.project.crud.model.service.IPersona;
import com.project.crud.model.repository.entity.Persona;
import com.project.crud.model.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService implements IPersona {

    @Autowired
    private IPersonaRepository personaRepository;

    public PersonasListDto getAllPersonas() {
        List<Persona> personas = personaRepository.findAll();
        List<PersonaDto> personaDtos = personas.stream()
                .map(persona -> new PersonaDto(persona.getNombre(), persona.getApellido(), persona.getDni(),
                        persona.getTelefono(), persona.getEmail(), persona.getCuenta()))
                .collect(Collectors.toList());
        return new PersonasListDto(personaDtos);
    }

    public Persona getPersonaById(Long id) {
        return personaRepository.findById(id).orElseThrow(
                () -> new NoExisteLaPersonaException("No existe la persona con id: " + id)
        );
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
