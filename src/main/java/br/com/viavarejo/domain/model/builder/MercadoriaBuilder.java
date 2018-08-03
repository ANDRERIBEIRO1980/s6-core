package br.com.viavarejo.domain.model.builder;

import java.math.BigDecimal;

import br.com.viavarejo.domain.model.mongodb.pedido.Mercadoria;

public class MercadoriaBuilder {

    private BigDecimal peso;
    private BigDecimal largura;
    private BigDecimal altura;
    private BigDecimal comprimento;
    private BigDecimal preco;
    private String descricao;
    private String sku;
    private String categoria;
    private Integer quantidade;
    private String imagemUrl;

    private MercadoriaBuilder() {}

    public static MercadoriaBuilder init() {
        return new MercadoriaBuilder();
    }

    public MercadoriaBuilder peso(final BigDecimal peso) {
        this.peso = peso;
        return this;
    }

    public MercadoriaBuilder largura(final BigDecimal largura) {
        this.largura = largura;
        return this;
    }

    public MercadoriaBuilder altura(final BigDecimal altura) {
        this.altura = altura;
        return this;
    }

    public MercadoriaBuilder comprimento(final BigDecimal comprimento) {
        this.comprimento = comprimento;
        return this;
    }

    public MercadoriaBuilder preco(final BigDecimal preco) {
        this.preco = preco;
        return this;
    }

    public MercadoriaBuilder descricao(final String descricao) {
        this.descricao = descricao;
        return this;
    }

    public MercadoriaBuilder sku(final String sku) {
        this.sku = sku;
        return this;
    }

    public MercadoriaBuilder categoria(final String categoria) {
        this.categoria = categoria;
        return this;
    }

    public MercadoriaBuilder quantidade(final Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public MercadoriaBuilder imagemUrl(final String imagemUrl) {
        this.imagemUrl = imagemUrl;
        return this;
    }

    public Mercadoria build() {
        final Mercadoria obj = new Mercadoria();

        obj.setAltura(this.altura);
        obj.setCategoria(this.categoria);
        obj.setComprimento(this.comprimento);
        obj.setDescricao(this.descricao);
        obj.setImagemUrl(this.imagemUrl);
        obj.setLargura(this.largura);
        obj.setPeso(this.peso);
        obj.setPreco(this.preco);
        obj.setQuantidade(this.quantidade);
        obj.setSku(this.sku);

        return obj;
    }

}
