package managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import beans.TipoEspacoCulturalBean;
import entities.TipoEspacoCultural;
import exceptions.PersistenciaException;

/**
 * 
 * @author Denis Moura
 *
 */

@Named(value="tipoEspacoCulturalMB")
@SessionScoped
public class TipoEspacoCulturalMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TipoEspacoCulturalBean tipoEspacoCulturalBean;
	
	private TipoEspacoCultural tipoEspacoCultural;

	@PostConstruct
	public void iniciar() {
		
	}
	
	public void criarSegmentoCultural(TipoEspacoCultural tipoEspacoCultural) throws PersistenciaException {
		tipoEspacoCulturalBean.criarTipoEspacoCultural(tipoEspacoCultural);
	}
	
	public TipoEspacoCultural buscarSegmentoPorId(Long id) throws PersistenciaException {
		return tipoEspacoCulturalBean.buscarSegmentoCulturalPorId(id);
	}
	
	public List<TipoEspacoCultural> buscarTodosTrabalhadores() throws PersistenciaException {
		return tipoEspacoCulturalBean.buscarTodosTipoEspaco();
	}
	
	public void deletarTrabalhador(Long id) throws PersistenciaException {
		tipoEspacoCulturalBean.deletarTipoEspaco(id);
	}

	public TipoEspacoCultural getTipoEspacoCultural() {
		return tipoEspacoCultural;
	}

	public void setTipoEspacoCultural(TipoEspacoCultural tipoEspacoCultural) {
		this.tipoEspacoCultural = tipoEspacoCultural;
	}

}
