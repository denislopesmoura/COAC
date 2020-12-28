package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tipo_espacos_culturais")
public class TipoEspacoCultural extends Entidade {

	private static final long serialVersionUI = 1L;
	
	@NotEmpty
	@Column(nullable = false, name = "nome")
	private String nome;
	
	@NotEmpty
	@NotNull
	@Column(nullable = false, name = "ativo")
	private boolean ativo;

	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
