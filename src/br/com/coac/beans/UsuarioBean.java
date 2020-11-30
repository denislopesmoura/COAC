package br.com.coac.beans;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.coac.entities.Usuario;

/**
 * Classe EJB que possui os m�todos de manipula��o e consulta do reposit�rio de
 * usu�rios.
 * 
 * Esse EJB n�o possui estado e foi definido como uma interface local.
 * 
 * @author Carlos
 *
 */
@Stateless
@Local
public class UsuarioBean {
	// Aqui vai ficar o reposit�rio JPA

	/**
	 * M�todo para salvar um usu�rio no reposit�rio.
	 * 
	 * @param usuario o usu�rio que ser� salvo
	 * @return o usu�rio que foi salvo
	 */
	public Usuario criarUsuario(Usuario usuario) {
		return null;
	}

	/**
	 * Busca o usu�rio no reposit�rio utilizando o email.
	 * 
	 * @param email email do usu�rio
	 * @return usu�rio encontrado
	 */
	public Usuario buscarUsuarioPorEmail(String email) {
		return null;
	}

	/**
	 * Busca todos os usu�rio salvos no reposit�rio.
	 * 
	 * @return uma lista com todo os usu�rio salvos
	 */
	public List<Usuario> buscarTodosUsuarios() {
		return null;
	}

	/**
	 * Deleta o usu�rio do reposit�rio.
	 * 
	 * @param usuario o usu�rio que ser� deletado
	 */
	public void deletarUsuario(Usuario usuario) {
	}

	/**
	 * Atualiza um usu�rio espec�fico no reposit�rio, utilizando o email.
	 * 
	 * @param email             o email do usu�rio que ser� atualizado
	 * @param usuarioAtualizado o usu�rio com os campos atualizados
	 * @return o usu�rio atualizado
	 */
	public Usuario atualizarUsuario(String email, Usuario usuarioAtualizado) {
		return null;
	}
}
