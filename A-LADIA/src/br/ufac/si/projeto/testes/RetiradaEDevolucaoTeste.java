package br.ufac.si.projeto.testes;

import br.ufac.si.projeto.entidades.Amostra;
import br.ufac.si.projeto.entidades.Devolucao;
import br.ufac.si.projeto.entidades.Retirada;
import br.ufac.si.projeto.entidades.Usuario;
import br.ufac.si.projeto.gerentes.AmostraGerente;
import br.ufac.si.projeto.gerentes.DevolucaoGerente;
import br.ufac.si.projeto.gerentes.RetiradaGerente;
import br.ufac.si.projeto.gerentes.UsuarioGerente;

public class RetiradaEDevolucaoTeste {

	public static void main(String[] args) {
		
		Amostra a1 = new Amostra();
		AmostraGerente ag = new AmostraGerente();
		Usuario u1 = new Usuario();
		Usuario u2 = new Usuario();
		UsuarioGerente ug = new UsuarioGerente();
		u1.setNome("André");
		u2.setNome("Felipe");
		a1.setDisponibilidade(true);
		System.out.println("Amostra cadastrada: "+a1.isDisponibilidade());
		
		Retirada r1 = new Retirada();
		RetiradaGerente rg = new RetiradaGerente();
		r1.retirar(a1, u1);
//		r1.setAmostra(a1);
//		r1.setUsuario(u1);
		System.out.println("Amostra retirada: "+a1.isDisponibilidade());
		
		Devolucao d1 = new Devolucao();
		DevolucaoGerente dg = new DevolucaoGerente();
		d1.devolver(a1, u2);
		//System.out.println("Amostra devolvida: "+a1.isDisponibilidade());
		ug.adicionar(u1);
		ug.adicionar(u2);
		ag.adicionar(a1);
		rg.adicionar(r1);
		dg.adicionar(d1);
		rg.encerrar();
		dg.encerrar();
		ag.encerrar();
		ug.encerrar();

	}

}
