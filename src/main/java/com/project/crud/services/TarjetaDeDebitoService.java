package com.project.crud.services;

import com.project.crud.interfaces.ITarjetaDeDebito;
import com.project.crud.model.CajaDeAhorro;
import com.project.crud.model.TarjetaDeDebito;
import com.project.crud.repository.ITarjetaDeDebitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarjetaDeDebitoService implements ITarjetaDeDebito {

    @Autowired
    private ITarjetaDeDebitoRepository tarjetaDeDebitoRepository;

    @Autowired
    private CajaDeAhorroService cajaDeAhorroService;

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


    public void processPayment(Long id, Double monto) throws RuntimeException {
        TarjetaDeDebito tarjetaDeDebito = tarjetaDeDebitoRepository.findById(id).orElse(null);

        try {
            if (tarjetaDeDebito == null) {
                throw new RuntimeException("Tarjeta de débito no encontrada");
            }

            CajaDeAhorro cajaDeAhorro = tarjetaDeDebito.getCajaDeAhorro();
            if (cajaDeAhorro == null) {
                throw new RuntimeException("Caja de ahorro no asociada");
            }

            cajaDeAhorroService.restarSaldo(cajaDeAhorro.getId(), monto);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
