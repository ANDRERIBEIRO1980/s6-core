package br.com.viavarejo.domain.model.builder.eventoretornointelipost;

import br.com.viavarejo.domain.model.mongodb.ocorrencia.eventointelipost.PrevisaoEntregaPedido;
import br.com.viavarejo.domain.model.mongodb.ocorrencia.eventointelipost.PrevisaoEntregaPedidoCliente;
import br.com.viavarejo.domain.model.mongodb.ocorrencia.eventointelipost.PrevisaoEntregaPedidoTransportadora;

public class PrevisaoEntregaPedidoBuilder {

	private PrevisaoEntregaPedidoCliente dataEstimadaEntregaCliente;
	private PrevisaoEntregaPedidoTransportadora dataEstimadaEntregaTransportadora;

    private PrevisaoEntregaPedidoBuilder() {}

    public static PrevisaoEntregaPedidoBuilder init() {
        return new PrevisaoEntregaPedidoBuilder();
    }

	public PrevisaoEntregaPedidoBuilder dataEstimadaEntregaCliente(
			final PrevisaoEntregaPedidoCliente dataEstimadaEntregaCliente) {
		this.dataEstimadaEntregaCliente = dataEstimadaEntregaCliente;
		return this;
	}

	public PrevisaoEntregaPedidoBuilder dataEstimadaEntregaTransportadora(
			final PrevisaoEntregaPedidoTransportadora dataEstimadaEntregaTransportadora) {
		this.dataEstimadaEntregaTransportadora = dataEstimadaEntregaTransportadora;
		return this;
	}

	public PrevisaoEntregaPedido build() {

		final PrevisaoEntregaPedido previsao = new PrevisaoEntregaPedido();
		previsao.setDataEstimadaEntregaCliente(this.dataEstimadaEntregaCliente);
		previsao.setDataEstimadaEntregaTransportadora(this.dataEstimadaEntregaTransportadora);
		return previsao;
    }
}
