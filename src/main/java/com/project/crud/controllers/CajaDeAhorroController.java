package com.project.crud.controllers;

import com.project.crud.model.CajaDeAhorro;
import com.project.crud.services.CajaDeAhorroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cajaDeAhorro")
public class CajaDeAhorroController {

    @Autowired
    CajaDeAhorroService cajaDeAhorroService;

    @GetMapping
    public List<CajaDeAhorro> getAllCajasDeAhorro() {
        return cajaDeAhorroService.getAllCajasDeAhorro();
    }

    @GetMapping("/{id}")
    public CajaDeAhorro getCajaDeAhorroById(@PathVariable Long id) {
        return cajaDeAhorroService.getCajaDeAhorroById(id);
    }

    @PostMapping
    public CajaDeAhorro saveCajaDeAhorro(@RequestBody CajaDeAhorro cajaDeAhorro) {
        return cajaDeAhorroService.saveCajaDeAhorro(cajaDeAhorro);
    }

    @DeleteMapping("/{id}")
    public void deleteCajaDeAhorro(@PathVariable Long id) {
        cajaDeAhorroService.deleteCajaDeAhorro(id);
    }
}
