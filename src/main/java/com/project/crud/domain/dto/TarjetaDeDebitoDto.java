package com.project.crud.domain.dto;

import com.project.crud.model.CajaDeAhorro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TarjetaDeDebitoDto {
    private Long numeroDeTarjeta;
    private String fechaDeVencimiento;
    private CajaDeAhorro cajaDeAhorro;
}
