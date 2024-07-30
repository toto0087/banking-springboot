package com.project.crud.model.service;

import com.project.crud.domain.dto.ResponseDto;
import com.project.crud.domain.dto.TarjetaDeDebitoDto;
import com.project.crud.domain.dto.dtolist.TarjetaDebitoListDto;
import com.project.crud.model.repository.entity.TarjetaDeDebito;

public interface ITarjetaDeDebito {
    TarjetaDebitoListDto getAllTarjetasDeDebito();
    TarjetaDeDebitoDto getTarjetaDeDebitoById(Long id);
    TarjetaDeDebito saveTarjetaDeDebito(TarjetaDeDebito tarjetaDeDebito);
    ResponseDto deleteTarjetaDeDebito(Long id);
    ResponseDto processPayment(Long id, Double monto) throws RuntimeException;
}
