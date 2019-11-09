package br.ufac.si.projeto.gerentes;

import java.util.List;

import javax.persistence.*;
import br.ufac.si.projeto.entidades.*;

public class UsuarioGerente {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public UsuarioGerente() {
		emf = Persistence.createEntityManagerFactory("projeto");
		em = emf.createEntityManager();
	}
	
	public void adicionar(Usuario usuario) {
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
	}
	
	public Usuario recuperar(long id) {
		return em.find(Usuario.class, id);
	}
	
	public void atualizar(Usuario usuario) {
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
	}
	
	public void remover(Usuario usuario) {
		em.getTransaction().begin();
		em.remove(usuario);
		em.getTransaction().commit();
	}
	
	public List<Usuario> recuperarTodos(){
		return em.createNamedQuery("Usuario.todos").getResultList();
	}
	
	public List<Usuario> recuperarTodosPorNome(){
		return em.createNamedQuery("Usuario.todosPorNome").getResultList();
	}
	
	public List<Usuario> recuperarTodosPorNomeContendo(String termo){
		return em.createNamedQuery("Usuario.todosPorNomeContendo").setParameter("termo", "%"+termo+"%").getResultList();
	}
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	
}
