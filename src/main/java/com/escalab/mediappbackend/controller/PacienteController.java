package com.escalab.mediappbackend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.escalab.mediappbackend.exception.ModeloNotFoundException;
import com.escalab.mediappbackend.model.Paciente;
import com.escalab.mediappbackend.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired
	private PacienteService pacienteService;
	
	
	@GetMapping
	public ResponseEntity<List<Paciente>> listar() {
		List<Paciente> lista = pacienteService.getAll();
		return new ResponseEntity<List<Paciente>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> listarPorId(@PathVariable("id") Integer id) {
		if(id != null && id > 0) {
			Paciente pac = pacienteService.findById(id);
			return new ResponseEntity<Paciente>(pac, HttpStatus.OK);
		}{
			return new ResponseEntity<Paciente>(new Paciente(), HttpStatus.NOT_FOUND);
		}
		/*
		if (pac.getIdPaciente() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}*/
	}
	
	@PostMapping
	public ResponseEntity<Paciente> registrar(@Valid @RequestBody Paciente paciente) {
		Paciente pac = pacienteService.save(paciente);
		return new ResponseEntity<Paciente>(pac, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Paciente> modificar(@Valid @RequestBody Paciente paciente) {
		Paciente pac = pacienteService.update(paciente);
		return new ResponseEntity<Paciente>(pac, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Paciente pac = pacienteService.findById(id);
		if (pac.getIdPaciente() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		pacienteService.delete(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
