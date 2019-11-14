package br.ufac.si.projeto.gerentes;

import java.util.List;

import javax.persistence.*;
import br.ufac.si.projeto.entidades.*;

public class AmostraGerente {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public AmostraGerente() {
		emf = Persistence.createEntityManagerFactory("projeto");
		em = emf.createEntityManager();
	}
	
	public void adicionar(Amostra amostra) {
		em.getTransaction().begin();
		em.persist(amostra);
		em.getTransaction().commit();
	}
	
	public Amostra recuperar(long id) {
		return em.find(Amostra.class, id);
	}
	
	public void atualizar(Amostra amostra) {
		em.getTransaction().begin();
		em.merge(amostra);
		em.getTransaction().commit();
	}
	
	public void remover(Amostra amostra) {
		em.getTransaction().begin();
		em.remove(amostra);
		em.getTransaction().commit();
	}
	
	public List<Amostra> recuperarTodas(){
		return em.createNamedQuery("Amostra.todas").getResultList();
	}
	
	public List<Amostra> recuperarTodasRecente(){
		return em.createNamedQuery("Amostra.todasRecente").getResultList();
	}
	
	public List<Amostra> recuperarTodasPorNomeContendo(String termo){
		return em.createNamedQuery("Amostra.todasPorNomeContendo").setParameter("termo", "%"+termo+"%").getResultList();
	}
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	
}
