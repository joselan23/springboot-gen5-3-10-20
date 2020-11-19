package com.escalab.mediappbackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalab.mediappbackend.model.Paciente;

public interface IPacienteRepo extends JpaRepository<Paciente, Integer> {

}
