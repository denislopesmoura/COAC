package beans;

import java.util.List;

import javax.ejb.Stateless;

import entities.TipoEspacoCultural;
import exceptions.PersistenciaException;
import persistence.TipoEspacoCulturalPersistencia;
import util.TipoEspacoCulturalUtils;

@Stateless
public class TipoEspacoCulturalBean {
	
	private TipoEspacoCulturalPersistencia tipoEspacoCulturalPersistencia;
	
	public void criarTipoEspacoCultural(TipoEspacoCultural tipoEspacoCultural) throws PersistenciaException {
		
		TipoEspacoCulturalUtils.validarEspacoCultural(tipoEspacoCultural);
		
		this.tipoEspacoCulturalPersistencia.adicionarTipoEspacoCultural(tipoEspacoCultural);

	}
	
	public List<TipoEspacoCultural> buscarTodosTipoEspaco() throws PersistenciaException{
		
		return this.tipoEspacoCulturalPersistencia.pegarTodosTiposEspaco();
	}
	
	public void deletarTipoEspaco(Long id) throws PersistenciaException {
	
		this.tipoEspacoCulturalPersistencia.removerTipoEspacoPorId(id);
	}
	
	public void atualizarSegmentoCultural(TipoEspacoCultural tipoEspacoCultural) throws PersistenciaException {
		this.tipoEspacoCulturalPersistencia.atualizarTipoEspaco(tipoEspacoCultural);
	}

	public TipoEspacoCultural buscarSegmentoCulturalPorId(Long id) throws PersistenciaException {
		return this.tipoEspacoCulturalPersistencia.pegarTipoEspacoPorId(id);
	}


}
