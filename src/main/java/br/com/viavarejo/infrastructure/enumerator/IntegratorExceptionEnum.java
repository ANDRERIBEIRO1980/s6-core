package br.com.viavarejo.infrastructure.enumerator;

import static br.com.viavarejo.util.Utils.isNotNull;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import br.com.viavarejo.application.exception.AutorizacaoException;
import br.com.viavarejo.application.exception.ConflitoException;
import br.com.viavarejo.application.exception.IdentificacaoException;
import br.com.viavarejo.application.exception.InfraestruturaException;
import br.com.viavarejo.application.exception.NaoEncontradoException;
import br.com.viavarejo.application.exception.PortalTransportadorException;
import br.com.viavarejo.application.exception.SemResultadoException;
import br.com.viavarejo.application.exception.ServicoIndisponivelException;
import br.com.viavarejo.application.exception.ValidacaoException;

/**
 * Enum utilitário para recuperar a exception pelo Http status code. As exceções que são
 * instanciadas são herdeiras de {@link PortalTransportadorException}.</br>
 * Toda constante deverá instanciar uma instância filha de {@link PortalTransportadorException} que
 * por sua vez deverá possuir um código Http único das demais.
 *
 * @see HttpStatus
 */
public enum IntegratorExceptionEnum {

    /**
     * {@code 204 Sem conteúdo}
     *
     * @see {@link SemResultadoException}
     */
    SEM_RESULTADO_EXCEPTION(204) {
        @Override
        public PortalTransportadorException getInstanciaException(final String mensagem) {
            return new SemResultadoException(mensagem);
        }
    },

    /**
     * {@code 400 Bad request}
     *
     * @see {@link ValidacaoException}
     */
    VALIDACAO_EXCEPTION(400) {
        @Override
        public PortalTransportadorException getInstanciaException(final String mensagem) {
            return new ValidacaoException(mensagem);
        }
    },

    /**
     * {@code 401 Não Autorizado}
     *
     * @see {@link AutorizacaoException}
     */
    AUTORIZACAO_EXCEPTION(401) {
        @Override
        public PortalTransportadorException getInstanciaException(final String mensagem) {
            return new AutorizacaoException(mensagem);
        }
    },

    /**
     * {@code 404 Não encontrado}
     *
     * @see {@link NaoEncontradoException}
     */
    NAO_ENCONTRADO_EXCEPTION(404) {
        @Override
        public PortalTransportadorException getInstanciaException(final String mensagem) {
            return new NaoEncontradoException(mensagem);
        }
    },

    /**
     * {@code 409 Conflito}
     *
     * @see {@link ConflitoException}
     */
    CONFLITO_EXCEPTION(409) {
        @Override
        public PortalTransportadorException getInstanciaException(final String mensagem) {
            return new ConflitoException(mensagem);
        }
    },

    /**
     * {@code 422 Entidade não processada}
     *
     * @see {@link IdentificacaoException}
     */
    IDENTIFICACAO_EXCEPTION(422) {
        @Override
        public PortalTransportadorException getInstanciaException(final String mensagem) {
            return new IdentificacaoException(mensagem);
        }
    },

    /**
     * {@code 500 Erro interno no servidor}
     *
     * @see {@link InfraestruturaException}
     */
    INFRAESTRUTURA_EXCEPTION(500) {
        @Override
        public PortalTransportadorException getInstanciaException(final String mensagem) {
            return new InfraestruturaException(mensagem);
        }
    },

    /**
     * {@code 503 Servidor offline}
     *
     * @see {@link ServicoIndisponivelException}
     */
    SERVICO_INDISPONIVEL(503) {
        @Override
        public PortalTransportadorException getInstanciaException(final String mensagem) {
            return new ServicoIndisponivelException(mensagem);
        }
    };

    /**
     * Código Http inteiro
     */
    private final int httpCode;

    private IntegratorExceptionEnum(final int httpCode) {
        this.httpCode = httpCode;
    }

    public int getHttpCode() {
        return this.httpCode;
    }

    /**
     * Recupera uma instância do Enum pelo código Http. Retornará uma instância de
     * {@code INFRAESTRUTURA_EXCEPTION} caso não exista enum registrado para o código Http
     * informado.
     *
     * @param httpCode
     * @return uma instância do Enum
     */
    public static IntegratorExceptionEnum getInstanciaEnum(final int httpCode) {
        final List<IntegratorExceptionEnum> enums = Arrays.asList(values());
        return enums.stream().filter(e -> e.httpCode == httpCode).findFirst().orElse(IntegratorExceptionEnum.INFRAESTRUTURA_EXCEPTION);
    }

    /**
     * Recupera uma instância do Enum pelo status code
     *
     * @param statusCode
     * @return uma instância do Enum
     * @throws IllegalArgumentException caso não seja encontrada uma constante como o mesmo
     *         statusCode
     */
    public static IntegratorExceptionEnum getInstanciaEnum(final HttpStatus statusCode) throws IllegalArgumentException {
        if (isNotNull(statusCode)) {
            return getInstanciaEnum(statusCode.value());
        }
        throw new IllegalArgumentException("Status Code é inválido: [" + statusCode + "]");
    }

    /**
     * Recupera uma instância filha de {@link PortalTransportadorException}
     *
     * @return uma instância da exception
     */
    public abstract PortalTransportadorException getInstanciaException(String mensagem);
}
