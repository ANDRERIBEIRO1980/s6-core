package br.com.viavarejo.domain.model.mongodb.ocorrencia.eventointelipost;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.viavarejo.domain.DomainObject;
import io.swagger.annotations.ApiModelProperty;

public class HistoricoStatusVolPedidoEnvio implements DomainObject<HistoricoStatusVolPedidoEnvio> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Identificador Intelipost do micro status.", required = false)
	@JsonProperty("id")
	private Integer idIntelipostMicroStatus;

	@ApiModelProperty(notes = "Código Intelipost do micro status.", required = false)
	@JsonProperty("code")
	private String codIntelipostMicroStatus;

	@ApiModelProperty(notes = "Nome padrão.", required = false)
	@JsonProperty("default_name")
	private String nomePadrao;

	@ApiModelProperty(notes = "Nome internacionalizado.", required = false)
	@JsonProperty("i18n_name")
	private String nomeInternacionalizado;

	@ApiModelProperty(notes = "Descrição do status.", required = false)
	@JsonProperty("description")
	private String descricaoStatus;

	@ApiModelProperty(notes = "Identificador do volume.", required = false)
	@JsonProperty("shipment_order_volume_state_id")
	private Integer identificadorVolume;

	@ApiModelProperty(notes = "Identificador da origem do volume.", required = false)
	@JsonProperty("shipment_volume_state_source_id")
	private Integer identificadorOrigemVolume;

	@ApiModelProperty(notes = "Nome do stauts.", required = false)
	@JsonProperty("name")
	private String nomeStatus;

	public Integer getIdIntelipostMicroStatus() {
		return this.idIntelipostMicroStatus;
	}

	public void setIdIntelipostMicroStatus(final Integer idIntelipostMicroStatus) {
		this.idIntelipostMicroStatus = idIntelipostMicroStatus;
	}

	public String getCodIntelipostMicroStatus() {
		return this.codIntelipostMicroStatus;
	}

	public void setCodIntelipostMicroStatus(final String codIntelipostMicroStatus) {
		this.codIntelipostMicroStatus = codIntelipostMicroStatus;
	}

	public String getNomePadrao() {
		return this.nomePadrao;
	}

	public void setNomePadrao(final String nomePadrao) {
		this.nomePadrao = nomePadrao;
	}

	public String getNomeInternacionalizado() {
		return this.nomeInternacionalizado;
	}

	public void setNomeInternacionalizado(final String nomeInternacionalizado) {
		this.nomeInternacionalizado = nomeInternacionalizado;
	}

	public String getDescricaoStatus() {
		return this.descricaoStatus;
	}

	public void setDescricaoStatus(final String descricaoStatus) {
		this.descricaoStatus = descricaoStatus;
	}

	public Integer getIdentificadorVolume() {
		return this.identificadorVolume;
	}

	public void setIdentificadorVolume(final Integer identificadorVolume) {
		this.identificadorVolume = identificadorVolume;
	}

	public Integer getIdentificadorOrigemVolume() {
		return this.identificadorOrigemVolume;
	}

	public void setIdentificadorOrigemVolume(final Integer identificadorOrigemVolume) {
		this.identificadorOrigemVolume = identificadorOrigemVolume;
	}

	public String getNomeStatus() {
		return this.nomeStatus;
	}

	public void setNomeStatus(final String nomeStatus) {
		this.nomeStatus = nomeStatus;
	}

	@Override
	public String toString() {
		return "HistoricoStatusVolPedidoEnvio [idIntelipostMicroStatus=" + this.idIntelipostMicroStatus
				+ ", codIntelipostMicroStatus=" + this.codIntelipostMicroStatus + ", nomePadrao=" + this.nomePadrao
				+ ", nomeInternacionalizado=" + this.nomeInternacionalizado + ", descricaoStatus="
				+ this.descricaoStatus + ", identificadorVolume=" + this.identificadorVolume
				+ ", identificadorOrigemVolume=" + this.identificadorOrigemVolume + ", nomeStatus=" + this.nomeStatus
				+ "]";
	}

}
