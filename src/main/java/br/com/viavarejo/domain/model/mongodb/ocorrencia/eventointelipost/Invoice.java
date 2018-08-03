package br.com.viavarejo.domain.model.mongodb.ocorrencia.eventointelipost;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.viavarejo.domain.DomainObject;
import io.swagger.annotations.ApiModelProperty;

public class Invoice implements DomainObject<Invoice> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Série da nota fiscal.", required = false)
	@JsonProperty("invoice_series")
	private String serieNotaFiscal;

	@ApiModelProperty(notes = "Número da nota fiscal.", required = false)
	@JsonProperty("invoice_number")
	private String numeroNotaFiscal;

	@ApiModelProperty(notes = "Chave da nota fiscal.", required = false)
	@JsonProperty("invoice_key")
	private String chaveNotaFiscal;

	public String getSerieNotaFiscal() {
		return this.serieNotaFiscal;
	}

	public void setSerieNotaFiscal(final String serieNotaFiscal) {
		this.serieNotaFiscal = serieNotaFiscal;
	}

	public String getNumeroNotaFiscal() {
		return this.numeroNotaFiscal;
	}

	public void setNumeroNotaFiscal(final String numeroNotaFiscal) {
		this.numeroNotaFiscal = numeroNotaFiscal;
	}

	public String getChaveNotaFiscal() {
		return this.chaveNotaFiscal;
	}

	public void setChaveNotaFiscal(final String chaveNotaFiscal) {
		this.chaveNotaFiscal = chaveNotaFiscal;
	}

	@Override
	public String toString() {
		return "Invoice [serieNotaFiscal=" + this.serieNotaFiscal + ", numeroNotaFiscal=" + this.numeroNotaFiscal
				+ ", chaveNotaFiscal=" + this.chaveNotaFiscal + "]";
	}

}
