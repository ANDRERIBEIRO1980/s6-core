package br.com.viavarejo.domain.model.enumerator;

public enum IncidenciaICMSEnum {

    SIM("S", "Sim"),
    NAO("N", "Não"),
    ISENTO("I", "Isento"),
    DIFERIDO("D", "Diferido"),
    REDUZIDO("R", "Reduzido"),
    PRESUMIDO("P", "Presumido"),
    SUBSTITUIDO("T", "Substituído");

    private String sigla;
    private String descricao;

    private IncidenciaICMSEnum(final String sigla, final String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public String getSigla() {
        return this.sigla;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static IncidenciaICMSEnum getInstance(final String sigla) {
        IncidenciaICMSEnum objEnum = null;
        for (final IncidenciaICMSEnum element : IncidenciaICMSEnum.values()) {
            if (element.getSigla().equalsIgnoreCase(sigla.trim())) {
                objEnum = element;
                break;
            }
        }
        return objEnum;
    }

}
