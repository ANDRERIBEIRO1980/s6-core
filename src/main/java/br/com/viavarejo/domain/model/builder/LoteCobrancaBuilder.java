package br.com.viavarejo.domain.model.builder;

import java.math.BigDecimal;

import br.com.viavarejo.domain.model.enumerator.StatusAprovacaoLoteCobrancaEnum;
import br.com.viavarejo.domain.model.mongodb.cobranca.LoteCobranca;

public class LoteCobrancaBuilder {

    private String formaPagamento;
    private Integer numeroFaturaBoleto;
    private BigDecimal valorDebito;
    private Integer codigoContasReceber;
    private Integer codigoContasPagar;
    private StatusAprovacaoLoteCobrancaEnum status;
    private String observacao;
    private Boolean flagSincronizacao;

    private LoteCobrancaBuilder() {
        super();
        this.flagSincronizacao = Boolean.FALSE;
    }

    public static LoteCobrancaBuilder init() {
        return new LoteCobrancaBuilder();
    }

    public LoteCobrancaBuilder formaPagamento(final String formaPagamento) {
        this.formaPagamento = formaPagamento;
        return this;
    }

    public LoteCobrancaBuilder numeroFatura(final Integer numeroFatura) {
        this.numeroFaturaBoleto = numeroFatura;
        return this;
    }

    public LoteCobrancaBuilder valorDebito(final BigDecimal valorDebito) {
        this.valorDebito = valorDebito;
        return this;
    }

    public LoteCobrancaBuilder codigoContasReceber(final Integer codigo) {
        this.codigoContasReceber = codigo;
        return this;
    }

    public LoteCobrancaBuilder codigoContasPagar(final Integer codigo) {
        this.codigoContasPagar = codigo;
        return this;
    }

    public LoteCobrancaBuilder statusAprovacao(final StatusAprovacaoLoteCobrancaEnum status) {
        this.status = status;
        return this;
    }

    public LoteCobrancaBuilder observacao(final String observacao) {
        this.observacao = observacao;
        return this;
    }

    public LoteCobrancaBuilder comFlagSincronizacaoAtiva() {
        this.flagSincronizacao = Boolean.TRUE;
        return this;
    }

    public LoteCobrancaBuilder comFlagSincronizacaoDesativada() {
        this.flagSincronizacao = Boolean.FALSE;
        return this;
    }

    public LoteCobranca build() {
        final LoteCobranca lote = new LoteCobranca();
        lote.setCodigoContasPagar(this.codigoContasPagar);
        lote.setCodigoContasPagar(this.codigoContasReceber);
        lote.setFormaPagamento(this.formaPagamento);
        lote.setNumeroFatura(this.numeroFaturaBoleto);
        lote.setObservacao(this.observacao);
        lote.setStatusAprovacao(this.status);
        lote.setValorDebito(this.valorDebito);
        lote.setSincronizacaoMainframe(this.flagSincronizacao);
        return lote;
    }
}
