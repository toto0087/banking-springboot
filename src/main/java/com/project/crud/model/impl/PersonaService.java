package com.project.crud.model.impl;

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

    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    public Persona getPersonaById(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    public Persona savePersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }
}
