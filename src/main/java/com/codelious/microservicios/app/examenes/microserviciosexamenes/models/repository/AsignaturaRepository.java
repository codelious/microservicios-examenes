package com.codelious.microservicios.app.examenes.microserviciosexamenes.models.repository;

import com.codelious.microservicios.commons.examenes.commonsexamenes.models.entity.Asignatura;

import org.springframework.data.repository.CrudRepository;

public interface AsignaturaRepository extends CrudRepository<Asignatura, Long> {
    
}
