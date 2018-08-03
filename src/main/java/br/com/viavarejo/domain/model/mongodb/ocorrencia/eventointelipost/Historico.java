package br.com.viavarejo.domain.model.mongodb.ocorrencia.eventointelipost;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.viavarejo.domain.DomainObject;
import io.swagger.annotations.ApiModelProperty;

public class Historico implements DomainObject<Historico> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Id do volume do pedido de envio.", required = false)
	@JsonProperty("shipment_order_volume_id")
	private Integer idVolumePedidoEnvio;

	@ApiModelProperty(notes = "Macro status do volume do pedido de envio.", required = false)
	@JsonProperty("shipment_order_volume_state")
	private String macroStatusVolumePedidoEnvio;

	@ApiModelProperty(notes = "Status do rastreamento.", required = false)
	@JsonProperty("tracking_state")
	private String statusRastreamento;

	@ApiModelProperty(notes = "Data de criação do evento em Unix Timestamp", required = false)
	@JsonProperty("created")
	private Date dataCriacaoEventoUnix;

	@ApiModelProperty(notes = "Data de criação do evento.", required = false)
	@JsonProperty("created_iso")
	private Date dataCriacaoEvento;

	@ApiModelProperty(notes = "Mensagem enviada pelo transportador.", required = false)
	@JsonProperty("provider_message")
	private String mensagemEnviadaPeloTransportador;

	@ApiModelProperty(notes = "Status enviado pelo transportador.", required = false)
	@JsonProperty("provider_state")
	private String statusEnviadoPeloTransportador;

	@ApiModelProperty(notes = "Status remetente (De-Para).", required = false)
	@JsonProperty("shipper_provider_state")
	private String statusRemetenteDePara;

	@ApiModelProperty(notes = "Mensagem traduzida no modelo Intelipost.", required = false)
	@JsonProperty("esprinter_message")
	private String mensagemTraduzidaModeloIntelipost;

	@ApiModelProperty(notes = "Micro status do volume do pedido de envio.", required = false)
	@JsonProperty("shipment_volume_micro_state")
	private HistoricoStatusVolPedidoEnvio statusVolumePedidoEnvio;

	@ApiModelProperty(notes = "Dados dos anexos.", required = false)
	@JsonProperty("attachments")
	private final List<HistoricoAnexo> anexos = new ArrayList<>();

	@ApiModelProperty(notes = "Status atual do volume do pedido de envio.", required = false)
	@JsonProperty("shipment_order_volume_state_localized")
	private String statusAtualVolumePedidoEnvio;

	@ApiModelProperty(notes = "Histórico do volume.", required = false)
	@JsonProperty("shipment_order_volume_state_history")
	private Integer historicoVolume;

	@ApiModelProperty(notes = "Data do evento em Unix Timestamp.", required = false)
	@JsonProperty("event_date")
	private Date dataEventoUnix;

	@ApiModelProperty(notes = "Data do evento.", required = false)
	@JsonProperty("event_date_iso")
	private Date dataEvento;

	public Integer getIdVolumePedidoEnvio() {
		return this.idVolumePedidoEnvio;
	}

	public void setIdVolumePedidoEnvio(final Integer idVolumePedidoEnvio) {
		this.idVolumePedidoEnvio = idVolumePedidoEnvio;
	}

	public String getMacroStatusVolumePedidoEnvio() {
		return this.macroStatusVolumePedidoEnvio;
	}

	public void setMacroStatusVolumePedidoEnvio(final String macroStatusVolumePedidoEnvio) {
		this.macroStatusVolumePedidoEnvio = macroStatusVolumePedidoEnvio;
	}

	public String getStatusRastreamento() {
		return this.statusRastreamento;
	}

	public void setStatusRastreamento(final String statusRastreamento) {
		this.statusRastreamento = statusRastreamento;
	}

	public Date getDataCriacaoEventoUnix() {
		return this.dataCriacaoEventoUnix;
	}

	public void setDataCriacaoEventoUnix(final Date dataCriacaoEventoUnix) {
		this.dataCriacaoEventoUnix = dataCriacaoEventoUnix;
	}

	public Date getDataCriacaoEvento() {
		return this.dataCriacaoEvento;
	}

	public void setDataCriacaoEvento(final Date dataCriacaoEvento) {
		this.dataCriacaoEvento = dataCriacaoEvento;
	}

	public String getMensagemEnviadaPeloTransportador() {
		return this.mensagemEnviadaPeloTransportador;
	}

	public void setMensagemEnviadaPeloTransportador(final String mensagemEnviadaPeloTransportador) {
		this.mensagemEnviadaPeloTransportador = mensagemEnviadaPeloTransportador;
	}

	public String getStatusEnviadoPeloTransportador() {
		return this.statusEnviadoPeloTransportador;
	}

	public void setStatusEnviadoPeloTransportador(final String statusEnviadoPeloTransportador) {
		this.statusEnviadoPeloTransportador = statusEnviadoPeloTransportador;
	}

	public String getMensagemTraduzidaModeloIntelipost() {
		return this.mensagemTraduzidaModeloIntelipost;
	}

	public void setMensagemTraduzidaModeloIntelipost(final String mensagemTraduzidaModeloIntelipost) {
		this.mensagemTraduzidaModeloIntelipost = mensagemTraduzidaModeloIntelipost;
	}

	public HistoricoStatusVolPedidoEnvio getStatusVolumePedidoEnvio() {
		return this.statusVolumePedidoEnvio;
	}

	public void setStatusVolumePedidoEnvio(final HistoricoStatusVolPedidoEnvio statusVolumePedidoEnvio) {
		this.statusVolumePedidoEnvio = statusVolumePedidoEnvio;
	}

	public String getStatusAtualVolumePedidoEnvio() {
		return this.statusAtualVolumePedidoEnvio;
	}

	public void setStatusAtualVolumePedidoEnvio(final String statusAtualVolumePedidoEnvio) {
		this.statusAtualVolumePedidoEnvio = statusAtualVolumePedidoEnvio;
	}

	public Integer getHistoricoVolume() {
		return this.historicoVolume;
	}

	public void setHistoricoVolume(final Integer historicoVolume) {
		this.historicoVolume = historicoVolume;
	}

	public Date getDataEventoUnix() {
		return this.dataEventoUnix;
	}

	public void setDataEventoUnix(final Date dataEventoUnix) {
		this.dataEventoUnix = dataEventoUnix;
	}

	public Date getDataEvento() {
		return this.dataEvento;
	}

	public void setDataEvento(final Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public List<HistoricoAnexo> getAnexos() {
		return this.anexos;
	}

	public String getStatusRemetenteDePara() {
		return this.statusRemetenteDePara;
	}

	public void setStatusRemetenteDePara(final String statusRemetenteDePara) {
		this.statusRemetenteDePara = statusRemetenteDePara;
	}

	@Override
	public String toString() {
		return "Historico [idVolumePedidoEnvio=" + this.idVolumePedidoEnvio + ", macroStatusVolumePedidoEnvio="
				+ this.macroStatusVolumePedidoEnvio + ", statusRastreamento=" + this.statusRastreamento
				+ ", dataCriacaoEventoUnix=" + this.dataCriacaoEventoUnix + ", dataCriacaoEvento="
				+ this.dataCriacaoEvento + ", mensagemEnviadaPeloTransportador=" + this.mensagemEnviadaPeloTransportador
				+ ", statusEnviadoPeloTransportador=" + this.statusEnviadoPeloTransportador + ", statusRemetenteDePara="
				+ this.statusRemetenteDePara + ", mensagemTraduzidaModeloIntelipost="
				+ this.mensagemTraduzidaModeloIntelipost
				+ ", statusVolumePedidoEnvio=" + this.statusVolumePedidoEnvio + ", anexos=" + this.anexos
				+ ", statusAtualVolumePedidoEnvio=" + this.statusAtualVolumePedidoEnvio + ", historicoVolume="
				+ this.historicoVolume + ", dataEventoUnix=" + this.dataEventoUnix + ", dataEvento=" + this.dataEvento
				+ "]";
	}

}
