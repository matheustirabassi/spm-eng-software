package com.curso.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.curso.modelo.Agendamento;
import com.curso.modelo.enums.Sexo;
import com.curso.service.AgendamentoService;
import com.curso.util.MessageUtil;
import com.curso.util.NegocioException;

import lombok.Data;

@Data
@Named
@ViewScoped
public class CadastroAgendamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Agendamento agendamento;

	@Inject
	private AgendamentoService agendamentoService;

	public void salvar() {
		try {

			this.agendamentoService.salvar(agendamento);
			MessageUtil.sucesso("Agendamento salvo com sucesso!");
		} catch (NegocioException e) {
			MessageUtil.erro(e.getMessage());
		} catch (Exception ex) {
			MessageUtil.erro(ex.getMessage());
		}

		this.limpar();
	}

	@PostConstruct
	public void inicializar() {
		limpar();
	}

	public void limpar() {
		this.agendamento = new Agendamento();
	}

}