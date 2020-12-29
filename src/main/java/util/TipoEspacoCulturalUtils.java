package util;

import entities.TipoEspacoCultural;

public class TipoEspacoCulturalUtils {
	
	public static void validarEspacoCultural(TipoEspacoCultural tipoEspacoCultural) {
		
		if (tipoEspacoCultural == null) {
			throw new IllegalArgumentException("O espaco cultural não pode ser nulo!");
		}
		
		if (!verificarNome(tipoEspacoCultural.getNome())) {
			throw new IllegalArgumentException("O nome deve conter apenas letras e espaços em branco!");
		}
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
