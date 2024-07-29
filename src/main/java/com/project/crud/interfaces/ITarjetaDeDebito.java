package com.project.crud.interfaces;

import com.project.crud.model.TarjetaDeDebito;

import java.util.List;

public interface ITarjetaDeDebito {
    List<TarjetaDeDebito> getAllTarjetasDeDebito();
    TarjetaDeDebito getTarjetaDeDebitoById(Long id);
    TarjetaDeDebito saveTarjetaDeDebito(TarjetaDeDebito tarjetaDeDebito);
    void deleteTarjetaDeDebito(Long id);
    void processPayment(Long id, Double monto) throws RuntimeException;
}
