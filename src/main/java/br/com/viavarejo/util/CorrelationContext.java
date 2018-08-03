package br.com.viavarejo.util;

/**
 * Classe utilitária para armazenar via ThreadLocal (Request) o correlation id da requisição.<br>
 *
 * @author 2102421909
 */
public class CorrelationContext {

    public static final String CORRELATION_ID = "X-Correlation-Id";

    private static final ThreadLocal<String> id = new ThreadLocal<>();

    private CorrelationContext() {}

    public static String getId() {
        return id.get();
    }

    public static void setId(final String correlationId) {
        id.set(correlationId);
    }
}
