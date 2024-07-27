package com.project.crud.controllers;

import com.project.crud.model.TarjetaDeDebito;
import com.project.crud.services.TarjetaDeDebitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class TarjetaDeDebitoController {

    @Autowired
    private TarjetaDeDebitoService tarjetaDeDebitoService;

    @GetMapping
    public List<TarjetaDeDebito> getAllTarjetasDeDebito() {
        return tarjetaDeDebitoService.getAllTarjetasDeDebito();
    }

    @GetMapping
    public TarjetaDeDebito getTarjetaDeDebitoById(Long id) {
        return tarjetaDeDebitoService.getTarjetaDeDebitoById(id);
    }

    @GetMapping
    public TarjetaDeDebito saveTarjetaDeDebito(TarjetaDeDebito tarjetaDeDebito) {
        return tarjetaDeDebitoService.saveTarjetaDeDebito(tarjetaDeDebito);
    }

    @GetMapping
    public void deleteTarjetaDeDebito(Long id) {
        tarjetaDeDebitoService.deleteTarjetaDeDebito(id);
    }
}
