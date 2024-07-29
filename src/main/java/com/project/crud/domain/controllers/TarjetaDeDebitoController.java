package com.project.crud.domain.controllers;

import com.project.crud.model.TarjetaDeDebito;
import com.project.crud.model.impl.TarjetaDeDebitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/debito")
public class TarjetaDeDebitoController {

    @Autowired
    private TarjetaDeDebitoService tarjetaDeDebitoService;

    @GetMapping
    public ResponseEntity<List<TarjetaDeDebito>> getAllTarjetasDeDebito() {
        List<TarjetaDeDebito> tarjetas = tarjetaDeDebitoService.getAllTarjetasDeDebito();
        return ResponseEntity.ok(tarjetas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarjetaDeDebito> getTarjetaDeDebitoById(@PathVariable Long id) {
        TarjetaDeDebito tarjeta = tarjetaDeDebitoService.getTarjetaDeDebitoById(id);
        return ResponseEntity.of(java.util.Optional.ofNullable(tarjeta));
    }

    @PostMapping
    public ResponseEntity<TarjetaDeDebito> saveTarjetaDeDebito(@RequestBody TarjetaDeDebito tarjetaDeDebito) {
        TarjetaDeDebito savedTarjeta = tarjetaDeDebitoService.saveTarjetaDeDebito(tarjetaDeDebito);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTarjeta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarjetaDeDebito(@PathVariable Long id) {
        tarjetaDeDebitoService.deleteTarjetaDeDebito(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/pagar")
    public ResponseEntity<Void> pagar(@PathVariable Long id, @RequestParam Double monto) {
        tarjetaDeDebitoService.processPayment(id, monto);
        return ResponseEntity.ok().build();
    }

}
