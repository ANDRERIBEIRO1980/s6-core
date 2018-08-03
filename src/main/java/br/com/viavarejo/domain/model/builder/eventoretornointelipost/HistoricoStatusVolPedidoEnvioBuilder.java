package br.com.viavarejo.domain.model.builder.eventoretornointelipost;

import br.com.viavarejo.domain.model.mongodb.ocorrencia.eventointelipost.HistoricoStatusVolPedidoEnvio;

public class HistoricoStatusVolPedidoEnvioBuilder {

	private Integer idIntelipostMicroStatus;
	private String codIntelipostMicroStatus;
	private String nomePadrao;
	private String nomeInternacionalizado;
	private String descricaoStatus;
	private Integer identificadorVolume;
	private Integer identificadorOrigemVolume;
	private String nomeStatus;

    private HistoricoStatusVolPedidoEnvioBuilder() {}

    public static HistoricoStatusVolPedidoEnvioBuilder init() {
        return new HistoricoStatusVolPedidoEnvioBuilder();
    }

	public HistoricoStatusVolPedidoEnvioBuilder idIntelipostMicroStatus(final Integer idIntelipostMicroStatus) {
		this.idIntelipostMicroStatus = idIntelipostMicroStatus;
        return this;
    }

	public HistoricoStatusVolPedidoEnvioBuilder codIntelipostMicroStatus(final String codIntelipostMicroStatus) {
		this.codIntelipostMicroStatus = codIntelipostMicroStatus;
		return this;
	}

	public HistoricoStatusVolPedidoEnvioBuilder nomePadrao(final String nomePadrao) {
		this.nomePadrao = nomePadrao;
		return this;
	}

	public HistoricoStatusVolPedidoEnvioBuilder nomeInternacionalizado(final String nomeInternacionalizado) {
		this.nomeInternacionalizado = nomeInternacionalizado;
		return this;
	}

	public HistoricoStatusVolPedidoEnvioBuilder descricaoStatus(final String descricaoStatus) {
		this.descricaoStatus = descricaoStatus;
		return this;
	}

	public HistoricoStatusVolPedidoEnvioBuilder identificadorVolume(final Integer identificadorVolume) {
		this.identificadorVolume = identificadorVolume;
		return this;
	}

	public HistoricoStatusVolPedidoEnvioBuilder identificadorOrigemVolume(final Integer identificadorOrigemVolume) {
		this.identificadorOrigemVolume = identificadorOrigemVolume;
		return this;
	}

	public HistoricoStatusVolPedidoEnvioBuilder nomeStatus(final String nomeStatus) {
		this.nomeStatus = nomeStatus;
		return this;
	}



	public HistoricoStatusVolPedidoEnvio build() {

		final HistoricoStatusVolPedidoEnvio historicoVolume = new HistoricoStatusVolPedidoEnvio();
		historicoVolume.setIdIntelipostMicroStatus(this.idIntelipostMicroStatus);
		historicoVolume.setCodIntelipostMicroStatus(this.codIntelipostMicroStatus);
		historicoVolume.setNomePadrao(this.nomePadrao);
		historicoVolume.setNomeInternacionalizado(this.nomeInternacionalizado);
		historicoVolume.setDescricaoStatus(this.descricaoStatus);
		historicoVolume.setIdentificadorVolume(this.identificadorVolume);
		historicoVolume.setIdentificadorOrigemVolume(this.identificadorOrigemVolume);
		return historicoVolume;
    }
}
