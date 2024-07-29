package com.project.crud.services;

import com.project.crud.interfaces.IDireccion;
import com.project.crud.model.Direccion;
import com.project.crud.repository.IDireccionRepository;
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
