package br.ufac.si.projeto.entidades;

import java.util.*;

import javax.persistence.*;

@Entity
public class Retirada {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private Date data;
	private String requisitante;
	
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
	public String getRequisitante() {
		return requisitante;
	}
	public void setRequisitante(String requisitante) {
		this.requisitante = requisitante;
	}
	
	public void retirar(Amostra amostra, Usuario usuario) {
		if(amostra.isSituacao()==true || amostra.isDisponibilidade()==true) {
			amostra.setDisponibilidade(false);
			this.amostra = amostra;
			this.usuario = usuario;
		}
	}
	public long getId() {
		return id;
	}
//	public void setId(long id) {
//		this.id = id;
//	}
	public Amostra getAmostra() {
		return amostra;
	}
//	public void setAmostra(Amostra amostra) {
//		this.amostra = amostra;
//	}
	public Usuario getUsuario() {
		return usuario;
	}
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}
	
}
