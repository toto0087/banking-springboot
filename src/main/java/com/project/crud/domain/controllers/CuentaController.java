package com.project.crud.domain.controllers;

import com.project.crud.domain.dto.CuentaDto;
import com.project.crud.domain.dto.dtolist.CuentaListDto;
import com.project.crud.domain.dto.ResponseDto;
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
    public ResponseEntity<CuentaDto> getCuentaById(@PathVariable Long id) {
        CuentaDto cuentaDto = cuentaService.getCuentaById(id);
        return ResponseEntity.of(java.util.Optional.ofNullable(cuentaDto));
    }

    @PostMapping
    public ResponseEntity<com.project.crud.model.repository.entity.Cuenta> saveCuenta(@RequestBody com.project.crud.model.repository.entity.Cuenta cuenta) {
        com.project.crud.model.repository.entity.Cuenta savedCuenta = cuentaService.saveCuenta(cuenta);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCuenta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteCuenta(@PathVariable Long id) {
        ResponseDto responseDto = cuentaService.deleteCuenta(id);
        return ResponseEntity.ok(responseDto);
    }

}
