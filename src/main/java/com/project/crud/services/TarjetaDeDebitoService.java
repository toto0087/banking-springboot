package com.project.crud.services;

import com.project.crud.model.TarjetaDeDebito;
import com.project.crud.repository.ITarjetaDeDebitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarjetaDeDebitoService {

    @Autowired
    private ITarjetaDeDebitoRepository tarjetaDeDebitoRepository;

    public List<TarjetaDeDebito> getAllTarjetasDeDebito() {
        return tarjetaDeDebitoRepository.findAll();
    }

    public TarjetaDeDebito getTarjetaDeDebitoById(Long id) {
        return tarjetaDeDebitoRepository.findById(id).orElse(null);
    }

    public TarjetaDeDebito saveTarjetaDeDebito(TarjetaDeDebito tarjetaDeDebito) {
        return tarjetaDeDebitoRepository.save(tarjetaDeDebito);
    }

    public void deleteTarjetaDeDebito(Long id) {
        tarjetaDeDebitoRepository.deleteById(id);
    }
}
