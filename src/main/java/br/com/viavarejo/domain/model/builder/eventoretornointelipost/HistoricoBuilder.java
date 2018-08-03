package br.com.viavarejo.domain.model.builder.eventoretornointelipost;

import java.util.Date;

import br.com.viavarejo.domain.model.mongodb.ocorrencia.eventointelipost.Historico;
import br.com.viavarejo.domain.model.mongodb.ocorrencia.eventointelipost.HistoricoStatusVolPedidoEnvio;

public class HistoricoBuilder {

	private Integer idVolumePedidoEnvio;
	private String macroStatusVolumePedidoEnvio;
	private String statusRastreamento;
	private Date dataCriacaoEvento;
	private String mensagemEnviadaPeloTransportador;
	private String statusEnviadoPeloTransportador;
	private String mensagemTraduzidaModeloIntelipost;
	private HistoricoStatusVolPedidoEnvio statusVolumePedidoEnvio;
	private String statusAtualVolumePedidoEnvio;
	private Integer historicoVolume;
	private Date dataEvento;

    private HistoricoBuilder() {}

    public static HistoricoBuilder init() {
        return new HistoricoBuilder();
    }

	public HistoricoBuilder idVolumePedidoEnvio(final Integer idVolumePedidoEnvio) {
		this.idVolumePedidoEnvio = idVolumePedidoEnvio;
        return this;
    }

	public HistoricoBuilder macroStatusVolumePedidoEnvio(final String macroStatusVolumePedidoEnvio) {
		this.macroStatusVolumePedidoEnvio = macroStatusVolumePedidoEnvio;
		return this;
	}

	public HistoricoBuilder statusRastreamento(final String statusRastreamento) {
		this.statusRastreamento = statusRastreamento;
		return this;
	}

	public HistoricoBuilder dataCriacaoEvento(final Date dataCriacaoEvento) {
		this.dataCriacaoEvento = dataCriacaoEvento;
		return this;
	}

	public HistoricoBuilder mensagemEnviadaPeloTransportador(final String mensagemEnviadaPeloTransportador) {
		this.mensagemEnviadaPeloTransportador = mensagemEnviadaPeloTransportador;
		return this;
	}

	public HistoricoBuilder statusEnviadoPeloTransportador(final String statusEnviadoPeloTransportador) {
		this.statusEnviadoPeloTransportador = statusEnviadoPeloTransportador;
		return this;
	}

	public HistoricoBuilder mensagemTraduzidaModeloIntelipost(final String mensagemTraduzidaModeloIntelipost) {
		this.mensagemTraduzidaModeloIntelipost = mensagemTraduzidaModeloIntelipost;
		return this;
	}

	public HistoricoBuilder statusVolumePedidoEnvio(final HistoricoStatusVolPedidoEnvio statusVolumePedidoEnvio) {
		this.statusVolumePedidoEnvio = statusVolumePedidoEnvio;
		return this;
	}

	public HistoricoBuilder historicoVolume(final Integer historicoVolume) {
		this.historicoVolume = historicoVolume;
		return this;
	}

	public HistoricoBuilder dataEvento(final Date dataEvento) {
		this.dataEvento = dataEvento;
		return this;
	}

	public Historico build() {

		final Historico historico = new Historico();
		historico.setIdVolumePedidoEnvio(this.idVolumePedidoEnvio);
		historico.setMacroStatusVolumePedidoEnvio(this.macroStatusVolumePedidoEnvio);
		historico.setStatusRastreamento(this.statusRastreamento);
		historico.setDataCriacaoEvento(this.dataCriacaoEvento);
		historico.setMensagemEnviadaPeloTransportador(this.mensagemEnviadaPeloTransportador);
		historico.setStatusEnviadoPeloTransportador(this.statusEnviadoPeloTransportador);
		historico.setMensagemTraduzidaModeloIntelipost(this.mensagemTraduzidaModeloIntelipost);
		historico.setStatusVolumePedidoEnvio(this.statusVolumePedidoEnvio);
		historico.setStatusAtualVolumePedidoEnvio(this.statusAtualVolumePedidoEnvio);
		historico.setHistoricoVolume(this.historicoVolume);
		historico.setDataEvento(this.dataEvento);
		return historico;
    }
}
