package br.com.viavarejo.domain.model.mongodb.ocorrencia.eventointelipost;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.viavarejo.domain.DomainObject;
import io.swagger.annotations.ApiModelProperty;

public class PrevisaoEntregaPedidoTransportadora implements DomainObject<PrevisaoEntregaPedidoTransportadora> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Data estimada de entrega (transportadora) atual em Unix Timestamp.", required = false)
	@JsonProperty("current")
	private Date dataEstimadaUnix;

	@ApiModelProperty(notes = "Data estimada de entrega (transportadora) atual em Timestamp.", required = false)
	@JsonProperty("current_iso")
	private Date dataEstimada;

	@ApiModelProperty(notes = "Data estimada de entrega (transportadora) sem nenhuma regra de negócio aplicada. É enviado no formato unix timestamp.", required = false)
	@JsonProperty("original")
	private Date dataOrignalUnix;

	@ApiModelProperty(notes = "Data estimada de entrega (transportadora) sem nenhuma regra de negócio aplicada. É enviado no formato unix timestamp.", required = false)
	@JsonProperty("original_iso")
	private Date dataOrignal;

	public Date getDataEstimadaUnix() {
		return this.dataEstimadaUnix;
	}

	public void setDataEstimadaUnix(final Date dataEstimadaUnix) {
		this.dataEstimadaUnix = dataEstimadaUnix;
	}

	public Date getDataEstimada() {
		return this.dataEstimada;
	}

	public void setDataEstimada(final Date dataEstimada) {
		this.dataEstimada = dataEstimada;
	}

	public Date getDataOrignalUnix() {
		return this.dataOrignalUnix;
	}

	public void setDataOrignalUnix(final Date dataOrignalUnix) {
		this.dataOrignalUnix = dataOrignalUnix;
	}

	public Date getDataOrignal() {
		return this.dataOrignal;
	}

	public void setDataOrignal(final Date dataOrignal) {
		this.dataOrignal = dataOrignal;
	}

	@Override
	public String toString() {
		return "PrevisaoEntregaPedidoTransportadora [dataEstimadaUnix=" + this.dataEstimadaUnix + ", dataEstimada="
				+ this.dataEstimada + ", dataOrignalUnix=" + this.dataOrignalUnix + ", dataOrignal=" + this.dataOrignal
				+ "]";
	}

}
