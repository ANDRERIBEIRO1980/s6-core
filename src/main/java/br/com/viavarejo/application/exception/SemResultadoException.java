package br.com.viavarejo.application.exception;

import org.springframework.http.HttpStatus;

public class SemResultadoException extends PortalTransportadorException {
    private static final long serialVersionUID = -7144784284708215400L;

    public SemResultadoException() {
        super();
    }

    public SemResultadoException(final String message) {
        super(message);
    }

    @Override
    protected HttpStatus getStatusCode() {
        return HttpStatus.NO_CONTENT;
    }
}
