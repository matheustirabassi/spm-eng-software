package com.curso.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQueries(value = {
		@NamedQuery(name = "Login.findByEmailSenha", query = "SELECT c FROM Login c "
				+ "WHERE c.email = :email AND c.senha = :senha"),
		@NamedQuery(name = "Login.findByEmail", query = "select a from Login a where a.email = :email"),
		@NamedQuery(name = "Login.findAll", query = "select a from Login a") })
@Entity
public class Login implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String usuario;
	@Column(unique = true)
	private String email;
	private String senha;

	@Temporal(TemporalType.DATE)
	private Date dataCriacao;
	@Temporal(TemporalType.DATE)
	private Date dataModificacao;

	public Login() {
		super();
	}

	public Login(Integer id, String nome, String email, String senha) {
		this.id = id;
		this.usuario = nome;
		this.email = email;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return usuario;
	}

	public void setNome(String nome) {
		this.usuario = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

	@PrePersist
	@PreUpdate
	public void configuraDatasCriacaoAlteracao() {
		this.dataModificacao = new Date();

		if (this.dataCriacao == null) {
			this.dataCriacao = new Date();
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", nome=" + usuario + ", email=" + email + ", senha=" + senha + ", dataCriacao="
				+ dataCriacao + ", dataModificacao=" + dataModificacao + "]";
	}

	

}
