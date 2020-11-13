package com.escalab.mediappbackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escalab.mediappbackend.model.Paciente;

@Repository
public interface PacienteRepoInterface extends JpaRepository<Paciente, Integer> {

}
