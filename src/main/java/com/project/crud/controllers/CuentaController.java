package com.project.crud.controllers;

import com.project.crud.model.Cuenta;
import com.project.crud.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public Cuenta getCuentaById(Long id) {
        return cuentaService.getCuentaById(id);
    }

    @GetMapping
    public Cuenta saveCuenta(Cuenta cuenta) {
        return cuentaService.saveCuenta(cuenta);
    }

    @GetMapping
    public void deleteCuenta(Long id) {
        cuentaService.deleteCuenta(id);
    }

}
