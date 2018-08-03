package br.com.viavarejo.domain.model.mongodb.ocorrencia.eventointelipost;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.viavarejo.domain.DomainObject;
import io.swagger.annotations.ApiModelProperty;

public class HistoricoAnexo implements DomainObject<HistoricoAnexo> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Nome do arquivo.", required = false)
	@JsonProperty("file_name")
	private String nomeArquivo;

	@ApiModelProperty(notes = "Identificação da extensão dos anexos.", required = false)
	@JsonProperty("mime_type")
	private String identificacaoExtensaoAnexo;

	@ApiModelProperty(notes = "Tipo do arquivo.", required = false)
	@JsonProperty("type")
	private String tipoArquivo;

	@ApiModelProperty(notes = "Status de processamento.", required = false)
	@JsonProperty("processing_status")
	private String statusProcessamento;

	@ApiModelProperty(notes = "Informações adicionais do anexo.", required = false)
	@JsonProperty("additional_information")
	private HistoricoAnexoInfAdic informacoesAdicionais;

	@ApiModelProperty(notes = "URL do anexo.", required = false)
	@JsonProperty("url")
	private String urlAnexo;

	@ApiModelProperty(notes = "Data de criação em Unix Timestamp.", required = false)
	@JsonProperty("created")
	private Date dataCriacaoUnix;

	@ApiModelProperty(notes = "Data de criação", required = false)
	@JsonProperty("created_iso")
	private Date dataCriacao;

	@ApiModelProperty(notes = "Data de modificação em Unix Timestamp.", required = false)
	@JsonProperty("modified")
	private Date dataModificacaoUnix;

	@ApiModelProperty(notes = "Data de modificação em ISO.", required = false)
	@JsonProperty("modified_iso")
	private Date dataModificacao;

	public String getNomeArquivo() {
		return this.nomeArquivo;
	}

	public void setNomeArquivo(final String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public String getIdentificacaoExtensaoAnexo() {
		return this.identificacaoExtensaoAnexo;
	}

	public void setIdentificacaoExtensaoAnexo(final String identificacaoExtensaoAnexo) {
		this.identificacaoExtensaoAnexo = identificacaoExtensaoAnexo;
	}

	public String getTipoArquivo() {
		return this.tipoArquivo;
	}

	public void setTipoArquivo(final String tipoArquivo) {
		this.tipoArquivo = tipoArquivo;
	}

	public String getStatusProcessamento() {
		return this.statusProcessamento;
	}

	public void setStatusProcessamento(final String statusProcessamento) {
		this.statusProcessamento = statusProcessamento;
	}

	public HistoricoAnexoInfAdic getInformacoesAdicionais() {
		return this.informacoesAdicionais;
	}

	public void setInformacoesAdicionais(final HistoricoAnexoInfAdic informacoesAdicionais) {
		this.informacoesAdicionais = informacoesAdicionais;
	}

	public String getUrlAnexo() {
		return this.urlAnexo;
	}

	public void setUrlAnexo(final String urlAnexo) {
		this.urlAnexo = urlAnexo;
	}

	public Date getDataCriacaoUnix() {
		return this.dataCriacaoUnix;
	}

	public void setDataCriacaoUnix(final Date dataCriacaoUnix) {
		this.dataCriacaoUnix = dataCriacaoUnix;
	}

	public Date getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(final Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataModificacaoUnix() {
		return this.dataModificacaoUnix;
	}

	public void setDataModificacaoUnix(final Date dataModificacaoUnix) {
		this.dataModificacaoUnix = dataModificacaoUnix;
	}

	public Date getDataModificacao() {
		return this.dataModificacao;
	}

	public void setDataModificacao(final Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

	@Override
	public String toString() {
		return "HistoricoAnexo [nomeArquivo=" + this.nomeArquivo + ", identificacaoExtensaoAnexo="
				+ this.identificacaoExtensaoAnexo + ", tipoArquivo=" + this.tipoArquivo + ", statusProcessamento="
				+ this.statusProcessamento + ", informacoesAdicionais=" + this.informacoesAdicionais + ", urlAnexo="
				+ this.urlAnexo + ", dataCriacaoUnix=" + this.dataCriacaoUnix + ", dataCriacao=" + this.dataCriacao
				+ ", dataModificacaoUnix=" + this.dataModificacaoUnix + ", dataModificacao=" + this.dataModificacao
				+ "]";
	}

}
