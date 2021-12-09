package com.curso.modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import com.curso.modelo.enums.Sexo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
public class BanhadorTosador extends BaseEntity {
  private static final long serialVersionUID = 1L;
  private Long cpf;
  private String nome;
  private String email;
  private Date dataDeNascimento;
  @Enumerated(EnumType.STRING)
  private Sexo sexo;

  @OneToMany
  List<Agendamento> agendamentos = new ArrayList<>();

}
