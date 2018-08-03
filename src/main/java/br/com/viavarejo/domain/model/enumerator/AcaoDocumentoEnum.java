package br.com.viavarejo.domain.model.enumerator;

public enum AcaoDocumentoEnum {

    INCLUSAO("I", "Inclusão"), EXCLUSAO("E", "Exclusão/Cancelamento");

    private String sigla;
    private String descricao;

    private AcaoDocumentoEnum(final String sigla, final String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public String getSigla() {
        return this.sigla;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static AcaoDocumentoEnum getInstance(final String sigla) {
        AcaoDocumentoEnum objEnum = null;
        for (final AcaoDocumentoEnum element : AcaoDocumentoEnum.values()) {
            if (element.getSigla().equalsIgnoreCase(sigla.trim())) {
                objEnum = element;
                break;
            }
        }
        return objEnum;
    }

}
