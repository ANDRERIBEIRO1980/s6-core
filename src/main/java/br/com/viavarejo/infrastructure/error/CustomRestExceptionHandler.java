package br.com.viavarejo.infrastructure.error;

import static java.util.Collections.singletonList;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.viavarejo.application.exception.ConflitoException;
import br.com.viavarejo.application.exception.InfraestruturaException;
import br.com.viavarejo.application.exception.NaoEncontradoException;
import br.com.viavarejo.application.exception.PortalTransportadorException;
import br.com.viavarejo.application.exception.SemResultadoException;
import br.com.viavarejo.application.exception.ValidacaoException;
import br.com.viavarejo.util.CorrelationContext;
import br.com.viavarejo.web.dto.MensagemResponseDto;
import br.com.viavarejo.web.dto.ResponseDto;

@SuppressWarnings("rawtypes")
@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler({ ValidacaoException.class })
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	public ResponseEntity<ResponseDto> validacaoException(final ValidacaoException ex, final WebRequest request) {
		return this.getResponse(ex);
	}

	@ExceptionHandler({ NaoEncontradoException.class })
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	public ResponseEntity<ResponseDto> naoEncontradoException(final NaoEncontradoException ex) {
		return this.getResponse(ex);
	}

	@ExceptionHandler(value = { SemResultadoException.class })
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	public ResponseEntity<ResponseDto> semResultadoException(final SemResultadoException ex) {
		return this.getResponse(ex);
	}

	@ExceptionHandler(value = { InfraestruturaException.class })
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	public ResponseEntity<ResponseDto> infraestruturaException(final InfraestruturaException ex) {
		return this.getResponse(ex);
	}

    @ExceptionHandler(value = {DuplicateKeyException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<ResponseDto> conflitoException(final DuplicateKeyException ex) {
        final ConflitoException chaveDuplicada = new ConflitoException(String.format("Chave da entidade duplicada. %1$s", ex
                        .getCause()
                        .getMessage()));
        return this.getResponse(chaveDuplicada);
    }

	@ExceptionHandler(value = { PortalTransportadorException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ResponseDto> portalTransportadorException(final InfraestruturaException ex) {
		return this.getResponse(ex);
	}

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ResponseDto> handleAll(final Exception ex, final WebRequest request) {

        final String mensagem = CorrelationContext.getId() + " Erro :: " + ex.getMessage();
        this.logger.error("x-correlation-id: " + mensagem, ex);

		final ResponseDto responseDefault = new ResponseDto();
		responseDefault.setValido(Boolean.FALSE);
		responseDefault.setProtocolo(mensagem);
		responseDefault.setMensagens(singletonList(
				new MensagemResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getLocalizedMessage())));

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDefault);
	}

    @Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex,
			final HttpHeaders headers, final HttpStatus status, final WebRequest request) {

		final String msgRetorno = this.messageSource.getMessage("mensagem.invalida", null,
				LocaleContextHolder.getLocale());
		final String msgErro = ex.getCause() != null ? ex.getCause().toString() : ex.toString();
		final List<Erro> erros = Arrays.asList(new Erro(msgRetorno + ": " + msgErro));
		return this.handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}

	private ResponseEntity<ResponseDto> getResponse(final PortalTransportadorException ex) {
        final String mensagem = CorrelationContext.getId() + " Erro :: " + ex.getMessage();
        this.logger.error("x-correlation-id: " + mensagem, ex);
		return ex.buildResponse(mensagem);
	}

	public static class Erro {
		private final String msgRetorno;
		public Erro(final String msgRetorno) {
			this.msgRetorno = msgRetorno;
		}
		public String getMsgRetorno() {
			return this.msgRetorno;
		}
	}
}
