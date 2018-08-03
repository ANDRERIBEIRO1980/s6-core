package br.com.viavarejo.domain.model.enumerator;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TipoAcaoRegistroEnum {

    NOVO(1), ATUALIZACAO(2);

    private Integer codigo;

    private TipoAcaoRegistroEnum(final Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    @JsonCreator
    public static TipoAcaoRegistroEnum getInstance(final Integer codigo) {
        TipoAcaoRegistroEnum objEnum = null;
        for (final TipoAcaoRegistroEnum element : TipoAcaoRegistroEnum.values()) {
            if (element.getCodigo().equals(codigo)) {
                objEnum = element;
                break;
            }
        }
        return objEnum;
    }
}
