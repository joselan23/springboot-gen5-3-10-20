package com.escalab.mediappbackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalab.mediappbackend.model.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer > {

}
