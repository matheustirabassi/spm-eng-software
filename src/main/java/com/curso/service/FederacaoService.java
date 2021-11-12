package com.curso.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.curso.dao.FederacaoDAO;
import com.curso.modelo.Federacao;
import com.curso.util.NegocioException;

public class FederacaoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FederacaoDAO federacaoDAO;

	public void salvar(Federacao federacao) throws NegocioException {

		this.federacaoDAO.salvar(federacao);
	}

	public List<Federacao> buscarTodos() {
		return federacaoDAO.buscarTodos();
	}

	public void excluir(Federacao federacao) throws NegocioException {
		federacaoDAO.excluir(federacao);

	}

}