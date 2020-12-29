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

@Named(value = "segmentoCulturalMB")
public class SegmentoCulturalMB implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void iniciar() {
		
	}
	

}
