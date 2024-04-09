package com.dh.ClinicMVC.repository;

import com.dh.ClinicMVC.entity.Domicilio;
import com.dh.ClinicMVC.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
    
}
