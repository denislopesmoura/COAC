package persistence;

import java.util.List;

import javax.persistence.TypedQuery;

import entities.SegmentoCultural;
import exceptions.PersistenciaException;

public class SegmentoCulturalPersistencia extends EntidadePersistencia<SegmentoCultural> {

	public void configurar() {
		this.setClasse(SegmentoCultural.class);
	}
	
	public void adicionarSegmentoCultural(SegmentoCultural segmentoCultural) throws PersistenciaException {
		
		this.persistir(segmentoCultural);
		
	}
	
	public List<SegmentoCultural> pegarTodosSegmentos() throws PersistenciaException{
		try {
			
			TypedQuery<SegmentoCultural> typeQuery = this.getEntityManager().createNamedQuery("SegmentoCultural.pegarTodosSegmentos", SegmentoCultural.class);
			
			return typeQuery.getResultList();
			
		} catch (Exception e) {
			throw new PersistenciaException("Ocorreu um problema ao tentar pegar todos os segmentos");
		}
		
	} 
	
	public SegmentoCultural pegarSegmentoPorId(Long id) throws PersistenciaException {
		return this.pegarPorId(id);
	}
	
	public void removerSegmentoPorId(Long id) throws PersistenciaException {
		this.removerPorId(id);
	}

	public void atualizarSegmento(SegmentoCultural segmentoCultural) throws PersistenciaException {
		this.atualizar(segmentoCultural);
	}
}
