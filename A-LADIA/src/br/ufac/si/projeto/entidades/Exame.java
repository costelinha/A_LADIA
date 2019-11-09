package br.ufac.si.projeto.entidades;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Exame {
	@Id
	private long id;
//	private String nome;
	
	@ManyToOne
	@JoinColumn(name="amostra_fk")
	private Amostra amostra;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Amostra getAmostra() {
		return amostra;
	}

	public void setAmostra(Amostra amostra) {
		this.amostra = amostra;
	}

//	public String getNome() {
//		return nome;
//	}

//	public void setNome(String nome) {
//		this.nome = nome;
//	}

}
