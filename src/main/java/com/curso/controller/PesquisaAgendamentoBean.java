package com.curso.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.curso.modelo.Agendamento;
import com.curso.service.AgendamentoService;
import com.curso.util.MessageUtil;

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
		agendamentos = tutorService.findAll();
	}

	public void excluir() {
		tutorService.delete(agendamentoSelecionado);
		this.agendamentos.remove(agendamentoSelecionado);
		MessageUtil.sucesso("Agendamento " + agendamentoSelecionado.getId() + " excluído com sucesso.");
	}

}