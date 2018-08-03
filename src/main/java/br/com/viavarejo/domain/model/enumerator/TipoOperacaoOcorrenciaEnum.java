package br.com.viavarejo.domain.model.enumerator;

import java.util.Arrays;

public enum TipoOperacaoOcorrenciaEnum {

    NORMAL(0, "Normal"), NIKE(1, "Nike");

    private Integer codigo;
    private String descricao;

    private TipoOperacaoOcorrenciaEnum(final Integer codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static TipoOperacaoOcorrenciaEnum getInstance(final String descricao) {
        return Arrays.asList(TipoOperacaoOcorrenciaEnum.values())
                        .stream()
                        .filter(t -> t.getDescricao().equals(descricao))
                        .findFirst()
                        .orElse(null);
    }

    public static TipoOperacaoOcorrenciaEnum getInstance(final Integer codigo) {
        return Arrays.asList(TipoOperacaoOcorrenciaEnum.values()).stream().
                        filter(t -> t.getCodigo().equals(codigo)).
                        findFirst().orElse(null);
    }
}
