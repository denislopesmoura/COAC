package persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Entidade;
import exceptions.PersistenciaException;

/**
 * 
 * @author Carlos
 *
 */
public abstract class EntidadePersistencia<T extends Entidade> {

	@PersistenceContext(name = "COAC")
	private EntityManager entityManager;

	private Class<T> classe;

	protected void persistir(final T entidade) throws PersistenciaException {
		try {
			this.entityManager.persist(entidade);
		} catch (Exception ex) {
			throw new PersistenciaException("Ocorreu um problema ao salvar a entidade, por favor, tente novamente");
		}
	}

	protected T pegarPorId(final Long id) throws PersistenciaException {
		if (existePorId(id)) {
			return this.entityManager.find(this.classe, id);
		} else {
			throw new PersistenciaException(
					"Não foi possível encontrar a entidade " + classe.getCanonicalName() + " com id " + id);
		}
	}

	protected void removerPorId(final Long id) throws PersistenciaException {
		T entidade = pegarPorId(id);

		if (entidade != null) {
			this.entityManager.remove(entidade);
			this.entityManager.flush();
		} else {
			throw new PersistenciaException(
					"Não foi possível remover a entidade " + classe.getCanonicalName() + " com id " + id);
		}
	}

	protected void atualizar(final T entidade) throws PersistenciaException {
		if (existePorId(entidade.getId())) {
			this.entityManager.merge(entidade);
			this.entityManager.flush();
		} else {
			throw new PersistenciaException("Não foi possível atualizar a entidade " + classe.getCanonicalName()
					+ " com id " + entidade.getId());
		}
	}

	protected boolean existePorId(final Long id) {
		boolean existe = false;

		if (this.entityManager.find(this.classe, id) != null) {
			existe = true;
		}

		return existe;
	}

	protected void setClasse(final Class<T> classe) {
		this.classe = classe;
	}

	protected Class<T> getClasse() {
		return classe;
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}
}
