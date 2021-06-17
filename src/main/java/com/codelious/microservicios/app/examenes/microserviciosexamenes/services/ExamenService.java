package com.codelious.microservicios.app.examenes.microserviciosexamenes.services;

import java.util.List;

import com.codelious.microservicios.commons.commonsmicroservicios.services.CommonService;
import com.codelious.microservicios.commons.examenes.commonsexamenes.models.entity.Asignatura;
import com.codelious.microservicios.commons.examenes.commonsexamenes.models.entity.Examen;

public interface ExamenService extends CommonService<Examen> {
    
    public List<Examen> findByNombre(String nombre);

    public Iterable<Asignatura> findAllAsignaturas();
    
}
