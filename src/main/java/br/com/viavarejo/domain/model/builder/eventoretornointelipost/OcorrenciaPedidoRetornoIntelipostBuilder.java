package br.com.viavarejo.domain.model.builder.eventoretornointelipost;

import br.com.viavarejo.domain.model.mongodb.ocorrencia.eventointelipost.EventoIntelipost;
import br.com.viavarejo.domain.model.mongodb.ocorrencia.eventointelipost.Historico;
import br.com.viavarejo.domain.model.mongodb.ocorrencia.eventointelipost.Invoice;
import br.com.viavarejo.domain.model.mongodb.ocorrencia.eventointelipost.PrevisaoEntregaPedido;

public class OcorrenciaPedidoRetornoIntelipostBuilder {

	private Historico historico;
	private Invoice invoice;
	private String numeroPedidoEntrega;
	private String codigoRastreamento;
	private String numeroVolume;
	private PrevisaoEntregaPedido dataEstimadaEntregaPedido;

    private OcorrenciaPedidoRetornoIntelipostBuilder() {}

    public static OcorrenciaPedidoRetornoIntelipostBuilder init() {
        return new OcorrenciaPedidoRetornoIntelipostBuilder();
    }

	public OcorrenciaPedidoRetornoIntelipostBuilder historico(final Historico historico) {
		this.historico = historico;
        return this;
    }

	public OcorrenciaPedidoRetornoIntelipostBuilder invoice(final Invoice invoice) {
		this.invoice = invoice;
        return this;
    }

	public OcorrenciaPedidoRetornoIntelipostBuilder numeroPedidoEntrega(final String numeroPedidoEntrega) {
		this.numeroPedidoEntrega = numeroPedidoEntrega;
        return this;
    }

	public OcorrenciaPedidoRetornoIntelipostBuilder codigoRastreamento(final String codigoRastreamento) {
		this.codigoRastreamento = codigoRastreamento;
        return this;
    }

	public OcorrenciaPedidoRetornoIntelipostBuilder numeroVolume(final String numeroVolume) {
		this.numeroVolume = numeroVolume;
        return this;
    }

	public OcorrenciaPedidoRetornoIntelipostBuilder dataEstimadaEntregaPedido(
			final PrevisaoEntregaPedido dataEstimadaEntregaPedido) {
		this.dataEstimadaEntregaPedido = dataEstimadaEntregaPedido;
        return this;
    }


	public EventoIntelipost build() {

		final EventoIntelipost ocorrenciaRetorno = new EventoIntelipost();
		ocorrenciaRetorno.setHistorico(this.historico);
		ocorrenciaRetorno.setInvoice(this.invoice);
		ocorrenciaRetorno.setNumeroPedidoEntrega(this.numeroPedidoEntrega);
		ocorrenciaRetorno.setCodigoRastreamento(this.codigoRastreamento);
		ocorrenciaRetorno.setNumeroVolume(this.numeroVolume);
		ocorrenciaRetorno.setDataEstimadaEntregaPedido(this.dataEstimadaEntregaPedido);

		return ocorrenciaRetorno;
    }
}
