package com.project.crud.domain.dto;

import com.project.crud.model.CajaDeAhorro;
import com.project.crud.model.Persona;
import com.project.crud.model.TarjetaDeDebito;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CuentaDto {
    private Persona cliente;
    private CajaDeAhorro cajaDeAhorro;
    private TarjetaDeDebito tarjetaDeDebito;
}
