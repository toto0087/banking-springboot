package com.project.crud.domain.controllers;

import com.project.crud.domain.dto.dtoList.DireccionesListDto;
import com.project.crud.domain.dto.ResponseDto;
import com.project.crud.model.Direccion;
import com.project.crud.model.impl.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/direccion")
public class DireccionController {

    @Autowired
    private DireccionService direccionService;

    @GetMapping
    public ResponseEntity<DireccionesListDto> getAllDirecciones() {
        DireccionesListDto direccionesListDto = direccionService.getAllDirecciones();
        return ResponseEntity.ok(direccionesListDto);
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
    public ResponseEntity<ResponseDto> deleteDireccion(@PathVariable Long id) {
        ResponseDto responseDto = direccionService.deleteDireccion(id);
        return ResponseEntity.ok(responseDto);
    }
}
