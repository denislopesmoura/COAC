package managedbeans;

import java.io.Serializable;
import java.security.Principal;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.UsuarioBean;
import entities.Grupo;
import entities.Usuario;
import exceptions.PersistenciaException;
import util.CpfCnpjUtils;

/**
 * 
 * @author Carlos
 *
 */
@Named(value = "loginUsuarioMB")
@SessionScoped
public class LoginUsuarioMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private UsuarioBean usuarioBean;

	private String cpf;
	private String senha;

	private Usuario usuario;

	public String login() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

		try {
			request.login(CpfCnpjUtils.formatarCpfCnpj(cpf), senha);

			Principal principal = request.getUserPrincipal();

			this.usuario = usuarioBean.pegarUsuarioPorCpf(principal.getName());

			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> sessionMap = externalContext.getSessionMap();
			sessionMap.put("User", usuario);

			System.out.println("Role: " + request.isUserInRole(Grupo.GRUPO_USUARIOS));

			if (request.isUserInRole(Grupo.GRUPO_USUARIOS)) {
				return "/usuario/listar";
			}

		} catch (ServletException ex) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha no login!", null));
			ex.printStackTrace();
		} catch (EJBException ex) {
			Exception e = ex.getCausedByException();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		} catch (PersistenciaException ex) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
		}

		return null;
	}

	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

		try {
			this.usuario = null;
			request.logout();
			((HttpSession) context.getExternalContext().getSession(false)).invalidate();
		} catch (ServletException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha ao realizar logout!", null));
		}
		return "/login";
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
