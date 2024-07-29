package com.project.crud.domain.repository;

import com.project.crud.model.CajaDeAhorro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICajaDeAhorroRepository extends JpaRepository<CajaDeAhorro, Long> {
    CajaDeAhorro findByNumeroDeCuenta(Long numeroCuentaDestino);
}
