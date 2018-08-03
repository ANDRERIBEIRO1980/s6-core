package br.com.viavarejo.domain.model.enumerator;

public enum TipoVolumeEnum {

    ENVELOPE("ENVELOPE"), CAIXA("BOX"), PECA("BAG"), TUBO("TUBE"), PALETE("PALLET");

    private String aliasIntelipost;

    private TipoVolumeEnum(final String aliasIntelipost) {
        this.aliasIntelipost = aliasIntelipost;
    }

    public String getAliasIntelipost() {
        return this.aliasIntelipost;
    }

    public static TipoVolumeEnum getInstance(final String value) {
        TipoVolumeEnum objEnum = null;
        for (final TipoVolumeEnum element : TipoVolumeEnum.values()) {
            if (element.getAliasIntelipost().equalsIgnoreCase(value)) {
                objEnum = element;
                break;
            }
        }
        return objEnum;
    }

}