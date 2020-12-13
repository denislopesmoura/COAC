package managedbeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.model.file.UploadedFile;

import beans.UsuarioBean;
import entities.Arquivo;
import entities.Usuario;
import exceptions.ResourceAlreadyExistsException;

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
		usuario = new Usuario();
		usuarios = new ArrayList<>();
		dataNascimento = new Date();
	}

	public void criarUsuario() throws ResourceAlreadyExistsException, IOException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataNascimento);
		this.usuario.setDataNascimento(calendar);

		this.usuario.setFoto(arquivoConverter(foto));
		this.usuario.getEndereco().setComprovante(arquivoConverter(comprovanteResidencia));

		this.usuarioBean.criarUsuario(usuario);

		FacesMessage message = new FacesMessage("Usuário criado com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, message);
		FacesContext.getCurrentInstance().getExternalContext().dispatch("listar.xhtml");

		limparCampos();
	}

	private Arquivo arquivoConverter(UploadedFile arquivoUpado) {
		Arquivo arquivo = new Arquivo();

		arquivo.setNome(FilenameUtils.getBaseName(arquivoUpado.getFileName()));
		arquivo.setConteudo(arquivoUpado.getContent());
		arquivo.setTipo(FilenameUtils.getExtension(arquivoUpado.getFileName()));

		return arquivo;
	}

	private void limparCampos() {
		usuario = new Usuario();
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
		usuarios = this.usuarioBean.buscarTodosUsuarios();

		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
