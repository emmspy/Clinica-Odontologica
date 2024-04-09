package com.dh.ClinicMVC.controller;

import com.dh.ClinicMVC.entity.Odontologo;
import com.dh.ClinicMVC.service.IOdontologoService;
import com.dh.ClinicMVC.service.implementation.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private IOdontologoService odontologoService;

    @Autowired
    public OdontologoController (OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    //busca por id
    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarPorId(@PathVariable Long id) {
        Optional<Odontologo> odontologo = odontologoService.buscarPorId(id);

        if (odontologo.isPresent()) {
            return ResponseEntity.ok(odontologo.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    //guarda un odontologo
    @PostMapping
    public ResponseEntity<Odontologo> guardar(@RequestBody Odontologo odontologo) {
        return ResponseEntity.ok(odontologoService.guardar(odontologo));
    }

    //lista todos los odontologos
    @GetMapping
    public ResponseEntity<List<Odontologo>> listarTodos() {
        return ResponseEntity.ok(odontologoService.listarTodos());
    }

    //actualizar un odontologo
    @PutMapping
    public ResponseEntity<String> actualizar(@RequestBody Odontologo odontologo) {
        ResponseEntity<String> response;
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarPorId(odontologo.getId());
        if (odontologoBuscado.isPresent()) {
            odontologoService.actualizar(odontologo);
            response = ResponseEntity.ok("Se actualizó el odontologo con id " + odontologo.getId());
        } else {
            response = ResponseEntity.ok().body("No se puede actualizar el odontologo");
        }
        return response;
    }

    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<Odontologo> findByMatricula(@PathVariable String matricula) throws Exception {
        //buscamos el odontologo por matricula
        Optional<Odontologo> odontologoOptional = odontologoService.findByMatricula(matricula);

        if (odontologoOptional.isPresent()) {
            return ResponseEntity.ok(odontologoOptional.get());
        } else {
            throw new Exception("No se encontró el odontólogo con matrícula " + matricula);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        odontologoService.eliminar(id);
        return ResponseEntity.ok("Se eliminó el odontólogo con id: " + id);
    }


}
