package util;

import entities.Trabalhador;
import util.CpfCnpjUtils;

public class TrabalhadorUtils {
	
	public static void validarTrabalhador(Trabalhador trabalhador) {
		
		if (trabalhador == null) {
			throw new IllegalArgumentException("O trabalhador n�o pode ser nulo!");
		}
		
		if (!verificarNome(trabalhador.getNomeArtistico())) {
			throw new IllegalArgumentException("O nome deve conter apenas letras e espa�os em branco!");
		}
		
		if (trabalhador.getMei() != "" && !CpfCnpjUtils.validaCnpj(trabalhador.getMei())) {
			throw new IllegalArgumentException("O Mei informado � inv�lido");
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