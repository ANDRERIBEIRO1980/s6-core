package br.com.viavarejo.domain.model.builder.eventoretornointelipost;

import java.util.Date;

import br.com.viavarejo.domain.model.mongodb.ocorrencia.eventointelipost.HistoricoAnexo;
import br.com.viavarejo.domain.model.mongodb.ocorrencia.eventointelipost.HistoricoAnexoInfAdic;

public class HistoricoAnexoBuilder {

	private String nomeArquivo;
	private String identificacaoExtensaoAnexo;
	private String tipoArquivo;
	private String statusProcessamento;
	private HistoricoAnexoInfAdic informacoesAdicionais;
	private String urlAnexo;
	private Date dataCriacao;
	private Date dataModificacao;

    private HistoricoAnexoBuilder() {}

    public static HistoricoAnexoBuilder init() {
        return new HistoricoAnexoBuilder();
    }

	public HistoricoAnexoBuilder nomeArquivo(final String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
        return this;
	}

	public HistoricoAnexoBuilder identificacaoExtensaoAnexo(final String identificacaoExtensaoAnexo) {
		this.identificacaoExtensaoAnexo = identificacaoExtensaoAnexo;
		return this;
	}

	public HistoricoAnexoBuilder statusProcessamento(final String statusProcessamento) {
		this.statusProcessamento = statusProcessamento;
		return this;
	}

	public HistoricoAnexoBuilder urlAnexo(final String urlAnexo) {
		this.urlAnexo = urlAnexo;
		return this;
	}

	public HistoricoAnexoBuilder dataCriacao(final Date dataCriacao) {
		this.dataCriacao = dataCriacao;
		return this;
	}

	public HistoricoAnexoBuilder dataModificacao(final Date dataModificacao) {
		this.dataModificacao = dataModificacao;
		return this;
	}

	public HistoricoAnexo build() {

		final HistoricoAnexo historicoAnexo = new HistoricoAnexo();
		historicoAnexo.setNomeArquivo(this.nomeArquivo);
		historicoAnexo.setIdentificacaoExtensaoAnexo(this.identificacaoExtensaoAnexo);
		historicoAnexo.setTipoArquivo(this.tipoArquivo);
		historicoAnexo.setStatusProcessamento(this.statusProcessamento);
		historicoAnexo.setUrlAnexo(this.urlAnexo);
		historicoAnexo.setDataCriacao(this.dataCriacao);
		historicoAnexo.setDataModificacao(this.dataModificacao);

		return historicoAnexo;
    }
}
