package util;

import java.util.Calendar;

import entities.Usuario;

/**
 * 
 * @author Carlos
 *
 */
public class UsuarioUtils {

	public static void verificarUsuario(final Usuario usuario) {
		if (usuario == null) {
			throw new IllegalArgumentException("O usu�rio n�o pode ser nulo!");
		}

		if (!CpfCnpjUtils.validaCpf(usuario.getCpf())) {
			throw new IllegalArgumentException("O cpf informado � inv�lido!");
		}

		if (verificarIdade(usuario.getDataNascimento()) < 18) {
			throw new IllegalArgumentException("A idade deve ser de no m�nimo 18 anos!");
		}

		if (!verificarNome(usuario.getNome())) {
			throw new IllegalArgumentException("O nome deve conter apenas letras e espa�os em branco!");
		}

		if (!verificarSenha(usuario.getSenha())) {
			throw new IllegalArgumentException("A senha deve conter apenas letras e d�gitos!");
		}

		if (!verificarTelefone(usuario.getTelefone())) {
			throw new IllegalArgumentException("O telefone � inv�lido!");
		}
	}

	private static int verificarIdade(final Calendar dataNascimento) {
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

	private static boolean verificarSenha(final String senha) {
		char[] chars = senha.toCharArray();

		for (char c : chars) {
			if (!Character.isLetter(c) && !Character.isDigit(c)) {
				return false;
			}
		}

		return true;
	}

	private static boolean verificarTelefone(final String telefone) {
		return telefone.matches("(\\(?\\d{2}\\)?\\s?)?(\\d{4,5}\\-?\\d{4})");
	}

	private static boolean verificarNome(final String nome) {
		char[] chars = nome.toCharArray();
		boolean teveEspaco = false;

		for (char c : chars) {
			if (Character.isSpaceChar(c)) {
				if (teveEspaco) {
					return false;
				} else {
					teveEspaco = true;
				}
			} else if (Character.isLetter(c)) {
				teveEspaco = false;
			}
		}

		return true;
	}
}
