package managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.model.file.UploadedFile;

import beans.TrabalhadorBean;
import entities.Trabalhador;
import exceptions.PersistenciaException;

/**
 * Classe EJB para gerenciar o bean dos trabalhadores.
 * 
 * @author Denis Lopes
 *
 */

@Named(value = "trabalhadorMB")
public class TrabalhadorMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private TrabalhadorBean trabalhadorBean;
	
	private Trabalhador trabalhador;
	
	private List<UploadedFile> cadastrosFile;
	
	private UploadedFile documentoHomologação;

	/**
	 * Cria um novo trabalhador no banco de dados
	 * 
	 * @param trabalhador o trabalhador que serÃ¡ criado
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
	 * @param nomeArtistico Nome artÃ­stico do trabalhador
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
	 * @param trabalhador trabalhador que serÃ¡ excluÃ­do
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

	public Trabalhador getTrabalhador() {
		return trabalhador;
	}

	public void setTrabalhador(Trabalhador trabalhador) {
		this.trabalhador = trabalhador;
	}

	public List<UploadedFile> getCadastrosFile() {
		return cadastrosFile;
	}

	public void setCadastrosFile(List<UploadedFile> cadastrosFile) {
		this.cadastrosFile = cadastrosFile;
	}

	public UploadedFile getDocumentoHomologação() {
		return documentoHomologação;
	}

	public void setDocumentoHomologação(UploadedFile documentoHomologação) {
		this.documentoHomologação = documentoHomologação;
	}
}