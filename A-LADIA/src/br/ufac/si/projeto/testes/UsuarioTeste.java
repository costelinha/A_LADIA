package br.ufac.si.projeto.testes;

import br.ufac.si.projeto.entidades.*;
import br.ufac.si.projeto.gerentes.*;

public class UsuarioTeste {

	public static void main(String[] args) {
		UsuarioGerente ug = new UsuarioGerente();
		Usuario u1, u2;
		Amostra a1, a2, a3, a4, a5;
		
		u1 = new Usuario();
		u1.setNome("Coordenador 1");
		u1.setEmail("coordenador1@gmail.com");
		u1.setLogin("coordenador1");
		u1.setSenha("123");
		u1.setStatus(true);
		u1.setTipo(0);
		u1.setTelefone("999999999");
		
		u2 = new Usuario();
		u2.setNome("Estagiário 1");
		u2.setEmail("estagiario1@gmail.com");
		u2.setLogin("estagiario1");
		u2.setSenha("123");
		u2.setStatus(true);
		u2.setTipo(1);
		u2.setTelefone("8888888888");
		
		a1 = new Amostra();
		a1.setNumeroFicha(1);
		a1.setRaca("Pitbull");
		a1.setAnimal("Totó");
		a1.setEspecie("Canino");
		a1.setSexo("Macho");
		a1.setTutor("André");
		a1.setIdade("1 ano");
		a1.setRequisitante("Dra. Alguém");
		a1.setTipoDeAmostras("Parasita de Pele, Tricograma");
		a1.setResponsavelObtencao(u1.getNome());
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
		a2.setTipoDeAmostras("Parasita de Ouvido");
		a2.setResponsavelObtencao(u2.getNome());
		a2.setDisponibilidade(true);
		a2.setSituacao(true);
		
		ug.adicionar(u1);
		
		ug.encerrar();
	}

}
