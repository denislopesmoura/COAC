package mb;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.coac.beans.TrabalhadorBean;
import br.com.coac.entities.Trabalhador;

@ManagerBean
public class TrabalhadorMB{

    @EJB
    TrabalhadorBean trabalhadorBean;

    public Trabalhador trabalhador;

    public Trabalhador criarTrabalhador(){
        return trabalhadorBean.criarTrabalhador(trabalhador); 
    }

}