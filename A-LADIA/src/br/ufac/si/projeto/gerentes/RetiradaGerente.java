package br.ufac.si.projeto.gerentes;

import java.util.List;

import javax.persistence.*;
import br.ufac.si.projeto.entidades.*;

public class RetiradaGerente {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public RetiradaGerente() {
		emf = Persistence.createEntityManagerFactory("projeto");
		em = emf.createEntityManager();
	}
	
	public void adicionar(Retirada retirada) {
		em.getTransaction().begin();
		em.persist(retirada);
		em.getTransaction().commit();
	}
	
	public Retirada recuperar(long id) {
		return em.find(Retirada.class, id);
	}
	
	public void atualizar(Retirada retirada) {
		em.getTransaction().begin();
		em.merge(retirada);
		em.getTransaction().commit();
	}
	
	public void remover(Retirada retirada) {
		em.getTransaction().begin();
		em.remove(retirada);
		em.getTransaction().commit();
	}
	
	public List<Retirada> recuperarTodas(){
		return em.createNamedQuery("Retirada.todas").getResultList();
	}
	
	public List<Retirada> recuperarTodasPorNome(){
		return em.createNamedQuery("Retirada.todasPorNome").getResultList();
	}
	
	public List<Retirada> recuperarTodasPorNomeContendo(String termo){
		return em.createNamedQuery("Retirada.todasPorNomeContendo").setParameter("termo", "%"+termo+"%").getResultList();
	}
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	
}
