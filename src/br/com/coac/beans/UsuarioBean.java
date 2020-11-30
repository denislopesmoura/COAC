package br.com.coac.beans;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.coac.entities.Usuario;

/**
 * Classe EJB que possui os métodos de manipulação e consulta do repositório de
 * usuários.
 * 
 * Esse EJB não possui estado e foi definido como uma interface local.
 * 
 * @author Carlos
 *
 */
@Stateless
@Local
public class UsuarioBean {
	// Aqui vai ficar o repositório JPA

	/**
	 * Método para salvar um usuário no repositório.
	 * 
	 * @param usuario o usuário que será salvo
	 * @return o usuário que foi salvo
	 */
	public Usuario criarUsuario(Usuario usuario) {
		return null;
	}

	/**
	 * Busca o usuário no repositório utilizando o email.
	 * 
	 * @param email email do usuário
	 * @return usuário encontrado
	 */
	public Usuario buscarUsuarioPorEmail(String email) {
		return null;
	}

	/**
	 * Busca todos os usuário salvos no repositório.
	 * 
	 * @return uma lista com todo os usuário salvos
	 */
	public List<Usuario> buscarTodosUsuarios() {
		return null;
	}

	/**
	 * Deleta o usuário do repositório.
	 * 
	 * @param usuario o usuário que será deletado
	 */
	public void deletarUsuario(Usuario usuario) {
	}

	/**
	 * Atualiza um usuário específico no repositório, utilizando o email.
	 * 
	 * @param email             o email do usuário que será atualizado
	 * @param usuarioAtualizado o usuário com os campos atualizados
	 * @return o usuário atualizado
	 */
	public Usuario atualizarUsuario(String email, Usuario usuarioAtualizado) {
		return null;
	}
}
