package com.curso.modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Agendamento.class)
public abstract class Agendamento_ extends com.curso.modelo.BaseEntity_ {

	public static volatile SingularAttribute<Agendamento, String> observacao;
	public static volatile SingularAttribute<Agendamento, Date> dataHoraMarcada;
	public static volatile SingularAttribute<Agendamento, Tutor> tutor;

	public static final String OBSERVACAO = "observacao";
	public static final String DATA_HORA_MARCADA = "dataHoraMarcada";
	public static final String TUTOR = "tutor";

}

