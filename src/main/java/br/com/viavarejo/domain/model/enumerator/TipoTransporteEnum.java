package br.com.viavarejo.domain.model.enumerator;

public enum TipoTransporteEnum {

    CARGA_FECHADA(1, "Carga Fechada"), CARGA_FRACIONADA(2, "Carga Fracionada");

    private Integer codigo;
    private String descricao;

    private TipoTransporteEnum(final Integer codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static TipoTransporteEnum getInstance(final Integer codigo) {
        TipoTransporteEnum objEnum = null;
        for (final TipoTransporteEnum element : TipoTransporteEnum.values()) {
            if (element.getCodigo().equals(codigo)) {
                objEnum = element;
                break;
            }
        }
        return objEnum;
    }
}
