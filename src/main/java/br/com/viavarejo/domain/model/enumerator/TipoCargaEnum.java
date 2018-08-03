package br.com.viavarejo.domain.model.enumerator;

public enum TipoCargaEnum {

    FRIA(1, "Fria"), SECA(2, "Seca"), MISTA(3, "Mista");

    private Integer codigo;
    private String descricao;

    private TipoCargaEnum(final Integer codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static TipoCargaEnum getInstance(final Integer codigo) {
        TipoCargaEnum objEnum = null;
        for (final TipoCargaEnum element : TipoCargaEnum.values()) {
            if (element.getCodigo() == codigo) {
                objEnum = element;
                break;
            }
        }
        return objEnum;
    }
}
