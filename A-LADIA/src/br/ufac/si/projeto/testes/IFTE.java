package br.ufac.si.projeto.testes;

import br.ufac.si.projeto.entidades.Filamentoso;
import br.ufac.si.projeto.entidades.IsolamentoFungico;
import br.ufac.si.projeto.gerentes.AmostraGerente;
import br.ufac.si.projeto.gerentes.IsolamentoFungicoGerente;

public class IFTE {

	public static void main(String[] args) {

		Filamentoso f1 = new Filamentoso();
		IsolamentoFungicoGerente ifg = new IsolamentoFungicoGerente();
		AmostraGerente ag = new AmostraGerente();
		
//		f1.setArtroconidio(true);
//		f1.setId(1);
//		IsolamentoFungico a = ifg.recuperar(1);
//		a.setAmostra(ag.recuperar(3));
//		ifg.atualizar(a);
		
		ifg.remover(ifg.recuperar(1));
		
//		ifg.adicionar(f1);
		ifg.encerrar();
		ag.encerrar();
	}

}
