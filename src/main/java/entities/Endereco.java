package entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author Carlos
 *
 */
@Entity
@Table(name = "enderecos")
public class Endereco extends Entidade {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, name = "cep")
	private String cep;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(nullable = false, name = "bairro_id")
	private Bairro bairro;

	@Column(nullable = false, name = "rua")
	private String rua;

	@Column(nullable = false, name = "numero")
	private String numero;

	@Column(nullable = true, name = "complemento")
	private String complemento;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(nullable = false, name = "comprovante_de_endereco_id")
	private Arquivo comprovante;

	public Endereco() {
		this.bairro = new Bairro();
		this.comprovante = new Arquivo();
	}

	public Endereco(String cep, Bairro bairro, String rua, String numero, String complemento, Arquivo comprovante)
			throws IllegalArgumentException {
		setCep(cep);
		setBairro(bairro);
		setRua(rua);
		setNumero(numero);
		setComplemento(complemento);
		setComprovante(comprovante);
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) throws IllegalArgumentException {
		if (cep == null)
			throw new IllegalArgumentException("cep não pode ser nulo");
		if (cep.isEmpty())
			throw new IllegalArgumentException("cep não pode ser vazio");

		this.cep = cep;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) throws IllegalArgumentException {
		if (bairro == null)
			throw new IllegalArgumentException("bairro não pode ser nulo");

		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) throws IllegalArgumentException {
		if (rua == null)
			throw new IllegalArgumentException("rua não pode ser nulo");
		if (rua.isEmpty())
			throw new IllegalArgumentException("rua não pode ser vazio");

		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) throws IllegalArgumentException {
		if (numero == null)
			throw new IllegalArgumentException("número não pode ser nulo");
		if (numero.isEmpty())
			throw new IllegalArgumentException("número não pode ser vazio");

		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Arquivo getComprovante() {
		return comprovante;
	}

	public void setComprovante(Arquivo comprovante) throws IllegalArgumentException {
		if (comprovante == null)
			throw new IllegalArgumentException("comprovante de residência não pode ser nulo");

		this.comprovante = comprovante;
	}

	@Override
	public String toString() {
		return String.format(
				"Endereco(id: %d, cep: %s, bairro: %s, rua: %s, numero: %s, " + "complemento: %s, comprovante: %s)",
				getId(), this.cep, this.bairro, this.rua, this.numero, this.complemento, this.comprovante);
	}
}
