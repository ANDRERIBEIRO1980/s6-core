package br.com.viavarejo.domain.model.mongodb;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.viavarejo.domain.DomainObject;
import io.swagger.annotations.ApiModelProperty;

@Document(collection = "metodo_entrega")
public class MetodoEntrega implements DomainObject<MetodoEntrega> {
    private static final long serialVersionUID = 1463568891236676344L;

    @Id
    private ObjectId id;

	@ApiModelProperty(notes = "Código método Entrega", required = true)
    @NotNull
    @Indexed
    private Integer codigo;

	@ApiModelProperty(notes = "Descrição método de entrega", required = true)
    @NotBlank
    private String descricao;

    public MetodoEntrega() {
        super();
    }

    public ObjectId getId() {
        return this.id;
    }

    public void setId(final ObjectId id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public void setCodigo(final Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }


    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.codigo == null) ? 0 : this.codigo.hashCode());
		result = (prime * result) + ((this.descricao == null) ? 0 : this.descricao.hashCode());
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
		final MetodoEntrega other = (MetodoEntrega) obj;
		if (this.codigo == null) {
			if (other.codigo != null) {
				return false;
			}
		} else if (!this.codigo.equals(other.codigo)) {
			return false;
		}
		if (this.descricao == null) {
			if (other.descricao != null) {
				return false;
			}
		} else if (!this.descricao.equals(other.descricao)) {
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
