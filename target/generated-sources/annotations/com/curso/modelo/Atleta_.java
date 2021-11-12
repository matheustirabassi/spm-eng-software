package com.curso.modelo;

import com.curso.modelo.enums.Sexo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Atleta.class)
public abstract class Atleta_ {

	public static volatile SingularAttribute<Atleta, Date> dataModificacao;
	public static volatile SingularAttribute<Atleta, Long> codigo;
	public static volatile SingularAttribute<Atleta, String> telefone;
	public static volatile SingularAttribute<Atleta, String> nome;
	public static volatile SingularAttribute<Atleta, Clube> clube;
	public static volatile SingularAttribute<Atleta, Date> dataNascimento;
	public static volatile SingularAttribute<Atleta, Sexo> sexo;
	public static volatile SingularAttribute<Atleta, Date> dataCriacao;
	public static volatile SingularAttribute<Atleta, String> email;

	public static final String DATA_MODIFICACAO = "dataModificacao";
	public static final String CODIGO = "codigo";
	public static final String TELEFONE = "telefone";
	public static final String NOME = "nome";
	public static final String CLUBE = "clube";
	public static final String DATA_NASCIMENTO = "dataNascimento";
	public static final String SEXO = "sexo";
	public static final String DATA_CRIACAO = "dataCriacao";
	public static final String EMAIL = "email";

}

