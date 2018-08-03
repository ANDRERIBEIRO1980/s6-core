package br.com.viavarejo.domain.model.mongodb.ocorrencia.eventointelipost;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.viavarejo.domain.DomainObject;
import io.swagger.annotations.ApiModelProperty;

public class EventoIntelipost implements DomainObject<EventoIntelipost> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Historico")
	@JsonProperty("history")
	private Historico historico;

	@ApiModelProperty(notes = "Invoice")
	@JsonProperty("invoice")
	private Invoice invoice;

	@ApiModelProperty(notes = "Numero do pedido de entrega.", required=false)
	@JsonProperty("order_number")
	private String numeroPedidoEntrega;

	@ApiModelProperty(notes = "Código de rastreamento.", required=false)
	@JsonProperty("tracking_code")
	private String codigoRastreamento;

	@ApiModelProperty(notes = "Número do volume.", required = false)
	@JsonProperty("volume_number")
	private String numeroVolume;

	@ApiModelProperty(notes = "Data estimada de entrega do pedido.", required = false)
	@JsonProperty("estimated_delivery_date")
	private PrevisaoEntregaPedido dataEstimadaEntregaPedido;

	public Historico getHistorico() {
		return this.historico;
	}

	public void setHistorico(final Historico historico) {
		this.historico = historico;
	}

	public Invoice getInvoice() {
		return this.invoice;
	}

	public void setInvoice(final Invoice invoice) {
		this.invoice = invoice;
	}

	public String getNumeroPedidoEntrega() {
		return this.numeroPedidoEntrega;
	}

	public void setNumeroPedidoEntrega(final String numeroPedidoEntrega) {
		this.numeroPedidoEntrega = numeroPedidoEntrega;
	}

	public String getCodigoRastreamento() {
		return this.codigoRastreamento;
	}

	public void setCodigoRastreamento(final String codigoRastreamento) {
		this.codigoRastreamento = codigoRastreamento;
	}

	public String getNumeroVolume() {
		return this.numeroVolume;
	}

	public void setNumeroVolume(final String numeroVolume) {
		this.numeroVolume = numeroVolume;
	}

	public PrevisaoEntregaPedido getDataEstimadaEntregaPedido() {
		return this.dataEstimadaEntregaPedido;
	}

	public void setDataEstimadaEntregaPedido(final PrevisaoEntregaPedido dataEstimadaEntregaPedido) {
		this.dataEstimadaEntregaPedido = dataEstimadaEntregaPedido;
	}

	@Override
	public String toString() {
		return "EventoIntelipost [historico=" + this.historico + ", invoice=" + this.invoice + ", numeroPedidoEntrega="
				+ this.numeroPedidoEntrega + ", codigoRastreamento=" + this.codigoRastreamento + ", numeroVolume="
				+ this.numeroVolume + ", dataEstimadaEntregaPedido=" + this.dataEstimadaEntregaPedido + "]";
	}

}
