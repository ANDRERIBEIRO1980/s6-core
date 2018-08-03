package br.com.viavarejo.domain.model.mongodb.pedido;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.viavarejo.domain.DomainObject;
import br.com.viavarejo.infrastructure.converter.DateDeserializer;
import br.com.viavarejo.infrastructure.converter.DateSerializer;
import br.com.viavarejo.util.DateUtils;
import io.swagger.annotations.ApiModelProperty;

public class NotaFiscal implements DomainObject<NotaFiscal> {
	private static final long serialVersionUID = -1022862138089215228L;

    @ApiModelProperty(notes = "Série da nota fiscal", required = true, example = "1")
	@NotBlank
	private String serie;

    @ApiModelProperty(notes = "Número da nota fiscal", required = true, example = "1010")
	@NotBlank
	private String numeroNF;

    @ApiModelProperty(notes = "Chave da nota fiscal", required = true, example = "01234567890123456789012345678901234567891234")
	@NotBlank
	private String chave;

    @ApiModelProperty(notes = "Data de emissão. Formato: dd/MM/yyyy HH:mm:ss", required = true, example = "10/04/2018 15:35:46")
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    @JsonFormat(pattern = DateUtils.FORMATO_BR_COMPLETO, locale = "pt_BR")
    @DateTimeFormat(pattern = DateUtils.FORMATO_BR_COMPLETO, iso = DateTimeFormat.ISO.DATE)
	@NotNull
	private Date dataEmissao;

    @ApiModelProperty(notes = "Valor total do produto", required = true)
	@NotNull
	private BigDecimal valorTotalProduto;

    @ApiModelProperty(notes = "Valor total", required = true)
	@NotNull
	private BigDecimal valorTotal;

    @ApiModelProperty(notes = "Código CFOP", required = true)
	@NotBlank
	private String codigoCFOP;

	public NotaFiscal() {
		super();
	}

	public String getSerie() {
		return this.serie;
	}

	public void setSerie(final String serie) {
		this.serie = serie;
	}

	public String getNumeroNF() {
		return this.numeroNF;
	}

	public void setNumeroNF(final String numeroNF) {
		this.numeroNF = numeroNF;
	}

	public String getChave() {
		return this.chave;
	}

	public void setChave(final String chave) {
		this.chave = chave;
	}

	public Date getDataEmissao() {
		return this.dataEmissao;
	}

	public void setDataEmissao(final Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public BigDecimal getValorTotalProduto() {
		return this.valorTotalProduto;
	}

	public void setValorTotalProduto(final BigDecimal valorTotalProduto) {
		this.valorTotalProduto = valorTotalProduto;
	}

	public BigDecimal getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(final BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getCodigoCFOP() {
		return this.codigoCFOP;
	}

	public void setCodigoCFOP(final String codigoCFOP) {
		this.codigoCFOP = codigoCFOP;
	}

	@Override
	public String toString() {
		return "NotaFiscal [serie=" + this.serie + ", numeroNF=" + this.numeroNF + ", chave=" + this.chave
				+ ", dataEmissao=" + this.dataEmissao + ", valorTotalProduto=" + this.valorTotalProduto
				+ ", valorTotal=" + this.valorTotal + ", codigoCFOP=" + this.codigoCFOP + "]";
	}


}
