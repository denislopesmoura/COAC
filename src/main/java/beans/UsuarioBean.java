package beans;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import entities.Usuario;
import persistence.UsuarioPersistencia;

@Stateless
public class UsuarioBean {

	@EJB
	private UsuarioPersistencia usuarioPersistencia;

	public void criarUsuario(Usuario usuario) {
		this.usuarioPersistencia.adicionarUsuario(usuario);
	}

	public Usuario buscarUsuarioPorCpf(String cpf) {
		return null;
	}

	public List<Usuario> buscarTodosUsuarios() {
		return null;
	}

	public void deletarUsuario(Usuario usuario) {
	}

	public Usuario atualizarUsuario(String email, Usuario usuarioAtualizado) {
		return null;
	}
}
