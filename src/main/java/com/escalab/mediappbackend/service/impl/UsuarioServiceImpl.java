package com.escalab.mediappbackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.beans.factory.annotation.Autowired;

import com.escalab.mediappbackend.model.Usuario;
import com.escalab.mediappbackend.repo.UsuarioRepositorio;
import com.escalab.mediappbackend.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepositorio repo;

	@Override
	public Usuario registrar(Usuario obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public Usuario modificar(Usuario obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Usuario leerPorId(Integer id) {
		// TODO Auto-generated method stub
		Optional<Usuario> optional = repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}{
			return new Usuario();
		}
	}

	@Override
	public boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return true;
	}
	
	

}
