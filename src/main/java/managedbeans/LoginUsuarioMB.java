package managedbeans;

import java.io.IOException;
import java.io.Serializable;
import java.security.Principal;
import java.util.Date;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.model.file.UploadedFile;

import beans.UsuarioBean;
import entities.Arquivo;
import entities.Grupo;
import entities.Usuario;
import exceptions.ArquivoException;
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
	private Usuario usuarioCadastro;

	private UploadedFile foto;
	private UploadedFile comprovanteResidencia;

	private Date dataNascimento;

	@PostConstruct
	public void iniciar() {
		this.usuario = new Usuario();
		this.dataNascimento = new Date();
		this.usuarioCadastro = new Usuario();
	}

	public String cadastrar() throws IOException {
		try {
			this.usuarioCadastro.setDataNascimento(dataNascimento);
			this.usuarioCadastro.setFoto(arquivoConverter(foto));
			this.usuarioCadastro.setCpf(CpfCnpjUtils.formatarCpfCnpj(this.usuarioCadastro.getCpf()));
			this.usuarioCadastro.getEndereco().setComprovante(arquivoConverter(comprovanteResidencia));

			this.usuarioBean.criarUsuario(usuarioCadastro);

			alertarUsuario(FacesMessage.SEVERITY_INFO, "Usuário criado com sucesso!");

			return irParaPaginaLogin();
		} catch (PersistenciaException ex) {
			alertarUsuario(FacesMessage.SEVERITY_ERROR, ex.getMessage());
		} catch (EJBException ex) {
			Exception e = ex.getCausedByException();
			alertarUsuario(FacesMessage.SEVERITY_INFO, e.getMessage());
		} catch (ArquivoException ex) {
			alertarUsuario(FacesMessage.SEVERITY_INFO, ex.getMessage());
		}

		return null;
	}

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

			limparFormCadastro();
			limparFormLogin();

			if (request.isUserInRole(Grupo.GRUPO_USUARIOS)) {
				return "/usuario/usuario";
			} else if (request.isUserInRole(Grupo.GRUPO_ADMIN)) {
				return "/admin/admin";
			}

		} catch (ServletException ex) {
			if (request.getUserPrincipal() != null) {
				if (request.isUserInRole(Grupo.GRUPO_USUARIOS)) {
					return "/usuario/usuario";
				} else if (request.isUserInRole(Grupo.GRUPO_ADMIN)) {
					return "/admin/admin";
				}

				alertarUsuario(FacesMessage.SEVERITY_INFO, "Você já está logado com outra conta!");
			} else {
				alertarUsuario(FacesMessage.SEVERITY_ERROR, "Seu cpf ou senha estão incorretos!");
			}
		} catch (EJBException ex) {
			Exception e = ex.getCausedByException();
			alertarUsuario(FacesMessage.SEVERITY_ERROR, e.getMessage());
		} catch (PersistenciaException ex) {
			alertarUsuario(FacesMessage.SEVERITY_ERROR, ex.getMessage());
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
			alertarUsuario(FacesMessage.SEVERITY_ERROR, "Falha ao realizar logout!");
		}
		return "/login";
	}

	public String irParaPaginaCadastro() {
		limparFormCadastro();
		limparFormLogin();

		return "/cadastro";
	}

	public String irParaPaginaLogin() {
		limparFormCadastro();
		limparFormLogin();

		return "/login";
	}

	private Arquivo arquivoConverter(final UploadedFile arquivoUpado) throws ArquivoException {
		Arquivo arquivo = new Arquivo();

		if (arquivoUpado.getFileName() == null || arquivoUpado.getContent() == null) {
			throw new ArquivoException("Os campos de foto e comprovante de residência são obrigratórios!");
		}

		arquivo.setNome(FilenameUtils.getBaseName(arquivoUpado.getFileName()));
		arquivo.setConteudo(arquivoUpado.getContent());
		arquivo.setTipo(FilenameUtils.getExtension(arquivoUpado.getFileName()));

		return arquivo;
	}

	private void limparFormCadastro() {
		this.usuarioCadastro = new Usuario();
		this.dataNascimento = new Date();
	}

	private void limparFormLogin() {
		this.cpf = null;
		this.senha = null;
	}

	private void alertarUsuario(final Severity gravidade, final String msg) {
		FacesMessage mensagem = new FacesMessage(gravidade, msg, null);
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
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

	public Usuario getUsuarioCadastro() {
		return usuarioCadastro;
	}

	public void setUsuarioCadastro(Usuario usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}

	public UploadedFile getFoto() {
		return foto;
	}

	public void setFoto(UploadedFile foto) {
		this.foto = foto;
	}

	public UploadedFile getComprovanteResidencia() {
		return comprovanteResidencia;
	}

	public void setComprovanteResidencia(UploadedFile comprovanteResidencia) {
		this.comprovanteResidencia = comprovanteResidencia;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
