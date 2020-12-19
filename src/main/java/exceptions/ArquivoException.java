package exceptions;

public class ArquivoException extends Exception {

	private static final long serialVersionUID = 1L;

	public ArquivoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ArquivoException(String message) {
		super(message);
	}

}
