package entities;

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

	@Column(nullable = false)
	private String cep;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bairro_id")
	private Bairro bairro;

	@Column(nullable = false)
	private String rua;

	@Column(nullable = false)
	private String numero;

	@Column
	private String complemento;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comprovante_id")
	private Arquivo comprovante;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
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

	public void setComprovante(Arquivo comprovante) {
		this.comprovante = comprovante;
	}
}
