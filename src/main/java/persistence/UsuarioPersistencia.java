package persistence;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import entities.Grupo;
import entities.StatusUsuario;
import entities.Usuario;
import exceptions.PersistenciaException;
import util.AuthenticationUtils;

@Stateless
public class UsuarioPersistencia extends EntidadePersistencia<Usuario> {

	@PostConstruct
	public void configurar() {
		this.setClasse(Usuario.class);
	}

	public void adicionarUsuario(final Usuario usuario) throws PersistenciaException {
		if (!existePorCpf(usuario.getCpf())) {
			try {
				usuario.setSenha(AuthenticationUtils.encodeSHA256(usuario.getSenha()));
			} catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
				throw new PersistenciaException("Ocorreu um problema ao tentar encriptar a senha");
			}

			Grupo grupo = new Grupo();

			grupo.setCpf(usuario.getCpf());

			if (usuario.getCpf().equals("70982723458")) {
				grupo.setNome(Grupo.GRUPO_ADMIN);
				usuario.setStatus(StatusUsuario.APROVADA);
			} else {
				grupo.setNome(Grupo.GRUPO_USUARIOS);
			}

			this.persistir(usuario);
			this.getEntityManager().persist(grupo);
		} else {
			throw new PersistenciaException("Já existe um usuário com esse cpf");
		}
	}

	public Usuario pegarUsuarioPorCpf(final String cpf) throws PersistenciaException {
		try {
			TypedQuery<Usuario> typedQuery = this.getEntityManager().createNamedQuery("Usuario.pegarUsuarioPorCpf",
					Usuario.class);

			typedQuery.setParameter(1, cpf);

			return typedQuery.getSingleResult();
		} catch (Exception ex) {
			throw new PersistenciaException("Não há nenhum usuário com esse cpf");
		}
	}

	public List<Usuario> pegarTodosUsuarios() throws PersistenciaException {
		try {
			TypedQuery<Usuario> typedQuery = this.getEntityManager().createNamedQuery("Usuario.pegarTodosUsuarios",
					Usuario.class);

			return typedQuery.getResultList();
		} catch (Exception ex) {
			throw new PersistenciaException(
					"Ocorreu um problema ao tentar pegar todos os usuário, por favor tente novamente");
		}
	}

	public void removerUsuarioPorId(final Long id) throws PersistenciaException {
		this.removerPorId(id);
	}

	public void atualizarUsuario(final Usuario usuario) throws PersistenciaException {
		try {
			usuario.setSenha(AuthenticationUtils.encodeSHA256(usuario.getSenha()));
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
			throw new PersistenciaException("Ocorreu um problema ao tentar encriptar a senha");
		}

		this.atualizar(usuario);
	}

	public boolean existePorCpf(final String cpf) {
		boolean existe;

		try {
			pegarUsuarioPorCpf(cpf);

			existe = true;
		} catch (Exception ex) {
			existe = false;
		}

		return existe;

	}
	public void atualizarStatusPorID(long id, StatusUsuario status) throws PersistenciaException {
		
		Usuario usuario = this.pegarPorId(id);
		usuario.setStatus(status);
		this.atualizar(usuario);
	}
}
