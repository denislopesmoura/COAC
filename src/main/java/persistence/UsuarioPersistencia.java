package persistence;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import entities.Usuario;
import exceptions.CpfUsuarioJaExisteException;

@Stateless
public class UsuarioPersistencia extends EntidadePersistencia<Usuario> {

	@PostConstruct
	public void configurar() {
		super.setClasse(Usuario.class);
	}

	public void adicionarUsuario(final Usuario usuario) throws CpfUsuarioJaExisteException {
		if (!existePorCpf(usuario.getCpf())) {
			super.persistir(usuario);
		} else {
			throw new CpfUsuarioJaExisteException("Já existe um usuário com esse cpf!");
		}
	}

	public Usuario pegarUsuarioPorCpf(final String cpf) {
		try {
			TypedQuery<Usuario> typedQuery = this.getEntityManager().createNamedQuery("Usuario.pegarUsuarioPorCpf",
					Usuario.class);

			typedQuery.setParameter(1, cpf);

			return typedQuery.getSingleResult();
		} catch (Exception ex) {
			return null;
		}
	}

	public List<Usuario> pegarTodosUsuarios() {
		try {
			TypedQuery<Usuario> typedQuery = this.getEntityManager().createNamedQuery("Usuario.pegarTodosUsuarios",
					Usuario.class);

			return typedQuery.getResultList();
		} catch (Exception ex) {
			return null;
		}
	}

	public boolean removerUsuarioPorId(final Long id) {
		return this.removerPorId(id);
	}

	public boolean atualizarUsuario(final Usuario usuario) {
		return this.atualizar(usuario);
	}

	public boolean existePorCpf(final String cpf) {
		boolean existe = false;

		if (pegarUsuarioPorCpf(cpf) != null) {
			existe = true;
		}

		return existe;

	}
}
