package com.project.crud.controllers;

import com.project.crud.model.Direccion;
import com.project.crud.services.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DireccionController {

    @Autowired
    private DireccionService direccionService;

    @GetMapping
    public List<Direccion> getAllDirecciones() {
        return direccionService.getAllDirecciones();
    }

    @GetMapping("/{id}")
    public Direccion getDireccionById(Long id) {
        return direccionService.getDireccionById(id);
    }

    @PostMapping
    public Direccion saveDireccion(Direccion direccion) {
        return direccionService.saveDireccion(direccion);
    }

    @DeleteMapping
    public void deleteDireccion(Long id) {
        direccionService.deleteDireccion(id);
    }
}
