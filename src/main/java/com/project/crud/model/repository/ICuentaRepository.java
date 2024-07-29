package com.project.crud.domain.repository;

import com.project.crud.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICuentaRepository extends JpaRepository<Cuenta, Long> {
}
