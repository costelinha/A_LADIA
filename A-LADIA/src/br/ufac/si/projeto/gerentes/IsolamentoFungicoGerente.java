package br.ufac.si.projeto.gerentes;

import java.util.List;

import javax.persistence.*;
import br.ufac.si.projeto.entidades.*;

public class IsolamentoFungicoGerente {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public IsolamentoFungicoGerente() {
		emf = Persistence.createEntityManagerFactory("projeto");
		em = emf.createEntityManager();
	}
	
	public void adicionar(IsolamentoFungico isolamentoFungico) {
		em.getTransaction().begin();
		em.persist(isolamentoFungico);
		em.getTransaction().commit();
	}
	
	public IsolamentoFungico recuperar(long id) {
		return em.find(IsolamentoFungico.class, id);
	}
	
	public void atualizar(IsolamentoFungico isolamentoFungico) {
		em.getTransaction().begin();
		em.merge(isolamentoFungico);
		em.getTransaction().commit();
	}
	
	public void remover(IsolamentoFungico isolamentoFungico) {
		em.getTransaction().begin();
		em.remove(isolamentoFungico);
		em.getTransaction().commit();
	}
	
	public List<IsolamentoFungico> maiorID() {
		return em.createNamedQuery("IsolamentoFungico.maiorID").getResultList();
	}
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	
}
