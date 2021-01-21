package entities;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	@JoinColumn(nullable = false, name = "foto_id")
	private Arquivo foto;

	@Column(nullable = false, name = "nome")
	private String nome;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false, name = "data_de_nascimento")
	private Calendar dataNascimento;

	@Column(nullable = false, unique = true, name = "cpf")
	private String cpf;

	@Column(nullable = false, name = "senha")
	private String senha;

	@Column(nullable = false, name = "email")
	private String email;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(nullable = false, name = "endereco_id")
	private Endereco endereco;

	@Column(nullable = false, name = "telefone")
	private String telefone;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, name = "status")
	private StatusUsuario status;

	public Usuario() {
		this.foto = new Arquivo();
		this.endereco = new Endereco();
		this.dataNascimento = Calendar.getInstance();
		this.status = StatusUsuario.EM_ESPERA;
	}

	public Usuario(Arquivo foto, String nome, Calendar dataNascimento, String cpf, String senha, String email,
			Endereco endereco, String telefone, StatusUsuario status) throws IllegalArgumentException {
		setFoto(foto);
		setNome(nome);
		setDataNascimento(dataNascimento);
		setCpf(cpf);
		setSenha(senha);
		setEmail(email);
		setEndereco(endereco);
		setTelefone(telefone);
		setStatus(status);
	}

	public Arquivo getFoto() {
		return foto;
	}

	public void setFoto(Arquivo foto) throws IllegalArgumentException {
		if (foto == null)
			throw new IllegalArgumentException("foto não pode ser nulo");

		this.foto = foto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws IllegalArgumentException {
		if (nome == null)
			throw new IllegalArgumentException("nome não pode ser nulo");
		if (nome.isEmpty())
			throw new IllegalArgumentException("nome não pode ser vazio");

		this.nome = nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) throws IllegalArgumentException {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws IllegalArgumentException {
		if (cpf == null)
			throw new IllegalArgumentException("cpf não pode ser nulo");
		if (cpf.isEmpty())
			throw new IllegalArgumentException("cpf não pode ser vazio");

		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) throws IllegalArgumentException {
		if (senha == null)
			throw new IllegalArgumentException("senha não pode ser nulo");
		if (senha.isEmpty())
			throw new IllegalArgumentException("senha não pode ser vazio");

		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws IllegalArgumentException {
		if (email == null)
			throw new IllegalArgumentException("email não pode ser nulo");
		if (email.isEmpty())
			throw new IllegalArgumentException("email não pode ser vazio");

		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) throws IllegalArgumentException {
		if (endereco == null)
			throw new IllegalArgumentException("endereço não pode ser nulo");

		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) throws IllegalArgumentException {
		if (telefone == null)
			throw new IllegalArgumentException("telefone não pode ser nulo");
		if (telefone.isEmpty())
			throw new IllegalArgumentException("telefone não pode ser vazio");

		this.telefone = telefone;
	}

	public StatusUsuario getStatus() {
		return status;
	}

	public void setStatus(StatusUsuario status) throws IllegalArgumentException {
		if (status == null)
			throw new IllegalArgumentException("status não pode ser nulo");

		this.status = status;
	}

	@Override
	public String toString() {
		return String.format(
				"Usuario(id: %d, foto: %s, nome: %s, dataNascimento: %s, cpf: %s, senha: %s, email: %s, endereco: %s, status: %s)",
				getId(), this.foto, this.nome, this.dataNascimento.getTime(), this.cpf, this.senha, this.email,
				this.endereco, this.telefone, this.status);
	}

}
