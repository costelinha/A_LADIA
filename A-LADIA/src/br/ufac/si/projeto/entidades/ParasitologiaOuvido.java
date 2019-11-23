package br.ufac.si.projeto.entidades;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name="ParasitologiaOuvido.pegarID", query="SELECT p FROM ParasitologiaOuvido p "
			+ "WHERE amostra_fk = :valor")
})
public class ParasitologiaOuvido extends Exame {

	private String resultado;

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
}
