package entities;

import java.io.File;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Carlos
 * @author Weydson
 */

@Entity
@Table(name = "trabalhadores")
@NamedNativeQueries(value = {
		@NamedNativeQuery(name = "Trabalhador.pegarTrabalhadorPorNome", query = "SELECT * FROM trabalhador WHERE nomeArtistico = ?", resultClass = Trabalhador.class),
		@NamedNativeQuery(name = "Trabalhador.pegarTodosTrabalhadores", query = "SELECT * FROM trabalhador", resultClass = Trabalhador.class)})
public class Trabalhador extends Entidade {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(nullable = false, name = "nome_artistico")
	private String nomeArtistico;

	@NotEmpty
	@Column(nullable = true, name = "mei")
	private String mei;

	@NotEmpty
	@Column(nullable = false, name = "cor")
	private String cor;

	@NotEmpty
	@Column(nullable = false, name = "genero")
	private String genero;

	@NotEmpty
	@Column(nullable = false, name = "escolaridade")
	private String escolaridade;

	@NotEmpty
	@Column(nullable = false, name = "profissao")
	private String profissao;

	@NotNull
	@Column(nullable = false, name = "drt")
	private boolean drt;

//	@NotNull
//	@Column(nullable = true, name = "espaco_cultural")
//	private List<EspacoCultural> espacoCultural;

	@NotNull
	@NotEmpty
	@Column(nullable = false, name = "segmento_cultural")
	private List<String> segmentoCultural;

	@NotNull
	@Column(nullable = false, name = "curriculo_artistico")
	private File curriculoArtistico;

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

	@NotEmpty
	@Column(nullable = false, name = "renda_mensal_cultural")
	private String rendaMensalProducoesCulturais;

	@NotEmpty
	@Column(nullable = false, name = "renda_anual_2018")
	private String rendaAnual2018;

	@NotEmpty
	@Column(nullable = true, name = "beneficios")
	private List<String> beneficios;

	@NotEmpty
	@Column(nullable = true, name = "homologado_cadastro")
	private List<File> cadastros;

	@NotEmpty
	@Column(nullable = true, name = "documento_homologacao")
	private File documentoHomologacao;

	public String getNomeArtistico() {
		return nomeArtistico;
	}

	public void setNomeArtistico(String nomeArtistico) {
		this.nomeArtistico = nomeArtistico;
	}

	public String getMei() {
		return mei;
	}

	public void setMei(String mei) {
		this.mei = mei;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public boolean isDrt() {
		return drt;
	}

	public void setDrt(boolean drt) {
		this.drt = drt;
	}

//	public List<EspacoCultural> getEspacoCultural() {
//		return espacoCultural;
//	}
//
//	public void setEspacoCultural(List<EspacoCultural> espacoCultural) {
//		this.espacoCultural = espacoCultural;
//	}

	public List<String> getSegmentoCultural() {
		return segmentoCultural;
	}

	public void setSegmentoCultural(List<String> segmentoCultural) {
		this.segmentoCultural = segmentoCultural;
	}

	public File getCurriculoArtistico() {
		return curriculoArtistico;
	}

	public void setCurriculoArtistico(File curriculoArtistico) {
		this.curriculoArtistico = curriculoArtistico;
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

	public String getRendaMensalProducoesCulturais() {
		return rendaMensalProducoesCulturais;
	}

	public void setRendaMensalProducoesCulturais(String rendaMensalProducoesCulturais) {
		this.rendaMensalProducoesCulturais = rendaMensalProducoesCulturais;
	}

	public String getRendaAnual2018() {
		return rendaAnual2018;
	}

	public void setRendaAnual2018(String rendaAnual2018) {
		this.rendaAnual2018 = rendaAnual2018;
	}

	public List<String> getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(List<String> beneficios) {
		this.beneficios = beneficios;
	}

	public List<File> getCadastros() {
		return cadastros;
	}

	public void setCadastros(List<File> cadastros) {
		this.cadastros = cadastros;
	}

	public File getDocumentoHomologacao() {
		return documentoHomologacao;
	}

	public void setDocumentoHomologacao(File documentoHomologacao) {
		this.documentoHomologacao = documentoHomologacao;
	}
}
