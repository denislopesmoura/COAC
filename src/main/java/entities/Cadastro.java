package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author Carlos
 *
 */
@Entity
@Table(name = "cadastros")
public class Cadastro extends Entidade {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
