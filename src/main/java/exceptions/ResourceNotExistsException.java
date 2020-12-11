package exceptions;

public class ResourceNotExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public ResourceNotExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceNotExistsException(String message) {
		super(message);
	}
}
