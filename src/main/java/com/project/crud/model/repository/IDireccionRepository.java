package com.project.crud.model.repository;

import com.project.crud.model.repository.entity.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDireccionRepository extends JpaRepository<Direccion, Long> {
}
