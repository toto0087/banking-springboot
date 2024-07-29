package com.project.crud.model.repository;

import com.project.crud.model.repository.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaRepository extends JpaRepository<Persona, Long> {
}
