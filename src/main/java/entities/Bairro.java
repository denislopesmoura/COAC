package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bairros")
public class Bairro extends Entidade {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, name = "bairro")
	private String bairro;

	public Bairro() {
	}

	public Bairro(String bairro) throws IllegalArgumentException {
		setBairro(bairro);
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) throws IllegalArgumentException {
		if (bairro == null)
			throw new IllegalArgumentException("bairro não pode ser nulo");
		if (bairro.isEmpty())
			throw new IllegalArgumentException("bairro não pode ser vazio");

		this.bairro = bairro;
	}

	@Override
	public String toString() {
		return String.format("Bairro(id: %d, bairro: %s)", getId(), this.bairro);
	}
}
