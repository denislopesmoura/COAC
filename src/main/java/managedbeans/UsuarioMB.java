package managedbeans;

import java.io.Serializable;
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
import entities.Usuario;
import exceptions.ArquivoException;
import exceptions.PersistenciaException;

/**
 * 
 * @author Carlos
 *
 */
@Named(value = "usuarioMB")
@SessionScoped
public class UsuarioMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private UsuarioBean usuarioBean;

	private Usuario usuario;

	private UploadedFile foto;
	private UploadedFile comprovanteResidencia;

	private Date dataNascimento;

	@PostConstruct
	public void iniciar() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();

		this.usuario = (Usuario) sessionMap.get("User");
		this.dataNascimento = this.usuario.getDataNascimento().getTime();
	}

	public String deletarUsuario() {
		try {
			this.usuarioBean.deletarUsuario(usuario.getId());
			this.usuario = null;

			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

			request.logout();
			((HttpSession) context.getExternalContext().getSession(false)).invalidate();

			alertarUsuario(FacesMessage.SEVERITY_INFO, "Usuário apagado com sucesso!");
		} catch (PersistenciaException ex) {
			alertarUsuario(FacesMessage.SEVERITY_ERROR, ex.getMessage());
		} catch (ServletException e) {
			alertarUsuario(FacesMessage.SEVERITY_ERROR, "Falha ao realizar logout!");
			e.printStackTrace();
		}

		return "/login";
	}

	public String editar() {
		try {
			this.usuario.setDataNascimento(dataNascimento);
			this.usuario.setFoto(arquivoConverter(foto));
			this.usuario.getEndereco().setComprovante(arquivoConverter(comprovanteResidencia));

			this.usuarioBean.atualizarUsuario(this.usuario);

			alertarUsuario(FacesMessage.SEVERITY_INFO, "Usuário atualizado com sucesso!");

			return "/usuario/usuario";
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

	private void alertarUsuario(final Severity gravidade, final String msg) {
		FacesMessage mensagem = new FacesMessage(gravidade, msg, null);
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
