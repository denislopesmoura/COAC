package managedbeans;

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
public class TipoEspacoCulturalMB {
	
	@PostConstruct
	public void iniciar() {
		
	}

}
