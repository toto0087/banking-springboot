package com.project.crud.controllers;

import com.project.crud.model.Persona;
import com.project.crud.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaService.getAllPersonas();
    }

    @GetMapping("/{id}")
    public Persona getPersonaById(Long id) {
        return personaService.getPersonaById(id);
    }

    @PostMapping
    public Persona savePersona(Persona persona) {
        return personaService.savePersona(persona);
    }

    @DeleteMapping
    public void deletePersona(Long id) {
        personaService.deletePersona(id);
    }
}
