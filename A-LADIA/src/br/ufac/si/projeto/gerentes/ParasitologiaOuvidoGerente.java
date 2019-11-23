package br.ufac.si.projeto.gerentes;

import java.util.List;

import javax.persistence.*;
import br.ufac.si.projeto.entidades.*;

public class ParasitologiaOuvidoGerente {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public ParasitologiaOuvidoGerente() {
		emf = Persistence.createEntityManagerFactory("projeto");
		em = emf.createEntityManager();
	}
	
	public void adicionar(ParasitologiaOuvido parasitologiaOuvido) {
		em.getTransaction().begin();
		em.persist(parasitologiaOuvido);
		em.getTransaction().commit();
	}
	
	public ParasitologiaOuvido recuperar(long id) {
		return em.find(ParasitologiaOuvido.class, id);
	}
	
	public void atualizar(ParasitologiaOuvido parasitologiaOuvido) {
		em.getTransaction().begin();
		em.merge(parasitologiaOuvido);
		em.getTransaction().commit();
	}
	
	public void remover(ParasitologiaOuvido parasitologiaOuvido) {
		em.getTransaction().begin();
		em.remove(parasitologiaOuvido);
		em.getTransaction().commit();
	}
	
	public List<ParasitologiaOuvido> pegarID(long valor){
		return em.createNamedQuery("ParasitologiaOuvido.pegarID").setParameter("valor", valor).getResultList();
	}
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	
}
