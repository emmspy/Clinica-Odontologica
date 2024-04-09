package com.dh.ClinicMVC.service.implementation;

import com.dh.ClinicMVC.entity.Odontologo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;

    @Test
    void guardar() {

        Integer odontologoId = 1;
        Odontologo odontologo = new Odontologo();
        odontologo.setNombre("Nico");
        odontologo.setApellido("Trou");
        odontologo.setMatricula("123");
        odontologoService.guardar(odontologo);

        assertNotNull(odontologo);
    }
}