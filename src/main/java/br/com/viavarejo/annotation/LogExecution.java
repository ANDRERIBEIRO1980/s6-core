package br.com.viavarejo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.viavarejo.infrastructure.configuration.AopLogExecutionConfig;

/**
 * <p>
 * Anotação utilizada para tornar os métodos visíveis ao log de execuções via AspectJ <br>
 *
 * Métodos anotados irão medir o tempo de início e fim de suas execuções.
 *
 * @see AopLogExecutionConfig
 * @author 2102421909
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogExecution {

}
