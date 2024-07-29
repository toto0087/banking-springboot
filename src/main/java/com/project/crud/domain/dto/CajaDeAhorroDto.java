package com.project.crud.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CajaDeAhorroDto {
    private Long numeroDeCuenta;
    private Double saldo;
}
