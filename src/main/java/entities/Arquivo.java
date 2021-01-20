package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Carlos
 *
 */
@Entity
@Table(name = "arquivos")
public class Arquivo extends Entidade {

	private static final long serialVersionUID = 1L;

	@NotNull
	@NotEmpty
	@Column(nullable = false, name = "nome")
	private String nome;

	@NotNull
	@Lob
	@Column(nullable = false, name = "conteudo")
	private byte[] conteudo;

	@NotNull
	@NotEmpty
	@Column(nullable = false, name = "tipo")
	private String tipo;

	public Arquivo() {
	}

	public Arquivo(String nome, byte[] conteudo, String tipo) {
		setNome(nome);
		setConteudo(conteudo);
		setTipo(tipo);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome == null)
			throw new IllegalArgumentException("nome não pode ser nulo");
		if (nome.isEmpty())
			throw new IllegalArgumentException("nome não pode ser vazio");

		this.nome = nome;
	}

	public byte[] getConteudo() {
		return conteudo;
	}

	public void setConteudo(byte[] conteudo) {
		if (conteudo == null)
			throw new IllegalArgumentException("conteudo não pode ser nulo");
		if (conteudo.length == 0)
			throw new IllegalArgumentException("conteudo não pode ser vazio");

		this.conteudo = conteudo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		if (tipo == null)
			throw new IllegalArgumentException("tipo não pode ser nulo");
		if (tipo.isEmpty())
			throw new IllegalArgumentException("tipo não pode ser vazio");

		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return String.format("Arquivo(id: %d, nome: %s, conteudo: %s, tipo: %s)", getId(), this.nome, this.conteudo,
				this.tipo);
	}
}
