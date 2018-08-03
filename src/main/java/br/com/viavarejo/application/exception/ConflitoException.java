package br.com.viavarejo.application.exception;

import org.springframework.http.HttpStatus;

public class ConflitoException extends PortalTransportadorException {
    private static final long serialVersionUID = -6485783987463240954L;

    public ConflitoException() {
        super();
    }

    public ConflitoException(final String message) {
        super(message);
    }

    @Override
    protected HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }
}
