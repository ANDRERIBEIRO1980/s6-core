package br.com.viavarejo.domain.model.mongodb.pedido;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.viavarejo.domain.DomainObject;
import io.swagger.annotations.ApiModelProperty;

@Document(collection = "mercadoria")
public class Mercadoria implements DomainObject<Volume> {
    private static final long serialVersionUID = 6395615231952833774L;

    @Id
    private ObjectId id;

    @ApiModelProperty(notes = "Peso do produto", required = true)
    @NotNull
    private BigDecimal peso;

    @ApiModelProperty(notes = "Largura do produto", required = true)
    @NotNull
    private BigDecimal largura;

    @ApiModelProperty(notes = "Altura do produto", required = true)
    @NotNull
    private BigDecimal altura;

    @ApiModelProperty(notes = "Comprimento do produto", required = true)
    @NotNull
    private BigDecimal comprimento;

    @ApiModelProperty(notes = "Preço do produto", required = true)
    @NotNull
    private BigDecimal preco;

    @ApiModelProperty(notes = "Descrição do produto", required = true)
    @NotBlank
    private String descricao;

    @ApiModelProperty(notes = "SKU do produto", required = true)
    @NotBlank
    private String sku;

    @ApiModelProperty(notes = "Categoria do produto", required = true)
    @NotBlank
    private String categoria;

    @ApiModelProperty(notes = "Quantidade do produto", required = true)
    @NotNull
    private Integer quantidade;

    @ApiModelProperty(notes = "Url da imagem do produto", allowEmptyValue = true)
    private String imagemUrl;

    public Mercadoria() {
        super();
    }

    public ObjectId getId() {
        return this.id;
    }

    public void setId(final ObjectId id) {
        this.id = id;
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

    public BigDecimal getPreco() {
        return this.preco;
    }

    public void setPreco(final BigDecimal preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    public String getSku() {
        return this.sku;
    }

    public void setSku(final String sku) {
        this.sku = sku;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(final String categoria) {
        this.categoria = categoria;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(final Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getImagemUrl() {
        return this.imagemUrl;
    }

    public void setImagemUrl(final String imagemUrl) {
        this.imagemUrl = imagemUrl;
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
        if (!(obj instanceof Mercadoria)) {
            return false;
        }
        final Mercadoria other = (Mercadoria) obj;
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
