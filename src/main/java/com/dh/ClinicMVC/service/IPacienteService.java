package com.dh.ClinicMVC.service;

import com.dh.ClinicMVC.entity.Paciente;

import java.util.List;

public interface IPacienteService {
    Paciente guardar(Paciente paciente);
    List<Paciente> listarTodos();

    Paciente buscarPorId(Long id);
    void eliminar(Long id);
    void actualizar(Paciente paciente);
}
