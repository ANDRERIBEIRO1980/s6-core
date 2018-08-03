package br.com.viavarejo.domain.model.mongodb.cobranca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.viavarejo.domain.DomainObject;
import br.com.viavarejo.infrastructure.converter.DateDeserializer;
import br.com.viavarejo.infrastructure.converter.DateSerializer;
import br.com.viavarejo.util.DateUtils;
import io.swagger.annotations.ApiModelProperty;

@Document(collection = "ressarcimento")
public class Ressarcimento implements DomainObject<Ressarcimento> {
    private static final long serialVersionUID = -3137760242666811717L;

    @Id
    private ObjectId id;

    @ApiModelProperty(notes = "Chave do Ressarcimento no DB2", required = true)
    @NotNull
    private Long pk;

    @ApiModelProperty(notes = "Código do Pedido", required = true)
    @NotBlank
    private String numeroPedidoEnvio;

    @ApiModelProperty(notes = "Data de criação do Ressarcimento", value = "Este campo deve seguir o padrão dd/MM/yyyy HH:mm:ss",
                    example = "08/10/2016 15:20:15", required = false)
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    @JsonFormat(pattern = DateUtils.FORMATO_BR_COMPLETO, locale = "pt_BR")
    @DateTimeFormat(pattern = DateUtils.FORMATO_BR_COMPLETO, iso = DateTimeFormat.ISO.DATE)
    private Date dataCriacao;

    @ApiModelProperty(notes = "Tipo", required = false)
    private String tipo;

    @ApiModelProperty(notes = "Motivo", required = false)
    private String motivo;

    @ApiModelProperty(notes = "Motivo do Cliente", required = false)
	private String motivoCliente;

    @ApiModelProperty(notes = "Tipo da Entrega", required = false)
    private String tipoEntrega;

    @ApiModelProperty(notes = "Código do Ponto de Controle", required = false)
    private String codigoPontoControle;

    @ApiModelProperty(notes = "Descrição do Ponto de Controle", required = false)
    private String descricaoPontoControle;

    @ApiModelProperty(notes = "Usuário responsável pelo Ponto de Controle", required = false)
    private String usuarioPontoControle;

    @ApiModelProperty(notes = "Data de Referência Fiscal",
                    value = "Data de entrada do produto no Estoque. Este campo deve seguir o padrão dd/MM/yyyy HH:mm:ss",
                    example = "08/10/2016 15:20:15", required = false)
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    @JsonFormat(pattern = DateUtils.FORMATO_BR_COMPLETO, locale = "pt_BR")
    @DateTimeFormat(pattern = DateUtils.FORMATO_BR_COMPLETO, iso = DateTimeFormat.ISO.DATE)
    private Date dataReferenciaFiscal;

    @ApiModelProperty(notes = "Número da Referência Fiscal", value = "Número de Referência de entrada do produto no estoque.",
                    required = false)
    private String referenciaFiscal;

    @ApiModelProperty(notes = "Número da Referência Fiscal", required = false)
    private String usuario;

    @ApiModelProperty(notes = "Status da Coleta", required = false)
    private String statusColeta;

    @ApiModelProperty(notes = "Código da Coleta", required = false)
    private Long codigoColeta;

    @ApiModelProperty(notes = "Código do Pedido de Informação (PI) ", required = false)
    private Long codigoPedidoInformacao;

	@ApiModelProperty(notes = "Ressarcimento forçado?", required = false)
	private String ressarcimentoForcado;

    @ApiModelProperty(notes = "Mercadorias para Ressarcimento", required = false)
	private List<MercadoriaRessarcimento> mercadorias = new ArrayList<>();

	@ApiModelProperty(notes = "Informações sobre Impostos", required = false)
	private ImpostoRessarcimento impostos;

	@ApiModelProperty(notes = "Informações sobre Pedido de Venda", required = false)
	private PedidoVendaInforRessarcimento pedidoVendaInfor;

	@ApiModelProperty(notes = "Informações sobre Nota Fiscal", required = false)
	private NotaFiscalRessarcimento pedidoVendaNotaFiscal;

    private Boolean integracaoIntelipost;

    public Ressarcimento() {}

    public ObjectId getId() {
        return this.id;
    }

    public void setId(final ObjectId id) {
        this.id = id;
    }

    public Long getPk() {
        return this.pk;
    }

    public void setPk(final Long pk) {
        this.pk = pk;
    }

    public String getNumeroPedidoEnvio() {
        return this.numeroPedidoEnvio;
    }

    public void setNumeroPedidoEnvio(final String numeroPedidoEnvio) {
        this.numeroPedidoEnvio = numeroPedidoEnvio;
    }

    public Date getDataCriacao() {
        return this.dataCriacao;
    }

    public void setDataCriacao(final Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(final String tipo) {
        this.tipo = tipo;
    }

    public String getMotivo() {
        return this.motivo;
    }

    public void setMotivo(final String motivo) {
        this.motivo = motivo;
    }

	public String getMotivoCliente() {
		return this.motivoCliente;
	}

	public void setMotivoCliente(final String motivoCliente) {
		this.motivoCliente = motivoCliente;
	}

    public String getTipoEntrega() {
        return this.tipoEntrega;
    }

    public void setTipoEntrega(final String tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public String getCodigoPontoControle() {
        return this.codigoPontoControle;
    }

    public void setCodigoPontoControle(final String codigoPontoControle) {
        this.codigoPontoControle = codigoPontoControle;
    }

    public String getDescricaoPontoControle() {
        return this.descricaoPontoControle;
    }

    public void setDescricaoPontoControle(final String descricaoPontoControle) {
        this.descricaoPontoControle = descricaoPontoControle;
    }

    public String getUsuarioPontoControle() {
        return this.usuarioPontoControle;
    }

    public void setUsuarioPontoControle(final String usuarioPontoControle) {
        this.usuarioPontoControle = usuarioPontoControle;
    }

    public Date getDataReferenciaFiscal() {
        return this.dataReferenciaFiscal;
    }

    public void setDataReferenciaFiscal(final Date dataReferenciaFiscal) {
        this.dataReferenciaFiscal = dataReferenciaFiscal;
    }

    public String getReferenciaFiscal() {
        return this.referenciaFiscal;
    }

    public void setReferenciaFiscal(final String referenciaFiscal) {
        this.referenciaFiscal = referenciaFiscal;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(final String usuario) {
        this.usuario = usuario;
    }

    public String getStatusColeta() {
        return this.statusColeta;
    }

    public void setStatusColeta(final String statusColeta) {
        this.statusColeta = statusColeta;
    }

    public Long getCodigoColeta() {
        return this.codigoColeta;
    }

    public void setCodigoColeta(final Long codigoColeta) {
        this.codigoColeta = codigoColeta;
    }

    public Long getCodigoPedidoInformacao() {
        return this.codigoPedidoInformacao;
    }

    public void setCodigoPedidoInformacao(final Long codigoPedidoInformacao) {
        this.codigoPedidoInformacao = codigoPedidoInformacao;
    }

    public List<MercadoriaRessarcimento> getMercadorias() {
        return this.mercadorias;
    }

    public void setMercadorias(final List<MercadoriaRessarcimento> mercadorias) {
        this.mercadorias = mercadorias;
    }


	public String isRessarcimentoForcado() {
		return this.ressarcimentoForcado;
	}

	public void setRessarcimentoForcado(final String ressarcimentoForcado) {
		this.ressarcimentoForcado = ressarcimentoForcado;
	}

	public Boolean getIntegracaoIntelipost() {
        return this.integracaoIntelipost;
    }

    public void setIntegracaoIntelipost(final Boolean integracaoIntelipost) {
        this.integracaoIntelipost = integracaoIntelipost;
    }

	public ImpostoRessarcimento getImpostos() {
		return this.impostos;
	}

	public void setImpostos(final ImpostoRessarcimento impostos) {
		this.impostos = impostos;
	}

	public PedidoVendaInforRessarcimento getPedidoVendaInfor() {
		return this.pedidoVendaInfor;
	}

	public void setPedidoVendaInfor(final PedidoVendaInforRessarcimento pedidoVendaInfor) {
		this.pedidoVendaInfor = pedidoVendaInfor;
	}

	public NotaFiscalRessarcimento getPedidoVendaNotaFiscal() {
		return this.pedidoVendaNotaFiscal;
	}

	public void setPedidoVendaNotaFiscal(final NotaFiscalRessarcimento pedidoVendaNotaFiscal) {
		this.pedidoVendaNotaFiscal = pedidoVendaNotaFiscal;
	}

    /**
     * Tera a flag {@code #integracaoIntelipost} setada para {@code true}
     */
    public void visivelIntelipost() {
        this.integracaoIntelipost = Boolean.TRUE;
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
        result = (prime * result) + ((this.pk == null) ? 0 : this.pk.hashCode());
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
        if (!(obj instanceof Ressarcimento)) {
            return false;
        }
        final Ressarcimento other = (Ressarcimento) obj;
        if (this.pk == null) {
            if (other.pk != null) {
                return false;
            }
        } else if (!this.pk.equals(other.pk)) {
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
