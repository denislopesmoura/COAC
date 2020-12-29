package beans;

import java.util.List;

import javax.ejb.Stateless;

import entities.SegmentoCultural;
import exceptions.PersistenciaException;
import persistence.SegmentoCulturalPersistencia;
import util.SegmentoCulturalUtils;

@Stateless
public class SegmentoCulturalBean {
	
	private SegmentoCulturalPersistencia segmentoCulturalPersistencia;
	
	public void criarSegmentoCultural(SegmentoCultural segmentoCultural) throws PersistenciaException {
		
		SegmentoCulturalUtils.validarSegmentoCultural(segmentoCultural);
		
		this.segmentoCulturalPersistencia.adicionarSegmentoCultural(segmentoCultural);

	}
	
	public List<SegmentoCultural> buscarTodosSegmentosCulturais() throws PersistenciaException{
		
		return this.segmentoCulturalPersistencia.pegarTodosSegmentos();
	}
	
	public void deletarSegmentoCultural(Long id) throws PersistenciaException {
	
		this.segmentoCulturalPersistencia.removerSegmentoPorId(id);
	}
	
	public void atualizarSegmentoCultural(SegmentoCultural segmentoCultural) throws PersistenciaException {
		this.segmentoCulturalPersistencia.atualizarSegmento(segmentoCultural);
	}

	public SegmentoCultural buscarSegmentoCulturalPorId(Long id) throws PersistenciaException {
		return this.segmentoCulturalPersistencia.pegarSegmentoPorId(id);
	}

}
