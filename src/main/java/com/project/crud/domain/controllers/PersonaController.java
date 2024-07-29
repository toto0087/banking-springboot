package com.project.crud.domain.controllers;

import com.project.crud.domain.dto.dtoList.PersonasListDto;
import com.project.crud.domain.dto.ResponseDto;
import com.project.crud.model.repository.entity.Persona;
import com.project.crud.model.impl.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public ResponseEntity<PersonasListDto> getAllPersonas() {
        PersonasListDto personasListDto =  personaService.getAllPersonas();
        return ResponseEntity.ok(personasListDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Long id) {
        Persona persona = personaService.getPersonaById(id);
        return ResponseEntity.of(java.util.Optional.ofNullable(persona));
    }

    @PostMapping
    public ResponseEntity<Persona> savePersona(@RequestBody Persona persona) {
        Persona savedPersona = personaService.savePersona(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPersona);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deletePersona(@PathVariable Long id) {
        ResponseDto responseDto = personaService.deletePersona(id);
        return ResponseEntity.ok(responseDto);
    }
}
