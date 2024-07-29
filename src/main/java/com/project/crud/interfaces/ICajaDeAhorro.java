package com.project.crud.interfaces;

import com.project.crud.model.CajaDeAhorro;

import java.util.List;

public interface ICajaDeAhorro {
    List<CajaDeAhorro> getAllCajasDeAhorro();
    CajaDeAhorro getCajaDeAhorroById(Long id);
    CajaDeAhorro saveCajaDeAhorro(CajaDeAhorro cajaDeAhorro);
    void deleteCajaDeAhorro(Long id);
    void restarSaldo(Long id, Double monto);
    void depositar(Long id, Long numeroCuentaDestino, Double monto);
}
