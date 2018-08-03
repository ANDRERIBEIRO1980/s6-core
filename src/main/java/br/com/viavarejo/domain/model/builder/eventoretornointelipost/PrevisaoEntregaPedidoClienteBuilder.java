package br.com.viavarejo.domain.model.builder.eventoretornointelipost;

import java.util.Date;

import br.com.viavarejo.domain.model.mongodb.ocorrencia.eventointelipost.PrevisaoEntregaPedidoCliente;

public class PrevisaoEntregaPedidoClienteBuilder {

	private Date dataEstimada;
	private Date dataOriginal;

    private PrevisaoEntregaPedidoClienteBuilder() {}

    public static PrevisaoEntregaPedidoClienteBuilder init() {
        return new PrevisaoEntregaPedidoClienteBuilder();
    }

	public PrevisaoEntregaPedidoClienteBuilder dataEstimada(final Date dataEstimada) {
		this.dataEstimada = dataEstimada;
		return this;
	}

	public PrevisaoEntregaPedidoClienteBuilder dataOrignal(final Date dataOrignal) {
		this.dataOriginal = dataOrignal;
		return this;
	}




	public PrevisaoEntregaPedidoCliente build() {

		final PrevisaoEntregaPedidoCliente previsaoCliente = new PrevisaoEntregaPedidoCliente();
		previsaoCliente.setDataEstimada(this.dataEstimada);
		previsaoCliente.setDataOrignal(this.dataOriginal);
		return previsaoCliente;
    }
}
