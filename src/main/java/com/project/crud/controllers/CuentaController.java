package com.project.crud.controllers;

import com.project.crud.model.Cuenta;
import com.project.crud.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    @Autowired
    CuentaService cuentaService;

    @GetMapping
    public List<Cuenta> getAllCuentas() {
        return cuentaService.getAllCuentas();
    }

    @GetMapping("/{id}")
    public Cuenta getCuentaById(Long id) {
        return cuentaService.getCuentaById(id);
    }

    @PostMapping
    public Cuenta saveCuenta(Cuenta cuenta) {
        return cuentaService.saveCuenta(cuenta);
    }

    @DeleteMapping("/{id}")
    public void deleteCuenta(Long id) {
        cuentaService.deleteCuenta(id);
    }

}
