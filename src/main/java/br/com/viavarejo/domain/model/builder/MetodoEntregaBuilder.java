package br.com.viavarejo.domain.model.builder;

import br.com.viavarejo.domain.model.mongodb.MetodoEntrega;

public class MetodoEntregaBuilder {

    private Integer codigo;
    private String descricao;

    private MetodoEntregaBuilder() {
        super();
    }

    public static MetodoEntregaBuilder init() {
        return new MetodoEntregaBuilder();
    }

    public MetodoEntregaBuilder comCodigo(final Integer codigo) {
        this.codigo = codigo;
        return this;
    }

    public MetodoEntregaBuilder comDescricao(final String descricao) {
        this.descricao = descricao;
        return this;
    }

    public MetodoEntrega build() {
        final MetodoEntrega metodo = new MetodoEntrega();
        metodo.setCodigo(this.codigo);
        metodo.setDescricao(this.descricao);
        return metodo;
    }
}
