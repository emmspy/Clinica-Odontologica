package com.dh.ClinicMVC.service;

import com.dh.ClinicMVC.dto.request.TurnoRequestDTO;
import com.dh.ClinicMVC.dto.response.TurnoResponseDTO;
import com.dh.ClinicMVC.entity.Turno;
import com.dh.ClinicMVC.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ITurnoService {
    TurnoResponseDTO guardar(TurnoRequestDTO turno);
    List<TurnoResponseDTO> listarTodos();

    Optional<TurnoResponseDTO> buscarPorId(Long id) throws ResourceNotFoundException;

    void eliminar(Long id);

    void actualizar(Turno turno);
}
