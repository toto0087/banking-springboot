package com.project.crud.controllers;

import com.project.crud.model.Direccion;
import com.project.crud.services.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/direccion")
public class DireccionController {

    @Autowired
    private DireccionService direccionService;

    @GetMapping
    public ResponseEntity<List<Direccion>> getAllDirecciones() {
        List<Direccion> direcciones = direccionService.getAllDirecciones();
        return ResponseEntity.ok(direcciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Direccion> getDireccionById(@PathVariable Long id) {
        Direccion direccion = direccionService.getDireccionById(id);
        return ResponseEntity.of(java.util.Optional.ofNullable(direccion));
    }

    @PostMapping
    public ResponseEntity<Direccion> saveDireccion(@RequestBody Direccion direccion) {
        Direccion savedDireccion = direccionService.saveDireccion(direccion);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDireccion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDireccion(@PathVariable Long id) {
        direccionService.deleteDireccion(id);
        return ResponseEntity.noContent().build();
    }
}
