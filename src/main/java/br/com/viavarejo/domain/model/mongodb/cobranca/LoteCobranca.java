package br.com.viavarejo.domain.model.mongodb.cobranca;

import static br.com.viavarejo.util.DateUtils.FORMATO_BR_COMPLETO;
import static br.com.viavarejo.util.Utils.isNotNull;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.NotEmpty;
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
import br.com.viavarejo.domain.model.enumerator.StatusAprovacaoLoteCobrancaEnum;
import br.com.viavarejo.infrastructure.converter.DateDeserializer;
import br.com.viavarejo.infrastructure.converter.DateSerializer;
import br.com.viavarejo.util.DateUtils;
import io.swagger.annotations.ApiModelProperty;

@Document(collection = "lote_cobranca")
public class LoteCobranca implements DomainObject<LoteCobranca> {

    private static final long serialVersionUID = -6520977235921907629L;

    @Id
    @ApiModelProperty(notes = "ID da transportadora gerada pelo Banco", allowEmptyValue = true)
    private ObjectId id;

    @ApiModelProperty(notes = "Código do lote do ressarcimento da transportadora.", required = true)
    @NotNull
    private Integer codigoRessarcimento;

    @ApiModelProperty(notes = "Código de contas a receber", example = "1453", allowEmptyValue = true)
    private Integer codigoContasReceber;

    @ApiModelProperty(notes = "Código de contas a pagar.", example = "1470", allowEmptyValue = true)
    private Integer codigoContasPagar;

    @ApiModelProperty(notes = "Indica a forma de pagamento", allowEmptyValue = true)
    private String formaPagamento;

    @Indexed
    @ApiModelProperty(notes = "Número da fatura / boleto", example = "9620", required = true)
    @NotNull
    private Integer numeroFatura;

    @ApiModelProperty(notes = "Valor da fatura", required = true)
    @NotNull
    private BigDecimal valorFatura;

    @ApiModelProperty(notes = "Valor do debito", allowEmptyValue = true)
    private BigDecimal valorDebito;

    @ApiModelProperty(notes = "Valor do saldo pendente", allowEmptyValue = true)
    private BigDecimal saldoPendente;

    @ApiModelProperty(notes = "Nome da transportadora.", example = "TRANSP BR", required = true)
    @NotEmpty
    private String nomeTransportadora;

    @ApiModelProperty(notes = "Apelido da transportadora.", example = "TRANSPORT BR", required = true)
    @NotEmpty
    private String apelidoTransportadora;

    @ApiModelProperty(notes = "Raiz do CNPJ da transportadora que gerou o ressarcimento.", required = true)
    @NotNull
    private Integer raizCnpj;

    @ApiModelProperty(notes = "Filial do CNPJ da transportadora que gerou o ressarcimento.", required = true)
    @NotNull
    private Integer filialCnpj;

    @ApiModelProperty(notes = "Dígito verificador do CNPJ da transportadora que gerou o ressarcimento.", required = true)
    @NotNull
    private Integer digitoVerificadorCnpj;

    @ApiModelProperty(notes = "Data da geração do lote de cobrança. Formato: dd/MM/yyyy HH:mm:ss", example = "15/04/2018 15:35:46",
                    allowEmptyValue = true)
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    @JsonFormat(pattern = FORMATO_BR_COMPLETO, locale = "pt_BR")
    @DateTimeFormat(pattern = FORMATO_BR_COMPLETO, iso = DateTimeFormat.ISO.DATE)
    private Date geracaoLote;

    @ApiModelProperty(notes = "Descrição do tipo de lote de cobrança.", allowEmptyValue = true)
    private String descricaoTipoLote;

    @ApiModelProperty(notes = "Data do cancelamento. Formato: dd/MM/yyyy HH:mm:ss", example = "15/04/2018 15:35:46", allowEmptyValue = true)
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    @JsonFormat(pattern = FORMATO_BR_COMPLETO, locale = "pt_BR")
    @DateTimeFormat(pattern = FORMATO_BR_COMPLETO, iso = DateTimeFormat.ISO.DATE)
    private Date dataCancelamento;

    @ApiModelProperty(notes = "Nome do usuário responsável pelo cancelamento.", allowEmptyValue = true)
    private String responsavelCancelamento;

    @ApiModelProperty(notes = "Data do vencimento do cancelamento. Formato: dd/MM/yyyy HH:mm:ss", example = "15/04/2018 15:35:46",
                    allowEmptyValue = true)
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    @JsonFormat(pattern = FORMATO_BR_COMPLETO, locale = "pt_BR")
    @DateTimeFormat(pattern = FORMATO_BR_COMPLETO, iso = DateTimeFormat.ISO.DATE)
    private Date vencimentoCancelamento;

    @ApiModelProperty(notes = "Data da aprovação do contas a receber.Formato: dd/MM/yyyy HH:mm:ss", example = "15/04/2018 15:35:46",
                    required = true)
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    @JsonFormat(pattern = FORMATO_BR_COMPLETO, locale = "pt_BR")
    @DateTimeFormat(pattern = FORMATO_BR_COMPLETO, iso = DateTimeFormat.ISO.DATE)
    @NotNull
    private Date aprovacaoContasReceber;

    @ApiModelProperty(notes = "Nome do gestor da área.", allowEmptyValue = true)
    private String gestor;

    @ApiModelProperty(notes = "Cargo do gestor.", allowEmptyValue = true)
    private String cargoGestor;

    @ApiModelProperty(notes = "Status de aprovação.", example = "O valores aceitos são: \"\"(vazio) para Não ou \"S\" para Sim ",
                    required = true)
    @NotNull
    private String statusAprovacao;

    @ApiModelProperty(notes = "Código que identifica uma empresa do Grupo Casas Bahia.", example = "1060", required = true)
    @NotNull
    private Integer codigoEmpresa;

    @ApiModelProperty(notes = "Descrição do lote referência transmitido", required = true)
    @NotEmpty
    private String descricaoReferencia;

    @ApiModelProperty(notes = "Descrição do título da transportadora.", required = true)
    @NotEmpty
    private String descricaoTituloTransportadora;

    @ApiModelProperty(notes = "Descrição da criação do registro.", allowEmptyValue = true)
    private String descricaoCriacao;

    @ApiModelProperty(notes = "Campo destinado à observação", allowEmptyValue = true)
    private String observacao;

    @ApiModelProperty(notes = "Data de criação do lote de cobrança na API. Formato: dd/MM/yyyy HH:mm:ss", example = "15/04/2018 15:35:46",
                    allowEmptyValue = true)
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    @JsonFormat(pattern = FORMATO_BR_COMPLETO, locale = "pt_BR")
    @DateTimeFormat(pattern = FORMATO_BR_COMPLETO, iso = DateTimeFormat.ISO.DATE)
    private Date dataCriacaoAPI;

    @Indexed
    @ApiModelProperty(notes = "Flag que torna a entidade visível ou não à sincronização com mainframe.", hidden = true)
    private Boolean sincronizacaoMainframe;

    public LoteCobranca() {
        super();
        this.sincronizacaoMainframe = Boolean.FALSE;
    }

    public ObjectId getId() {
        return this.id;
    }

    public void setId(final ObjectId id) {
        this.id = id;
    }

    public Integer getCodigoRessarcimento() {
        return this.codigoRessarcimento;
    }

    public void setCodigoRessarcimento(final Integer codigoRessarcimento) {
        this.codigoRessarcimento = codigoRessarcimento;
    }

    public Integer getCodigoContasReceber() {
        return this.codigoContasReceber;
    }

    public void setCodigoContasReceber(final Integer codigoContasReceber) {
        this.codigoContasReceber = codigoContasReceber;
    }

    public Integer getCodigoContasPagar() {
        return this.codigoContasPagar;
    }

    public void setCodigoContasPagar(final Integer codigoContasPagar) {
        this.codigoContasPagar = codigoContasPagar;
    }

    public String getFormaPagamento() {
        return this.formaPagamento;
    }

    public void setFormaPagamento(final String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Integer getNumeroFatura() {
        return this.numeroFatura;
    }

    public void setNumeroFatura(final Integer numeroFatura) {
        this.numeroFatura = numeroFatura;
    }

    public BigDecimal getValorFatura() {
        return this.valorFatura;
    }

    public void setValorFatura(final BigDecimal valorFatura) {
        this.valorFatura = valorFatura;
    }

    public BigDecimal getValorDebito() {
        return this.valorDebito;
    }

    public void setValorDebito(final BigDecimal valorDebito) {
        this.valorDebito = valorDebito;
    }

    public BigDecimal getSaldoPendente() {
        return this.saldoPendente;
    }

    public void setSaldoPendente(final BigDecimal saldoPendente) {
        this.saldoPendente = saldoPendente;
    }

    public String getNomeTransportadora() {
        return this.nomeTransportadora;
    }

    public void setNomeTransportadora(final String nomeTransportadora) {
        this.nomeTransportadora = nomeTransportadora;
    }

    public String getApelidoTransportadora() {
        return this.apelidoTransportadora;
    }

    public void setApelidoTransportadora(final String apelidoTransportadora) {
        this.apelidoTransportadora = apelidoTransportadora;
    }

    public Integer getRaizCnpj() {
        return this.raizCnpj;
    }

    public void setRaizCnpj(final Integer raizCnpj) {
        this.raizCnpj = raizCnpj;
    }

    public Integer getFilialCnpj() {
        return this.filialCnpj;
    }

    public void setFilialCnpj(final Integer filialCnpj) {
        this.filialCnpj = filialCnpj;
    }

    public Integer getDigitoVerificadorCnpj() {
        return this.digitoVerificadorCnpj;
    }

    public void setDigitoVerificadorCnpj(final Integer digitoVerificadorCnpj) {
        this.digitoVerificadorCnpj = digitoVerificadorCnpj;
    }

    public Date getGeracaoLote() {
        return this.geracaoLote;
    }

    public void setGeracaoLote(final Date geracaoLote) {
        this.geracaoLote = geracaoLote;
    }

    public String getDescricaoTipoLote() {
        return this.descricaoTipoLote;
    }

    public void setDescricaoTipoLote(final String descricaoTipoLote) {
        this.descricaoTipoLote = descricaoTipoLote;
    }

    public Date getDataCancelamento() {
        return this.dataCancelamento;
    }

    public void setDataCancelamento(final Date dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    public String getResponsavelCancelamento() {
        return this.responsavelCancelamento;
    }

    public void setResponsavelCancelamento(final String responsavelCancelamento) {
        this.responsavelCancelamento = responsavelCancelamento;
    }

    public Date getVencimentoCancelamento() {
        return this.vencimentoCancelamento;
    }

    public void setVencimentoCancelamento(final Date vencimentoCancelamento) {
        this.vencimentoCancelamento = vencimentoCancelamento;
    }

    public Date getAprovacaoContasReceber() {
        return this.aprovacaoContasReceber;
    }

    public void setAprovacaoContasReceber(final Date aprovacaoContasReceber) {
        this.aprovacaoContasReceber = aprovacaoContasReceber;
    }

    public String getGestor() {
        return this.gestor;
    }

    public void setGestor(final String gestor) {
        this.gestor = gestor;
    }

    public String getCargoGestor() {
        return this.cargoGestor;
    }

    public void setCargoGestor(final String cargoGestor) {
        this.cargoGestor = cargoGestor;
    }

    public String getStatusAprovacao() {
        return this.statusAprovacao;
    }

    public StatusAprovacaoLoteCobrancaEnum getStatusAprovacaoEnum() {
        return StatusAprovacaoLoteCobrancaEnum.getInstance(this.statusAprovacao);
    }

    public void setStatusAprovacao(final StatusAprovacaoLoteCobrancaEnum statusAprovacao) {
        this.statusAprovacao = isNotNull(statusAprovacao) ? statusAprovacao.getValor() : null;
    }

    public Integer getCodigoEmpresa() {
        return this.codigoEmpresa;
    }

    public void setCodigoEmpresa(final Integer codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public String getDescricaoReferencia() {
        return this.descricaoReferencia;
    }

    public void setDescricaoReferencia(final String descricaoReferencia) {
        this.descricaoReferencia = descricaoReferencia;
    }

    public String getDescricaoTituloTransportadora() {
        return this.descricaoTituloTransportadora;
    }

    public void setDescricaoTituloTransportadora(final String descricaoTituloTransportadora) {
        this.descricaoTituloTransportadora = descricaoTituloTransportadora;
    }

    public String getDescricaoCriacao() {
        return this.descricaoCriacao;
    }

    public void setDescricaoCriacao(final String descricaoCriacao) {
        this.descricaoCriacao = descricaoCriacao;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public void setObservacao(final String observacao) {
        this.observacao = observacao;
    }

    public Date getDataCriacaoAPI() {
        return this.dataCriacaoAPI;
    }

    public void setDataCriacaoAPI(final Date dataCriacaoAPI) {
        this.dataCriacaoAPI = dataCriacaoAPI;
    }

    public Boolean getSincronizacaoMainframe() {
        return this.sincronizacaoMainframe;
    }

    public void setSincronizacaoMainframe(final Boolean sincronizacaoMainframe) {
        this.sincronizacaoMainframe = sincronizacaoMainframe;
    }

    public void ligaFlagSincronizacaoMainframe() {
        this.sincronizacaoMainframe = Boolean.TRUE;
    }

    public void desligaFlagSincronizacaoMainframe() {
        this.sincronizacaoMainframe = Boolean.FALSE;
    }

    public void prepararSincronizacao() {
        this.ligaFlagSincronizacaoMainframe();
        this.dataCriacaoAPI = DateUtils.currentDateBr();
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