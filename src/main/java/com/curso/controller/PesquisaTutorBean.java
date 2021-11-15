package com.curso.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.curso.modelo.Tutor;
import com.curso.service.TutorService;
import com.curso.util.MessageUtil;
import com.curso.util.NegocioException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Named
@ViewScoped
public class PesquisaTutorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Tutor> tutores = new ArrayList<>();
	private Tutor tutorSelecionado;

	@Inject
	TutorService tutorService;

	@PostConstruct
	public void inicializar() {
		tutores = tutorService.buscarTodos();
	}

	public void excluir() {
		try {
			tutorService.excluir(tutorSelecionado);
			this.tutores.remove(tutorSelecionado);
			MessageUtil.sucesso("Tutor " + tutorSelecionado.getNome() + " excluído com sucesso.");
		} catch (NegocioException e) {
			MessageUtil.erro(e.getMessage());
		}
	}

}