package entities;

/**
 * 
 * @author Denis Moura
 *
 */

public enum Escolaridade {
	
	EFI("Ensino Fundamental Incompleto"),
	EFC("Ensino Fundamental Completo"),
	EMI("Ensino Médio Incompleto"),
	EMC("Ensino Médio Completo"),
	ESI("Ensino Superior Incompleto"),
	ESC("Ensino Superior Completo");
	
	private String descricao;
	
	Escolaridade(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	

}
