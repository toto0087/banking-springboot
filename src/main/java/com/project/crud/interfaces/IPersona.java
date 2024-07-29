package com.project.crud.interfaces;

import com.project.crud.model.Persona;

import java.util.List;

public interface IPersona {
    List<Persona> getAllPersonas();
    Persona getPersonaById(Long id);
    Persona savePersona(Persona persona);
    void deletePersona(Long id);
}
