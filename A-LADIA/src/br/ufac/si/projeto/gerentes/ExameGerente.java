package br.ufac.si.projeto.gerentes;

import javax.persistence.*;
import br.ufac.si.projeto.entidades.*;

public class ExameGerente {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public ExameGerente() {
		emf = Persistence.createEntityManagerFactory("projeto");
		em = emf.createEntityManager();
	}
	
	public void adicionar(Exame exame) {
		em.getTransaction().begin();
		em.persist(exame);
		em.getTransaction().commit();
	}
	
	public Exame recuperar(long id) {
		return em.find(Exame.class, id);
	}
	
	public void atualizar(Exame exame) {
		em.getTransaction().begin();
		em.merge(exame);
		em.getTransaction().commit();
	}
	
	public void remover(Exame exame) {
		em.getTransaction().begin();
		em.remove(exame);
		em.getTransaction().commit();
	}
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	
}
