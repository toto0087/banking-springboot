package com.project.crud.model.impl;

import com.project.crud.domain.dto.CuentaListDto;
import com.project.crud.domain.dto.ResponseDto;
import com.project.crud.model.service.ICuentaService;
import com.project.crud.model.Cuenta;
import com.project.crud.domain.repository.ICuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaService implements ICuentaService {

    @Autowired
    private ICuentaRepository cuentaRepository;

    public CuentaListDto getAllCuentas() {
        List<Cuenta> cuentas = cuentaRepository.findAll();
        return new CuentaListDto(cuentas);
    }

    public Cuenta getCuentaById(Long id) {
        return cuentaRepository.findById(id).orElse(null);
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
