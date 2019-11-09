package br.ufac.si.projeto.testes;

import br.ufac.si.projeto.entidades.*;
import br.ufac.si.projeto.gerentes.AmostraGerente;
import br.ufac.si.projeto.gerentes.IsolamentoFungicoGerente;

public class IsolamentoFungicoTeste {

	public static void main(String[] args) {

		Amostra a1 = new Amostra();
		AmostraGerente ag = new AmostraGerente();
		Filamentoso f1 = new Filamentoso();
		IsolamentoFungicoGerente ifg = new IsolamentoFungicoGerente();
		
		f1.setId(1);
		ag.adicionar(a1);
		f1.setAmostra(a1);
//		a1.setIsoF(f1);
		ifg.adicionar(f1);
		
		ifg.encerrar();
		ag.encerrar();
	}

}
