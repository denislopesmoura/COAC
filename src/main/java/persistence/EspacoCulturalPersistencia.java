package persistence;

import java.util.List;

import javax.persistence.TypedQuery;

import entities.EspacoCultural;
import exceptions.PersistenciaException;

public class EspacoCulturalPersistencia extends EntidadePersistencia<EspacoCultural> {

	public void configurar() {
		this.setClasse(EspacoCultural.class);
	}

	public void adicionarEspacoCultural(EspacoCultural EspacoCultural) throws PersistenciaException {

		this.persistir(EspacoCultural);

	}

	public List<EspacoCultural> pegarTodosEspacos() throws PersistenciaException {
		try {

			TypedQuery<EspacoCultural> typeQuery = this.getEntityManager()
					.createNamedQuery("EspacoCultural.pegarTodosEspacos", EspacoCultural.class);

			return typeQuery.getResultList();

		} catch (Exception e) {
			throw new PersistenciaException("Ocorreu um problema ao tentar pegar todos os segmentos");
		}

	}

	public EspacoCultural pegarEspacoPorId(Long id) throws PersistenciaException {
		return this.pegarPorId(id);
	}

	
	public void removerEspacoPorCnpj(String cnpj) throws PersistenciaException {
			
		EspacoCultural centroCultural = pegarEspacosPorCnpj(cnpj);
		
		this.removerPorId(centroCultural.getId());
	}

	public void atualizarEspaco(EspacoCultural EspacoCultural) throws PersistenciaException {
		this.atualizar(EspacoCultural);
	}

	public EspacoCultural pegarEspacosPorCnpj(String cnpj) throws PersistenciaException {
		try {

			TypedQuery<EspacoCultural> typeQuery = this.getEntityManager()
					.createNamedQuery("EspacoCultural.pegarEspacosPorCnpj", EspacoCultural.class);

			typeQuery.setParameter(1, cnpj);

			return typeQuery.getSingleResult();

		} catch (Exception e) {
			throw new PersistenciaException("ocorreu um problema ao tentar filtrar o centro por cnpj");
		}

	}

}
