package com.project.crud.model.service;

import com.project.crud.domain.dto.dtoList.DireccionesListDto;
import com.project.crud.domain.dto.ResponseDto;
import com.project.crud.model.Direccion;

public interface IDireccion {
    DireccionesListDto getAllDirecciones();
    Direccion getDireccionById(Long id);
    Direccion saveDireccion(Direccion direccion);
    ResponseDto deleteDireccion(Long id);
}
