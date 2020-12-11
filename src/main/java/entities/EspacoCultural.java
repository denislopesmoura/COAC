package entities;

import java.io.File;
import java.util.List;

/**
 * 
 * @author Carlos
 *
 */
public class EspacoCultural {
	private String emailEspacoCultural;
	private String razaoSocial;
	private String nomeFantasia;
	private String cnpj;
	private Endereco endereco;
	private String telefone;
	private String tipoEspacoCultural;
	private List<String> linguagensCulturais;
	private List<String> modalidades;
	private List<File> imagens;
	private String descricao;
	private String facebook;
	private String instagram;
	private String youtube;
	private String repositorioOnline;

	public String getEmailEspacoCultural() {
		return emailEspacoCultural;
	}

	public void setEmailEspacoCultural(String emailEspacoCultural) {
		this.emailEspacoCultural = emailEspacoCultural;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTipoEspacoCultural() {
		return tipoEspacoCultural;
	}

	public void setTipoEspacoCultural(String tipoEspacoCultural) {
		this.tipoEspacoCultural = tipoEspacoCultural;
	}

	public List<String> getLinguagensCulturais() {
		return linguagensCulturais;
	}

	public void setLinguagensCulturais(List<String> linguagensCulturais) {
		this.linguagensCulturais = linguagensCulturais;
	}

	public List<String> getModalidades() {
		return modalidades;
	}

	public void setModalidades(List<String> modalidades) {
		this.modalidades = modalidades;
	}

	public List<File> getImagens() {
		return imagens;
	}

	public void setImagens(List<File> imagens) {
		this.imagens = imagens;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getYoutube() {
		return youtube;
	}

	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}

	public String getRepositorioOnline() {
		return repositorioOnline;
	}

	public void setRepositorioOnline(String repositorioOnline) {
		this.repositorioOnline = repositorioOnline;
	}
}
