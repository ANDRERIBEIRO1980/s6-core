package br.com.viavarejo.domain.model.mongodb.ocorrencia.eventointelipost;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.viavarejo.domain.DomainObject;
import io.swagger.annotations.ApiModelProperty;

public class HistoricoAnexoInfAdic implements DomainObject<HistoricoAnexoInfAdic> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Campo liberado para customizações adicionais. (Não é necessário enviar 'key1'.)	optional", required = false)
	@JsonProperty("key1")
	private String key1;

	@ApiModelProperty(notes = "Campo liberado para customizações adicionais. (Não é necessário enviar 'key2'.)	optional", required = false)
	@JsonProperty("key2")
	private String key2;

	public String getKey1() {
		return this.key1;
	}

	public void setKey1(final String key1) {
		this.key1 = key1;
	}

	public String getKey2() {
		return this.key2;
	}

	public void setKey2(final String key2) {
		this.key2 = key2;
	}

	@Override
	public String toString() {
		return "HistoricoAnexoInfAdic [key1=" + this.key1 + ", key2=" + this.key2 + "]";
	}

}
