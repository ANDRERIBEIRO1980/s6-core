package br.com.viavarejo.domain.model.enumerator;

public enum CondicaoFreteEnum {

    CIF("C"), FOB("F");

    private String sigla;

    private CondicaoFreteEnum(final String sigla) {
        this.sigla = sigla;
    }

    public String getSigla() {
        return this.sigla;
    }

    public static CondicaoFreteEnum getInstance(final String sigla) {
        CondicaoFreteEnum objEnum = null;
        for (final CondicaoFreteEnum element : CondicaoFreteEnum.values()) {
            if (element.getSigla().equalsIgnoreCase(sigla.trim())) {
                objEnum = element;
                break;
            }
        }
        return objEnum;
    }

}
