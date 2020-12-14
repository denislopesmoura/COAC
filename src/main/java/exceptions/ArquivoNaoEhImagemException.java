package exceptions;

public class ArquivoNaoEhImagemException extends Exception {

	private static final long serialVersionUID = 1L;

	public ArquivoNaoEhImagemException(String message, Throwable cause) {
		super(message, cause);
	}

	public ArquivoNaoEhImagemException(String message) {
		super(message);
	}

}
