package br.ufac.si.projeto.gerentes;

import java.util.List;

import javax.persistence.*;
import br.ufac.si.projeto.entidades.*;

public class DevolucaoGerente {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public DevolucaoGerente() {
		emf = Persistence.createEntityManagerFactory("projeto");
		em = emf.createEntityManager();
	}
	
	public void adicionar(Devolucao devolucao) {
		em.getTransaction().begin();
		em.persist(devolucao);
		em.getTransaction().commit();
	}
	
	public Devolucao recuperar(long id) {
		return em.find(Devolucao.class, id);
	}
	
	public void atualizar(Devolucao devolucao) {
		em.getTransaction().begin();
		em.merge(devolucao);
		em.getTransaction().commit();
	}
	
	public void remover(Devolucao devolucao) {
		em.getTransaction().begin();
		em.remove(devolucao);
		em.getTransaction().commit();
	}
	
	public List<Devolucao> recuperarTodas(){
		return em.createNamedQuery("Devolucao.todas").getResultList();
	}
	
	public List<Devolucao> recuperarTodasPorNome(){
		return em.createNamedQuery("Devolucao.todasPorNome").getResultList();
	}
	
	public List<Devolucao> recuperarTodasPorNomeContendo(String termo){
		return em.createNamedQuery("Devolucao.todasPorNomeContendo").setParameter("termo", "%"+termo+"%").getResultList();
	}
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	
}
