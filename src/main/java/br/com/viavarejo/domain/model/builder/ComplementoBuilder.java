package br.com.viavarejo.domain.model.builder;

import br.com.viavarejo.domain.model.enumerator.CondicaoFreteEnum;
import br.com.viavarejo.domain.model.enumerator.MeioTransporteEnum;
import br.com.viavarejo.domain.model.enumerator.TipoCargaEnum;
import br.com.viavarejo.domain.model.enumerator.TipoTransporteEnum;
import br.com.viavarejo.domain.model.mongodb.pedido.Complemento;

public class ComplementoBuilder {

    private String numeroRomaneio;
    private MeioTransporteEnum meioTransporte;
    private TipoTransporteEnum tipoTransporte;
    private TipoCargaEnum tipoCarga;
    private CondicaoFreteEnum condicaoFrete;

    private ComplementoBuilder() {}

    public static ComplementoBuilder init() {
        return new ComplementoBuilder();
    }

    public ComplementoBuilder numeroRomaneio(final String numeroRomaneio) {
        this.numeroRomaneio = numeroRomaneio;
        return this;
    }

    public ComplementoBuilder meioDeTransporte(final MeioTransporteEnum meioTransporte) {
        this.meioTransporte = meioTransporte;
        return this;
    }

    public ComplementoBuilder tipoTransporte(final TipoTransporteEnum tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
        return this;
    }

    public ComplementoBuilder tipoCarga(final TipoCargaEnum tipoCarga) {
        this.tipoCarga = tipoCarga;
        return this;
    }

    public ComplementoBuilder condicaoFrete(final CondicaoFreteEnum condicaoFrete) {
        this.condicaoFrete = condicaoFrete;
        return this;
    }

    public Complemento build() {
        final Complemento complemento = new Complemento();
        complemento.setNumeroRomaneio(this.numeroRomaneio);
        complemento.setMeioTransporte(this.meioTransporte);
        complemento.setTipoTransporte(this.tipoTransporte);
        complemento.setTipoCarga(this.tipoCarga);
        complemento.setCondicaoFrete(this.condicaoFrete);
        return complemento;
    }
}
