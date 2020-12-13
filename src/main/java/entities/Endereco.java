package entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Carlos
 *
 */
@Entity
@Table(name = "enderecos")
public class Endereco extends Entidade {

	private static final long serialVersionUID = 1L;

	@NotNull
	@NotEmpty
	@Column(nullable = false, name = "cep")
	private String cep;

	@NotNull
	@NotEmpty
	@Column(nullable = false, name = "bairro")
	private String bairro;

	@NotNull
	@NotEmpty
	@Column(nullable = false, name = "rua")
	private String rua;

	@NotNull
	@NotEmpty
	@Column(nullable = false, name = "numero")
	private String numero;

	@NotNull
	@NotEmpty
	@Column(nullable = true, name = "complemento")
	private String complemento;

	@NotNull
	@Valid
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "comprovante_de_endereco_id")
	private Arquivo comprovante;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
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
