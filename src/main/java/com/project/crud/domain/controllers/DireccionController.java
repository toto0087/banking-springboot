package com.project.crud.domain.controllers;

import com.project.crud.domain.dto.DireccionDto;
import com.project.crud.domain.dto.dtolist.DireccionesListDto;
import com.project.crud.domain.dto.ResponseDto;
import com.project.crud.model.repository.entity.Direccion;
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
    public ResponseEntity<DireccionDto> getDireccionById(@PathVariable Long id) {
        DireccionDto direccionDto = direccionService.getDireccionById(id);
        return ResponseEntity.of(java.util.Optional.ofNullable(direccionDto));
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
