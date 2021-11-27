package com.curso.modelo;

import com.curso.modelo.enums.Sexo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tutor.class)
public abstract class Tutor_ {

	public static volatile SingularAttribute<Tutor, Date> dataModificacao;
	public static volatile SingularAttribute<Tutor, String> telefone;
	public static volatile ListAttribute<Tutor, Agendamento> agendamentos;
	public static volatile ListAttribute<Tutor, Endereco> enderecos;
	public static volatile SingularAttribute<Tutor, Long> cpf;
	public static volatile SingularAttribute<Tutor, String> nome;
	public static volatile SingularAttribute<Tutor, Sexo> sexo;
	public static volatile SingularAttribute<Tutor, Date> dataNascimento;
	public static volatile SingularAttribute<Tutor, Login> login;
	public static volatile SingularAttribute<Tutor, Date> dataCriacao;
	public static volatile SingularAttribute<Tutor, String> email;

	public static final String DATA_MODIFICACAO = "dataModificacao";
	public static final String TELEFONE = "telefone";
	public static final String AGENDAMENTOS = "agendamentos";
	public static final String ENDERECOS = "enderecos";
	public static final String CPF = "cpf";
	public static final String NOME = "nome";
	public static final String SEXO = "sexo";
	public static final String DATA_NASCIMENTO = "dataNascimento";
	public static final String LOGIN = "login";
	public static final String DATA_CRIACAO = "dataCriacao";
	public static final String EMAIL = "email";

}

