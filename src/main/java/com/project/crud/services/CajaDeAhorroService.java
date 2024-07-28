package com.project.crud.services;

import com.project.crud.model.CajaDeAhorro;
import com.project.crud.repository.ICajaDeAhorroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CajaDeAhorroService {

    @Autowired
    private ICajaDeAhorroRepository cajaDeAhorroRepository;

    public List<CajaDeAhorro> getAllCajasDeAhorro() {
        return cajaDeAhorroRepository.findAll();
    }

    public CajaDeAhorro getCajaDeAhorroById(Long id) {
        return cajaDeAhorroRepository.findById(id).orElse(null);
    }

    public CajaDeAhorro saveCajaDeAhorro(CajaDeAhorro cajaDeAhorro) {
        return cajaDeAhorroRepository.save(cajaDeAhorro);
    }

    public void deleteCajaDeAhorro(Long id) {
        cajaDeAhorroRepository.deleteById(id);
    }


    public void restarSaldo(Long id, Double monto) {
        CajaDeAhorro cajaDeAhorro = cajaDeAhorroRepository.findById(id).orElse(null);

        try {
            if (cajaDeAhorro == null) {
                throw new RuntimeException("Caja de ahorro no encontrada");
            }

            Double saldo = cajaDeAhorro.getSaldo();
            if (saldo < monto) {
                throw new RuntimeException("Saldo insuficiente");
            }

            cajaDeAhorro.setSaldo(saldo - monto);
            cajaDeAhorroRepository.save(cajaDeAhorro);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void depositar(Long id, Long numeroCuentaDestino, Double monto) {
        CajaDeAhorro cajaDeAhorro = cajaDeAhorroRepository.findById(id).orElse(null);

        try {
            if (cajaDeAhorro == null) {
                throw new RuntimeException("Caja de ahorro no encontrada");
            }

            Double saldo = cajaDeAhorro.getSaldo();
            if (saldo < monto) {
                throw new RuntimeException("Saldo insuficiente");
            }

            cajaDeAhorro.setSaldo(saldo - monto);
            cajaDeAhorroRepository.save(cajaDeAhorro);

            CajaDeAhorro cajaDeAhorroDestino = cajaDeAhorroRepository.findByNumeroCuenta(numeroCuentaDestino);
            if (cajaDeAhorroDestino == null) {
                throw new RuntimeException("Cuenta destino no encontrada");
            }

            cajaDeAhorroDestino.setSaldo(cajaDeAhorroDestino.getSaldo() + monto);
            cajaDeAhorroRepository.save(cajaDeAhorroDestino);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
