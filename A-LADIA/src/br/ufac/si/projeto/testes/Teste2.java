package br.ufac.si.projeto.testes;

import java.util.List;

import br.ufac.si.projeto.entidades.Amostra;
import br.ufac.si.projeto.entidades.Usuario;
import br.ufac.si.projeto.gerentes.AmostraGerente;
import br.ufac.si.projeto.gerentes.UsuarioGerente;

public class Teste2 {

	public static void main(String[] args) {

		UsuarioGerente ug = new UsuarioGerente();
		Usuario u1, u2;
		List<Usuario> usuarios;
		
		u1 = new Usuario();
		u1.setNome("André");
		u1.setEmail("andregomes@gmail.com");
		u1.setLogin("andre");
		u1.setSenha("123");
		u1.setStatus(true);
		u1.setTelefone("9999991");
		u1.setTipo(1);
		
		
		ug.adicionar(u1);
		
		usuarios = ug.recuperarTodosPorNomeContendo("b");
		System.out.println("Listando usuários...");
		for(Usuario usuario: usuarios) {
			System.out.println(usuario);
		}
		
		ug.encerrar();
		
	}

}
