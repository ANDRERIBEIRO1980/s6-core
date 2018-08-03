package br.com.viavarejo.domain.model.builder.eventoretornointelipost;

import java.util.Date;

import br.com.viavarejo.domain.model.mongodb.ocorrencia.eventointelipost.PrevisaoEntregaPedidoTransportadora;

public class PrevisaoEntregaPedidoTransportadoraBuilder {

	private Date dataEstimada;
	private Date dataOriginal;

    private PrevisaoEntregaPedidoTransportadoraBuilder() {}

    public static PrevisaoEntregaPedidoTransportadoraBuilder init() {
        return new PrevisaoEntregaPedidoTransportadoraBuilder();
    }

	public PrevisaoEntregaPedidoTransportadoraBuilder dataEstimada(final Date dataEstimada) {
		this.dataEstimada = dataEstimada;
		return this;
	}

	public PrevisaoEntregaPedidoTransportadoraBuilder dataOrignal(final Date dataOrignal) {
		this.dataOriginal = dataOrignal;
		return this;
	}




	public PrevisaoEntregaPedidoTransportadora build() {

		final PrevisaoEntregaPedidoTransportadora previsaoCliente = new PrevisaoEntregaPedidoTransportadora();
		previsaoCliente.setDataEstimada(this.dataEstimada);
		previsaoCliente.setDataOrignal(this.dataOriginal);
		return previsaoCliente;
    }
}
