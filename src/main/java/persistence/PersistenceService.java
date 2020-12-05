package persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Entidade;

/**
 * 
 * @author Carlos
 *
 */
public abstract class PersistenceService<T extends Entidade> {

	@PersistenceContext(name = "COAC")
	private EntityManager entityManager;

	private Class<T> classe;

	public boolean existe(T entidade) {
		entidade = entidade.getId() == null ? null : this.entityManager.find(this.classe, entidade.getId());
		return entidade != null;
	}

	public void persistir(T entidade) {
		if (!existe(entidade)) {
			this.entityManager.persist(entidade);
		}
	}

	public void remover(T entidade) {
		if (existe(entidade)) {
			entidade = this.entityManager.merge(entidade);
			this.entityManager.remove(entidade);
			this.entityManager.flush();
		}
	}

	public void atualizar(T entidade) {
		if (existe(entidade)) {
			this.entityManager.merge(entidade);
			this.entityManager.flush();
		}
	}

	protected List<T> consultarEntidades(Object[] parametros, String nomeQuery) {
		TypedQuery<T> query = this.entityManager.createNamedQuery(nomeQuery, this.classe);

		int i = 1;
		for (Object parametro : parametros) {
			query.setParameter(i++, parametro);
		}

		return query.getResultList();
	}

	protected void setClasse(Class<T> classe) {
		this.classe = classe;
	}

	public Class<T> getClasse() {
		return classe;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
}
