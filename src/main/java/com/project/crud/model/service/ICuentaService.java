package com.project.crud.model.service;

import com.project.crud.domain.dto.CajaAhorroListDto;
import com.project.crud.domain.dto.CuentaListDto;
import com.project.crud.domain.dto.ResponseDto;
import com.project.crud.model.Cuenta;

import java.util.List;

public interface ICuentaService {
    CuentaListDto getAllCuentas();
    Cuenta getCuentaById(Long id);
    Cuenta saveCuenta(Cuenta cuenta);
    ResponseDto deleteCuenta(Long id);
}
