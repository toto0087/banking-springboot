package com.project.crud.model.repository;

import com.project.crud.model.repository.entity.CajaDeAhorro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICajaDeAhorroRepository extends JpaRepository<CajaDeAhorro, Long> {
    CajaDeAhorro findByNumeroDeCuenta(Long numeroCuentaDestino);
}
