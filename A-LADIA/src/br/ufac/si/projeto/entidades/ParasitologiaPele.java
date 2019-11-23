package br.ufac.si.projeto.entidades;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name="ParasitologiaPele.pegarID", query="SELECT p FROM ParasitologiaPele p "
			+ "WHERE amostra_fk = :valor")
})
public class ParasitologiaPele extends Exame {

	private String resultado;

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
}
