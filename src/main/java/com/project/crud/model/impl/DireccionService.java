package com.project.crud.model.impl;

import com.project.crud.domain.dto.DireccionesListDto;
import com.project.crud.domain.dto.ResponseDto;
import com.project.crud.model.service.IDireccion;
import com.project.crud.model.Direccion;
import com.project.crud.domain.repository.IDireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionService implements IDireccion {

    @Autowired
    private IDireccionRepository direccionRepository;

    public DireccionesListDto getAllDirecciones() {
        List<Direccion> direcciones = direccionRepository.findAll();
        return new DireccionesListDto(direcciones);
    }

    public Direccion getDireccionById(Long id) {
        return direccionRepository.findById(id).orElse(null);
    }

    public Direccion saveDireccion(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    public ResponseDto deleteDireccion(Long id) {
        ResponseDto responseDto = new ResponseDto();
        try {
            direccionRepository.deleteById(id);
            responseDto.setSuccess(true);
        } catch (Exception e) {
            responseDto.setSuccess(false);
        }
        return responseDto;
    }
}
