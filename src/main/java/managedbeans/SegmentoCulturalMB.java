package managedbeans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * 
 * @author Denis Moura
 *
 */

@Named(value="segmentoCulturalMB")
@SessionScoped
public class SegmentoCulturalMB {
	
	@PostConstruct
	public void iniciar() {
		
	}
	

}
