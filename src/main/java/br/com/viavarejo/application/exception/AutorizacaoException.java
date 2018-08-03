package br.com.viavarejo.application.exception;

import org.springframework.http.HttpStatus;

public class AutorizacaoException extends PortalTransportadorException {
    private static final long serialVersionUID = -1206715020073518129L;

    public AutorizacaoException() {
        super();
    }

    public AutorizacaoException(final String message) {
        super(message);
    }

    public AutorizacaoException(final Throwable cause) {
        super(cause);
    }

    public AutorizacaoException(final String message, final Throwable cause) {
        super(message, cause);
    }

    @Override
    protected HttpStatus getStatusCode() {
        return HttpStatus.UNAUTHORIZED;
    }
}
