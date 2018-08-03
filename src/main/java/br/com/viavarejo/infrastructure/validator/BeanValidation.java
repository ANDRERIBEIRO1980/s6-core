package br.com.viavarejo.infrastructure.validator;

import static br.com.viavarejo.util.Utils.isNotEmpty;
import static br.com.viavarejo.util.Utils.isNull;
import static br.com.viavarejo.util.Utils.not;
import static javax.validation.Validation.buildDefaultValidatorFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import br.com.viavarejo.application.exception.ValidacaoException;
import br.com.viavarejo.domain.DomainObject;

public abstract class BeanValidation<T extends DomainObject<T>> {

    protected static final Logger LOG = Logger.getLogger(BeanValidation.class);

    // Medoto usado para teste de integracao, removendo os objetos que possuem erro
    // public void validarBean(final List<T> lista) throws ValidacaoException {
    // final List<String> erros = new ArrayList<>();
    // final List<T> aRemover = new ArrayList<>();
    // lista.forEach(obj -> {
    // final T objErro = this.adicionarErros(erros, obj);
    // aRemover.add(objErro);
    // });
    //
    // lista.removeIf(obj -> aRemover.contains(obj));
    // }

    public void validarBean(final List<T> lista) throws ValidacaoException {
        final List<String> erros = new ArrayList<>();

        lista.forEach(obj -> {
            this.adicionarErros(erros, obj);
        });
        this.validar(erros);
    }

    public void validarBean(final T obj) throws ValidacaoException {
        final List<String> erros = new ArrayList<>();
        this.adicionarErros(erros, obj);
        this.validar(erros);
    }

    private T adicionarErros(final List<String> erros, final T obj) {
        if (isNull(obj)) {
            throw new ValidacaoException("A entidade deve ser fornecida para a validação dos campos obrigatórios.");
        }

        final Set<ConstraintViolation<T>> violation = buildDefaultValidatorFactory().getValidator().validate(obj);
        if (not(violation.isEmpty())) {

            final StringBuilder sb = new StringBuilder("Tipo ");
            sb.append(violation.stream().findFirst().get().getRootBeanClass());
            sb.append("; Entidade Inválida ");
            sb.append(obj.toString());

            violation.forEach(it -> {
                sb.append("; campo ").append(it.getPropertyPath()).append(" ");
                sb.append(it.getMessage());
            });

            erros.add(sb.toString());
            return obj;
        }
        return null;
    }

    private void validar(final List<String> erros) throws ValidacaoException {
        if (isNotEmpty(erros)) {
            LOG.log(Level.ERROR, String.format("Validação de campos: %s", erros.toString()));
            throw new ValidacaoException(erros);
        }
    }
}
