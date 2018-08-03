package br.com.viavarejo.application.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.viavarejo.web.dto.MensagemResponseDto;
import br.com.viavarejo.web.dto.ResponseDto;

public abstract class PortalTransportadorException extends RuntimeException {
    private static final long serialVersionUID = -419675524439842255L;

    public PortalTransportadorException() {
        this(null, null);
    }

    public PortalTransportadorException(final String message) {
        super(message);
    }

    public PortalTransportadorException(final Throwable cause) {
        super(cause);
    }

    public PortalTransportadorException(final String message, final Throwable cause) {
        super(message, cause);
    }

    @SuppressWarnings("rawtypes")
    public ResponseEntity<ResponseDto> buildResponse(final String protocolo) {

        final ResponseDto responseDefault = new ResponseDto();
        responseDefault.setValido(Boolean.FALSE);
        responseDefault.setProtocolo(protocolo);
        responseDefault.setMensagens(this.getMensagens());

        return ResponseEntity.status(this.getStatusCode()).body(responseDefault);
    }

    protected abstract HttpStatus getStatusCode();

    protected List<MensagemResponseDto> getMensagens() {
        final List<MensagemResponseDto> mensagens = new ArrayList<>();
        mensagens.add(new MensagemResponseDto(this.getCodigo(), this.getMensagem()));
        return mensagens;
    }

    protected Integer getCodigo() {
        return this.getStatusCode().value();
    }

    protected String getMensagem() {
        return this.getMessage();
    }
}
