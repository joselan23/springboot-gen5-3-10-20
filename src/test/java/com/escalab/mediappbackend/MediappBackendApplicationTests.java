package com.escalab.mediappbackend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import com.escalab.mediappbackend.repo.IPacienteRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.escalab.mediappbackend.model.Paciente;

@RunWith(SpringRunner.class)
@SpringBootTest
class MediappBackendApplicationTests {
	
	@Autowired
	private IPacienteRepo repo;
	
	@Test
	public void getPaciente() {
		Paciente paciente = new Paciente();
		paciente.setApellidos("Parmacela");
		paciente.setNombres("Juanito");
		paciente.setIdPaciente(2);
		paciente.setDni("1-8");
		
		Optional<Paciente> retorno = repo.findById(paciente.getIdPaciente());
		assertEquals(retorno.get().getDni(), paciente.getDni());
	}

}
