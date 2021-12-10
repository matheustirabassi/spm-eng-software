package com.curso.controller;

import com.curso.modelo.Agendamento;
import com.curso.modelo.BanhadorTosador;
import com.curso.modelo.Tutor;
import com.curso.service.AgendamentoService;
import com.curso.util.MessageUtil;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
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
      this.agendamentoService.saveOrUpdate(agendamento);
      MessageUtil.sucesso("Agendamento salvo com sucesso!");
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
    BanhadorTosador banhadorTosador = new BanhadorTosador();
    banhadorTosador.getAgendamentos().add(agendamento);
    agendamento.setBanhadorTosador(banhadorTosador);
    Tutor tutor = new Tutor();
    tutor.getAgendamentos().add(agendamento);
    agendamento.setTutor(tutor);
  }

}
