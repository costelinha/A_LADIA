package br.ufac.si.projeto.testes;

import java.util.List;

import br.ufac.si.projeto.entidades.Amostra;
import br.ufac.si.projeto.entidades.Usuario;
import br.ufac.si.projeto.gerentes.AmostraGerente;
import br.ufac.si.projeto.gerentes.UsuarioGerente;

public class UsuarioTeste2 {

	public static void main(String[] args) {

		UsuarioGerente ug = new UsuarioGerente();
		Usuario u1, u2;
		Amostra a1, a2;
		AmostraGerente ag = new AmostraGerente();
		List<Usuario> usuarios;
		
		a1 = ag.recuperar(1);
		a2 = ag.recuperar(2);
		
		u1 = new Usuario();
		u1.setNome("André");
		u2 = new Usuario();
		u2.setNome("Brenda");
		
		ug.adicionar(u1);
		ug.adicionar(u2);
		
		usuarios = ug.recuperarTodosPorNomeContendo("b");
		System.out.println("Listando usuários...");
		for(Usuario usuario: usuarios) {
			System.out.println(usuario);
		}
		
		ug.encerrar();
		ag.encerrar();
		
	}

}
