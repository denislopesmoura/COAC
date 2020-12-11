package entities;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
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
		@NamedNativeQuery(name = "Usuario.pegarUsuarioPorCpf", query = "SELECT * FROM usuarios WHERE cpf = ?", resultClass = Usuario.class),
		@NamedNativeQuery(name = "Usuario.pegarTodosUsuarios", query = "SELECT * FROM usuarios", resultClass = Usuario.class) })
public class Usuario extends Entidade {
	private static final long serialVersionUID = 1L;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "foto_id")
	private Arquivo foto;

	@Column(nullable = false, name = "nome")
	private String nome;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false, name = "data_de_nascimento")
	private Calendar dataNascimento;

	@Column(nullable = false, unique = true, name = "cpf")
	private String cpf;

	@Column(nullable = false, name = "email")
	private String email;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@Column(nullable = false, name = "telefone")
	private String telefone;

//	@ManyToMany
//	@JoinTable(name = "usuarios_cadastros", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "cadastro_id"))
//	private List<Cadastro> cadastros;

//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "documento_de_homologacao_id")
//	private Arquivo documentoHomologacao;

	public Arquivo getFoto() {
		return foto;
	}

	public void setFoto(Arquivo foto) {
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
}
