package beans;

import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import entities.Usuario;
import exceptions.CampoInvalidoException;
import exceptions.CpfUsuarioJaExisteException;
import persistence.UsuarioPersistencia;
import util.CpfCnpjUtils;

@Stateless
public class UsuarioBean {

	@EJB
	private UsuarioPersistencia usuarioPersistencia;

	public void criarUsuario(Usuario usuario) throws CpfUsuarioJaExisteException, CampoInvalidoException {
		verificarUsuario(usuario);

		this.usuarioPersistencia.adicionarUsuario(usuario);
	}

	public Usuario buscarUsuarioPorCpf(String cpf) {
		return null;
	}

	public List<Usuario> buscarTodosUsuarios() {
		return this.usuarioPersistencia.pegarTodosUsuarios();
	}

	public void deletarUsuario(Long id) {
		this.usuarioPersistencia.removerUsuarioPorId(id);
	}

	public boolean atualizarUsuario(Usuario usuarioAtualizado) {
		return this.usuarioPersistencia.atualizarUsuario(usuarioAtualizado);
	}

	private void verificarUsuario(Usuario usuario) throws CampoInvalidoException {
		if (usuario == null) {
			throw new IllegalArgumentException("O usuário não pode ser nulo!");
		}

		if (!CpfCnpjUtils.validaCpf(usuario.getCpf())) {
			throw new CampoInvalidoException("O cpf informado é inválido!", "cpf");
		}

		if (calculaIdade(usuario.getDataNascimento()) < 18) {
			throw new CampoInvalidoException("A idade deve ser de no mínimo 18 anos!", "dataNascimento");
		}
	}

	private int calculaIdade(final Calendar dataNascimento) {
		Calendar hoje = Calendar.getInstance();

		int idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);

		if (hoje.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) {
			idade--;
		} else {
			if (hoje.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH)
					&& hoje.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
				idade--;
			}
		}

		return idade;
	}
}
