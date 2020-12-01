package br.com.coac.entities;

import java.io.File;

/**
 * Classe que possui as informa��es b�sicas de um endere�o, al�m de um
 * comprovante, para provar que aquele local pertence a uma determinada pessoa
 * ou institui��o.
 * 
 * @author Carlos
 *
 */
public class Endereco {
	private String cep;
	private String bairro;
	private String rua;
	private String numero;
	private String complemento;
	private File comprovante;

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

	public File getComprovante() {
		return comprovante;
	}

	public void setComprovante(File comprovante) {
		this.comprovante = comprovante;
	}

}
