package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name= "segmentos_culturais")
@NamedNativeQueries(value = {
	@NamedNativeQuery(name="SegmentoCultural.pegarTodosSegmentos", query = "SELECT * FROM segmentos_culturais", resultClass = SegmentoCultural.class)
})
public class SegmentoCultural extends Entidade {
	
	private static final long serialVersionUI = 1L;
	
	@NotEmpty
	@Column(nullable = false, name = "nome")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
