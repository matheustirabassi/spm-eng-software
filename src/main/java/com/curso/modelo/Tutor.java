package com.curso.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.curso.modelo.enums.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Embeddable
@NamedQuery(name = "Tutor.buscarTodos", query = "select a from Tutor a")
@NamedQuery(name = "Tutor.buscarPorEmail", query = "select a from Tutor a where a.email = :email")
public class Tutor implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @EqualsAndHashCode.Include
  private Long cpf;
  private String nome;
  @Column(unique = true)
  private String email;
  @Enumerated(EnumType.STRING)
  private Sexo sexo;
  private Date dataNascimento;
  private String telefone;
  @Temporal(TemporalType.TIMESTAMP)
  private Date dataCriacao;
  @Temporal(TemporalType.TIMESTAMP)
  private Date dataModificacao;

  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "tutor_id")
  private Login login;
  @OneToMany
  private List<Agendamento> agendamentos = new ArrayList<>();
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "endereco_id")
  private Endereco endereco;

  @PrePersist
  @PreUpdate
  public void configuraDatasCriacaoAlteracao() {
    this.dataModificacao = new Date();

    if (this.dataCriacao == null) {
      this.dataCriacao = new Date();
    }
  }



}
