package entities;

import java.io.File;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Carlos
 * @author Weydson
 */
@Entity
@Table(name = "espacos_culturais")
@NamedNativeQueries(value = {
		@NamedNativeQuery(name = "EspacoCultural.pegarEspacoPorCNPJ", query = "SELECT * FROM espacos_culturais WHERE cnpj = ?", resultClass = EspacoCultural.class),
		@NamedNativeQuery(name = "EspacoCultural.pegarTodosEspacos", query = "SELECT * FROM espacos_culturais", resultClass = EspacoCultural.class)
		})
public class EspacoCultural extends Entidade{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	@Column(nullable = false, name = "email_espaco_cultural")
	private String emailEspacoCultural;
	
	@NotEmpty
	@Column(nullable = false, name = "razao_social")
	private String razaoSocial;
	
	@NotEmpty
	@Column(nullable = true, name = "nome_fantasia")
	private String nomeFantasia;
	
	@NotEmpty
	@Column(nullable = false, name = "cnpj")
	private String cnpj;
	
	@NotNull 
	@Valid
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="endereco_id")
	private Endereco endereco;
	
	@NotEmpty
	@Column(nullable = false, name = "telefone")
	private String telefone;
	
	@NotEmpty
	@Column(nullable = false, name = "tipo_espaco_cultural")
	private String tipoEspacoCultural;

	@NotNull
	@NotEmpty
	@Column(nullable = true, name = "linguagens_culturais")
	private List<String> linguagensCulturais;
	
	@NotNull
	@Column(nullable = false, name = "modalidades")
	private List<String> modalidades;
	
	@NotNull
	@Column(nullable = false, name = "imagens")
	private List<File> imagens;
	
	@NotEmpty
	@Column(nullable = false, name = "descricao")
	private String descricao;
	
	@NotEmpty
	@Column(nullable = true, name = "facebook")
	private String facebook;
	
	@NotEmpty
	@Column(nullable = true, name = "instagram")
	private String instagram;
	
	@NotEmpty
	@Column(nullable = true, name = "youtube")
	private String youtube;
	
	@NotEmpty
	@Column(nullable = true, name = "repositorio_online")
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
