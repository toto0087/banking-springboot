package com.project.crud.domain.controllers;

import com.project.crud.domain.dto.ResponseDto;
import com.project.crud.domain.dto.TarjetaDeDebitoDto;
import com.project.crud.domain.dto.dtolist.TarjetaDebitoListDto;
import com.project.crud.model.repository.entity.TarjetaDeDebito;
import com.project.crud.model.impl.TarjetaDeDebitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/debito")
public class TarjetaDeDebitoController {

    @Autowired
    private TarjetaDeDebitoService tarjetaDeDebitoService;

    @GetMapping
    public ResponseEntity<TarjetaDebitoListDto> getAllTarjetasDeDebito() {
        TarjetaDebitoListDto tarjetaDebitoListDto = tarjetaDeDebitoService.getAllTarjetasDeDebito();
        return ResponseEntity.ok(tarjetaDebitoListDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarjetaDeDebitoDto> getTarjetaDeDebitoById(@PathVariable Long id) {
        TarjetaDeDebitoDto tarjetaDeDebitoDto = tarjetaDeDebitoService.getTarjetaDeDebitoById(id);
        return ResponseEntity.of(java.util.Optional.ofNullable(tarjetaDeDebitoDto));
    }

    @PostMapping
    public ResponseEntity<TarjetaDeDebito> saveTarjetaDeDebito(@RequestBody TarjetaDeDebito tarjetaDeDebito) {
        TarjetaDeDebito savedTarjeta = tarjetaDeDebitoService.saveTarjetaDeDebito(tarjetaDeDebito);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTarjeta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteTarjetaDeDebito(@PathVariable Long id) {
        ResponseDto responseDto = tarjetaDeDebitoService.deleteTarjetaDeDebito(id);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/{id}/pagar")
    public ResponseEntity<ResponseDto> pagar(@PathVariable Long id, @RequestParam Double monto) {
        ResponseDto responseDto = tarjetaDeDebitoService.processPayment(id, monto);
        return ResponseEntity.ok(responseDto);
    }

}
