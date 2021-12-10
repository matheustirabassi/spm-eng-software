package com.curso.controller;

import com.curso.modelo.BanhadorTosador;
import com.curso.modelo.enums.Sexo;
import com.curso.service.BanhadorTosadorService;
import com.curso.util.MessageUtil;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Data;

@Data
@Named
@ViewScoped
public class CadastroBanhadorTosadorBean implements Serializable {

  private static final long serialVersionUID = 1L;

  private BanhadorTosador banhadorTosador;
  private List<Sexo> sexos;

  @Inject
  private BanhadorTosadorService banhadorTosadorService;

  public void salvar() {

    this.banhadorTosadorService.saveOrUpdate(banhadorTosador);
    MessageUtil.sucesso("Banhador salvo com sucesso!");

    this.limpar();
  }

  @PostConstruct
  public void inicializar() {
    limpar();
  }

  public void limpar() {
    this.banhadorTosador = new BanhadorTosador();
    sexos = Arrays.asList(Sexo.values());
  }

}
