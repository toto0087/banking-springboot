package com.project.crud.model.service;

import com.project.crud.domain.dto.CuentaDto;
import com.project.crud.domain.dto.dtolist.CuentaListDto;
import com.project.crud.domain.dto.ResponseDto;
import com.project.crud.model.repository.entity.Cuenta;

public interface ICuenta {
    CuentaListDto getAllCuentas();
    CuentaDto getCuentaById(Long id);
    Cuenta saveCuenta(Cuenta cuenta);
    ResponseDto deleteCuenta(Long id);
}
