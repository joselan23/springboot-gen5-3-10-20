package com.escalab.mediappbackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalab.mediappbackend.model.Medico;

public interface IMedicoRepo extends JpaRepository<Medico, Integer> {

}
