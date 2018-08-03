package br.com.viavarejo.application.exception;

import org.springframework.http.HttpStatus;

public class IdentificacaoException extends PortalTransportadorException {
    private static final long serialVersionUID = 4220212442387105196L;

    public IdentificacaoException() {
        super();
    }

    public IdentificacaoException(final String message) {
        super(message);
    }

    @Override
    protected HttpStatus getStatusCode() {
        return HttpStatus.UNPROCESSABLE_ENTITY;
    }
}
