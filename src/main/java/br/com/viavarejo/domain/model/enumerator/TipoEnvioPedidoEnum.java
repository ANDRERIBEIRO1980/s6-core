package br.com.viavarejo.domain.model.enumerator;

public enum TipoEnvioPedidoEnum {

    NORMAL("NORMAL"), REVERSA("RETURN");

    private String nomeIntegracao;

    private TipoEnvioPedidoEnum(final String nomeIntegracao) {
        this.nomeIntegracao = nomeIntegracao;
    }

    public String getNomeIntegracao() {
        return this.nomeIntegracao;
    }

    public static TipoEnvioPedidoEnum getInstance(final String nomeIntegracao) {
        TipoEnvioPedidoEnum objEnum = null;
        for (final TipoEnvioPedidoEnum element : TipoEnvioPedidoEnum.values()) {
            if (element.getNomeIntegracao().equals(nomeIntegracao)) {
                objEnum = element;
                break;
            }
        }
        return objEnum;
    }

}
