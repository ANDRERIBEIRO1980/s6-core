package br.com.viavarejo.domain.model.builder;

import java.math.BigDecimal;
import java.util.Date;

import br.com.viavarejo.domain.model.mongodb.pedido.NotaFiscal;

public class NotaFiscalBuilder {

    private String serieNf;
    private String numeroNf;
    private String chaveNf;
    private Date dataEmissao;
    private BigDecimal valorTotalProduto;
    private BigDecimal valorTotal;
    private String codigoCFOP;

    private NotaFiscalBuilder() {}

    public static NotaFiscalBuilder init() {
        return new NotaFiscalBuilder();
    }

    public NotaFiscalBuilder serieNF(final String serieNf) {
        this.serieNf = serieNf;
        return this;
    }

    public NotaFiscalBuilder numeroNF(final String numeroNf) {
        this.numeroNf = numeroNf;
        return this;
    }

    public NotaFiscalBuilder chave(final String chaveNf) {
        this.chaveNf = chaveNf;
        return this;
    }

    public NotaFiscalBuilder dataEmissao(final Date dataEmissao) {
        this.dataEmissao = dataEmissao;
        return this;
    }

    public NotaFiscalBuilder valorTotalProduto(final BigDecimal valorTotalProduto) {
        this.valorTotalProduto = valorTotalProduto;
        return this;
    }

    public NotaFiscalBuilder valorTotal(final BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public NotaFiscalBuilder codigoCFOP(final String codigoCFOP) {
        this.codigoCFOP = codigoCFOP;
        return this;
    }

    public NotaFiscal build() {
        final NotaFiscal nf = new NotaFiscal();
        nf.setSerie(this.serieNf);
        nf.setNumeroNF(this.numeroNf);
        nf.setChave(this.chaveNf);
        nf.setDataEmissao(this.dataEmissao);
        nf.setValorTotalProduto(this.valorTotalProduto);
        nf.setValorTotal(this.valorTotal);
        nf.setCodigoCFOP(this.codigoCFOP);
        return nf;
    }

}
