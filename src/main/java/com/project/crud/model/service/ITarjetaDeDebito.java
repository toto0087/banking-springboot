package com.project.crud.model.service;

import com.project.crud.domain.dto.ResponseDto;
import com.project.crud.domain.dto.dtoList.TarjetaDebitoListDto;
import com.project.crud.model.repository.entity.TarjetaDeDebito;

public interface ITarjetaDeDebito {
    TarjetaDebitoListDto getAllTarjetasDeDebito();
    TarjetaDeDebito getTarjetaDeDebitoById(Long id);
    TarjetaDeDebito saveTarjetaDeDebito(TarjetaDeDebito tarjetaDeDebito);
    ResponseDto deleteTarjetaDeDebito(Long id);
    ResponseDto processPayment(Long id, Double monto) throws RuntimeException;
}
