package com.curso.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.curso.dao.TutorDAO;
import com.curso.modelo.Tutor;
import com.curso.util.NegocioException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CadastroTutorBeanTest {

  @Mock
  TutorDAO tutorDAO;
  @Mock
  CadastroTutorBean controller;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }


  @Test
  public void salvar_cpfIsInvalid_NegocioException() throws NegocioException {
    String test = "11111111111";
    Tutor tutor = new Tutor();
    tutor.setCpf(Long.valueOf(test));
    controller.setTutor(tutor);
    assertThrows(NegocioException.class, () -> controller.salvar());

  }

}
