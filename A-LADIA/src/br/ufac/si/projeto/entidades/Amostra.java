package br.ufac.si.projeto.entidades;

import java.util.*;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name="Amostra.todas", query="SELECT a FROM Amostra a"),
	@NamedQuery(name="Amostra.todasRecente", query="SELECT a FROM Amostra a ORDER BY a.id DESC"),
	@NamedQuery(name="Amostra.todasPorNomeContendo", query="SELECT a FROM Amostra a WHERE a.animal LIKE :termo ORDER BY a.animal")
})
public class Amostra {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="numero_da_amostra", nullable=false)
	private long numeroAmostra;
	@Column(name="numero_da_ficha", nullable=true)
	private int numeroFicha;
	@Column(name="data_de_registro", nullable=true)
	private Date dataRegistro;
	private String raca;
	private String animal;
	private String especie;
	private String sexo;
	private String tutor;
	private String idade;
	private String requisitante;
	private boolean disponibilidade;
	private boolean situacao;
	private boolean exames[];
	
	@OneToOne(mappedBy="amostra")
	private Retirada retirada;
	
	@OneToOne(mappedBy="amostra")
	@JoinColumn(name="amostra_fk")
	private IsolamentoFungico isoF;
	
	@ManyToOne
	@JoinColumn(name="usuario_fk")
	private Usuario usuario;
	
	private String amostras;
	
	public long getNumeroAmostra() {
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
	public Retirada getRetirada() {
		return retirada;
	}
	public void setRetirada(Retirada retirada) {
		this.retirada = retirada;
	}
	
	public IsolamentoFungico getIsoF() {
		return isoF;
	}
	
	public String getAmostras() {
		return amostras;
	}
	public void setAmostras(String amostras) {
		this.amostras = amostras;
	}
	public String toString() {
		return String.format("Amostra [animal=\"%s\"]", this.animal);
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public boolean[] getExames() {
		return exames;
	}
	public void setExames(boolean[] exames) {
		this.exames = exames;
	}
}
