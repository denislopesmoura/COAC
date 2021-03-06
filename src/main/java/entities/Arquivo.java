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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public byte[] getConteudo() {
		return conteudo;
	}

	public void setConteudo(byte[] conteudo) {
		this.conteudo = conteudo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
