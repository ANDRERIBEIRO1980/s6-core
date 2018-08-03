package br.com.viavarejo.domain.model.mongodb.pedido;

import java.math.BigDecimal;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.viavarejo.domain.DomainObject;
import br.com.viavarejo.domain.model.enumerator.AcaoDocumentoEnum;
import br.com.viavarejo.domain.model.enumerator.CondicaoFreteEnum;
import br.com.viavarejo.domain.model.enumerator.IncidenciaICMSEnum;
import br.com.viavarejo.domain.model.enumerator.MeioTransporteEnum;
import br.com.viavarejo.domain.model.enumerator.TipoCargaEnum;
import br.com.viavarejo.domain.model.enumerator.TipoTransporteEnum;

public class Complemento implements DomainObject<Complemento> {
    private static final long serialVersionUID = 4084860412434741150L;

    private String numeroRomaneio;
    private String codigoRota;

	@Enumerated(EnumType.STRING)
    private MeioTransporteEnum meioTransporte;

	@Enumerated(EnumType.STRING)
    private TipoTransporteEnum tipoTransporte;

	@Enumerated(EnumType.STRING)
    private TipoCargaEnum tipoCarga;

	@Enumerated(EnumType.STRING)
	private CondicaoFreteEnum condicaoFrete;

	private String naturezaMercadoria;
    private String acondicionamento;
    private BigDecimal volume;
    private BigDecimal valorMercadoria;
    private BigDecimal pesoTotal;
    private BigDecimal pesoCubagem;

	@Enumerated(EnumType.STRING)
    private IncidenciaICMSEnum incidenciaICMS;

	@Enumerated(EnumType.STRING)
	private Boolean indicadorSeguro;

    private BigDecimal valorSeguro;
    private BigDecimal valorCobrado;
    private String placaCaminhao;

	@Enumerated(EnumType.STRING)
	private Boolean indicadorPlanoCargaRapida;

    private BigDecimal valorFrete;
    private BigDecimal valorADValorem;
    private BigDecimal valorTotalTaxas;
    private BigDecimal valorTotalFrete;

	@Enumerated(EnumType.STRING)
    private AcaoDocumentoEnum acaoDocumento;

	private BigDecimal valorICMS;
    private BigDecimal valorICMSSubstituto;

	@Enumerated(EnumType.STRING)
	private Boolean indicadorBonificacao;

    public Complemento() {
        super();
    }

    public String getNumeroRomaneio() {
        return this.numeroRomaneio;
    }

    public void setNumeroRomaneio(final String numeroRomaneio) {
        this.numeroRomaneio = numeroRomaneio;
    }

    public String getCodigoRota() {
        return this.codigoRota;
    }

    public void setCodigoRota(final String codigoRota) {
        this.codigoRota = codigoRota;
    }

    public MeioTransporteEnum getMeioTransporte() {
        return this.meioTransporte;
    }

    public void setMeioTransporte(final MeioTransporteEnum meioTransporte) {
        this.meioTransporte = meioTransporte;
    }

    public TipoTransporteEnum getTipoTransporte() {
        return this.tipoTransporte;
    }

    public void setTipoTransporte(final TipoTransporteEnum tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public TipoCargaEnum getTipoCarga() {
        return this.tipoCarga;
    }

    public void setTipoCarga(final TipoCargaEnum tipoCarga) {
        this.tipoCarga = tipoCarga;
    }

    public CondicaoFreteEnum getCondicaoFrete() {
        return this.condicaoFrete;
    }

    public void setCondicaoFrete(final CondicaoFreteEnum condicaoFrete) {
        this.condicaoFrete = condicaoFrete;
    }

    public String getNaturezaMercadoria() {
        return this.naturezaMercadoria;
    }

    public void setNaturezaMercadoria(final String naturezaMercadoria) {
        this.naturezaMercadoria = naturezaMercadoria;
    }

    public String getAcondicionamento() {
        return this.acondicionamento;
    }

    public void setAcondicionamento(final String acondicionamento) {
        this.acondicionamento = acondicionamento;
    }

    public BigDecimal getVolume() {
        return this.volume;
    }

    public void setVolume(final BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getValorMercadoria() {
        return this.valorMercadoria;
    }

    public void setValorMercadoria(final BigDecimal valorMercadoria) {
        this.valorMercadoria = valorMercadoria;
    }

    public BigDecimal getPesoTotal() {
        return this.pesoTotal;
    }

    public void setPesoTotal(final BigDecimal pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public BigDecimal getPesoCubagem() {
        return this.pesoCubagem;
    }

    public void setPesoCubagem(final BigDecimal pesoCubagem) {
        this.pesoCubagem = pesoCubagem;
    }

    public IncidenciaICMSEnum getIncidenciaICMS() {
        return this.incidenciaICMS;
    }

    public void setIncidenciaICMS(final IncidenciaICMSEnum incidenciaICMS) {
        this.incidenciaICMS = incidenciaICMS;
    }

	public Boolean getIndicadorSeguro() {
        return this.indicadorSeguro;
    }

	public void setIndicadorSeguro(final Boolean indicadorSeguro) {
        this.indicadorSeguro = indicadorSeguro;
    }

    public BigDecimal getValorSeguro() {
        return this.valorSeguro;
    }

    public void setValorSeguro(final BigDecimal valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    public BigDecimal getValorCobrado() {
        return this.valorCobrado;
    }

    public void setValorCobrado(final BigDecimal valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public String getPlacaCaminhao() {
        return this.placaCaminhao;
    }

    public void setPlacaCaminhao(final String placaCaminhao) {
        this.placaCaminhao = placaCaminhao;
    }

	public Boolean getIndicadorPlanoCargaRapida() {
        return this.indicadorPlanoCargaRapida;
    }

	public void setIndicadorPlanoCargaRapida(final Boolean indicadorPlanoCargaRapida) {
        this.indicadorPlanoCargaRapida = indicadorPlanoCargaRapida;
    }

    public BigDecimal getValorFrete() {
        return this.valorFrete;
    }

    public void setValorFrete(final BigDecimal valorFrete) {
        this.valorFrete = valorFrete;
    }

    public BigDecimal getValorADValorem() {
        return this.valorADValorem;
    }

    public void setValorADValorem(final BigDecimal valorADValorem) {
        this.valorADValorem = valorADValorem;
    }

    public BigDecimal getValorTotalTaxas() {
        return this.valorTotalTaxas;
    }

    public void setValorTotalTaxas(final BigDecimal valorTotalTaxas) {
        this.valorTotalTaxas = valorTotalTaxas;
    }

    public BigDecimal getValorTotalFrete() {
        return this.valorTotalFrete;
    }

    public void setValorTotalFrete(final BigDecimal valorTotalFrete) {
        this.valorTotalFrete = valorTotalFrete;
    }

    public AcaoDocumentoEnum getAcaoDocumento() {
        return this.acaoDocumento;
    }

    public void setAcaoDocumento(final AcaoDocumentoEnum acaoDocumento) {
        this.acaoDocumento = acaoDocumento;
    }

    public BigDecimal getValorICMS() {
        return this.valorICMS;
    }

    public void setValorICMS(final BigDecimal valorICMS) {
        this.valorICMS = valorICMS;
    }

    public BigDecimal getValorICMSSubstituto() {
        return this.valorICMSSubstituto;
    }

    public void setValorICMSSubstituto(final BigDecimal valorICMSSubstituto) {
        this.valorICMSSubstituto = valorICMSSubstituto;
    }

	public Boolean getIndicadorBonificacao() {
        return this.indicadorBonificacao;
    }

	public void setIndicadorBonificacao(final Boolean indicadorBonificacao) {
        this.indicadorBonificacao = indicadorBonificacao;
    }

	@Override
	public String toString() {
		return "Complemento [numeroRomaneio=" + this.numeroRomaneio + ", codigoRota=" + this.codigoRota
				+ ", meioTransporte=" + this.meioTransporte + ", tipoTransporte=" + this.tipoTransporte + ", tipoCarga="
				+ this.tipoCarga + ", condicaoFrete=" + this.condicaoFrete + ", naturezaMercadoria="
				+ this.naturezaMercadoria + ", acondicionamento=" + this.acondicionamento + ", volume=" + this.volume
				+ ", valorMercadoria=" + this.valorMercadoria + ", pesoTotal=" + this.pesoTotal + ", pesoCubagem="
				+ this.pesoCubagem + ", incidenciaICMS=" + this.incidenciaICMS + ", indicadorSeguro="
				+ this.indicadorSeguro + ", valorSeguro=" + this.valorSeguro + ", valorCobrado=" + this.valorCobrado
				+ ", placaCaminhao=" + this.placaCaminhao + ", indicadorPlanoCargaRapida="
				+ this.indicadorPlanoCargaRapida + ", valorFrete=" + this.valorFrete + ", valorADValorem="
				+ this.valorADValorem + ", valorTotalTaxas=" + this.valorTotalTaxas + ", valorTotalFrete="
				+ this.valorTotalFrete + ", acaoDocumento=" + this.acaoDocumento + ", valorICMS=" + this.valorICMS
				+ ", valorICMSSubstituto=" + this.valorICMSSubstituto + ", indicadorBonificacao="
				+ this.indicadorBonificacao + "]";
	}


}
