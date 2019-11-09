package br.ufac.si.projeto.entidades;

import javax.persistence.*;

@Entity
public class ParasitologiaPele extends Exame {

	private boolean resultado;

	public boolean isResultado() {
		return resultado;
	}

	public void setResultado(boolean resultado) {
		this.resultado = resultado;
	}
}
