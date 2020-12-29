package beans;

import java.awt.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import entities.EspacoCultural;

/**
 * Classe EJB que possui os m�todos de manipula��o e consulta do reposit�rio de
 * centros culturais.
 * 
 * Esse EJB n�o possui estado e foi definido como uma interface local.
 * 
 * @author Hugo
 *
 */

@Stateless
@Local
public class EspacoCulturalBean {

	public EspacoCultural criarEspaco(EspacoCultural espacoCultural) {
		return null;

		/* m�todo cria e adiciona um novo centro cultural */
	}

	public EspacoCultural buscarCentroPorCnpj(String cnpj) {
		return null;

		/* m�todo busca um centro cultural pelo cnpj de cadastro */
	}

	public List buscarTodosOsCentros() {
		return null;

		/*
		 * m�todo mostra uma lista com todos os centros culturais salvos no banco de
		 * dados
		 */
	}

	public void apagarEspaco(EspacoCultural espacocultural) {
		/* deleta um espa�o cultural salvo no banco */
	}

	public EspacoCultural atualizarEspaco(String tipoEspacoCultural, String telefone, String endereco) {
		return null;
		/* atualiza informa��es importantes sobre o espa�o cultural no banco */
	}

}
