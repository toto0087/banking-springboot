package com.project.crud.domain.dto;

import com.project.crud.model.TarjetaDeDebito;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TarjetaDebitoListDto {
    private List<TarjetaDeDebito> tarjetaDeDebitoList;
}
