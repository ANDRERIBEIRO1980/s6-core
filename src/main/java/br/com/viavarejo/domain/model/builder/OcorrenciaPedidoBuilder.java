package br.com.viavarejo.domain.model.builder;

import java.util.ArrayList;
import java.util.List;

import br.com.viavarejo.domain.model.enumerator.TipoOperacaoOcorrenciaEnum;
import br.com.viavarejo.domain.model.mongodb.ocorrencia.EventoPedido;
import br.com.viavarejo.domain.model.mongodb.ocorrencia.OcorrenciaPedido;
import br.com.viavarejo.domain.model.mongodb.transportador.TransportadorPK;

public class OcorrenciaPedidoBuilder {

    private TransportadorPK transportadorPK;
    private String transportadora;
    private String embarcador;
    private String codigoPedido;
    private String codigoVolume;
    private String numeroNotaFiscal;
    private final List<EventoPedido> eventos = new ArrayList<>();
    private TipoOperacaoOcorrenciaEnum tipoOperacao = TipoOperacaoOcorrenciaEnum.NORMAL;

    private OcorrenciaPedidoBuilder() {}

    public static OcorrenciaPedidoBuilder init() {
        return new OcorrenciaPedidoBuilder();
    }

    public OcorrenciaPedidoBuilder transportadora(final String transportadora) {
        this.transportadora = transportadora;
        return this;
    }

    public OcorrenciaPedidoBuilder embarcador(final String embarcador) {
        this.embarcador = embarcador;
        return this;
    }

    public OcorrenciaPedidoBuilder transportadora(final Integer codigoEmpresa, final Integer codigoFornecedor) {
        this.transportadorPK = new TransportadorPK(codigoEmpresa, codigoFornecedor);
        return this;
    }

    public OcorrenciaPedidoBuilder numeroNotaFiscal(final String numeroNotaFiscal) {
        this.numeroNotaFiscal = numeroNotaFiscal;
        return this;
    }

    public OcorrenciaPedidoBuilder comEvento(final EventoPedido eventoPedido) {
        this.eventos.add(eventoPedido);
        return this;
    }

    public OcorrenciaPedidoBuilder codigoPedido(final String codigoPedido) {
        this.codigoPedido = codigoPedido;
        return this;
    }

    public OcorrenciaPedidoBuilder codigoVolume(final String codigoVolume) {
        this.codigoVolume = codigoVolume;
        return this;
    }

    public OcorrenciaPedidoBuilder tipoOperacao(final TipoOperacaoOcorrenciaEnum tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
        return this;
    }

    public OcorrenciaPedido build() {
        final OcorrenciaPedido ocorrencia = new OcorrenciaPedido();

        ocorrencia.setTransportadoraPK(this.transportadorPK);
        ocorrencia.setTransportadora(this.transportadora);
        ocorrencia.setEmbarcador(this.embarcador);
        ocorrencia.setCodigoPedido(this.codigoPedido);
        ocorrencia.setCodigoVolume(this.codigoVolume);
        ocorrencia.setNumeroNotaFiscal(this.numeroNotaFiscal);
        ocorrencia.setTipoOperacao(this.tipoOperacao);
        ocorrencia.setEventos(this.eventos);
        return ocorrencia;
    }
}
