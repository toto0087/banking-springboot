package com.project.crud.domain.controllers;

import com.project.crud.domain.dto.dtoList.CajaAhorroListDto;
import com.project.crud.domain.dto.ResponseDto;
import com.project.crud.model.CajaDeAhorro;
import com.project.crud.model.impl.CajaDeAhorroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cajaDeAhorro")
public class CajaDeAhorroController {

    @Autowired
    private CajaDeAhorroService cajaDeAhorroService;

    @GetMapping
    public ResponseEntity<CajaAhorroListDto> getAllCajasDeAhorro() {
        CajaAhorroListDto cajaAhorroListDto = cajaDeAhorroService.getAllCajasDeAhorro();
        return ResponseEntity.ok(cajaAhorroListDto);
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
    public ResponseEntity<ResponseDto> deleteCajaDeAhorro(@PathVariable Long id) {
        ResponseDto responseDto = cajaDeAhorroService.deleteCajaDeAhorro(id);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/{id}/depositar/{numeroCuentaDestino}")
    public ResponseEntity<ResponseDto> depositar(@PathVariable Long id, @PathVariable Long numeroCuentaDestino, @RequestParam Double monto) {
        ResponseDto responseDto = cajaDeAhorroService.depositar(id, numeroCuentaDestino, monto);
        return ResponseEntity.ok(responseDto);
    }
}
