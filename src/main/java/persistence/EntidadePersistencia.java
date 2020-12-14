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

	protected boolean removerPorId(final Long id) {
		boolean removido = false;
		T entidade = pegarPorId(id);

		if (entidade != null) {
			this.entityManager.remove(entidade);
			this.entityManager.flush();

			removido = true;
		}

		return removido;
	}

	protected boolean atualizar(final T entidade) {
		boolean atualizado = false;

		if (existePorId(entidade.getId())) {
			this.entityManager.merge(entidade);
			this.entityManager.flush();

			atualizado = true;
		}

		return atualizado;
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
