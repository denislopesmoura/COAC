package entities;

/**
 * 
 * @author Denis Moura
 *
 */
public enum Cadastro {
	
	CEC("Cadastro Estadual de Cultura"),
	CNPPC("Cadastro Nacional de Pontos e Pontões de Cultura"),
	CEPPC("Cadastro Estadual de Pontos e Pontões de Cultura"),
	SNIIC("Sistema Nacional de Informações e Indicadores Culturais (SNIIC)"),
	SICAB("Sistema de Informações Cadastrais do Artesanato Brasileiro (SICAB)"),
	NENHUM("Nenhum");
	
	private String descricao;
	
	Cadastro(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}
