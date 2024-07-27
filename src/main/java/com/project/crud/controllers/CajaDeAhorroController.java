package com.project.crud.controllers;

import com.project.crud.model.CajaDeAhorro;
import com.project.crud.services.CajaDeAhorroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public CajaDeAhorro getCajaDeAhorroById(Long id) {
        return cajaDeAhorroService.getCajaDeAhorroById(id);
    }

    @GetMapping
    public CajaDeAhorro saveCajaDeAhorro(CajaDeAhorro cajaDeAhorro) {
        return cajaDeAhorroService.saveCajaDeAhorro(cajaDeAhorro);
    }

    @GetMapping
    public void deleteCajaDeAhorro(Long id) {
        cajaDeAhorroService.deleteCajaDeAhorro(id);
    }
}
