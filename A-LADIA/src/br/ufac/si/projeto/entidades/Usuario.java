package br.ufac.si.projeto.entidades;

import java.util.*;

import javax.persistence.*;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false, length=100)
	private String nome;
	
	@Column(nullable=false, length=100)
	private String email;
	
	@Column(nullable=false, length=20)
	private String telefone;
	
	@Column(nullable=false, length=20)
	private String login;
	
	@Column(nullable=false, length=20)
	private String senha;
	
	@Column(nullable=false)
	private int tipo;
	
	@Column(nullable=false)
	private boolean status;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="usuário")
	private List<Amostra> amostras = new ArrayList<Amostra>();
	
	public Usuario() {
		
	}
	
	public Usuario(long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void adicionarAmostra(Amostra amostra) {
		this.amostras.add(amostra);
	}
	
	public void removerAmostra(Amostra amostra) {
		this.amostras.remove(amostra);
	}
	
}
