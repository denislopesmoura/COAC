package beans;

import java.awt.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import entities.EspacoCultural;

/**
 * Classe EJB que possui os métodos de manipulação e consulta do repositório de
 * centros culturais.
 * 
 * Esse EJB não possui estado e foi definido como uma interface local.
 * 
 * @author Hugo
 *
 */

@Stateless
@Local
public class EspacoCulturalBean {

	public EspacoCultural criarEspaco(EspacoCultural espacoCultural) {
		return null;

		/* método cria e adiciona um novo centro cultural */
	}

	public EspacoCultural buscarCentroPorCnpj(String cnpj) {
		return null;

		/* método busca um centro cultural pelo cnpj de cadastro */
	}

	public List buscarTodosOsCentros() {
		return null;

		/*
		 * método mostra uma lista com todos os centros culturais salvos no banco de
		 * dados
		 */
	}

	public void apagarEspaco(EspacoCultural espacocultural) {
		/* deleta um espaço cultural salvo no banco */
	}

	public EspacoCultural atualizarEspaco(String tipoEspacoCultural, String telefone, String endereco) {
		return null;
		/* atualiza informações importantes sobre o espaço cultural no banco */
	}

}
