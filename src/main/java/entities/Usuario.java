package entities;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Carlos
 *
 */
@Entity
@Table(name = "usuarios")
@NamedNativeQueries(value = {
		@NamedNativeQuery(name = "usuario.pegarUsuarioPorCpf", query = "SELECT * FROM usuarios WHERE cpf = :cpf", resultClass = Usuario.class),
		@NamedNativeQuery(name = "usuario.pegarTodosUsuarios", query = "SELECT * FROM usuarios", resultClass = Usuario.class) })
public class Usuario extends Entidade {
	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private File foto;

	@Column(nullable = false)
	private String nome;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_de_nascimento", nullable = false)
	private Calendar dataNascimento;

	@Column(nullable = false, unique = true)
	private String cpf;

	@Column(nullable = false)
	private String email;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@Column(nullable = false)
	private String telefone;

	@Column(nullable = false)
	private String rendaMensalImpactadaPandemia;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuarios_cadastros", joinColumns = { @JoinColumn(name = "usuario_id") }, inverseJoinColumns = {
			@JoinColumn(name = "cadastro_id") })
	private List<Cadastro> cadastros;

	@Column(nullable = false)
	private File documentoHomologacao;

	public File getFoto() {
		return foto;
	}

	public void setFoto(File foto) {
		this.foto = foto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRendaMensalImpactadaPandemia() {
		return rendaMensalImpactadaPandemia;
	}

	public void setRendaMensalImpactadaPandemia(String rendaMensalImpactadaPandemia) {
		this.rendaMensalImpactadaPandemia = rendaMensalImpactadaPandemia;
	}

	public List<Cadastro> getCadastros() {
		return cadastros;
	}

	public void setCadastros(List<Cadastro> cadastros) {
		this.cadastros = cadastros;
	}

	public File getDocumentoHomologacao() {
		return documentoHomologacao;
	}

	public void setDocumentoHomologacao(File documentoHomologacao) {
		this.documentoHomologacao = documentoHomologacao;
	}
}
