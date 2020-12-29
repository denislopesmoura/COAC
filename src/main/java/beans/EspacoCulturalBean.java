package beans;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import entities.EspacoCultural;
import exceptions.PersistenciaException;
import persistence.EspacoCulturalPersistencia;

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
	
	@EJB
	private EspacoCulturalPersistencia espacoCulturalPersistencia;

	public void criarEspaco(EspacoCultural espacoCultural) throws PersistenciaException {
		
		
		this.espacoCulturalPersistencia.adicionarEspacoCultural(espacoCultural);

		/* m�todo cria e adiciona um novo centro cultural */
	}

	public EspacoCultural buscarCentroPorCnpj(String cnpj) throws PersistenciaException {
		
		return this.espacoCulturalPersistencia.pegarEspacosPorCnpj(cnpj);
		
	}

	public List<EspacoCultural> buscarTodosOsCentros() throws PersistenciaException {
		
		return this.espacoCulturalPersistencia.pegarTodosEspacos();
		

		/*
		 * m�todo mostra uma lista com todos os centros culturais salvos no banco de
		 * dados
		 */
	}

	public void apagarEspacoPorCnpj(String cnpj) throws PersistenciaException {
		
		this.espacoCulturalPersistencia.removerEspacoPorCnpj(cnpj);
		
		/* deleta um espa�o cultural salvo no banco */
	}

	public void atualizarEspaco(EspacoCultural espacoCultural) throws PersistenciaException {
		
		this.espacoCulturalPersistencia.atualizarEspaco(espacoCultural);
			
		 
		
		/* atualiza informa��es importantes sobre o espa�o cultural no banco */
	}

}
