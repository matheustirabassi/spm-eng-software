package com.curso.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Transient;

import com.curso.modelo.Tutor;
import com.curso.modelo.enums.Sexo;
import com.curso.service.TutorService;
import com.curso.util.MessageUtil;
import com.curso.util.NegocioException;

import lombok.Data;

@Data
@Named
@ViewScoped
public class CadastroTutorBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Tutor tutor;
	private List<Sexo> sexos;

	@Inject
	private TutorService tutorService;

	public void salvar() {
		try {

			this.tutorService.salvar(tutor);
			MessageUtil.sucesso("Tutor salvo com sucesso!");
		} catch (NegocioException e) {
			MessageUtil.erro(e.getMessage());
		} catch (Exception ex) {
			MessageUtil.erro(ex.getMessage());
		}

		this.limpar();
	}

	@PostConstruct
	public void inicializar() {
		sexos = Arrays.asList(Sexo.values());
		limpar();
	}

	public void limpar() {
		this.tutor = new Tutor();
	}


	public List<Sexo> getSexos() {
		return sexos;
	}

}
