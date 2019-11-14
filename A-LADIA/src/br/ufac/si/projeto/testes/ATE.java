package br.ufac.si.projeto.testes;

import java.text.ParseException;
import java.util.*;

import br.ufac.si.projeto.entidades.Amostra;
import br.ufac.si.projeto.gerentes.AmostraGerente;
import br.ufac.si.projeto.gerentes.UsuarioGerente;

public class ATE {

	public static void main(String[] args) throws ParseException {

		Amostra a1 = new Amostra();
		Amostra a2 = new Amostra();
		AmostraGerente ag = new AmostraGerente();
		
		Date data = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		
/*		a1.setAnimal("Chico");
		a1.setDisponibilidade(true);
		a1.setEspecie("Felino");
		a1.setIdade("1 ano");
		a1.setNumeroFicha(2);
		a1.setRaca("Siamês");
		a1.setRequisitante("Dra. Brenda");
		a1.setSexo("Macho");
		a1.setSituacao(true);
		a1.setTutor("Ana");
		a1.setDataRegistro(data);*/
		/*a2.setAnimal("Tobi");
		a2.setDisponibilidade(true);
		a2.setEspecie("Canino");
		a2.setIdade("5 anos e 3 meses");
		a2.setNumeroFicha(1);
		a2.setRaca("Genérico");
		a2.setRequisitante("Dra. Brenda");
		a2.setSexo("Macho");
		a2.setSituacao(true);
		a2.setTutor("Teresa");
		a2.setDataRegistro(data);*/
		
//		ag.recuperar(2).setTutor("Teresa Cordeiro");
		
//		ag.atualizar(ag.recuperar(2));;
		UsuarioGerente ug = new UsuarioGerente();
		ag.recuperar(4).setUsuario(ug.recuperar(4));
		ag.atualizar(ag.recuperar(4));
//		ag.adicionar(a1);
		ag.encerrar();
		ug.encerrar();
	}

}
