package com.escalab.mediappbackend;

import com.escalab.mediappbackend.model.Paciente;
import com.escalab.mediappbackend.repo.IPacienteRepo;
import com.escalab.mediappbackend.service.IPacienteService;
import com.escalab.mediappbackend.service.impl.PacienteServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner .class)
@SpringBootTest
public class PacienteTest {

    @Mock
    IPacienteRepo repo;

    @InjectMocks
    IPacienteService pacienteService = new PacienteServiceImpl();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void getPaciente(){
        Integer pacienteId = null;
        when(repo.findById(pacienteId)).thenReturn(Optional.of(new Paciente()));
        Paciente paciente = pacienteService.leerPorId(pacienteId);
        assertEquals(paciente.getIdPaciente(), pacienteId);
    }
}
