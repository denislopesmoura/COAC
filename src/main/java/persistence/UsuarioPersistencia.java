package persistence;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import entities.Usuario;

@Stateless
public class UsuarioPersistencia extends EntidadePersistencia<Usuario> {

	@PostConstruct
	public void configurar() {
		super.setClasse(Usuario.class);
	}

	public void adicionarUsuario(final Usuario usuario) {
		if (!existePorCpf(usuario.getCpf())) {
			super.persistir(usuario);
		}
	}

	public Usuario pegarUsuarioPorCpf(final String cpf) throws NoResultException {
		TypedQuery<Usuario> typedQuery = this.getEntityManager().createNamedQuery("Usuario.pegarUsuarioPorCpf",
				Usuario.class);

		typedQuery.setParameter(1, cpf);

		return typedQuery.getSingleResult();
	}

	public List<Usuario> pegarTodosUsuarios() {
		TypedQuery<Usuario> typedQuery = this.getEntityManager().createNamedQuery("Usuario.pegarTodosUsuarios",
				Usuario.class);

		return typedQuery.getResultList();
	}

	public void removerUsuarioPorId(final Long id) {
		this.removerPorId(id);
	}

	public void atualizarUsuario(final Usuario usuario) {
		this.atualizar(usuario);
	}

	public boolean existePorCpf(final String cpf) {
		try {
			pegarUsuarioPorCpf(cpf);

			return true;
		} catch (NoResultException ex) {
			return false;
		}
	}
}
