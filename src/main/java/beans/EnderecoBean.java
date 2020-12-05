package beans;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import entities.Endereco;

/**
 * Classe EJB que possui os metodos de manipulacao e consulta do repositorio de
 * enderecos.
 * 
 * @author Weydson Victor
 * 
 *
 */

/**
 * Cria um novo endereco no repositorio.
 * 
 * @param endereco o @br.com.coac.EnderecoBean que sera criado
 * @return o endereco criado.
 */
@Stateless
@Local
public class EnderecoBean {

	public Endereco criarEndereco(Endereco endereco) {

		return null;
	}

	/**
	 * busca o endereco no repositorio.
	 * 
	 * @param endereco o @br.com.coac.Endereco que sera buscado
	 * @return o endereco buscado.
	 */
	public Endereco buscarEndereco(String endereco) {

		return null;
	}

	/**
	 * Busca todos os enderecos salvos no repositorio.
	 * 
	 * @return uma lista com todo os enderecos salvos
	 */
	public List<Endereco> buscarTodosEndereco() {

		return null;
	}

	/**
	 * Deleta um endereco do repositorio.
	 * 
	 * @param endereco o @br.com.coac.entities.Endereco que sera deletado
	 */
	public void deletarEndereco(Endereco endereco) {
	}

	/**
	 * Deleta um endereco do repositorio.
	 * 
	 * @param endereco o @br.com.coac.entities.Endereco que sera atualizado
	 */
	public Endereco atualizarEndereco(String endereco, Endereco enderecoAtualizado) {
		return null;
	}
}
