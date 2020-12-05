package persistence;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import entities.Usuario;

@Stateless
public class UsuarioPersistencia extends PersistenceService<Usuario> {

	public UsuarioPersistencia() {
	}

	@PostConstruct
	public void configurar() {
		super.setClasse(Usuario.class);
	}

	public void adicionarUsuario(Usuario u) {
		this.persistir(u);
	}

	public Usuario pegarUsuarioPorCpf(String cpf) {
		TypedQuery<Usuario> query = this.getEntityManager().createNamedQuery("usuario.pegarUsuarioPorCpf",
				this.getClasse());

		return query.getSingleResult();
	}

	public List<Usuario> pegarTodosUsuarios() {
		TypedQuery<Usuario> query = this.getEntityManager().createNamedQuery("usuario.pegarTodosUsuarios",
				this.getClasse());

		return query.getResultList();
	}

	public void removerUsuario(Usuario usuario) {
		this.remover(usuario);
	}

	public void atualizarUsuario(Usuario usuario) {
		this.atualizar(usuario);
	}
}
