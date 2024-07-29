package com.project.crud.model.impl;

import com.project.crud.domain.dto.DireccionDto;
import com.project.crud.domain.dto.dtoList.DireccionesListDto;
import com.project.crud.domain.dto.ResponseDto;
import com.project.crud.model.service.IDireccion;
import com.project.crud.model.repository.entity.Direccion;
import com.project.crud.model.repository.IDireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DireccionService implements IDireccion {

    @Autowired
    private IDireccionRepository direccionRepository;

    public DireccionesListDto getAllDirecciones() {
        List<Direccion> direcciones = direccionRepository.findAll();
        List<DireccionDto> direccionDtos = direcciones.stream()
                .map(direccion -> new DireccionDto(direccion.getCalle(),direccion.getLocalidad(),direccion.getProvincia()))
                .collect(Collectors.toList());
        return new DireccionesListDto(direccionDtos);
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
