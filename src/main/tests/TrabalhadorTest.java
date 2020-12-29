
import entities.Cor;
import entities.Genero;
import entities.Trabalhador;
import exceptions.PersistenciaException;
import persistence.TrabalhadorPersistencia;
import persistence.UsuarioPersistencia;


public class TrabalhadorTest {

	public static void main(String[] args) throws PersistenciaException {
		
		Trabalhador trabalhador = new Trabalhador();
		
		trabalhador.setNomeArtistico("Raylson");
		trabalhador.setMei("82129231000164");
		trabalhador.setCor(Cor.BRANCA);
		trabalhador.setGenero(Genero.MASCULINO);
		
		TrabalhadorPersistencia tp = new TrabalhadorPersistencia();
		
		tp.configurar();
		
		tp.adicionarTrabalhador(trabalhador);
		
		System.out.println(tp.pegarTodosTrabalhadores());
		
		
		
		
	}

}
