package com.codelious.microservicios.app.examenes.microserviciosexamenes.controllers;

import java.util.Optional;

import javax.validation.Valid;

import com.codelious.microservicios.app.examenes.microserviciosexamenes.services.ExamenService;
import com.codelious.microservicios.commons.commonsmicroservicios.controllers.CommonController;
import com.codelious.microservicios.commons.examenes.commonsexamenes.models.entity.Examen;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ExamenController extends CommonController<Examen, ExamenService> {
    
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Examen examen, BindingResult result, @PathVariable Long id) {

        if (result.hasErrors()) {
            return this.validar(result);
        }

        Optional<Examen> o = service.findById(id);

        if(!o.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Examen examenDb = o.get();
        examenDb.setNombre(examen.getNombre());

        examenDb.getPreguntas()
        .stream()
        .filter(pdb -> !examen.getPreguntas().contains(pdb))
        .forEach(examenDb::removePreguntas);

        examenDb.setPreguntas(examen.getPreguntas());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenDb));
    }

    @GetMapping("/filtrar/{nombre}")
    public ResponseEntity<?> filtrar(@PathVariable String nombre) {
        return ResponseEntity.ok(service.findByNombre(nombre));
    }

    @GetMapping("/asignaturas")
    public ResponseEntity<?> listarAsignaturas() {
        return ResponseEntity.ok(service.findAllAsignaturas());
    }
}
