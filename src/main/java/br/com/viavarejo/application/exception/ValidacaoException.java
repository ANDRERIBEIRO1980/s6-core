package br.com.viavarejo.application.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import br.com.viavarejo.web.dto.MensagemResponseDto;

public class ValidacaoException extends PortalTransportadorException {
    private static final long serialVersionUID = -3253005617045010385L;

    private final List<MensagemResponseDto> mensagens = new ArrayList<>();

    public ValidacaoException() {
        super();
    }

    public ValidacaoException(final String message) {
        super(message);
        this.mensagens.add(new MensagemResponseDto(this.getCodigo(), message));
    }

    public ValidacaoException(final Integer codigo, final String message) {
        super(message);
        this.mensagens.add(new MensagemResponseDto(codigo, message));
    }

    public ValidacaoException(final List<String> erros) {
        erros.forEach(erro -> {
            this.mensagens.add(new MensagemResponseDto(this.getCodigo(), erro));
        });
    }

    public ValidacaoException(final String message, final List<MensagemResponseDto> erros) {
        super(message);
        this.mensagens.addAll(erros);
    }

    @Override
    protected HttpStatus getStatusCode() {
        return HttpStatus.BAD_REQUEST;
    }

    @Override
    protected List<MensagemResponseDto> getMensagens() {
        return this.mensagens;
    }
}
