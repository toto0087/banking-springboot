package com.project.crud.domain.dto;

import com.project.crud.model.CajaDeAhorro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CajaAhorroListDto {
    private List<CajaDeAhorro> cajaDeAhorroList;
}
