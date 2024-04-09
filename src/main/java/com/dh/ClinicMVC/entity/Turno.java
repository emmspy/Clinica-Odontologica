package com.dh.ClinicMVC.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "turnos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // -> generar un nuevo registro en la BD
    @ManyToOne
    private Odontologo odontologo;
    @ManyToOne
    private Paciente paciente;
    private LocalDate fecha;

}
