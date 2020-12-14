package exceptions;

public class CampoInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;
	private String campo;

	public CampoInvalidoException(String message, String campo) {
		super(message);
		this.campo = campo;
	}

	public CampoInvalidoException(String message, Throwable cause) {
		super(message, cause);
	}

	public CampoInvalidoException(String message) {
		super(message);
	}

	public String getCampo() {
		return campo;
	}
}
