package br.ufac.si.projeto.entidades;

import javax.persistence.*;

@Entity
public class Tricograma extends Exame {

	private String resultado;

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
}
