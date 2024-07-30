package com.project.crud.model.service;

import com.project.crud.domain.dto.DireccionDto;
import com.project.crud.domain.dto.dtolist.DireccionesListDto;
import com.project.crud.domain.dto.ResponseDto;
import com.project.crud.model.repository.entity.Direccion;

public interface IDireccion {
    DireccionesListDto getAllDirecciones();
    DireccionDto getDireccionById(Long id);
    Direccion saveDireccion(Direccion direccion);
    ResponseDto deleteDireccion(Long id);
}
