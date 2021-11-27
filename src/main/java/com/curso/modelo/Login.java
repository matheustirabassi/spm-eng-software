package com.curso.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "Login.findByEmailSenha", query = "SELECT c FROM Login c " + "WHERE c.email = :email AND c.senha = :senha")
@NamedQuery(name = "Login.findByEmail", query = "select a from Login a where a.email = :email")
@NamedQuery(name = "Login.findAll", query = "select a from Login a")
@Entity
public class Login extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private String usuario;
	@Column(unique = true)
	private String email;
	private String senha;
	
}
