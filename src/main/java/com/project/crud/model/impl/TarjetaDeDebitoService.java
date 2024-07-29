package com.project.crud.model.impl;

import com.project.crud.config.exceptions.NoExisteLaCajaDeAhorroException;
import com.project.crud.config.exceptions.NoExisteLaTarjetaDeDebitoException;
import com.project.crud.domain.dto.ResponseDto;
import com.project.crud.domain.dto.TarjetaDeDebitoDto;
import com.project.crud.domain.dto.dtoList.TarjetaDebitoListDto;
import com.project.crud.model.service.ITarjetaDeDebito;
import com.project.crud.model.repository.entity.CajaDeAhorro;
import com.project.crud.model.repository.entity.TarjetaDeDebito;
import com.project.crud.model.repository.ITarjetaDeDebitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarjetaDeDebitoService implements ITarjetaDeDebito {

    @Autowired
    private ITarjetaDeDebitoRepository tarjetaDeDebitoRepository;

    @Autowired
    private CajaDeAhorroService cajaDeAhorroService;

    public TarjetaDebitoListDto getAllTarjetasDeDebito() {
        List<TarjetaDeDebito> tarjetas = tarjetaDeDebitoRepository.findAll();
        List<TarjetaDeDebitoDto> tarjetaDeDebitoDtos = tarjetas.stream()
                .map(tarjetasDto -> new TarjetaDeDebitoDto(tarjetasDto.getNumeroDeTarjeta(),tarjetasDto.getFechaDeVencimiento(),
                        tarjetasDto.getCajaDeAhorro()))
                .collect(Collectors.toList());
        return new TarjetaDebitoListDto(tarjetaDeDebitoDtos);
    }

    public TarjetaDeDebito getTarjetaDeDebitoById(Long id) {
        return tarjetaDeDebitoRepository.findById(id).orElseThrow(
                () -> new NoExisteLaTarjetaDeDebitoException("No existe la tarjeta de débito con id: " + id)
        );
    }

    public TarjetaDeDebito saveTarjetaDeDebito(TarjetaDeDebito tarjetaDeDebito) {
        return tarjetaDeDebitoRepository.save(tarjetaDeDebito);
    }

    public ResponseDto deleteTarjetaDeDebito(Long id) {
        ResponseDto responseDto = new ResponseDto();
        try {
            tarjetaDeDebitoRepository.deleteById(id);
            responseDto.setSuccess(true);
        } catch (Exception e) {
            responseDto.setSuccess(false);
        }
        return responseDto;
    }


    public ResponseDto processPayment(Long id, Double monto) throws RuntimeException {
        ResponseDto responseDto = new ResponseDto();

        try {
            TarjetaDeDebito tarjetaDeDebito = tarjetaDeDebitoRepository.findById(id).orElse(null);

            if (tarjetaDeDebito == null) {
                throw new NoExisteLaTarjetaDeDebitoException("Tarjeta de débito no encontrada con ID:" + id);
            }

            CajaDeAhorro cajaDeAhorro = tarjetaDeDebito.getCajaDeAhorro();
            if (cajaDeAhorro == null) {
                throw new NoExisteLaCajaDeAhorroException("Caja de ahorro no asociada");
            }

            cajaDeAhorroService.restarSaldo(cajaDeAhorro.getId(), monto);
            responseDto.setSuccess(true);
        } catch (Exception e) {
            responseDto.setSuccess(false);
        }
        return responseDto;
    }
}
