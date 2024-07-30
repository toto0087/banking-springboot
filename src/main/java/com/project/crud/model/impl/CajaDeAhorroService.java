package com.project.crud.model.impl;

import com.project.crud.model.exceptions.NoExisteLaCajaDeAhorroException;
import com.project.crud.model.exceptions.SaldoInsuficienteException;
import com.project.crud.domain.dto.dtolist.CajaAhorroListDto;
import com.project.crud.domain.dto.CajaDeAhorroDto;
import com.project.crud.domain.dto.ResponseDto;
import com.project.crud.model.service.ICajaDeAhorro;
import com.project.crud.model.repository.entity.CajaDeAhorro;
import com.project.crud.model.repository.ICajaDeAhorroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CajaDeAhorroService implements ICajaDeAhorro {

    @Autowired
    private ICajaDeAhorroRepository cajaDeAhorroRepository;

    public CajaAhorroListDto  getAllCajasDeAhorro() {
        List<CajaDeAhorro> cajasDeAhorro = cajaDeAhorroRepository.findAll();
        List<CajaDeAhorroDto> cajaDeAhorroDtos = cajasDeAhorro.stream()
                .map(caja -> new CajaDeAhorroDto(caja.getNumeroDeCuenta(), caja.getSaldo()))
                .collect(Collectors.toList());
        return new CajaAhorroListDto(cajaDeAhorroDtos);
    }

    public CajaDeAhorroDto getCajaDeAhorroById(Long id) {
        return cajaDeAhorroRepository.findById(id)
                .map(caja -> new CajaDeAhorroDto(caja.getNumeroDeCuenta(), caja.getSaldo()))
                .orElseThrow(() -> new NoExisteLaCajaDeAhorroException("No existe la caja de ahorro con id: " + id));
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
                throw new NoExisteLaCajaDeAhorroException("Caja de ahorro no encontrada" + id);
            }

            Double saldo = cajaDeAhorro.getSaldo();
            if (saldo < monto) {
                throw new SaldoInsuficienteException("Saldo insuficiente:" + saldo + "monto: " + monto);
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
                throw new NoExisteLaCajaDeAhorroException("Caja de ahorro no encontrada con id: " + id);
            }

            Double saldo = cajaDeAhorro.getSaldo();
            if (saldo < monto) {
                throw new SaldoInsuficienteException("Saldo insuficiente:" + saldo + "monto: " + monto);
            }

            cajaDeAhorro.setSaldo(saldo - monto);
            cajaDeAhorroRepository.save(cajaDeAhorro);

            CajaDeAhorro cajaDeAhorroDestino = cajaDeAhorroRepository.findByNumeroDeCuenta(numeroCuentaDestino);
            if (cajaDeAhorroDestino == null) {
                throw new NoExisteLaCajaDeAhorroException("Cuenta destino no encontrada:" + numeroCuentaDestino);
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
