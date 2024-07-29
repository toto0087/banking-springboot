package com.project.crud.model.repository;

import com.project.crud.model.repository.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICuentaRepository extends JpaRepository<Cuenta, Long> {
}
