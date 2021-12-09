package com.curso.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.curso.modelo.BanhadorTosador;
import com.curso.service.BanhadorTosadorService;
import com.curso.util.MessageUtil;
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

  private List<BanhadorTosador> BanhadorTosadores = new ArrayList<>();
  private BanhadorTosador BanhadorTosadorSelecionado;

  @Inject
  BanhadorTosadorService banhadorTosadorService;

  @PostConstruct
  public void inicializar() {
    BanhadorTosadores = banhadorTosadorService.findAll();
  }

  public void excluir() {
    banhadorTosadorService.delete(BanhadorTosadorSelecionado);
      this.BanhadorTosadores.remove(BanhadorTosadorSelecionado);
      MessageUtil.sucesso(
          "BanhadorTosador " + BanhadorTosadorSelecionado.getNome() + " excluído com sucesso.");
    }
  }
