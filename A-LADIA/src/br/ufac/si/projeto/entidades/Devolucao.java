package br.ufac.si.projeto.entidades;

import java.util.*;

import javax.persistence.*;

@Entity
public class Devolucao {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private Date data;
	
	@OneToOne
	@JoinColumn(name="amostra_fk")
	private Amostra amostra;
	
	@OneToOne
	@JoinColumn(name="usuario_fk")
	private Usuario usuario;
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	public void devolver(Amostra amostra, Usuario usuario) {
		if(amostra.isSituacao()==true || amostra.isDisponibilidade()==false) {
			amostra.setDisponibilidade(true);
			this.amostra = amostra;
			this.usuario = usuario;
		}
	}
	public long getId() {
		return id;
	}
	public Amostra getAmostra() {
		return amostra;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	
	

}
