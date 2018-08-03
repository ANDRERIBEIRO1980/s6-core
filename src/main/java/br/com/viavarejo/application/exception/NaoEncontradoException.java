package br.com.viavarejo.application.exception;

import org.springframework.http.HttpStatus;

public class NaoEncontradoException extends PortalTransportadorException {
    private static final long serialVersionUID = 7713094065287970140L;

    public NaoEncontradoException() {
        super();
    }

    public NaoEncontradoException(final String message) {
        super(message);
    }

    @Override
    protected HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
