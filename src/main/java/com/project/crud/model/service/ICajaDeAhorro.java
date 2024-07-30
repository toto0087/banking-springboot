package com.project.crud.model.service;

import com.project.crud.domain.dto.CajaDeAhorroDto;
import com.project.crud.domain.dto.dtolist.CajaAhorroListDto;
import com.project.crud.domain.dto.ResponseDto;
import com.project.crud.model.repository.entity.CajaDeAhorro;

public interface ICajaDeAhorro {
    CajaAhorroListDto getAllCajasDeAhorro();
    CajaDeAhorroDto getCajaDeAhorroById(Long id);
    CajaDeAhorro saveCajaDeAhorro(CajaDeAhorro cajaDeAhorro);
    ResponseDto deleteCajaDeAhorro(Long id);
    void restarSaldo(Long id, Double monto);
    ResponseDto depositar(Long id, Long numeroCuentaDestino, Double monto);
}
