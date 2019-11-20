package br.ufac.si.projeto.testes;

import java.util.List;

import br.ufac.si.projeto.entidades.Amostra;
import br.ufac.si.projeto.gerentes.AmostraGerente;

public class Teste {

	public static void main(String[] args) {
		AmostraGerente ag = new AmostraGerente();
		Amostra a1, a2;
		List<Amostra> amostras;
		
		a1 = new Amostra();
		a1.setAnimal("Tóto");
		a2 = new Amostra();
		a2.setAnimal("Tadeu");
		
		ag.adicionar(a1);
		ag.adicionar(a2);
		
		amostras = ag.recuperarTodasPorNomeContendo("a");
		System.out.println("Listando amostras...");
		for(Amostra amostra: amostras) {
			System.out.println(amostra);
		}
		
		ag.encerrar();

	}

}
