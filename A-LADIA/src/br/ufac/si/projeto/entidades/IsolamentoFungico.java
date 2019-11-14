package br.ufac.si.projeto.entidades;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@NamedQueries({
	@NamedQuery(name="IsolamentoFungico.maiorID", query="SELECT isoF FROM IsolamentoFungico isoF ORDER BY isoF.id DESC")
})
public abstract class IsolamentoFungico {
	@Id
	@Column(nullable=false)
	private long id;
	@Column(nullable=false)
	private String textura;
	@Column(nullable=false)
	private String borda;
	private String observacoes;
	
	@OneToOne
	@JoinColumn(name="amostra_fk")
	private Amostra amostra;
	
	public void setId(long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
	public String getTextura() {
		return textura;
	}
	public void setTextura(String textura) {
		this.textura = textura;
	}
	public String getBorda() {
		return borda;
	}
	public void setBorda(String borda) {
		this.borda = borda;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public Amostra getAmostra() {
		return amostra;
	}
	public void setAmostra(Amostra amostra) {
		this.amostra = amostra;
	}
	public String toString() {
		return String.format("ISOF [id=\"%d\"]", this.id);
	}
	
}
