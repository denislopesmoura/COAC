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

	public List<Usuario> buscarTodosUsuarios() {
		return this.usuarioPersistencia.pegarTodosUsuarios();
	}

	public void deletarUsuario(Long id) {
		this.usuarioPersistencia.removerUsuarioPorId(id);
	}

	public boolean atualizarUsuario(Usuario usuario) throws CampoInvalidoException {
		verificarUsuario(usuario);

		return this.usuarioPersistencia.atualizarUsuario(usuario);
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

		if (!verificaNome(usuario.getNome())) {
			throw new CampoInvalidoException("O nome deve conter apenas letras e espaços em branco!", "nome");
		}

		if (!verificaSenha(usuario.getSenha())) {
			throw new CampoInvalidoException("A senha deve conter apenas letras e dígitos!", "senha");
		}

		if (!verificarTelefone(usuario.getTelefone())) {
			throw new CampoInvalidoException("O telefone é inválido!", "telefone");
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

	private boolean verificaNome(final String nome) {
		char[] chars = nome.toCharArray();

		for (char c : chars) {
			if (!Character.isLetter(c) && !Character.isSpaceChar(c)) {
				return false;
			}
		}

		return true;
	}

	private boolean verificaSenha(String senha) {
		char[] chars = senha.toCharArray();

		for (char c : chars) {
			if (!Character.isLetter(c) && !Character.isDigit(c)) {
				return false;
			}
		}

		return true;
	}

	private boolean verificarTelefone(String telefone) {
		System.out.println("Telefone: " + telefone);

		return telefone.matches("(\\(?\\d{2}\\)?\\s?)?(\\d{4,5}\\-?\\d{4})");
	}
}
