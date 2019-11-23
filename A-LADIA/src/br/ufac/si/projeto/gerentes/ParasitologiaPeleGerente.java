package br.ufac.si.projeto.gerentes;

import java.util.List;

import javax.persistence.*;
import br.ufac.si.projeto.entidades.*;

public class ParasitologiaPeleGerente {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public ParasitologiaPeleGerente() {
		emf = Persistence.createEntityManagerFactory("projeto");
		em = emf.createEntityManager();
	}
	
	public void adicionar(ParasitologiaPele parasitologiaPele) {
		em.getTransaction().begin();
		em.persist(parasitologiaPele);
		em.getTransaction().commit();
	}
	
	public ParasitologiaPele recuperar(long id) {
		return em.find(ParasitologiaPele.class, id);
	}
	
	public void atualizar(ParasitologiaPele parasitologiaPele) {
		em.getTransaction().begin();
		em.merge(parasitologiaPele);
		em.getTransaction().commit();
	}
	
	public void remover(ParasitologiaPele parasitologiaPele) {
		em.getTransaction().begin();
		em.remove(parasitologiaPele);
		em.getTransaction().commit();
	}
	
	public List<ParasitologiaPele> pegarID(long valor){
		return em.createNamedQuery("ParasitologiaPele.pegarID").setParameter("valor", valor).getResultList();
	}
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	
}
