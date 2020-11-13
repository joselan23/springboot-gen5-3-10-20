package com.escalab.mediappbackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalab.mediappbackend.model.Paciente;
import com.escalab.mediappbackend.repo.PacienteRepoInterface;
import com.escalab.mediappbackend.service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService {
	
	@Autowired
	private PacienteRepoInterface repoInterface;

	@Override
	public List<Paciente> getAll() {
		List<Paciente> pacientes = repoInterface.findAll();

		pacientes.forEach((p)-> {
			System.out.print(p.toString());
		});
		
		return pacientes;
	}

	@Override
	public Paciente save(Paciente paciente) {
		return repoInterface.save(paciente);
	}

	@Override
	public Paciente findById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Paciente> paciente = repoInterface.findById(id);
		if(paciente.isPresent()) {
			return paciente.get();
		}else {
			return new Paciente();
		}
	}

	@Override
	public Paciente update(Paciente paciente) {
		// TODO Auto-generated method stub
		return repoInterface.save(paciente);
	}

	@Override
	public Boolean delete(Integer id) {
		// TODO Auto-generated method stub
		repoInterface.deleteById(id);
		return true;
	}
	

}
