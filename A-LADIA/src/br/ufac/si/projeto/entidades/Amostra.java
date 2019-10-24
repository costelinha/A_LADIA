package br.ufac.si.projeto.entidades;

import java.util.*;

import javax.persistence.*;

public class Amostra {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int numeroAmostra;
	private int numeroFicha;
	private Date dataRegistro;
	private String raca;
	private String animal;
	private String especie;
	private String sexo;
	private String tutor;
	private String idade;
	private String requisitante;
	private String tipoDeAmostras;
	private String responsavelObtencao;
	private boolean disponibilidade;
	private boolean situacao;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="usuário")
	private Usuario usuario;
	
	public int getNumeroAmostra() {
		return numeroAmostra;
	}
	public int getNumeroFicha() {
		return numeroFicha;
	}
	public void setNumeroFicha(int numeroFicha) {
		this.numeroFicha = numeroFicha;
	}
	public Date getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public String getAnimal() {
		return animal;
	}
	public void setAnimal(String animal) {
		this.animal = animal;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getTutor() {
		return tutor;
	}
	public void setTutor(String tutor) {
		this.tutor = tutor;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getRequisitante() {
		return requisitante;
	}
	public void setRequisitante(String requisitante) {
		this.requisitante = requisitante;
	}
	public String getTipoDeAmostras() {
		return tipoDeAmostras;
	}
	public void setTipoDeAmostras(String tipoDeAmostras) {
		this.tipoDeAmostras = tipoDeAmostras;
	}
	public String getResponsavelObtencao() {
		return responsavelObtencao;
	}
	public void setResponsavelObtencao(String responsavelObtencao) {
		this.responsavelObtencao = responsavelObtencao;
	}
	public boolean isDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	public boolean isSituacao() {
		return situacao;
	}
	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}
}
