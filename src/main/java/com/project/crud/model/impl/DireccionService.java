package com.project.crud.model.impl;

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

    public List<Direccion> getAllDirecciones() {
        return direccionRepository.findAll();
    }

    public Direccion getDireccionById(Long id) {
        return direccionRepository.findById(id).orElse(null);
    }

    public Direccion saveDireccion(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    public void deleteDireccion(Long id) {
        direccionRepository.deleteById(id);
    }

}
