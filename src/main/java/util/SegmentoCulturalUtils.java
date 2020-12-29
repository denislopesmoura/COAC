package util;

import entities.SegmentoCultural;

/**
 * 
 * @author Denis Moura
 *
 */

public class SegmentoCulturalUtils {
	
	public static void validarSegmentoCultural(SegmentoCultural segmentoCultural) {
		
		if (segmentoCultural == null) {
			throw new IllegalArgumentException("O segmento cultural não pode ser nulo!");
		}
		
		if (!verificarNome(segmentoCultural.getNome())) {
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
