package com.project.crud.domain.controllers;

import com.project.crud.model.Cuenta;
import com.project.crud.model.impl.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    public ResponseEntity<List<Cuenta>> getAllCuentas() {
        List<Cuenta> cuentas = cuentaService.getAllCuentas();
        return ResponseEntity.ok(cuentas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> getCuentaById(@PathVariable Long id) {
        Cuenta cuenta = cuentaService.getCuentaById(id);
        return ResponseEntity.of(java.util.Optional.ofNullable(cuenta));
    }

    @PostMapping
    public ResponseEntity<Cuenta> saveCuenta(@RequestBody Cuenta cuenta) {
        Cuenta savedCuenta = cuentaService.saveCuenta(cuenta);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCuenta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCuenta(@PathVariable Long id) {
        cuentaService.deleteCuenta(id);
        return ResponseEntity.noContent().build();
    }

}
