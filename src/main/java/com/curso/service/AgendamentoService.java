package com.curso.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.curso.dao.AgendamentoDAO;
import com.curso.modelo.Agendamento;
import com.curso.util.NegocioException;

public class AgendamentoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AgendamentoDAO agendamentoDAO;

	public void salvar(Agendamento agendamento) throws NegocioException {
		this.agendamentoDAO.salvar(agendamento);
	}

	public List<Agendamento> buscarTodos() {
		return agendamentoDAO.buscarTodos();
	}

	public void excluir(Agendamento agendamento) throws NegocioException {
		agendamentoDAO.excluir(agendamento);
	}

	public Agendamento buscarPorId(Long cpf) {
		return agendamentoDAO.buscarPeloCodigo(cpf);
	}
}
