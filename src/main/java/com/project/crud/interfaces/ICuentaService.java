package com.project.crud.interfaces;

import com.project.crud.model.Cuenta;

import java.util.List;

public interface ICuentaService {
    List<Cuenta> getAllCuentas();
    Cuenta getCuentaById(Long id);
    Cuenta saveCuenta(Cuenta cuenta);
    void deleteCuenta(Long id);
}
