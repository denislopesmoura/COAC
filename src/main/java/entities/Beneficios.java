package entities;

/**
 * 
 * @author Denis Moura
 *
 */
public enum Beneficios {
	
	BP("Benefício previdenciário"),
	BA("Benefício assistencial"),
	BSD("Benefício do seguro-desemprego"),
	PTRF("Programa de transferência de renda federal"),
	BAE("Benefício do auxílio emergencial"),
	NDA("Não sou titular de nenhum benefício");
	
	private String descricao;
	
	Beneficios(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

}
