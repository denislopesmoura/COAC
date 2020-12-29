package managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import beans.SegmentoCulturalBean;
import entities.SegmentoCultural;
import exceptions.PersistenciaException;

/**
 * 
 * @author Denis Moura
 *
 */

@Named(value = "segmentoCulturalMB")
public class SegmentoCulturalMB implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SegmentoCulturalBean segmentoCulturaBean;
	
	private SegmentoCultural segmentoCultural;

	@PostConstruct
	public void iniciar() {
		
	}
	
	public void criarSegmentoCultural(SegmentoCultural segmentoCultural) throws PersistenciaException {
		segmentoCulturaBean.criarSegmentoCultural(segmentoCultural);
	}
	
	public SegmentoCultural buscarSegmentoPorId(Long id) throws PersistenciaException {
		return segmentoCulturaBean.buscarSegmentoCulturalPorId(id);
	}
	
	public List<SegmentoCultural> buscarTodosTrabalhadores() throws PersistenciaException {
		return segmentoCulturaBean.buscarTodosSegmentosCulturais();
	}
	
	public void deletarTrabalhador(Long id) throws PersistenciaException {
		segmentoCulturaBean.deletarSegmentoCultural(id);
	}

	public SegmentoCultural getSegmentoCultural() {
		return segmentoCultural;
	}

	public void setSegmentoCultural(SegmentoCultural segmentoCultural) {
		this.segmentoCultural = segmentoCultural;
	}
	

}
