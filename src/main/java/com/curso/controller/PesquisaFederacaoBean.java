package com.curso.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import com.curso.modelo.Federacao;
import com.curso.service.FederacaoService;
import com.curso.util.MessageUtil;
import com.curso.util.NegocioException;

@Named
@ViewScoped
public class PesquisaFederacaoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(PesquisaFederacaoBean.class);
	private List<Federacao> federacoes = new ArrayList<Federacao>();
	private Federacao federacaoSelecionada;

	@Inject
	FederacaoService federacaoService;

	@PostConstruct
	public void inicializar() {
		log.info("info Construindo bean pesquisaFederação...");
		log.debug("debug Construindo bean pesquisaFederação...");
		log.error("error Construindo bean pesquisaFederação...");
		federacoes = federacaoService.buscarTodos();
		log.info("bean pesquisaFederação tamanho = " + federacoes.size());
	}

	public void excluir() {
		try {
			federacaoService.excluir(federacaoSelecionada);
			this.federacoes.remove(federacaoSelecionada);
			MessageUtil.sucesso("Federação " + federacaoSelecionada.getSigla() + " excluída com sucesso.");
		} catch (NegocioException e) {
			MessageUtil.erro(e.getMessage());
		}
	}

	public List<Federacao> getFederacoes() {
		return federacoes;
	}

	public Federacao getFederacaoSelecionada() {
		return federacaoSelecionada;
	}

	public void setFederacaoSelecionada(Federacao federacaoSelecionada) {
		this.federacaoSelecionada = federacaoSelecionada;
	}

	
}