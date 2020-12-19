package managedbeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.model.file.UploadedFile;

import beans.UsuarioBean;
import entities.Arquivo;
import entities.Usuario;
import exceptions.ArquivoException;
import exceptions.PersistenciaException;
import util.CpfCnpjUtils;

/**
 * 
 * @author Carlos
 *
 */
@Named(value = "usuariosMB")
@SessionScoped
public class UsuarioMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private UsuarioBean usuarioBean;

	private Usuario usuario;
	private List<Usuario> usuarios;

	private UploadedFile foto;
	private UploadedFile comprovanteResidencia;

	private Date dataNascimento;

	@PostConstruct
	public void iniciar() {
		try {
			this.usuario = new Usuario();
			this.usuarios = this.usuarioBean.buscarTodosUsuarios();
			this.dataNascimento = new Date();
		} catch (PersistenciaException ex) {
			alertarUsuario(FacesMessage.SEVERITY_ERROR, ex.getMessage());
		}
	}

	public String criarUsuario() throws IOException {
		try {
			this.usuario.setDataNascimento(dataNascimento);
			this.usuario.setFoto(arquivoConverter(foto));
			this.usuario.setCpf(CpfCnpjUtils.formatarCpfCnpj(this.usuario.getCpf()));
			this.usuario.getEndereco().setComprovante(arquivoConverter(comprovanteResidencia));

			this.usuarioBean.criarUsuario(usuario);
			this.usuarios = this.usuarioBean.buscarTodosUsuarios();

			limparCampos();

			alertarUsuario(FacesMessage.SEVERITY_INFO, "Usuário criado com sucesso!");

			return "/usuario/listar";
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

	public String deletarUsuario(final Long id) {
		try {
			this.usuarioBean.deletarUsuario(id);
			this.usuarios = this.usuarioBean.buscarTodosUsuarios();

			alertarUsuario(FacesMessage.SEVERITY_INFO, "Usuário apagado com sucesso!");
		} catch (PersistenciaException ex) {
			alertarUsuario(FacesMessage.SEVERITY_ERROR, ex.getMessage());
		}

		return null;
	}

	public String editarUsuario() {
		try {
			this.usuario.setDataNascimento(dataNascimento);
			this.usuario.setFoto(arquivoConverter(foto));
			this.usuario.setCpf(CpfCnpjUtils.formatarCpfCnpj(this.usuario.getCpf()));
			this.usuario.getEndereco().setComprovante(arquivoConverter(comprovanteResidencia));

			this.usuarioBean.atualizarUsuario(this.usuario);

			limparCampos();

			alertarUsuario(FacesMessage.SEVERITY_INFO, "Usuário atualizado com sucesso!");

			return "/usuario/listar";
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

	public String irParaPaginaEdicao(final Usuario u) {
		this.usuario = u;
		this.dataNascimento = u.getDataNascimento().getTime();

		return "/usuario/editar";
	}

	public String voltarParaPaginaListagem() {
		limparCampos();

		return "/usuario/listar";
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

	private void limparCampos() {
		usuario = new Usuario();
		dataNascimento = new Date();
	}

	private void alertarUsuario(final Severity gravidade, final String msg) {
		FacesMessage mensagem = new FacesMessage(gravidade, msg, null);
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
