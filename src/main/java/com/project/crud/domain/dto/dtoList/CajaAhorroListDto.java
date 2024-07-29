package com.project.crud.domain.dto.dtoList;
import com.project.crud.domain.dto.CajaDeAhorroDto;
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
    private List<CajaDeAhorroDto> cajaDeAhorroList;
}
