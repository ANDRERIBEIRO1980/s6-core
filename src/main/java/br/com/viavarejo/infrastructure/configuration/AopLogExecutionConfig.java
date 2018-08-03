package br.com.viavarejo.infrastructure.configuration;

import static java.lang.String.format;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import br.com.viavarejo.annotation.LogExecution;

/**
 * <p>
 * Classe de AspectJ que mede o tempo de execução de um determinado recurso. <br>
 * Usa o recurso do StopWatch para criação de threads de medição em métodos anotados com
 * LogExecution. <br>
 *
 * @see LogExecution
 * @author 2102421909
 */
@Aspect
@Component
public class AopLogExecutionConfig {

    private final Logger LOG = LogManager.getLogger(this.getClass());

    @Pointcut("execution(@br.com.viavarejo.annotation.LogExecution * *(..))")
    public void isAnnotated() {}

    @Around("isAnnotated()")
    public Object inIntegrationLayer(final ProceedingJoinPoint pjp) throws Throwable {

        final String declaringName = pjp.getSignature().getDeclaringTypeName();
        final String methodName = pjp.getSignature().getName();

        final StopWatch monitor = new StopWatch(declaringName);

        this.LOG.debug(format("==> START :: %1$s :: %2$s", declaringName, methodName));

        monitor.start(methodName);
        final Object objReturn = pjp.proceed();
        monitor.stop();

        this.LOG.info(format("==> END :: %1$s :: %2$s em %3$s ms", declaringName, methodName, monitor.getTotalTimeMillis()));
        return objReturn;
    }
}
