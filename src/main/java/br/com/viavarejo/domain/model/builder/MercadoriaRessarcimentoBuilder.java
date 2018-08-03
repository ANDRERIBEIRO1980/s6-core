package br.com.viavarejo.domain.model.builder;

import br.com.viavarejo.domain.model.mongodb.cobranca.MercadoriaRessarcimento;

public class MercadoriaRessarcimentoBuilder {

    private String sku;
    private String descricao;
    private Integer quantidade;

    private MercadoriaRessarcimentoBuilder() {}

    public static MercadoriaRessarcimentoBuilder init() {
        return new MercadoriaRessarcimentoBuilder();
    }

    public MercadoriaRessarcimentoBuilder sku(final String sku) {
        this.sku = sku;
        return this;
    }

    public MercadoriaRessarcimentoBuilder descricao(final String descricao) {
        this.descricao = descricao;
        return this;
    }

    public MercadoriaRessarcimentoBuilder quantidade(final Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public MercadoriaRessarcimento build() {
        final MercadoriaRessarcimento obj = new MercadoriaRessarcimento();

        obj.setSku(this.sku);
        obj.setDescricao(this.descricao);
        obj.setQuantidade(this.quantidade);

        return obj;
    }

}
