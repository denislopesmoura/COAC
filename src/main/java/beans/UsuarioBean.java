package beans;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import entities.Usuario;
import exceptions.ResourceAlreadyExistsException;
import persistence.UsuarioPersistencia;

@Stateless
public class UsuarioBean {

	@EJB
	private UsuarioPersistencia usuarioPersistencia;

	public void criarUsuario(Usuario usuario) throws ResourceAlreadyExistsException {
		this.usuarioPersistencia.adicionarUsuario(usuario);
	}

	public Usuario buscarUsuarioPorCpf(String cpf) {
		return null;
	}

	public List<Usuario> buscarTodosUsuarios() {
		return this.usuarioPersistencia.pegarTodosUsuarios();
	}

	public void deletarUsuario(Usuario usuario) {
	}

	public Usuario atualizarUsuario(String email, Usuario usuarioAtualizado) {
		return null;
	}

}
