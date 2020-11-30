package br.com.coac.beans;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.coac.entities.Trabalhador;

/**
 * Classe EJB que possui os m�todos de manipula��o e consulta do reposit�rio de
 * trabalhadores.
 * 
 * @author Denis Lopes
 *
 */

@Stateless
@Local
public class TrabalhadorBean{

    /**
	 * Cria um novo trabalhador no reposit�rio.
	 * 
     * @param trabalhador o trabalhador que será criado
	 * @return o trabalhador criado.
	 */
    public Trabalhador criarTrabalhador(Trabalhador trabalhador){

        return null;
        
    }

    /**
	 * Busca um trabalhador no reposit�rio através do nome artistico.
	 * 
     * @param nomeArtistico nome artistico do trabalhador
	 * @return trabalhador encontrado
	 */
    public Trabalhador buscarTrabalhador(String nomeArtistico){

        return null;
    }

    /**
	 * Busca todos os trabalhadores salvos no reposit�rio.
	 * 
	 * @return uma lista com todo os trabalhadores salvos
	 */
	public List<Trabalhador> buscarTodosTrabalhadores() {
        
        return null;
	}

    /**
	 * Deleta um trabalhador do reposit�rio.
	 * 
	 * @param trabalhador o trabalhador que será deletado
	 */
	public void deletarTrabalhador(Trabalhador trabalhador) {
	}

	/**
	 * Atualiza um trabalhador espec�fico no reposit�rio, utilizando o nome artistico.
	 * 
	 * @param nomeArtistico             o nome artistico do trabalhador
	 * @param trabalhadorAtualizado     o trabalhador com os campos atualizados
	 * @return o trabalhador atualizado
	 */
	public Trabalhador atualizarTrabalhador(String nomeArtistico, Trabalhador trabalhadorAtualizado) {
		return null;
	}


}