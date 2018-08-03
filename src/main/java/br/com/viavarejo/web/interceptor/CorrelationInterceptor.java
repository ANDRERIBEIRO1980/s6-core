package br.com.viavarejo.web.interceptor;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import br.com.viavarejo.util.CorrelationContext;

@Component
public class CorrelationInterceptor implements ClientHttpRequestInterceptor {
    protected final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Override
    public ClientHttpResponse intercept(final HttpRequest request, final byte[] body, final ClientHttpRequestExecution execution)
                    throws IOException {

        final HttpHeaders headers = request.getHeaders();
        headers.set(CorrelationContext.CORRELATION_ID, CorrelationContext.getId());
        this.LOG.debug("Adicionando CollectionId {} ao header.", CorrelationContext.getId());
        return execution.execute(request, body);
    }
}
