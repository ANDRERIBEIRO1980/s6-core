package br.com.viavarejo.application.exception;

import org.springframework.http.HttpStatus;

public class ServicoIndisponivelException extends PortalTransportadorException {

    private static final long serialVersionUID = 4632440955268451434L;

    public ServicoIndisponivelException() {
        super();
    }

    public ServicoIndisponivelException(final String message) {
        super(message);
    }

    public ServicoIndisponivelException(final Throwable cause) {
        super(cause);
    }

    public ServicoIndisponivelException(final String message, final Throwable cause) {
        super(message, cause);
    }

    @Override
    protected HttpStatus getStatusCode() {
        return HttpStatus.SERVICE_UNAVAILABLE;
    }
}
