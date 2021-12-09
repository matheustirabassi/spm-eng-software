package com.curso.modelo;

import com.curso.modelo.enums.Sexo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Classe somente relacionada aos agendamentos.
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@NamedQuery(name = "BanhadorTosador.findAll", query = "select a from BanhadorTosador a")
@NamedQuery(name = "BanhadorTosador.findByEmail",
    query = "select a from BanhadorTosador a where a.email = :email")
@Entity
public class BanhadorTosador extends BaseEntity {
  private static final long serialVersionUID = 1L;
  private Long cpf;
  private String nome;
  @Column(unique = true)
  private String email;
  private String telefone;
  private Date dataDeNascimento;
  @Enumerated(EnumType.STRING)
  private Sexo sexo;

  @OneToMany
  List<Agendamento> agendamentos = new ArrayList<>();

}
