package managedbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import beans.TrabalhadorBean;
import entities.Trabalhador;
import exceptions.PersistenciaException;

/**
 * Classe EJB para gerenciar o bean dos trabalhadores.
 * 
 * @author Denis Lopes
 *
 */

@Named
public class TrabalhadorMB {

	@EJB
	TrabalhadorBean trabalhadorBean;

	/**
	 * Cria um novo trabalhador no banco de dados
	 * 
	 * @param trabalhador o trabalhador que será criado
	 * @return o trabalhador criado.
	 * @throws PersistenciaException 
	 */
	public void criarTrabalhador(Trabalhador trabalhador) throws PersistenciaException {
		trabalhadorBean.criarTrabalhador(trabalhador);
	}

	/**
	 * 
	 * Busca um trabalhador no banco de dados pelo nome artistico
	 * 
	 * @param nomeArtistico Nome artístico do trabalhador
	 * @return
	 * @throws PersistenciaException 
	 */
	public Trabalhador buscarTrabalhador(String nomeArtistico) throws PersistenciaException {
		return trabalhadorBean.buscarTrabalhadorPorNome(nomeArtistico);
	}

	/**
	 * 
	 * Busca todos os trabalhadores armazenados no banco de dados
	 * 
	 * @return Uma lista com todos os trabalhadores
	 * @throws PersistenciaException 
	 */
	public List<Trabalhador> buscarTodosTrabalhadores() throws PersistenciaException {
		return trabalhadorBean.buscarTodosTrabalhadores();
	}

	/**
	 * 
	 * Exclui um trabalhador da base de dados.
	 * 
	 * @param trabalhador trabalhador que será excluído
	 * @throws PersistenciaException 
	 */
	public void deletarTrabalhador(Long id) throws PersistenciaException {
		trabalhadorBean.deletarTrabalhador(id);
	}

	/**
	 * 
	 * Atualiza os dados de um trabalhador na base de dados
	 * 
	 * @param nomeArtistico         nome artistico do trabalhador
	 * @param trabalhadorAtualizado o trabalhador com os campos atualizador
	 * @return o trabalhador atualizado
	 * @throws PersistenciaException 
	 */
	public void atualizarTrabalhador(Trabalhador trabalhador) throws PersistenciaException {
		trabalhadorBean.atualizarTrabalhador(trabalhador);
	}

	public Trabalhador pegarTrabalhadorPorMei(String mei) throws PersistenciaException {
		return trabalhadorBean.pegarTrabalhadorPorMei(mei);
	}
}