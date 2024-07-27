package com.project.crud.controllers;

import com.project.crud.model.Direccion;
import com.project.crud.services.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DireccionController {

    @Autowired
    private DireccionService direccionService;

    public List<Direccion> getAllDirecciones() {
        return direccionService.getAllDirecciones();
    }

    public Direccion getDireccionById(Long id) {
        return direccionService.getDireccionById(id);
    }

    public Direccion saveDireccion(Direccion direccion) {
        return direccionService.saveDireccion(direccion);
    }

    public void deleteDireccion(Long id) {
        direccionService.deleteDireccion(id);
    }
}
