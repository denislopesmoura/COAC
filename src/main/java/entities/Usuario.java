package entities;

import java.util.Calendar;
import java.util.Date;

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
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

	@Valid
	@NotNull
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "foto_id")
	private Arquivo foto;

	@NotNull
	@NotEmpty
	@Column(nullable = false, name = "nome")
	private String nome;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(nullable = false, name = "data_de_nascimento")
	private Calendar dataNascimento;

	@NotNull
	@NotEmpty
	@Column(nullable = false, unique = true, name = "cpf")
	private String cpf;

	@NotNull
	@NotEmpty
	@Column(nullable = false, name = "senha")
	private String senha;

	@NotNull
	@NotEmpty
	@Email
	@Column(nullable = false, name = "email")
	private String email;

	@NotNull
	@Valid
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@NotNull
	@NotEmpty
	@Column(nullable = false, name = "telefone")
	private String telefone;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, name = "status")        
	private StatusUsuario status;

	public StatusUsuario getStatus() {
		return status;
	}



	public void setStatus(StatusUsuario status) {
		this.status = status;
	}



	public Usuario() {
		this.endereco = new Endereco();
		this.foto = new Arquivo();
		this.status = StatusUsuario.EM_ESPERA;
	}
	


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

	public void setDataNascimento(Date dataNascimento) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataNascimento);

		this.dataNascimento = calendar;
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
