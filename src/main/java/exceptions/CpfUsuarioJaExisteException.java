package exceptions;

public class CpfUsuarioJaExisteException extends Exception {
	private static final long serialVersionUID = 1L;

	public CpfUsuarioJaExisteException(String message, Throwable cause) {
		super(message, cause);
	}

	public CpfUsuarioJaExisteException(String message) {
		super(message);
	}
}
