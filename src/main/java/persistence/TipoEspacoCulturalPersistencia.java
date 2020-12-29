package persistence;

import java.util.List;

import javax.persistence.TypedQuery;

import entities.TipoEspacoCultural;
import exceptions.PersistenciaException;

public class TipoEspacoCulturalPersistencia extends EntidadePersistencia<TipoEspacoCultural> {
	
	public void configurar() {
		this.setClasse(TipoEspacoCultural.class);
	}
	
	public void adicionarTipoEspacoCultural(TipoEspacoCultural tipoEspacoCultural) throws PersistenciaException {
		
		this.persistir(tipoEspacoCultural);
		
	}
	
	public List<TipoEspacoCultural> pegarTodosSegmentos() throws PersistenciaException{
		try {
			
			TypedQuery<TipoEspacoCultural> typeQuery = this.getEntityManager().createNamedQuery("TipoEspacoCultural.pegarTodosEspacos", TipoEspacoCultural.class);
			
			return typeQuery.getResultList();
			
		} catch (Exception e) {
			throw new PersistenciaException("Ocorreu um problema ao tentar pegar todos os segmentos");
		}
		
	} 
	
	public TipoEspacoCultural pegarSegmentoPorId(Long id) throws PersistenciaException {
		return this.pegarPorId(id);
	}
	
	public void removerSegmentoPorId(Long id) throws PersistenciaException {
		this.removerPorId(id);
	}

	public void atualizarSegmento(TipoEspacoCultural tipoEspacoCultural) throws PersistenciaException {
		this.atualizar(tipoEspacoCultural);
	}

}
