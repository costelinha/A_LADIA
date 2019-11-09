package br.ufac.si.projeto.testes;

import br.ufac.si.projeto.entidades.*;
import br.ufac.si.projeto.gerentes.*;

public class ETE {

	public static void main(String[] args) {

		ParasitologiaPele pp1 = new ParasitologiaPele();
		ParasitologiaOuvido po1 = new ParasitologiaOuvido();
		Tricograma t1 = new Tricograma();
		CitologiaPele cp1 = new CitologiaPele();
		CitologiaOuvido co1 = new CitologiaOuvido();
		ExameGerente eg = new ExameGerente();
		
/*		pp1.setId(1);
		pp1.setResultado(true);
		
		t1.setId(2);
		t1.setResultado("Positivo: Endotrhix");
		
		po1.setId(3);
		po1.setResultado(true);
		
		cp1.setId(4);
		cp1.setCed(true);
		cp1.setLeveduras("+++");
		cp1.setCen(false);
		cp1.setcNeoplasicas(false);
		cp1.setEosinofilos(false);
		cp1.setLinfocitos(false);
		cp1.setMacrofagos(true);
		cp1.setNeutrofilos(false);
		cp1.setObservacao("O cachorro mais lindo que já vi");
		
		co1.setId(5);
		co1.setCed(true);
		co1.setLeveduras("++");
		co1.setCen(true);
		co1.setcNeoplasicas(false);
		co1.setEosinofilos(false);
		co1.setLinfocitos(true);
		co1.setMacrofagos(false);
		co1.setNeutrofilos(false);*/
		
		AmostraGerente ag = new AmostraGerente();
//		ag.recuperar(3).adicionarPP(pp1);
//		ag.recuperar(3).adicionarTricograma(t1);
//		ag.atualizar(ag.recuperar(3));
//		eg.atualizar(eg.recuperar(4));
//		ag.recuperar(2).adicionarCP(cp1);
//		ag.recuperar(2).adicionarCO(co1);
//		ag.recuperar(2).adicionarPO(po1);
//		ag.atualizar(ag.recuperar(2));
//		eg.remover(eg.recuperar(0));
//		eg.recuperar(1).setAmostra(ag.recuperar(3));
//		eg.atualizar(eg.recuperar(1));
//		ag.atualizar(ag.recuperar(3));
		eg.recuperar(2).setAmostra(ag.recuperar(3));
		eg.atualizar(eg.recuperar(2));
		
		
//		eg.adicionar(pp1);
//		eg.adicionar(t1);
//		eg.adicionar(co1);
//		eg.adicionar(po1);
//		eg.adicionar(cp1);
		
		ag.encerrar();
		eg.encerrar();
	}

}
