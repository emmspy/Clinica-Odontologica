package com.dh.ClinicMVC.controller;

import com.dh.ClinicMVC.dto.request.TurnoRequestDTO;
import com.dh.ClinicMVC.dto.response.TurnoResponseDTO;
import com.dh.ClinicMVC.exception.ResourceNotFoundException;
import com.dh.ClinicMVC.service.IOdontologoService;
import com.dh.ClinicMVC.service.IPacienteService;
import com.dh.ClinicMVC.service.ITurnoService;
import com.dh.ClinicMVC.service.implementation.OdontologoService;
import com.dh.ClinicMVC.service.implementation.PacienteService;
import com.dh.ClinicMVC.service.implementation.TurnoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private static final Logger LOGGER = Logger.getLogger(TurnoController.class);

    private ITurnoService turnoService;
    private IOdontologoService odontologoService;
    private IPacienteService pacienteService;

    @Autowired
    public TurnoController(TurnoService turnoService, OdontologoService odontologoService, PacienteService pacienteService) {
        this.turnoService = turnoService;
        this.odontologoService = odontologoService;
        this.pacienteService = pacienteService;
    }


    //endpoint para guardar un turnoRequestDTO
    @PostMapping
    public ResponseEntity<TurnoResponseDTO> guardar(@RequestBody TurnoRequestDTO turnoRequestDTO) {
        ResponseEntity<TurnoResponseDTO> response;

        LOGGER.info("esto trae el turnoRequestDTO: " + turnoRequestDTO);
//        vamos a chequear que exista el odontologo y la paciente
        if (odontologoService.buscarPorId(turnoRequestDTO.getOdontologo_id()) != null &&
                pacienteService.buscarPorId(turnoRequestDTO.getPaciente_id()) != null) {

            //setear una respuesta en 200 y vamos a hacer que devuelva el turnoRequestDTO
            response = ResponseEntity.ok(turnoService.guardar(turnoRequestDTO));

        } else {
            //si no existe el odontologo o el paciente
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        }
        return response;
    }

    @GetMapping
    public ResponseEntity<List<TurnoResponseDTO>> findAll(){
        return ResponseEntity.ok(turnoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoResponseDTO> findById(@PathVariable Long id) {
        //vamos simplemente a llamar al servicio que busca por id
        //porque si no lo encuentra, el servicio va a manejar la excepción
        turnoService.buscarPorId(id);
        return ResponseEntity.ok().build();

//        Optional<TurnoResponseDTO> turnoOptional = turnoService.buscarPorId(id);
//
//        if (turnoOptional.isPresent()) {
//            return ResponseEntity.ok(turnoOptional.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
    }


}
