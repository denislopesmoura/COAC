package persistence;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.TypedQuery;

import entities.Trabalhador;
import exceptions.PersistenciaException;

/**
 * 
 * @author Denis Moura
 *
 */

public class TrabalhadorPersistencia extends EntidadePersistencia<Trabalhador>{
	
	@PostConstruct
	public void configurar() {
		this.setClasse(Trabalhador.class);
	}
	
	public void adicionarTrabalhador(final Trabalhador trabalhador) throws PersistenciaException {
		
		this.persistir(trabalhador);
	}
	
	public Trabalhador pegarTrabalhadorPorNomeArtistico(String nomeArtistico) throws PersistenciaException {
		try {
			
			TypedQuery<Trabalhador> typedQuery = this.getEntityManager().createNamedQuery("Trabalhador.pegarTrabalhadorPorNome", Trabalhador.class);
			
			typedQuery.setParameter(1, nomeArtistico);
			
			return typedQuery.getSingleResult();
			
		}catch (Exception ex){
			
			throw new PersistenciaException("Não há nenhum trabalhador com esse nome artístico"); 
			
		}
		
	}

	public List<Trabalhador> pegarTodosTrabalhadores() throws PersistenciaException {
		try {
			
			TypedQuery<Trabalhador> typedQuery = this.getEntityManager().createNamedQuery("Trabalhador.pegarTodosTrabalhadores", Trabalhador.class);
			
			return typedQuery.getResultList();
			
		}catch (Exception ex){
			
			throw new PersistenciaException("Ocorreu um problema ao tentar pegar todos os trabalhadores, por favor tente novamente"); 
			
		}
		
	}
	
	public void atualizarTrabalhador(Trabalhador trabalhador) throws PersistenciaException {
		
		this.atualizar(trabalhador);
	}
	
	public void deletarTrabalhadorPorId (Long id) throws PersistenciaException {
		this.removerPorId(id);
	}
	
	public Trabalhador pegarTrabalhadorPorMei (String mei) throws PersistenciaException {
		try {
			
			TypedQuery<Trabalhador> typeQuery = this.getEntityManager().createNamedQuery("Trabalhador.pegarPorMei", Trabalhador.class);
			
			typeQuery.setParameter(1, mei);
			
			return typeQuery.getSingleResult();
			
		} catch (Exception ex) {
			throw new PersistenciaException("Não há nenhum trabalhador com esse mei cadastrado");
		}
		
	}
	

}
