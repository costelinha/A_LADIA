package br.ufac.si.projeto.gerentes;

import java.util.List;

import javax.persistence.*;
import br.ufac.si.projeto.entidades.*;

public class CitologiaPeleGerente {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public CitologiaPeleGerente() {
		emf = Persistence.createEntityManagerFactory("projeto");
		em = emf.createEntityManager();
	}
	
	public void adicionar(CitologiaPele citologiaPele) {
		em.getTransaction().begin();
		em.persist(citologiaPele);
		em.getTransaction().commit();
	}
	
	public CitologiaPele recuperar(long id) {
		return em.find(CitologiaPele.class, id);
	}
	
	public void atualizar(CitologiaPele citologiaPele) {
		em.getTransaction().begin();
		em.merge(citologiaPele);
		em.getTransaction().commit();
	}
	
	public void remover(CitologiaPele citologiaPele) {
		em.getTransaction().begin();
		em.remove(citologiaPele);
		em.getTransaction().commit();
	}
	
	public List<CitologiaPele> pegarID(long valor){
		return em.createNamedQuery("CitologiaPele.pegarID").setParameter("valor", valor).getResultList();
	}
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	
}
