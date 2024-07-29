package com.project.crud.model.impl;

import com.project.crud.domain.dto.CajaAhorroListDto;
import com.project.crud.domain.dto.ResponseDto;
import com.project.crud.model.service.ICajaDeAhorro;
import com.project.crud.model.CajaDeAhorro;
import com.project.crud.domain.repository.ICajaDeAhorroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CajaDeAhorroService implements ICajaDeAhorro {

    @Autowired
    private ICajaDeAhorroRepository cajaDeAhorroRepository;

    public CajaAhorroListDto  getAllCajasDeAhorro() {
        List<CajaDeAhorro> cajasDeAhorro = cajaDeAhorroRepository.findAll();
        return new CajaAhorroListDto(cajasDeAhorro);
    }

    public CajaDeAhorro getCajaDeAhorroById(Long id) {
        return cajaDeAhorroRepository.findById(id).orElse(null);
    }

    public CajaDeAhorro saveCajaDeAhorro(CajaDeAhorro cajaDeAhorro) {
        return cajaDeAhorroRepository.save(cajaDeAhorro);
    }

    public ResponseDto deleteCajaDeAhorro(Long id) {
        ResponseDto responseDto = new ResponseDto();
        try {
            cajaDeAhorroRepository.deleteById(id);
            responseDto.setSuccess(true);
        } catch (Exception e) {
            responseDto.setSuccess(false);
        }
        return responseDto;
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

    public ResponseDto depositar(Long id, Long numeroCuentaDestino, Double monto) {
        CajaDeAhorro cajaDeAhorro = cajaDeAhorroRepository.findById(id).orElse(null);
        ResponseDto responseDto = new ResponseDto();

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

            CajaDeAhorro cajaDeAhorroDestino = cajaDeAhorroRepository.findByNumeroDeCuenta(numeroCuentaDestino);
            if (cajaDeAhorroDestino == null) {
                throw new RuntimeException("Cuenta destino no encontrada");
            }

            cajaDeAhorroDestino.setSaldo(cajaDeAhorroDestino.getSaldo() + monto);
            cajaDeAhorroRepository.save(cajaDeAhorroDestino);
            responseDto.setSuccess(true);
        } catch (Exception e) {
            responseDto.setSuccess(false);
        }
        return responseDto;
    }
}
