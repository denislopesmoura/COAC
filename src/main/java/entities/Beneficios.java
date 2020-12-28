package entities;

/**
 * 
 * @author Denis Moura
 *
 */
public enum Beneficios {
	
	BP("Benef�cio previdenci�rio"),
	BA("Benef�cio assistencial"),
	BSD("Benef�cio do seguro-desemprego"),
	PTRF("Programa de transfer�ncia de renda federal"),
	BAE("Benef�cio do aux�lio emergencial"),
	NDA("N�o sou titular de nenhum benef�cio");
	
	private String descricao;
	
	Beneficios(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

}
