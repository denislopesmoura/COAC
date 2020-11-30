package br.com.coac.entities;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

/**
 * Usuário do sistema, que pode utilizar dos serviços permitidos a ele pelo
 * administrador.
 * 
 * @author Carlos
 *
 */
public class Usuario {
	private File foto;
	private String nome;
	private LocalDate dataNascimento;
	private String cpf;
	private String email;
	private Endereco endereco;
	private String telefone;
	private String rendaMensalImpactadaPandemia;
	private List<String> cadastros;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
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

	public List<String> getCadastros() {
		return cadastros;
	}

	public void setCadastros(List<String> cadastros) {
		this.cadastros = cadastros;
	}

	public File getDocumentoHomologacao() {
		return documentoHomologacao;
	}

	public void setDocumentoHomologacao(File documentoHomologacao) {
		this.documentoHomologacao = documentoHomologacao;
	}
}
