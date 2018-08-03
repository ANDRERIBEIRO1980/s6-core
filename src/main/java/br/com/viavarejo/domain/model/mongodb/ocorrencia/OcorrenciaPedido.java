package br.com.viavarejo.domain.model.mongodb.ocorrencia;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.viavarejo.domain.DomainObject;
import br.com.viavarejo.domain.model.enumerator.TipoOperacaoOcorrenciaEnum;
import br.com.viavarejo.domain.model.mongodb.transportador.TransportadorPK;
import io.swagger.annotations.ApiModelProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "ocorrencia_pedido")
public class OcorrenciaPedido implements DomainObject<OcorrenciaPedido> {
    private static final long serialVersionUID = -2151661210378794585L;

    @Id
    private ObjectId id;

    @ApiModelProperty(notes = "Chave composta da Transportadora no DB2.", required = false)
    private TransportadorPK transportadoraPK;

    @ApiModelProperty(notes = "Transportadora que está entregando o pedido.", required = true)
    @NotBlank
    private String transportadora;

    @ApiModelProperty(notes = "Embarcador da encomenda.", required = true)
    @NotBlank
    private String embarcador;

    @ApiModelProperty(notes = "Código do pedido de envio.", required = true)
    @NotBlank
    @Indexed
    private String codigoPedido;

    @ApiModelProperty(notes = "Número do volume de envio.", required = true)
    @NotNull
    private String codigoVolume;

    @ApiModelProperty(notes = "Código de rastreamento da transportadora.", required = true)
    @NotBlank
    private String codigoRastreioPedido;

    @ApiModelProperty(notes = "Serie da Nota Fiscal referente ao pedido do evento.", required = true)
    @NotBlank
    private String serieNotaFiscal;

    @ApiModelProperty(notes = "Número da Nota Fiscal referente ao pedido do evento.", required = true)
    @NotNull
    private String numeroNotaFiscal;

    @ApiModelProperty(notes = "Chave da Nota Fiscal referente ao pedido do evento.", required = true)
    @NotBlank
    private String chaveNotaFiscal;

    @ApiModelProperty(notes = "Tipo da operação. 0 - Normal; 1 - Nike", required = true)
    @NotNull
    private Integer codigoTipoOperacao;

    @ApiModelProperty(notes = "Tipo do pedido que originou o evento", required = false)
    private String tipoPedidoOrigem;

    @ApiModelProperty(notes = "Dados relativos aos eventos de entrega da transportadora. ", required = false)
    @Valid
    private List<EventoPedido> eventos = new ArrayList<>();

    public OcorrenciaPedido() {
        super();
    }

    public ObjectId getId() {
        return this.id;
    }

    public void setId(final ObjectId id) {
        this.id = id;
    }

    public TransportadorPK getTransportadoraPK() {
        return this.transportadoraPK;
    }

    public void setTransportadoraPK(final TransportadorPK transportadoraPK) {
        this.transportadoraPK = transportadoraPK;
    }

    public String getTransportadora() {
        return this.transportadora;
    }

    public void setTransportadora(final String transportadora) {
        this.transportadora = transportadora;
    }

    public String getEmbarcador() {
        return this.embarcador;
    }

    public void setEmbarcador(final String embarcador) {
        this.embarcador = embarcador;
    }

    public String getCodigoPedido() {
        return this.codigoPedido;
    }

    public void setCodigoPedido(final String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public String getCodigoVolume() {
        return this.codigoVolume;
    }

    public void setCodigoVolume(final String codigoVolume) {
        this.codigoVolume = codigoVolume;
    }

    public String getCodigoRastreioPedido() {
        return this.codigoRastreioPedido;
    }

    public void setCodigoRastreioPedido(final String codigoRastreioPedido) {
        this.codigoRastreioPedido = codigoRastreioPedido;
    }

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

    public Integer getCodigoTipoOperacao() {
        return this.codigoTipoOperacao;
    }

    public TipoOperacaoOcorrenciaEnum getTipoOperacao() {
        return TipoOperacaoOcorrenciaEnum.getInstance(this.codigoTipoOperacao);
    }

    public void setTipoOperacao(final TipoOperacaoOcorrenciaEnum tipoOperacao) {
        this.codigoTipoOperacao = tipoOperacao.getCodigo();
    }

    public String getTipoPedidoOrigem() {
        return this.tipoPedidoOrigem;
    }

    public void setTipoPedidoOrigem(final String tipoPedidoOrigem) {
        this.tipoPedidoOrigem = tipoPedidoOrigem;
    }

    public void setCodigoTipoOperacao(final Integer codigoTipoOperacao) {
        this.codigoTipoOperacao = codigoTipoOperacao;
    }

    public List<EventoPedido> getEventos() {
        return this.eventos;
    }

    public void setEventos(final List<EventoPedido> eventos) {
        this.eventos = eventos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((this.codigoPedido == null) ? 0 : this.codigoPedido.hashCode());
        result = (prime * result) + ((this.codigoVolume == null) ? 0 : this.codigoVolume.hashCode());
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
        final OcorrenciaPedido other = (OcorrenciaPedido) obj;
        if (this.codigoPedido == null) {
            if (other.codigoPedido != null) {
                return false;
            }
        } else if (!this.codigoPedido.equals(other.codigoPedido)) {
            return false;
        }
        if (this.codigoVolume == null) {
            if (other.codigoVolume != null) {
                return false;
            }
        } else if (!this.codigoVolume.equals(other.codigoVolume)) {
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
