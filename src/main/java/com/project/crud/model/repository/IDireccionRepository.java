package com.project.crud.domain.repository;

import com.project.crud.model.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDireccionRepository extends JpaRepository<Direccion, Long> {
}