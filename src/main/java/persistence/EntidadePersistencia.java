package persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Entidade;

/**
 * 
 * @author Carlos
 *
 */
public abstract class EntidadePersistencia<T extends Entidade> {

	@PersistenceContext(name = "COAC")
	private EntityManager entityManager;

	private Class<T> classe;

	protected void persistir(final T entidade) {
		this.entityManager.persist(entidade);
	}

	protected T pegarPorId(final Long id) {
		if (existePorId(id)) {
			return this.entityManager.find(this.classe, id);
		} else {
			return null;
		}
	}

	protected void removerPorId(final Long id) {
		final T entidade = pegarPorId(id);

		this.entityManager.remove(entidade);
		this.entityManager.flush();
	}

	protected void atualizar(final T entidade) {
		if (existePorId(entidade.getId())) {
			this.entityManager.merge(entidade);
			this.entityManager.flush();
		}
	}

	protected boolean existePorId(final Long id) {
		if (this.entityManager.find(this.classe, id) == null) {
			return false;
		} else {
			return true;
		}
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
