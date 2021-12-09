package com.curso.controller;

import com.curso.modelo.BanhadorTosador;
import com.curso.service.BanhadorTosadorService;
import com.curso.util.MessageUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Named
@ViewScoped
public class PesquisaBanhadorTosadorBean implements Serializable {

  private static final long serialVersionUID = 1L;

  private List<BanhadorTosador> banhadorTosadores = new ArrayList<>();
  private BanhadorTosador banhadorTosadorSelecionado;

  @Inject
  BanhadorTosadorService banhadorTosadorService;

  @PostConstruct
  public void inicializar() {
    banhadorTosadores = banhadorTosadorService.findAll();
  }

  public void delete() {
    banhadorTosadorService.delete(banhadorTosadorSelecionado);
    this.banhadorTosadores.remove(banhadorTosadorSelecionado);
      MessageUtil.sucesso(
          "BanhadorTosador " + banhadorTosadorSelecionado.getNome() + " excluído com sucesso.");
    }
  }
