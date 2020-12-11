package managedbeans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

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
import entities.Endereco;
import entities.Usuario;

@Named(value = "usuariosMB")
@SessionScoped
public class UsuarioMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private UsuarioBean usuarioBean;

	private Usuario usuario;
	private Endereco endereco;

	private UploadedFile foto;
	private UploadedFile comprovanteResidencia;

	private Date dataNascimento;

	@PostConstruct
	public void iniciar() {
		usuario = new Usuario();
		endereco = new Endereco();
		dataNascimento = new Date();
	}

	public void criarUsuario() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataNascimento);
		this.usuario.setDataNascimento(calendar);

		Arquivo arquivoFoto = new Arquivo();
		arquivoFoto.setNome(FilenameUtils.getBaseName(foto.getFileName()));
		arquivoFoto.setConteudo(foto.getContent());
		arquivoFoto.setTipo(FilenameUtils.getExtension(foto.getFileName()));
		this.usuario.setFoto(arquivoFoto);

		Arquivo arquivoComprovanteResidencia = new Arquivo();
		arquivoComprovanteResidencia.setNome(FilenameUtils.getBaseName(comprovanteResidencia.getFileName()));
		arquivoComprovanteResidencia.setConteudo(comprovanteResidencia.getContent());
		arquivoComprovanteResidencia.setTipo(FilenameUtils.getExtension(comprovanteResidencia.getFileName()));
		this.endereco.setComprovante(arquivoComprovanteResidencia);
		this.usuario.setEndereco(endereco);

		this.usuarioBean.criarUsuario(usuario);

		FacesMessage message = new FacesMessage("Usuário criado com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, message);
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public UploadedFile getComprovanteResidencia() {
		return comprovanteResidencia;
	}

	public void setComprovanteResidencia(UploadedFile comprovanteResidencia) {
		this.comprovanteResidencia = comprovanteResidencia;
	}
}
