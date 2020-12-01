package br.com.coac.managedbeans;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;

import br.com.coac.beans.UsuarioBean;
import br.com.coac.entities.Usuario;

@javax.faces.bean.ManagedBean
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
