package com.project.crud.controllers;

import com.project.crud.model.Persona;
import com.project.crud.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaService.getAllPersonas();
    }

    @GetMapping
    public Persona getPersonaById(Long id) {
        return personaService.getPersonaById(id);
    }

    @GetMapping
    public Persona savePersona(Persona persona) {
        return personaService.savePersona(persona);
    }

    @GetMapping
    public void deletePersona(Long id) {
        personaService.deletePersona(id);
    }
}
