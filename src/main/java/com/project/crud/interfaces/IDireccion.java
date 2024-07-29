package com.project.crud.interfaces;

import com.project.crud.model.Direccion;

import java.util.List;

public interface IDireccion {
    List<Direccion> getAllDirecciones();
    Direccion getDireccionById(Long id);
    Direccion saveDireccion(Direccion direccion);
    void deleteDireccion(Long id);
}
