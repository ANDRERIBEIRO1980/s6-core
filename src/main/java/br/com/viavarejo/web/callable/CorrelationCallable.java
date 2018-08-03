package br.com.viavarejo.web.callable;

import java.util.concurrent.Callable;

import br.com.viavarejo.util.CorrelationContext;

public class CorrelationCallable<V> implements Callable<V> {

    private final String correlationId;
    private final Callable<V> callable;

    public CorrelationCallable(final Callable<V> targetCallable) {
        this.correlationId = CorrelationContext.getId();
        this.callable = targetCallable;
    }

    @Override
    public V call() throws Exception {
        CorrelationContext.setId(this.correlationId);
        return this.callable.call();
    }
}
