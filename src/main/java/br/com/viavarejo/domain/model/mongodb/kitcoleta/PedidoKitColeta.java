package br.com.viavarejo.domain.model.mongodb.kitcoleta;

import static br.com.viavarejo.util.DateUtils.FORMATO_BR_COMPLETO;
import static br.com.viavarejo.util.PortalTransportadorUtils.valoresConcatenados;
import static br.com.viavarejo.util.Utils.isNotEmpty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.viavarejo.domain.DomainObject;
import br.com.viavarejo.domain.model.mongodb.filial.FilialPK;
import br.com.viavarejo.domain.model.mongodb.pedido.Cliente;
import br.com.viavarejo.domain.model.mongodb.pedido.Complemento;
import br.com.viavarejo.domain.model.mongodb.pedido.Volume;
import br.com.viavarejo.domain.model.mongodb.transportador.TransportadorPK;
import br.com.viavarejo.infrastructure.converter.DateDeserializer;
import br.com.viavarejo.infrastructure.converter.DateSerializer;
import io.swagger.annotations.ApiModelProperty;

@Document(collection = "pedido_kit_coleta")
public class PedidoKitColeta implements DomainObject<PedidoKitColeta> {
	private static final long serialVersionUID = -7182760866878653434L;

	@ApiModelProperty(allowEmptyValue = true, hidden = true)
	@Id
	private ObjectId id;

	@ApiModelProperty(notes = "Chave do Pedido no DB2", required = true)
	@NotNull
	private Long codigo;

	@ApiModelProperty(notes = "Valor do Frete pago pelo Cliente", required = true)
	@NotNull
	private BigDecimal valorFreteCliente;

	@ApiModelProperty(notes = "Valor do Frete cobrado pela Transportadora", allowEmptyValue = true)
	private BigDecimal valorFreteTransportadora;

	@ApiModelProperty(notes = "Número do Pedido de envio", required = true)
	@NotBlank
	@Indexed
	private String numeroPedidoEnvio;

	@ApiModelProperty(notes = "Número do Pedido de venda", allowEmptyValue = true)
	private String numeroPedidoVenda;

	@ApiModelProperty(notes = "Número do Pedido original para reversa", allowEmptyValue = true)
	private String numeroPedidoOriginal;

	@ApiModelProperty(notes = "Número do Pedido pai", allowEmptyValue = true)
	private String numeroPedidoPai;

	@ApiModelProperty(notes = "Canal de Venda", required = true)
	@NotBlank
	private String canalVenda;

	@ApiModelProperty(notes = "Indica se a entrega é agendada", required = true)
	@NotNull
	private Boolean entregaAgendada;

	@ApiModelProperty(notes = "Hora inicial da entrega (Entrega Agendada)", allowEmptyValue = true)
	private String horaInicialEntrega;

	@ApiModelProperty(notes = "Hora final da entrega (Entrega Agendada)", allowEmptyValue = true)
	private String horaFinalEntrega;

	@ApiModelProperty(notes = "Diretório onde está o arquivo Zip", allowEmptyValue = true)
	private String diretorioArquivoZip;

	@ApiModelProperty(notes = "Nome do arquivo Zip", allowEmptyValue = true)
	private String nomeArquivoZip;

	@ApiModelProperty(notes = "Nome do arquivo Danfe", allowEmptyValue = true)
	private String nomeArquivoDanfe;

	@ApiModelProperty(notes = "Arquivo Danfe em base64", allowEmptyValue = true)
	private String arquivoDanfeEmBase64;

	@ApiModelProperty(notes = "Nome do arquivo do Laudo", allowEmptyValue = true)
	private String nomeArquivoLaudo;

	@ApiModelProperty(notes = "Arquivo do Laudo em base64", allowEmptyValue = true)
	private String arquivoLaudoEmBase64;

	@ApiModelProperty(notes = "Nome do arquivo do Notfis", allowEmptyValue = true)
	private String nomeArquivoNotfis;

	@ApiModelProperty(notes = "Arquivo do Notifis em base64", allowEmptyValue = true)
	private String arquivoNotfisEmBase64;

	@ApiModelProperty(notes = "Data de despacho do Pedido. Formato: dd/MM/yyyy HH:mm:ss", example = "10/04/2018 15:35:46", allowEmptyValue = true)
	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateDeserializer.class)
	@JsonFormat(pattern = FORMATO_BR_COMPLETO, locale = "pt_BR")
	@DateTimeFormat(pattern = FORMATO_BR_COMPLETO, iso = DateTimeFormat.ISO.DATE)
	private Date dataDespacho;

	@ApiModelProperty(notes = "Código do Método de Entrega - De acodo com a entidade MetodoEntrega", allowEmptyValue = true)
	private Integer tipoPedidoEnvio;

	@ApiModelProperty(notes = "Subtipo do Pedido de envio", allowEmptyValue = true)
	private String subtipoPedidoEnvio;

	@ApiModelProperty(notes = "Data de criação. Formato: dd/MM/yyyy HH:mm:ss", example = "10/04/2018 15:35:46", required = true)
	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateDeserializer.class)
	@JsonFormat(pattern = FORMATO_BR_COMPLETO, locale = "pt_BR")
	@DateTimeFormat(pattern = FORMATO_BR_COMPLETO, iso = DateTimeFormat.ISO.DATE)
	@NotNull
	private Date dataCriacao;

	@ApiModelProperty(notes = "Data estimada da Entrega Formato: dd/MM/yyyy HH:mm:ss", example = "10/04/2018 15:35:46", required = true)
	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateDeserializer.class)
	@JsonFormat(pattern = FORMATO_BR_COMPLETO, locale = "pt_BR")
	@DateTimeFormat(pattern = FORMATO_BR_COMPLETO, iso = DateTimeFormat.ISO.DATE)
	@NotNull
	private Date dataEstimadaEntrega;

	@ApiModelProperty(notes = "Chave composta da transportadora no DB2", required = true)
	@Valid
	private TransportadorPK transportador;

	@ApiModelProperty(notes = "Código da responsável pela entrega (transportadora)", allowEmptyValue = true)
	private String metodoEntrega;

	@ApiModelProperty(notes = "Chave composta do Embarcador/Filial no DB2", required = true)
	@Valid
	private FilialPK embarcador;

	@ApiModelProperty(notes = "Chave única do Embarcador/Filial", required = false, hidden = true)
	private String codigoIntegradoEmbarcador;

	@ApiModelProperty(notes = "Informações do Cliente", required = true)
	@Valid
	private Cliente cliente;

	@ApiModelProperty(notes = "Complemento Notifis", allowEmptyValue = true)
	private Complemento complemento;

	@ApiModelProperty(notes = "Coleção de Volumes", required = true)
	@Valid
	private List<Volume> volumes;

	@ApiModelProperty(notes = "Flag para tornar a entidade visível à integração", required = false, hidden = true)
	@Indexed
	private Boolean integracaoIntelipost;

	public PedidoKitColeta() {
		super();
		this.canalVenda = "";
		this.volumes = new ArrayList<>();
	}

	public ObjectId getId() {
		return this.id;
	}

	public void setId(final ObjectId id) {
		this.id = id;
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(final Long codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getValorFreteCliente() {
		return this.valorFreteCliente;
	}

	public void setValorFreteCliente(final BigDecimal valorFreteCliente) {
		this.valorFreteCliente = valorFreteCliente;
	}

	public BigDecimal getValorFreteTransportadora() {
		return this.valorFreteTransportadora;
	}

	public void setValorFreteTransportadora(final BigDecimal valorFreteTransportadora) {
		this.valorFreteTransportadora = valorFreteTransportadora;
	}

	public String getNumeroPedidoEnvio() {
		return this.numeroPedidoEnvio;
	}

	public void setNumeroPedidoEnvio(final String numeroPedidoEnvio) {
		this.numeroPedidoEnvio = numeroPedidoEnvio;
	}

	public String getNumeroPedidoVenda() {
		return this.numeroPedidoVenda;
	}

	public void setNumeroPedidoVenda(final String numeroPedidoVenda) {
		this.numeroPedidoVenda = numeroPedidoVenda;
	}

	public String getNumeroPedidoOriginal() {
		return this.numeroPedidoOriginal;
	}

	public void setNumeroPedidoOriginal(final String numeroPedidoOriginal) {
		this.numeroPedidoOriginal = numeroPedidoOriginal;
	}

	public String getCanalVenda() {
		return this.canalVenda;
	}

	public void setCanalVenda(final String canalVenda) {
		this.canalVenda = canalVenda;
	}

	public Boolean getEntregaAgendada() {
		return this.entregaAgendada;
	}

	public void setEntregaAgendada(final Boolean entregaAgendada) {
		this.entregaAgendada = entregaAgendada;
	}

	public String getHoraInicialEntrega() {
		return this.horaInicialEntrega;
	}

	public void setHoraInicialEntrega(final String horaInicialEntrega) {
		this.horaInicialEntrega = horaInicialEntrega;
	}

	public String getHoraFinalEntrega() {
		return this.horaFinalEntrega;
	}

	public void setHoraFinalEntrega(final String horaFinalEntrega) {
		this.horaFinalEntrega = horaFinalEntrega;
	}

	public Date getDataDespacho() {
		return this.dataDespacho;
	}

	public void setDataDespacho(final Date dataDespacho) {
		this.dataDespacho = dataDespacho;
	}

	public Integer getTipoPedidoEnvio() {
		return this.tipoPedidoEnvio;
	}

	public void setTipoPedidoEnvio(final Integer tipoPedidoEnvio) {
		this.tipoPedidoEnvio = tipoPedidoEnvio;
	}

	public String getSubtipoPedidoEnvio() {
		return this.subtipoPedidoEnvio;
	}

	public void setSubtipoPedidoEnvio(final String subtipoPedidoEnvio) {
		this.subtipoPedidoEnvio = subtipoPedidoEnvio;
	}

	public String getMetodoEntrega() {
		return this.metodoEntrega;
	}

	public void setMetodoEntrega(final String metodoEntrega) {
		this.metodoEntrega = metodoEntrega;
	}

	public Date getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(final Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataEstimadaEntrega() {
		return this.dataEstimadaEntrega;
	}

	public void setDataEstimadaEntrega(final Date dataEstimadaEntrega) {
		this.dataEstimadaEntrega = dataEstimadaEntrega;
	}

	public TransportadorPK getTransportador() {
		return this.transportador;
	}

	public void setTransportador(final TransportadorPK transportador) {
		this.transportador = transportador;
	}

	public FilialPK getEmbarcador() {
		return this.embarcador;
	}

	public void setEmbarcador(final FilialPK embarcador) {
		this.embarcador = embarcador;
	}

	public String getCodigoIntegradoEmbarcador() {
		return this.codigoIntegradoEmbarcador;
	}

	public void setCodigoIntegradoEmbarcador(final String codigoIntegradoEmbarcador) {
		this.codigoIntegradoEmbarcador = codigoIntegradoEmbarcador;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(final Cliente cliente) {
		this.cliente = cliente;
	}

	public Complemento getComplemento() {
		return this.complemento;
	}

	public void setComplemento(final Complemento complemento) {
		this.complemento = complemento;
	}

	public List<Volume> getVolumes() {
		return this.volumes;
	}

	public void setVolumes(final List<Volume> volumes) {
		this.volumes = volumes;
	}

	public String getNumeroPedidoPai() {
		return this.numeroPedidoPai;
	}

	public void setNumeroPedidoPai(final String numeroPedidoPai) {
		this.numeroPedidoPai = numeroPedidoPai;
	}

	public String getDiretorioArquivoZip() {
		return this.diretorioArquivoZip;
	}

	public void setDiretorioArquivoZip(final String diretorioArquivoZip) {
		this.diretorioArquivoZip = diretorioArquivoZip;
	}

	public String getNomeArquivoZip() {
		return this.nomeArquivoZip;
	}

	public void setNomeArquivoZip(final String nomeArquivoZip) {
		this.nomeArquivoZip = nomeArquivoZip;
	}

	public String getNomeArquivoDanfe() {
		return this.nomeArquivoDanfe;
	}

	public void setNomeArquivoDanfe(final String nomeArquivoDanfe) {
		this.nomeArquivoDanfe = nomeArquivoDanfe;
	}

	public String getArquivoDanfeEmBase64() {
		return this.arquivoDanfeEmBase64;
	}

	public void setArquivoDanfeEmBase64(final String arquivoDanfeEmBase64) {
		this.arquivoDanfeEmBase64 = arquivoDanfeEmBase64;
	}

	public String getNomeArquivoLaudo() {
		return this.nomeArquivoLaudo;
	}

	public void setNomeArquivoLaudo(final String nomeArquivoLaudo) {
		this.nomeArquivoLaudo = nomeArquivoLaudo;
	}

	public String getArquivoLaudoEmBase64() {
		return this.arquivoLaudoEmBase64;
	}

	public void setArquivoLaudoEmBase64(final String arquivoLaudoEmBase64) {
		this.arquivoLaudoEmBase64 = arquivoLaudoEmBase64;
	}

	public String getNomeArquivoNotfis() {
		return this.nomeArquivoNotfis;
	}

	public void setNomeArquivoNotfis(final String nomeArquivoNotfis) {
		this.nomeArquivoNotfis = nomeArquivoNotfis;
	}

	public String getArquivoNotfisEmBase64() {
		return this.arquivoNotfisEmBase64;
	}

	public void setArquivoNotfisEmBase64(final String arquivoNotfisEmBase64) {
		this.arquivoNotfisEmBase64 = arquivoNotfisEmBase64;
	}

	public Boolean getIntegracaoIntelipost() {
		return this.integracaoIntelipost;
	}

	public void setIntegracaoIntelipost(final Boolean integracaoIntelipost) {
		this.integracaoIntelipost = integracaoIntelipost;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Prepara a entidade antes de submeta-la ao banco:<br>
	 *
	 * - Torna visivel para a integracao com a Intelipost<br>
	 * - Atribuí ao campo codigoIntegradoEmbarcador um id unico com base na pk
	 * da filial de emissao<br>
	 * - Atribuí ao campo metodoEntrega um id unico com base na pk da
	 * transportadora de entrega e seu tipo de envio<br>
	 */
	public void prepararEntidade() {
		this.visivelIntelipost();

		if (isNotEmpty(this.embarcador)) {
			this.codigoIntegradoEmbarcador = valoresConcatenados(this.embarcador.getCodigo(),
					this.embarcador.getEmpresa());
		}

		if (isNotEmpty(this.transportador)) {
			this.metodoEntrega = valoresConcatenados(this.transportador.getCodigo(),
					this.transportador.getCodigoEmpresa(), this.tipoPedidoEnvio);
		}
	}

	/**
	 * Tera a flag {@code #integracaoIntelipost} setada para {@code true}
	 */
	public void visivelIntelipost() {
		this.integracaoIntelipost = true;
	}

	/**
	 * Tera a flag {@code #integracaoIntelipost} setada para {@code null}
	 */
	public void naoVisivelIntelipost() {
		this.integracaoIntelipost = null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.numeroPedidoEnvio == null) ? 0 : this.numeroPedidoEnvio.hashCode());
		result = (prime * result) + ((this.numeroPedidoOriginal == null) ? 0 : this.numeroPedidoOriginal.hashCode());
		result = (prime * result) + ((this.numeroPedidoVenda == null) ? 0 : this.numeroPedidoVenda.hashCode());
		result = (prime * result) + ((this.subtipoPedidoEnvio == null) ? 0 : this.subtipoPedidoEnvio.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final PedidoKitColeta other = (PedidoKitColeta) obj;
		if (this.numeroPedidoEnvio == null) {
			if (other.numeroPedidoEnvio != null) {
				return false;
			}
		} else if (!this.numeroPedidoEnvio.equals(other.numeroPedidoEnvio)) {
			return false;
		}
		if (this.numeroPedidoOriginal == null) {
			if (other.numeroPedidoOriginal != null) {
				return false;
			}
		} else if (!this.numeroPedidoOriginal.equals(other.numeroPedidoOriginal)) {
			return false;
		}
		if (this.numeroPedidoVenda == null) {
			if (other.numeroPedidoVenda != null) {
				return false;
			}
		} else if (!this.numeroPedidoVenda.equals(other.numeroPedidoVenda)) {
			return false;
		}
		if (this.subtipoPedidoEnvio == null) {
			if (other.subtipoPedidoEnvio != null) {
				return false;
			}
		} else if (!this.subtipoPedidoEnvio.equals(other.subtipoPedidoEnvio)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		final ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";
		try {
			// mapper.enable(SerializationFeature.INDENT_OUTPUT);
			jsonString = mapper.writeValueAsString(this);
		} catch (final JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonString;
	}
}
