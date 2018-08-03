package br.com.viavarejo.domain.model.mongodb.pedido;

import static br.com.viavarejo.util.Utils.isEmpty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.viavarejo.domain.DomainObject;
import br.com.viavarejo.domain.model.enumerator.TipoVolumeEnum;
import io.swagger.annotations.ApiModelProperty;

public class Volume implements DomainObject<Volume> {
    private static final long serialVersionUID = 8794254304406771473L;

    @ApiModelProperty(notes = "Código identificador do volume", required = true)
	@NotNull
    private Integer id;

    @ApiModelProperty(notes = "Nome do volume", allowEmptyValue = true)
    private String nome;

    @ApiModelProperty(notes = "Tipo do volume", required = true)
    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoVolumeEnum tipo;

    @ApiModelProperty(notes = "Peso do volume", required = true)
	@NotNull
    private BigDecimal peso;

    @ApiModelProperty(notes = "Largura do volume", required = true)
	@NotNull
    private BigDecimal largura;

    @ApiModelProperty(notes = "Altura do volume", required = true)
	@NotNull
    private BigDecimal altura;

    @ApiModelProperty(notes = "Comprimento do volume", required = true)
	@NotNull
    private BigDecimal comprimento;

    @ApiModelProperty(notes = "Natureza do volume", required = true)
	@NotBlank
    private String naturezaProduto;

    @ApiModelProperty(notes = "Quantidade de produtos no volume", required = true)
	@NotNull
    private Integer quantidadeProduto;

    @ApiModelProperty(notes = "Indica se é isento de ICMS", allowEmptyValue = true)
    private Boolean icmsIsento;

    @ApiModelProperty(notes = "Código de Rastreio", allowEmptyValue = true)
    private String codigoRastreio;

    @ApiModelProperty(notes = "Nota fiscal do volume", required = true)
	@NotNull
	@Valid
    private NotaFiscal notaFiscal;

    @ApiModelProperty(notes = "Mercadorias do volume", required = true)
    @NotNull
    @Valid
    private List<Mercadoria> mercadorias;

    public Volume() {
        super();
        this.mercadorias = new ArrayList<>();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public TipoVolumeEnum getTipo() {
        return this.tipo;
    }

    public void setTipo(final TipoVolumeEnum tipo) {
        this.tipo = isEmpty(tipo) ? TipoVolumeEnum.CAIXA : tipo;
    }

    public BigDecimal getPeso() {
        return this.peso;
    }

    public void setPeso(final BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getLargura() {
        return this.largura;
    }

    public void setLargura(final BigDecimal largura) {
        this.largura = largura;
    }

    public BigDecimal getAltura() {
        return this.altura;
    }

    public void setAltura(final BigDecimal altura) {
        this.altura = altura;
    }

    public BigDecimal getComprimento() {
        return this.comprimento;
    }

    public void setComprimento(final BigDecimal comprimento) {
        this.comprimento = comprimento;
    }

    public String getNaturezaProduto() {
        return this.naturezaProduto;
    }

    public void setNaturezaProduto(final String naturezaProduto) {
        this.naturezaProduto = naturezaProduto;
    }

    public Integer getQuantidadeProduto() {
        return this.quantidadeProduto;
    }

    public void setQuantidadeProduto(final Integer quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public Boolean getIcmsIsento() {
        return this.icmsIsento;
    }

    public void setIcmsIsento(final Boolean icmsIsento) {
        this.icmsIsento = icmsIsento;
    }

    public String getCodigoRastreio() {
        return this.codigoRastreio;
    }

    public void setCodigoRastreio(final String codigoRastreio) {
        this.codigoRastreio = codigoRastreio;
    }

    public NotaFiscal getNotaFiscal() {
        return this.notaFiscal;
    }

    public void setNotaFiscal(final NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public List<Mercadoria> getMercadorias() {
        return this.mercadorias;
    }

    public void setMercadorias(final List<Mercadoria> mercadorias) {
        this.mercadorias = mercadorias;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((this.id == null) ? 0 : this.id.hashCode());
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
        final Volume other = (Volume) obj;
        if (this.id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!this.id.equals(other.id)) {
            return false;
        }
        return true;
    }


}
