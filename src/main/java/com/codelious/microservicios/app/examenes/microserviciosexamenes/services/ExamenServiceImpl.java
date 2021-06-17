package com.codelious.microservicios.app.examenes.microserviciosexamenes.services;

import java.util.List;

import com.codelious.microservicios.app.examenes.microserviciosexamenes.models.repository.AsignaturaRepository;
import com.codelious.microservicios.app.examenes.microserviciosexamenes.models.repository.ExamenRepository;
import com.codelious.microservicios.commons.commonsmicroservicios.services.CommonServiceImpl;
import com.codelious.microservicios.commons.examenes.commonsexamenes.models.entity.Asignatura;
import com.codelious.microservicios.commons.examenes.commonsexamenes.models.entity.Examen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository> implements ExamenService {

    @Autowired
    AsignaturaRepository asignaturaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Examen> findByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Asignatura> findAllAsignaturas() {
        return asignaturaRepository.findAll();
    }
    
}
