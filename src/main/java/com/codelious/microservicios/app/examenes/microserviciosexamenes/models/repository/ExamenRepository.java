package com.codelious.microservicios.app.examenes.microserviciosexamenes.models.repository;

import java.util.List;

import com.codelious.microservicios.commons.examenes.commonsexamenes.models.entity.Examen;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExamenRepository extends PagingAndSortingRepository<Examen, Long> {
    
    @Query("select e from Examen e where e.nombre like %?1%")
    public List<Examen> findByNombre(String nombre);
    
}
