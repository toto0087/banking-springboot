package com.project.crud.domain.dto.dtolist;

import com.project.crud.domain.dto.TarjetaDeDebitoDto;
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
    private List<TarjetaDeDebitoDto> tarjetaDeDebitoList;
}
