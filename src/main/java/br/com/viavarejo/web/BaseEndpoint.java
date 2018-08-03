package br.com.viavarejo.web;

import java.net.URI;
import java.util.Collections;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.viavarejo.domain.DomainObject;
import br.com.viavarejo.infrastructure.validator.BeanValidation;
import br.com.viavarejo.util.CorrelationContext;
import br.com.viavarejo.web.dto.ResponseDto;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;

@SuppressWarnings({"rawtypes", "unchecked"})
@ApiResponses(value = {

    @ApiResponse(code = 200, message = "Sucesso.", response = ResponseDto.class),
    @ApiResponse(code = 201, message = "Criado com Sucesso.", response = ResponseDto.class),

    @ApiResponse(code = 400, message = "Necessário pelo menos uma entidade para ser criada.", response = ResponseDto.class,
                    responseHeaders = {@ResponseHeader(name = "x-correlation-id",
                                                       description = "É um identificador que será utilizado por todas as camadas para identificar os log e dessa maneira possibilitar o trace completo de uma requisição",
                    response = String.class)}),
    @ApiResponse(code = 409, message = "Chave duplicada.", response = ResponseDto.class,
                    responseHeaders = {@ResponseHeader(name = "x-correlation-id",
                                                       description = "É um identificador que será utilizado por todas as camadas para identificar os log e dessa maneira possibilitar o trace completo de uma requisição",
                    response = String.class)}),
    @ApiResponse(code = 401, message = "Não foi autorizado para realizar essa operação", response = ResponseDto.class,
                    responseHeaders = {@ResponseHeader(name = "x-correlation-id",
                                                       description = "É um identificador que será utilizado por todas as camadas para identificar os log e dessa maneira possibilitar o trace completo de uma requisição",
                    response = String.class)}),
    @ApiResponse(code = 422, message = "Erro de negócio", response = ResponseDto.class,
                    responseHeaders = {@ResponseHeader(name = "x-correlation-id",
                                                       description = "É um identificador que será utilizado por todas as camadas para identificar os log e dessa maneira possibilitar o trace completo de uma requisição",
                    response = String.class)}),

    @ApiResponse(code = 500, message = "Erro interno", response = ResponseDto.class,
                    responseHeaders = {@ResponseHeader(name = "x-correlation-id",
                                                       description = "É um identificador que será utilizado por todas as camadas para identificar os log e dessa maneira possibilitar o trace completo de uma requisição",
                    response = String.class)})
})
public abstract class BaseEndpoint<T extends DomainObject<T>> extends BeanValidation<T> {

    protected final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    protected ModelMapper modelMapper;

    protected URI recuperarLocation(final String path, final Object identificador) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path(path).buildAndExpand(identificador).toUri();
    }

    protected ResponseEntity<ResponseDto> sucessoResponse() {
        return ResponseEntity.ok()
                        .header(CorrelationContext.CORRELATION_ID, this.getCorrelationId())
                        .body(this.buildResponse(Collections.emptyList()));
    }

    protected ResponseEntity<ResponseDto> sucessoResponse(final Object obj) {
        return ResponseEntity.ok()
                        .header(CorrelationContext.CORRELATION_ID, this.getCorrelationId())
                        .body(this.buildResponse(obj));
    }

    protected ResponseEntity<ResponseDto> criarResponse(final Object obj) {
        return ResponseEntity.status(HttpStatus.CREATED)
                        .header(CorrelationContext.CORRELATION_ID, this.getCorrelationId())
                        .body(this.buildResponse(obj));
    }

	protected ResponseEntity<ResponseDto> criarResponseAccepted(final Object obj) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                        .header(CorrelationContext.CORRELATION_ID, this.getCorrelationId())
                        .body(this.buildResponse(obj));
	}

    protected ResponseEntity<ResponseDto> recuperarResponse(final Object obj) {
        return ResponseEntity.ok()
                        .header(CorrelationContext.CORRELATION_ID, this.getCorrelationId())
                        .body(this.buildResponse(obj));
    }

    private ResponseDto<?> buildResponse(final Object obj) {

        final ResponseDto response = new ResponseDto();
        response.setValido(Boolean.TRUE);
        response.add(obj);

        return response;
    }

    protected void geraLogEventoIntelipost(final Object obj) {
        final ObjectMapper mapperObj = new ObjectMapper();
        try {
            final String jsonStr = mapperObj.writeValueAsString(obj);
            this.logger.log(Level.INFO, String.format("Evento gerado: %1$s", jsonStr));
        } catch (final JsonProcessingException e) {
            this.logger.log(Level.ERROR, "Erro ao parsear JSON.", e);
        }
    }

    protected String getCorrelationId() {
        return CorrelationContext.getId();
    }

    // protected Usuario getUsuarioLogado() throws IdentificacaoException{
    // return this.identificacaoService.getUsuarioAutenticado();
    // }
}
