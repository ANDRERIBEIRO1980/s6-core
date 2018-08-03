package br.com.viavarejo.application.exception;

import org.springframework.http.HttpStatus;

public class InfraestruturaException extends PortalTransportadorException {
    private static final long serialVersionUID = 5824145276269516144L;

    public InfraestruturaException() {
        super();
    }

    public InfraestruturaException(final String message) {
        super(message);
    }

    public InfraestruturaException(final Throwable cause) {
        super(cause);
    }

    public InfraestruturaException(final String message, final Throwable cause) {
        super(message, cause);
    }

    @Override
    protected HttpStatus getStatusCode() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
