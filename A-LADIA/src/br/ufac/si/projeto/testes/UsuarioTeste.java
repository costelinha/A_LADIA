package br.ufac.si.projeto.testes;

import br.ufac.si.projeto.entidades.*;
import br.ufac.si.projeto.gerentes.*;


public class UsuarioTeste {

	public static void main(String[] args) {
		UsuarioGerente ug = new UsuarioGerente();
		Usuario u1, u2;
		Amostra a1, a2, a3;
		ExameGerente eg = new ExameGerente();
		ParasitologiaPele pp1, pp2;
		ParasitologiaOuvido po1;
		CitologiaOuvido co1;
		Tricograma t1;
		
		u1 = new Usuario();
		u1.setNome("Coordenador 1");
		u1.setEmail("coordenador1@gmail.com");
		u1.setLogin("coordenador1");
		u1.setSenha(Criptografar.encriptografar("123"));
		u1.setStatus(true);
		u1.setTipo(0);
		u1.setTelefone("999999999");
		
		u2 = new Usuario();
		u2.setNome("Estagiário 1");
		u2.setEmail("estagiario1@gmail.com");
		u2.setLogin("estagiario1");
		u2.setSenha(Criptografar.encriptografar("123"));
		u2.setStatus(true);
		u2.setTipo(1);
		u2.setTelefone("888888888");
		
		pp1 = new ParasitologiaPele();
		pp1.setId(1);
		pp1.setResultado(true);
		
		po1 = new ParasitologiaOuvido();
		po1.setId(2);
		po1.setResultado(true);
		
		pp2 = new ParasitologiaPele();
		pp2.setId(3);
		pp2.setResultado(true);
		
		co1 = new CitologiaOuvido();
		co1.setId(4);
		
		t1 = new Tricograma();
		t1.setId(5);
		t1.setResultado("Positivo: Endothrix");
		
		a1 = new Amostra();
		a1.setNumeroFicha(1);
		a1.setRaca("Pitbull");
		a1.setAnimal("Totó");
		a1.setEspecie("Canino");
		a1.setSexo("Macho");
		a1.setTutor("André");
		a1.setIdade("1 ano");
		a1.setRequisitante("Dra. Alguém");
		a1.setDisponibilidade(true);
		a1.setSituacao(true);
		
		a2 = new Amostra();
		a2.setNumeroFicha(2);
		a2.setRaca("Poodle");
		a2.setAnimal("Hera");
		a2.setEspecie("Canino");
		a2.setSexo("Fêmea");
		a2.setTutor("Felipe");
		a2.setIdade("1 ano e 7 meses");
		a2.setRequisitante("Dra. Alguém");
		a2.setDisponibilidade(true);
		a2.setSituacao(true);
		
		a3 = new Amostra();
		a3.setNumeroFicha(3);
		a3.setRaca("Siamês");
		a3.setAnimal("Chanin");
		a3.setEspecie("Felino");
		a3.setSexo("Macho");
		a3.setTutor("Cara");
		a3.setIdade("3 ano e 4 meses");
		a3.setRequisitante("Dra. Alguém");
		a3.setDisponibilidade(true);
		a3.setSituacao(true);
		
		a1.adicionarPP(pp1);
		a1.adicionarPO(po1);
		a2.adicionarPP(pp2);
		a3.adicionarCO(co1);
		a3.adicionarTricograma(t1);

		u1.adicionarAmostra(a1);
		u2.adicionarAmostra(a2);
		u2.adicionarAmostra(a3);
		
		ug.adicionar(u1);
		ug.adicionar(u2);
		eg.adicionar(pp1);
		eg.adicionar(po1);
		eg.adicionar(pp2);
		
		eg.encerrar();
		ug.encerrar();
	}

}
