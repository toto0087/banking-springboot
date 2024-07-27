package com.project.crud.services;

import com.project.crud.model.CajaDeAhorro;
import com.project.crud.repository.ICajaDeAhorroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CajaDeAhorroService {

    @Autowired
    private ICajaDeAhorroRepository cajaDeAhorroRepository;

    public List<CajaDeAhorro> getAllCajasDeAhorro() {
        return cajaDeAhorroRepository.findAll();
    }

    public CajaDeAhorro getCajaDeAhorroById(Long id) {
        return cajaDeAhorroRepository.findById(id).orElse(null);
    }

    public CajaDeAhorro saveCajaDeAhorro(CajaDeAhorro cajaDeAhorro) {
        return cajaDeAhorroRepository.save(cajaDeAhorro);
    }

    public void deleteCajaDeAhorro(Long id) {
        cajaDeAhorroRepository.deleteById(id);
    }


}
