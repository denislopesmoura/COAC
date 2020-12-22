package beans;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import entities.StatusUsuario;
import entities.Usuario;
import exceptions.PersistenciaException;
import persistence.UsuarioPersistencia;
import util.CpfCnpjUtils;
import util.UsuarioUtils;

/**
 * 
 * @author Carlos
 *
 */
@Stateless
public class UsuarioBean {

	@EJB
	private UsuarioPersistencia usuarioPersistencia;

	public void criarUsuario(final Usuario usuario) throws PersistenciaException {
		UsuarioUtils.verificarUsuario(usuario);

		this.usuarioPersistencia.adicionarUsuario(usuario);
	}

	public List<Usuario> buscarTodosUsuarios() throws PersistenciaException {
		return this.usuarioPersistencia.pegarTodosUsuarios();
	}

	public void deletarUsuario(final Long id) throws PersistenciaException {
		this.usuarioPersistencia.removerUsuarioPorId(id);
	}

	public void atualizarUsuario(final Usuario usuario) throws PersistenciaException {
		System.out.println("Cpf: " + usuario.getCpf());
		UsuarioUtils.verificarUsuario(usuario);

		this.usuarioPersistencia.atualizarUsuario(usuario);
	}

	public Usuario pegarUsuarioPorCpf(String cpf) throws PersistenciaException {
		if (!CpfCnpjUtils.validaCpf(cpf)) {
			throw new IllegalArgumentException("O cpf não é válido!");
		}

		return this.usuarioPersistencia.pegarUsuarioPorCpf(cpf);
	}
	
	public void atualizarStatusPorID(long id, StatusUsuario status) throws PersistenciaException {
	this.usuarioPersistencia.atualizarStatusPorID(id, status);
	
	}
	
}
