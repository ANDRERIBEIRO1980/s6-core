package br.com.viavarejo.domain.model.mongodb.cobranca;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.viavarejo.domain.DomainObject;
import io.swagger.annotations.ApiModelProperty;

public class MercadoriaRessarcimento implements DomainObject<MercadoriaRessarcimento> {
    private static final long serialVersionUID = 2144586912691308760L;

    @ApiModelProperty(notes = "Código SKU do produto", required = false)
    private String sku;

    @ApiModelProperty(notes = "Descrição do produto", required = false)
    private String descricao;

    @ApiModelProperty(notes = "Quantidade do produto", required = false)
    private Integer quantidade;

    public MercadoriaRessarcimento() {
        super();
    }

    public String getSku() {
        return this.sku;
    }

    public void setSku(final String sku) {
        this.sku = sku;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(final Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((this.sku == null) ? 0 : this.sku.hashCode());
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
        if (!(obj instanceof MercadoriaRessarcimento)) {
            return false;
        }
        final MercadoriaRessarcimento other = (MercadoriaRessarcimento) obj;
        if (this.sku == null) {
            if (other.sku != null) {
                return false;
            }
        } else if (!this.sku.equals(other.sku)) {
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
