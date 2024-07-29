package com.project.crud.domain.controllers;

import com.project.crud.model.CajaDeAhorro;
import com.project.crud.model.impl.CajaDeAhorroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cajaDeAhorro")
public class CajaDeAhorroController {

    @Autowired
    private CajaDeAhorroService cajaDeAhorroService;

    @GetMapping
    public ResponseEntity<List<CajaDeAhorro>> getAllCajasDeAhorro() {
        List<CajaDeAhorro> cajasDeAhorro = cajaDeAhorroService.getAllCajasDeAhorro();
        return ResponseEntity.ok(cajasDeAhorro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CajaDeAhorro> getCajaDeAhorroById(@PathVariable Long id) {
        CajaDeAhorro cajaDeAhorro = cajaDeAhorroService.getCajaDeAhorroById(id);
        return ResponseEntity.of(java.util.Optional.ofNullable(cajaDeAhorro));
    }

    @PostMapping
    public ResponseEntity<CajaDeAhorro> saveCajaDeAhorro(@RequestBody CajaDeAhorro cajaDeAhorro) {
        CajaDeAhorro savedCajaDeAhorro = cajaDeAhorroService.saveCajaDeAhorro(cajaDeAhorro);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCajaDeAhorro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCajaDeAhorro(@PathVariable Long id) {
        cajaDeAhorroService.deleteCajaDeAhorro(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/depositar/{numeroCuentaDestino}")
    public ResponseEntity<Void> depositar(@PathVariable Long id, @PathVariable Long numeroCuentaDestino, @RequestParam Double monto) {
        cajaDeAhorroService.depositar(id, numeroCuentaDestino, monto);
        return ResponseEntity.ok().build();
    }
}
