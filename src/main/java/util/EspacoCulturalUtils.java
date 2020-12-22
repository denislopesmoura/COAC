package util;

import entities.EspacoCultural;

public class EspacoCulturalUtils {
	
	public static void verificarEspacoCultural (EspacoCultural espacoCultural){
		if (espacoCultural == null) {
			throw new IllegalArgumentException("O usu�rio n�o pode ser nulo!");
		}

		if (!CpfCnpjUtils.validaCnpj(espacoCultural.getCnpj())) {
			throw new IllegalArgumentException("O cpf informado � inv�lido!");
		}

		if (!verificarNome(espacoCultural.getNomeFantasia())) {
			throw new IllegalArgumentException("O nome deve conter apenas letras e espa�os em branco!");
		}
		
		if (!verificarTelefone(espacoCultural.getTelefone())) {
			throw new IllegalArgumentException("O telefone � inv�lido!");
		}

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
