package managedbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import beans.UsuarioBean;
import entities.Usuario;

@Named
public class UsuarioMB {

	@EJB
	UsuarioBean usuarioBean;

	public void create(Usuario usuario) {
		this.usuarioBean.criarUsuario(usuario);
	}

	public Usuario getByEmail(String email) {
		return usuarioBean.buscarUsuarioPorEmail(email);
	}

	public List<Usuario> list() {
		return usuarioBean.buscarTodosUsuarios();
	}

	public void delete(Usuario usuario) {
		usuarioBean.deletarUsuario(usuario);
	}

	public Usuario atualizar(String email, Usuario usuario) {
		return usuarioBean.atualizarUsuario(email, usuario);
	}

}
