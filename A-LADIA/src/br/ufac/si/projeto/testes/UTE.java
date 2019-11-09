package br.ufac.si.projeto.testes;

import br.ufac.si.projeto.entidades.Usuario;
import br.ufac.si.projeto.gerentes.UsuarioGerente;

public class UTE {

	public static void main(String[] args) {

		Usuario u1 = new Usuario();
		Usuario u2 = new Usuario();
		UsuarioGerente ug = new UsuarioGerente();
/*		u1.setNome("André");
		u1.setEmail("andre@gmail.com");
		u1.setTelefone("999999999");
		u1.setTipo(1);
		u1.setStatus(true);
		u1.setLogin("andre");
		u1.setSenha(Criptografar.encriptografar("123"));
		
		u2.setNome("Felipe");
		u2.setEmail("felipe@gmail.com");
		u2.setTelefone("999456587");
		u2.setTipo(1);
		u2.setStatus(true);
		u2.setLogin("felipe");
		u2.setSenha(Criptografar.encriptografar("123"));*/
		
		ug.recuperar(4).setStatus(false);
		ug.atualizar(ug.recuperar(4));
		ug.encerrar();
	}

}
