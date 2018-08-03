package br.com.viavarejo.domain.model.mongodb.ocorrencia.eventointelipost;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.viavarejo.domain.DomainObject;
import io.swagger.annotations.ApiModelProperty;

public class PrevisaoEntregaPedido implements DomainObject<PrevisaoEntregaPedido> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Data estimada entrega Cliente")
	@JsonProperty("client")
	private PrevisaoEntregaPedidoCliente dataEstimadaEntregaCliente;

	@ApiModelProperty(notes = "Data estimada entrega Transportador")
	@JsonProperty("logistic_provider")
	private PrevisaoEntregaPedidoTransportadora dataEstimadaEntregaTransportadora;

	public PrevisaoEntregaPedidoCliente getDataEstimadaEntregaCliente() {
		return this.dataEstimadaEntregaCliente;
	}

	public void setDataEstimadaEntregaCliente(final PrevisaoEntregaPedidoCliente dataEstimadaEntregaCliente) {
		this.dataEstimadaEntregaCliente = dataEstimadaEntregaCliente;
	}

	public PrevisaoEntregaPedidoTransportadora getDataEstimadaEntregaTransportadora() {
		return this.dataEstimadaEntregaTransportadora;
	}

	public void setDataEstimadaEntregaTransportadora(
			final PrevisaoEntregaPedidoTransportadora dataEstimadaEntregaTransportadora) {
		this.dataEstimadaEntregaTransportadora = dataEstimadaEntregaTransportadora;
	}

	@Override
	public String toString() {
		return "PrevisaoEntregaPedido [dataEstimadaEntregaCliente=" + this.dataEstimadaEntregaCliente
				+ ", dataEstimadaEntregaTransportadora=" + this.dataEstimadaEntregaTransportadora + "]";
	}

}
