package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Denis Moura
 */

@Entity
@Table(name= "segmentos_culturais")
@NamedNativeQueries(value = {
	@NamedNativeQuery(name="SegmentoCultural.pegarTodosSegmentos", query = "SELECT * FROM segmentos_culturais WHERE ativo = 1", resultClass = SegmentoCultural.class)
})
public class SegmentoCultural extends Entidade {
	
	private static final long serialVersionUI = 1L;
	
	@NotEmpty
	@Column(nullable = false, name = "nome")
	private String nome;
	
	@NotEmpty
	@NotNull
	@Column(nullable = false, name = "ativo")
	private boolean ativo;
	
	public SegmentoCultural() {
		this.ativo = true;
	}
	
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
