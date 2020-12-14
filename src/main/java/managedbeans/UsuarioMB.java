package managedbeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import beans.UsuarioBean;
import entities.Arquivo;
import entities.Usuario;
import exceptions.CampoInvalidoException;
import exceptions.CpfUsuarioJaExisteException;

@Named(value = "usuariosMB")
@SessionScoped
public class UsuarioMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private UsuarioBean usuarioBean;

	private Usuario usuario;
	private List<Usuario> usuarios;

	private Part foto;
	private Part comprovanteResidencia;

	private Date dataNascimento;

	@PostConstruct
	public void iniciar() {
		this.usuario = new Usuario();
		this.usuarios = this.usuarioBean.buscarTodosUsuarios();
		this.dataNascimento = new Date();
	}

	public String criarUsuario() throws IOException {
		try {
			this.usuario.setDataNascimento(dataNascimento);
			this.usuario.setFoto(arquivoConverter(foto));
			this.usuario.getEndereco().setComprovante(arquivoConverter(comprovanteResidencia));

			this.usuarioBean.criarUsuario(usuario);
			this.usuarios = this.usuarioBean.buscarTodosUsuarios();

			limparCampos();

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário criado com sucesso!"));

			return "/usuario/listar";
		} catch (CampoInvalidoException | CpfUsuarioJaExisteException | IllegalArgumentException ex) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(ex.getMessage()));
		}

		return null;
	}

	public String deletarUsuario(Long id) {
		System.out.println("Id usuário: " + id);

		this.usuarioBean.deletarUsuario(id);

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário apagado com sucesso!"));

		this.usuarios = this.usuarioBean.buscarTodosUsuarios();

		return null;
	}

	private Arquivo arquivoConverter(Part arquivoUpado) throws IOException {
		Arquivo arquivo = new Arquivo();

		if (arquivoUpado != null) {
			String arquivoTipo = arquivoUpado.getContentType();
			String tipo = arquivoTipo.split("/")[1];

			arquivo.setNome(arquivoUpado.getSubmittedFileName());
			arquivo.setConteudo(IOUtils.toByteArray(arquivoUpado.getInputStream()));
			arquivo.setTipo(tipo);
		}

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

	public Part getFoto() {
		return foto;
	}

	public void setFoto(Part foto) {
		this.foto = foto;
	}

	public Part getComprovanteResidencia() {
		return comprovanteResidencia;
	}

	public void setComprovanteResidencia(Part comprovanteResidencia) {
		this.comprovanteResidencia = comprovanteResidencia;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
