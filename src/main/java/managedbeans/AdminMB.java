package managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import beans.UsuarioBean;
import entities.StatusUsuario;
import entities.Usuario;
import exceptions.PersistenciaException;

@Named(value = "adminMB")
@SessionScoped
public class AdminMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private UsuarioBean usuarioBean;

	private List<Usuario> usuarios;

	@PostConstruct
	public void iniciar() {
		try {
			this.usuarios = this.usuarioBean.buscarTodosUsuarios();
		} catch (PersistenciaException ex) {
			alertarUsuario(FacesMessage.SEVERITY_ERROR, ex.getMessage());
		}
	}

	public String atualizar() {
		try {
			this.usuarios = this.usuarioBean.buscarTodosUsuarios();
		} catch (PersistenciaException ex) {
			alertarUsuario(FacesMessage.SEVERITY_ERROR, ex.getMessage());
		}

		return null;
	}

	private void alertarUsuario(final Severity gravidade, final String msg) {
		FacesMessage mensagem = new FacesMessage(gravidade, msg, null);
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}

	public String aprovar(Usuario usuario) {
		
		try {
			this.usuarioBean.atualizarStatusPorID(usuario.getId(), StatusUsuario.APROVADA);
		} catch (PersistenciaException e) {
			alertarUsuario(FacesMessage.SEVERITY_ERROR, e.getMessage());
		}
		atualizar();
		return null;
	}
	
	public String recusar(Usuario usuario) {
		try {
			this.usuarioBean.atualizarStatusPorID(usuario.getId(), StatusUsuario.REJEITADA);
		} catch (PersistenciaException e) {
			alertarUsuario(FacesMessage.SEVERITY_ERROR, e.getMessage());
		}
		atualizar();
		return null;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
