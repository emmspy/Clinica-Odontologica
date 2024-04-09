package com.dh.ClinicMVC.service.implementation;

import com.dh.ClinicMVC.entity.Odontologo;
import com.dh.ClinicMVC.exception.ResourceNotFoundException;
import com.dh.ClinicMVC.repository.IOdontologoRepository;
import com.dh.ClinicMVC.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService implements IOdontologoService {

    private IOdontologoRepository odontologoRepository;

    @Autowired
    public OdontologoService(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    @Override
    public List<Odontologo> listarTodos() {
        return odontologoRepository.findAll();
    }

    @Override
    public Optional<Odontologo> buscarPorId(Long id) {
        return odontologoRepository.findById(id);

    }

    @Override
    public void actualizar(Odontologo odontologo) {
        odontologoRepository.save(odontologo);
    }

    @Override
    public Optional<Odontologo> findByMatricula(String matricula) {
        return odontologoRepository.findByMatricula(matricula);
    }

    @Override
    public void eliminar(Long id) {
        Optional<Odontologo> odontologo = buscarPorId(id);
        if (odontologo.isPresent()) {
            odontologoRepository.deleteById(id);
        } else {
            throw  new ResourceNotFoundException("No se pudo eliminar el odontólogo con id: " + id);
        }
    }
}
