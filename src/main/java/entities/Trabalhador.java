package entities;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.persistence.JoinTable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Carlos
 * @author Weydson
 * @author Denis Moura
 */

@Entity
@Table(name = "trabalhadores")
@NamedNativeQueries(value = {
		@NamedNativeQuery(name = "Trabalhador.pegarTrabalhadorPorNome", query = "SELECT * FROM trabalhadores WHERE nomeArtistico = ?", resultClass = Trabalhador.class),
		@NamedNativeQuery(name = "Trabalhador.pegarTodosTrabalhadores", query = "SELECT * FROM trabalhadores", resultClass = Trabalhador.class),
		@NamedNativeQuery(name = "Trabalhador.pegarPorMei", query = "SELECT * FROM trabalhadores WHERE mei = ?", resultClass = Trabalhador.class)
})
public class Trabalhador extends Entidade {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(nullable = false, name = "nome_artistico")
	private String nomeArtistico;

	@NotEmpty
	@Column(nullable = true, name = "mei")
	private String mei;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, name = "cor")
	private Cor cor;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, name = "genero")
	private Genero genero;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, name = "escolaridade")
	private Escolaridade escolaridade;

	
	@Column(nullable = false, name = "profissao")
	private String profissao;

	
	@Column(nullable = false, name = "drt")
	private boolean drt;
	
	//Relacionamento n-to-n entre os espacos culturais e o trabalhador. 
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "trabalhador_tipo_espaco_cultural",
				joinColumns = @JoinColumn (name = "trabalhador_id"),
				inverseJoinColumns = @JoinColumn(name = "tipo_espaco_cultural_id")
	)
	private Set<TipoEspacoCultural> espacoCultural = new HashSet<TipoEspacoCultural>();
	
	//Relacionamento n-to-n entre os segmentos culturais e o trabalhador. 
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "trabalhador_segmento_cultural",
				joinColumns = @JoinColumn (name = "trabalhador_id"),
				inverseJoinColumns = @JoinColumn(name = "segmento_cultural_id")
	)
	private Set<SegmentoCultural> segmentoCultural = new HashSet<SegmentoCultural>();

	
	@Column(nullable = false, name = "curriculo_artistico")
	private File curriculoArtistico;

	
	@Column(nullable = true, name = "facebook")
	private String facebook;

	
	@Column(nullable = true, name = "instagram")
	private String instagram;

	
	@Column(nullable = true, name = "youtube")
	private String youtube;

	
	@Column(nullable = true, name = "repositorio_online")
	private String repositorioOnline;

	
	@Column(nullable = false, name = "renda_mensal_cultural")
	private String rendaMensalProducoesCulturais;

	
	@Column(nullable = false, name = "renda_anual_2018")
	private String rendaAnual2018;

	@Enumerated(EnumType.STRING)
	@Column(nullable = true, name = "beneficios")
	private List<Beneficios> beneficios;

	
	@Column(nullable = true, name = "homologado_cadastro")
	private List<File> cadastros;

	
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

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Escolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Escolaridade escolaridade) {
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

	public Set<TipoEspacoCultural> getEspacoCultural() {
		return espacoCultural;
	}

	public void setEspacoCultural(Set<TipoEspacoCultural> espacoCultural) {
		this.espacoCultural = espacoCultural;
	}

	public Set<SegmentoCultural> getSegmentoCultural() {
		return segmentoCultural;
	}

	public void setSegmentoCultural(Set<SegmentoCultural> segmentoCultural) {
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

	public List<Beneficios> getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(List<Beneficios> beneficios) {
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
