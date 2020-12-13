package entities;

import java.io.File;
import java.util.List;

/**
 * 
 * @author Carlos
 *
 */
public class Trabalhador {
	private String nomeArtistico;
	private String mei;
	private String cor;
	private String genero;
	private String escolaridade;
	private String profissao;
	private boolean drt;
	private List<EspacoCultural> espacoCultural;
	private List<String> segmentoCultural;
	private File curriculoArtistico;
	private String facebook;
	private String instagram;
	private String youtube;
	private String repositorioOnline;
	private String rendaMensalProducoesCulturais;
	private String rendaAnual2018;
	private List<String> beneficios;
	private List<File> cadastros;
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

	public List<EspacoCultural> getEspacoCultural() {
		return espacoCultural;
	}

	public void setEspacoCultural(List<EspacoCultural> espacoCultural) {
		this.espacoCultural = espacoCultural;
	}

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
