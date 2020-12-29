package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Denis Moura
 *
 */

@Entity
@Table(name="tipo_espacos_culturais")
@NamedNativeQueries(value = {
		@NamedNativeQuery(name="TipoEspacoCultural.pegarTodosEspacos", query = "SELECT * FROM tipo_espacos_culturais WHERE ativo = 1", resultClass = TipoEspacoCultural.class)
	})
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
