package exceptions;

import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

public class JsfExceptionHandler extends ExceptionHandlerWrapper {

	private final ExceptionHandler wrapped;
	private final FacesContext FacesContext = javax.faces.context.FacesContext.getCurrentInstance();

	@SuppressWarnings("deprecation")
	public JsfExceptionHandler(final ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return this.wrapped;
	}

	@Override
	public void handle() throws FacesException {
		final Iterator<ExceptionQueuedEvent> events = getUnhandledExceptionQueuedEvents().iterator();

		while (events.hasNext()) {
			ExceptionQueuedEvent event = events.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();

			Throwable exception = context.getException();

			try {
				if (exception instanceof ResourceAlreadyExistsException) {
					FacesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							exception.getLocalizedMessage(), exception.getMessage()));
				} else if (exception instanceof ResourceNotExistsException) {

				}

				FacesContext.renderResponse();
			} finally {
				events.remove();
			}

			getWrapped().handle();
		}
	}
}
