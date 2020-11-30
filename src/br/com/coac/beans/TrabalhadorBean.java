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
	 * Cria um novo trablhador no reposit�rio.
	 * 
	 * @return um boolean informando se a criação foi realizada.
	 */
    public boolean criarTrabalhador(Trabalhador trabalhador){

        return false;
        
    }

    /**
	 * Busca um trablhador no reposit�rio através do nome artistico.
	 * 
     * @param nomeArtistico
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
	 * @param usuario o trabalhador que será deletado
	 */
	public void deletarTrabalhador(Trabalhador trabalhador) {
	}

	/**
	 * Atualiza um trabalhador espec�fico no reposit�rio, utilizando o nome artistico.
	 * 
	 * @param nomeArtistico             o email do usu�rio que ser� atualizado
	 * @param trabalhadorAtualizado o usu�rio com os campos atualizados
	 * @return o trabalhador atualizado
	 */
	public Usuario atualizarTrabalhador(String nomeArtistico, Trabalhador trabalhadorAtualizado) {
		return null;
	}


}