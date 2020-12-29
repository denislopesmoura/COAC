package managedbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

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

	@PostConstruct
	public void iniciar() {
		
	}

}
