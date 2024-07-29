package com.project.crud.domain.controllers;

import com.project.crud.domain.dto.dtoList.CuentaListDto;
import com.project.crud.domain.dto.ResponseDto;
import com.project.crud.model.repository.entity.Cuenta;
import com.project.crud.model.impl.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    public ResponseEntity<CuentaListDto> getAllCuentas() {
        CuentaListDto cuentaListDto = cuentaService.getAllCuentas();
        return ResponseEntity.ok(cuentaListDto);
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
    public ResponseEntity<ResponseDto> deleteCuenta(@PathVariable Long id) {
        ResponseDto responseDto = cuentaService.deleteCuenta(id);
        return ResponseEntity.ok(responseDto);
    }

}
