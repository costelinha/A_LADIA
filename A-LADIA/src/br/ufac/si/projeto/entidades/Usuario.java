package br.ufac.si.projeto.entidades;

import java.util.*;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name="Usuario.todos", query="SELECT u FROM Usuario u"),
	@NamedQuery(name="Usuario.todosPorNome", query="SELECT u FROM Usuario u ORDER BY u.nome"),
	@NamedQuery(name="Usuario.todosPorNomeContendo", query="SELECT u FROM Usuario u WHERE u.nome LIKE :termo ORDER BY u.nome"),
	@NamedQuery(name="Usuario.recuperarLogin", query="SELECT u FROM Usuario u WHERE u.login = :termo")
})
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(nullable=false, length=100)
	private String nome;
	@Column(nullable=true, length=100)
	private String email;
	@Column(nullable=true, length=20)
	private String telefone;
	@Column(nullable=false, length=20)
	private String login;
	@Column(nullable=false, length=100)
	private String senha;
	@Column(nullable=false)
	private int tipo;
	@Column(nullable=false)
	private boolean status;
	
	@OneToMany
	@JoinColumn(name="usuario_fk")
	private List<Amostra> amostras = new ArrayList<Amostra>();
	
	@OneToOne(mappedBy="usuario")
	private Retirada retirada;
	
	public Usuario() {
		
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
	
	public String toString() {
		return String.format(this.nome);
	}
	
}
