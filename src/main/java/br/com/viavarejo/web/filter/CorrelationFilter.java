package br.com.viavarejo.web.filter;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.viavarejo.util.CorrelationContext;

/**
 * Responsável pelo controle do CorrelationId no Header da requisição
 *
 * @author 2102421909
 */
@Component
public class CorrelationFilter implements Filter {
	private static final Logger LOG = LoggerFactory.getLogger(CorrelationFilter.class);

	@Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain)
                    throws IOException, ServletException {

        final HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String cId = httpServletRequest.getHeader(CorrelationContext.CORRELATION_ID);

        if (!this.currentRequestIsAsyncDispatcher(httpServletRequest)) {
            if (cId == null) {

                cId = UUID.randomUUID().toString();
                LOG.info("CorrelationId Criado :: {} ", cId);
            } else {

                LOG.info("CorrelationId Recuperado :: {} ", cId);
            }
            CorrelationContext.setId(cId);
        }
        filterChain.doFilter(httpServletRequest, servletResponse);
    }

    private boolean currentRequestIsAsyncDispatcher(final HttpServletRequest httpServletRequest) {
        return httpServletRequest.getDispatcherType().equals(DispatcherType.ASYNC);
    }

	@Override
	public void init(final FilterConfig filterConfig) throws ServletException{}

	@Override
	public void destroy() {}
}
