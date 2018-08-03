package br.com.viavarejo.domain.model.enumerator;

public enum MeioTransporteEnum {

	RODOVIARIO(1, "Rodoviário"), AEREO(2, "Aéreo"), MARITIMO(3, "Marítimo"), FLUVIAL(4, "Fluvial"), FERROVIARIO(5,
			"Ferroviário");

    private Integer codigo;
    private String descricao;

    private MeioTransporteEnum(final Integer codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static MeioTransporteEnum getInstance(final Integer codigo) {
        MeioTransporteEnum objEnum = null;
        for (final MeioTransporteEnum element : MeioTransporteEnum.values()) {
            if (element.getCodigo().equals(codigo)) {
                objEnum = element;
                break;
            }
        }
        return objEnum;
    }
}
