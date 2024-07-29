package com.project.crud.model.impl;

import com.project.crud.config.exceptions.NoExisteLaCuentaException;
import com.project.crud.domain.dto.CuentaDto;
import com.project.crud.domain.dto.dtoList.CuentaListDto;
import com.project.crud.domain.dto.ResponseDto;
import com.project.crud.model.service.ICuentaService;
import com.project.crud.model.repository.entity.Cuenta;
import com.project.crud.model.repository.ICuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CuentaService implements ICuentaService {

    @Autowired
    private ICuentaRepository cuentaRepository;

    public CuentaListDto getAllCuentas() {
        List<Cuenta> cuentas = cuentaRepository.findAll();
        List<CuentaDto> cuentaDtos = cuentas.stream()
                .map(cuentasDto -> new CuentaDto(cuentasDto.getCliente(),cuentasDto.getCajaDeAhorro(), cuentasDto.getTarjetaDeDebito()))
                .collect(Collectors.toList());
        return new CuentaListDto(cuentaDtos);
    }

    public Cuenta getCuentaById(Long id) {
        return cuentaRepository.findById(id).orElseThrow(
                () -> new NoExisteLaCuentaException("No existe la cuenta con id: " + id)
        );
    }

    public Cuenta saveCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public ResponseDto deleteCuenta(Long id) {
        ResponseDto responseDto = new ResponseDto();
        try {
            cuentaRepository.deleteById(id);
            responseDto.setSuccess(true);
        } catch (Exception e) {
            responseDto.setSuccess(false);
        }
        return responseDto;
    }
}
