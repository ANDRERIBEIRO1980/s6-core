package br.com.viavarejo.domain.model.enumerator;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum StatusAprovacaoLoteCobrancaEnum {

    VAZIO("");

    private String statusAprovacao;

    private StatusAprovacaoLoteCobrancaEnum(final String statusAprovacao) {
        this.statusAprovacao = statusAprovacao;
    }

    @JsonCreator
    public static StatusAprovacaoLoteCobrancaEnum getInstance(final String statusAprovacao) {
        return Stream.of(StatusAprovacaoLoteCobrancaEnum.values())
                        .filter(status -> status.statusAprovacao.equalsIgnoreCase(statusAprovacao))
                        .findFirst()
                        .orElse(StatusAprovacaoLoteCobrancaEnum.VAZIO);
    }

    public String getValor() {
        return this.statusAprovacao;
    }
}
