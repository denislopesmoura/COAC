package managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.coac.beans.TrabalhadorBean;
import br.com.coac.entities.Trabalhador;

/**
 * Classe EJB para gerenciar o bean dos trabalhadores.
 * 
 * @author Denis Lopes
 *
 */

@ManagedBean
public class TrabalhadorMB{

    @EJB
    TrabalhadorBean trabalhadorBean;

    /**
	* Cria um novo trabalhador no banco de dados
	* 
    * @param trabalhador o trabalhador que será criado
	* @return o trabalhador criado.
	*/
    public Trabalhador criarTrabalhador(Trabalhador trabalhador){
        return trabalhadorBean.criarTrabalhador(trabalhador); 
    }

    /**
     * 
     * Busca um trabalhador no banco de dados pelo nome artistico
     * 
     * @param nomeArtistico     Nome artístico do trabalhador
     * @return
     */
    public Trabalhador buscarTrabalhador(String nomeArtistico){
        return trabalhadorBean.buscarTrabalhador(nomeArtistico);
    }


    /**
     * 
     * Busca todos os trabalhadores armazenados no banco de dados
     * 
     * @return Uma lista com todos os trabalhadores 
     */
    public List<Trabalhador> buscarTodosTrabalhadores(){
        return trabalhadorBean.buscarTodosTrabalhadores();
    }

    /**
     * 
     * Exclui um trabalhador da base de dados.
     * 
     * @param trabalhador trabalhador que será excluído
     */
    public void deletarTrabalhador(Trabalhador trabalhador){
        trabalhadorBean.deletarTrabalhador(trabalhador);
    }

    /**
     * 
     * Atualiza os dados de um trabalhador na base de dados
     * 
     * @param nomeArtistico         nome artistico do trabalhador
     * @param trabalhadorAtualizado o trabalhador com os campos atualizador    
     * @return o trabalhador atualizado
     */
    public Trabalhador atualizarTrabalhador(String nomeArtistico, Trabalhador trabalhadorAtualizado){
        return trabalhadorBean.atualizarTrabalhador(nomeArtistico,trabalhadorAtualizado);
    }
    
}