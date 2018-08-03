package br.com.viavarejo.infrastructure.error;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import br.com.viavarejo.application.exception.InfraestruturaException;
import br.com.viavarejo.application.exception.PortalTransportadorException;
import br.com.viavarejo.infrastructure.enumerator.IntegratorExceptionEnum;

/**
 * Handler responsável por verificar se possui erros no response das requisições HTTP. São
 * considerados erros os códigos Http de series <i>400</i> e <i>500</i>.</br>
 * Havendo erros, as exceções lançadas serão do tipo PortalTransportadorException.
 *
 */
@Component
public class CustomRestClientErrorHandler implements ResponseErrorHandler {

    private final Logger logger = Logger.getLogger(this.getClass());
    private static final String UTF_8 = "UTF-8";

    @Override
    public boolean hasError(final ClientHttpResponse response) throws IOException {
        try {
            return this.hasError(this.getHttpStatusCode(response));
        } catch (final UnknownHttpStatusCodeException ex) {
            return false;
        }
    }

    @Override
    public void handleError(final ClientHttpResponse response) throws IOException {
        final HttpStatus statusCode = this.getHttpStatusCode(response);
        final byte[] responseBodyByte = this.getResponseBody(response);
        final String json = this.getResponseBodyAsString(responseBodyByte, UTF_8);

        throw this.getIntegratorException(statusCode, json);
    }

    protected PortalTransportadorException getIntegratorException(final HttpStatus statusCode, final String mensagem) {
        return IntegratorExceptionEnum.getInstanciaEnum(statusCode).getInstanciaException(mensagem);
    }

    protected boolean hasError(final HttpStatus statusCode) {
        return ((statusCode.series() == HttpStatus.Series.CLIENT_ERROR) || (statusCode.series() == HttpStatus.Series.SERVER_ERROR));
    }

    protected HttpStatus getHttpStatusCode(final ClientHttpResponse response) throws PortalTransportadorException {
        try {
            return response.getStatusCode();
        } catch (final IOException ex) {
            this.logger.error("Falha ao recuperar o código Http.", ex);
            throw new InfraestruturaException("Falha ao recuperar o Http status code da mensagem de erro original.", ex);
        }
    }

    protected byte[] getResponseBody(final ClientHttpResponse response) {
        try {
            return FileCopyUtils.copyToByteArray(response.getBody());
        } catch (final IOException ex) {
            // ignore
        }
        return new byte[0];
    }

    protected Charset getCharset(final ClientHttpResponse response) {
        final HttpHeaders headers = response.getHeaders();
        final MediaType contentType = headers.getContentType();
        return (contentType != null ? contentType.getCharset() : Charset.forName(UTF_8));
    }

    public String getResponseBodyAsString(final byte[] responseBody, final String charset) {
        try {
            return new String(responseBody, charset);
        } catch (final UnsupportedEncodingException ex) {
            // should not occur
            this.logger.error("Falha ao recuperar o responseBody.", ex);
            throw new IllegalStateException(ex);
        }
    }
}
