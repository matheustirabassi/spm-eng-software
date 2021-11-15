package com.curso.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.curso.modelo.Agendamento;
import com.curso.service.AgendamentoService;
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
public class PesquisaAgendamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Agendamento> agendamentos = new ArrayList<>();
	private Agendamento agendamentoSelecionado;

	@Inject
	AgendamentoService tutorService;

	@PostConstruct
	public void inicializar() {
		agendamentos = tutorService.buscarTodos();
	}

	public void excluir() {
		try {
			tutorService.excluir(agendamentoSelecionado);
			this.agendamentos.remove(agendamentoSelecionado);
			MessageUtil.sucesso("Agendamento " + agendamentoSelecionado.getId() + " excluído com sucesso.");
		} catch (NegocioException e) {
			MessageUtil.erro(e.getMessage());
		}
	}

}