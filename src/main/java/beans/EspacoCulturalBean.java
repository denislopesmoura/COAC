package beans;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import entities.EspacoCultural;
import exceptions.PersistenciaException;
import persistence.EspacoCulturalPersistencia;

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
	
	@EJB
	private EspacoCulturalPersistencia espacoCulturalPersistencia;

	public void criarEspaco(EspacoCultural espacoCultural) throws PersistenciaException {
		
		
		this.espacoCulturalPersistencia.adicionarEspacoCultural(espacoCultural);

		/* método cria e adiciona um novo centro cultural */
	}

	public EspacoCultural buscarCentroPorCnpj(String cnpj) throws PersistenciaException {
		
		return this.espacoCulturalPersistencia.pegarEspacosPorCnpj(cnpj);
		
	}

	public List<EspacoCultural> buscarTodosOsCentros() throws PersistenciaException {
		
		return this.espacoCulturalPersistencia.pegarTodosEspacos();
		

		/*
		 * método mostra uma lista com todos os centros culturais salvos no banco de
		 * dados
		 */
	}

	public void apagarEspacoPorCnpj(String cnpj) throws PersistenciaException {
		
		this.espacoCulturalPersistencia.removerEspacoPorCnpj(cnpj);
		
		/* deleta um espaço cultural salvo no banco */
	}

	public void atualizarEspaco(EspacoCultural espacoCultural) throws PersistenciaException {
		
		this.espacoCulturalPersistencia.atualizarEspaco(espacoCultural);
			
		 
		
		/* atualiza informações importantes sobre o espaço cultural no banco */
	}

}
