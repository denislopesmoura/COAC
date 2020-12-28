package beans;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import entities.Trabalhador;
import exceptions.PersistenciaException;
import persistence.TrabalhadorPersistencia;
import util.CpfCnpjUtils;
import util.TrabalhadorUtils;

/**
 * 
 * @author Denis Lopes
 *
 */

@Stateless
@Local
public class TrabalhadorBean {
	
	private TrabalhadorPersistencia trabalhadorPersistencia;

	/**
	 * Cria um novo formulario do tipo trabalhador
	 * 
	 * @param trabalhador
	 * @throws PersistenciaException 
	 */
	public void criarTrabalhador(Trabalhador trabalhador) throws PersistenciaException {
		
		TrabalhadorUtils.validarTrabalhador(trabalhador);
		
		this.trabalhadorPersistencia.adicionarTrabalhador(trabalhador);

	}

	/**
	 * Busca um trabalhador no repositï¿½rio atravÃ©s do nome artistico.
	 * 
	 * @param Nome artistico nome artistico do trabalhador
	 * @return trabalhador encontrado
	 * @throws PersistenciaException 
	 */
	public Trabalhador buscarTrabalhadorPorNome(String nomeArtistico) throws PersistenciaException {
		
		return this.trabalhadorPersistencia.pegarTrabalhadorPorNomeArtistico(nomeArtistico);
	}

	/**
	 * Busca todos os trabalhadores salvos no repositï¿½rio.
	 * 
	 * @return uma lista com todo os trabalhadores salvos
	 * @throws PersistenciaException 
	 */
	public List<Trabalhador> buscarTodosTrabalhadores() throws PersistenciaException {

		return this.trabalhadorPersistencia.pegarTodosTrabalhadores();
	}

	/**
	 * Deleta um trabalhador do repositorio
	 * 
	 * @param O id do trabalhador
	 * @throws PersistenciaException 
	 */
	public void deletarTrabalhador(Long id) throws PersistenciaException {
		this.trabalhadorPersistencia.deletarTrabalhadorPorId(id);
	}
	
	public void atualizarTrabalhador(Trabalhador trabalhador) throws PersistenciaException {
		
		this.trabalhadorPersistencia.atualizarTrabalhador(trabalhador);
		
	}

	public Trabalhador pegarTrabalhadorPorMei(String mei) throws PersistenciaException {
		if(!CpfCnpjUtils.validaCnpj(mei)) {
			throw new IllegalArgumentException("O mei não é válido!");
		}
		
		return this.trabalhadorPersistencia.pegarTrabalhadorPorMei(mei);
	}
}