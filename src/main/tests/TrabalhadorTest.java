
import entities.Trabalhador;
import exceptions.PersistenciaException;
import persistence.TrabalhadorPersistencia;
import persistence.UsuarioPersistencia;


public class TrabalhadorTest {

	public static void main(String[] args) throws PersistenciaException {
		// TODO Auto-generated method stub
		
//		TrabalhadorPersistencia tp = new TrabalhadorPersistencia();
//		
//		System.out.println(tp.pegarTodosTrabalhadores());
		
		UsuarioPersistencia up = new UsuarioPersistencia();
		
		System.out.println(up.pegarTodosUsuarios());
		
		
		
	}

}
