package br.com.viavarejo.domain.model.mongodb.filial;

import static br.com.viavarejo.util.DateUtils.FORMATO_BR_COMPLETO;
import static br.com.viavarejo.util.PortalTransportadorUtils.valoresConcatenados;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

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
import br.com.viavarejo.domain.model.mongodb.Contato;
import br.com.viavarejo.domain.model.mongodb.Endereco;
import br.com.viavarejo.infrastructure.converter.DateDeserializer;
import br.com.viavarejo.infrastructure.converter.DateSerializer;
import io.swagger.annotations.ApiModelProperty;

@Document(collection = "filial")
public class Filial implements DomainObject<Filial> {
    private static final long serialVersionUID = 1463568891236676344L;

    @Id
    private ObjectId id;

    @ApiModelProperty(notes = "Chave composta da filial no DB2", required = true)
    @Valid
    @Indexed
    private FilialPK pk;

    @ApiModelProperty(notes = "CNPJ da Filial", required = true)
    @NotBlank
    private String cnpj;

    @ApiModelProperty(notes = "Nome da Filial", required = true)
    @NotBlank
    private String nome;

    @ApiModelProperty(notes = "Razão Social da Filial", required = true)
    @NotBlank
    private String razaoSocial;

    @ApiModelProperty(notes = "Endereço da Filial", required = true)
    @Valid
    private Endereco endereco;

    @ApiModelProperty(notes = "Contato da Filial", required = true)
    @Valid
    private Contato contato;

    @ApiModelProperty(notes = "Data de criação", value = "Este campo deve seguir o padrão dd/MM/yyyy HH:mm:ss",
                    example = "08/10/2016 15:20:15")
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    @JsonFormat(pattern = FORMATO_BR_COMPLETO, locale = "pt_BR")
    @DateTimeFormat(pattern = FORMATO_BR_COMPLETO, iso = DateTimeFormat.ISO.DATE)
    private Date dataCriacao;

    @ApiModelProperty(notes = "Flag para tornar a entidade visível à integração", required = false, hidden = true)
    @Indexed
    private Boolean integracaoIntelipost;

    @ApiModelProperty(notes = "Código integrado da filial",
                    value = "Representa: codigoEmpresa + codigo. Utilizado também como índice para buscas", required = false, hidden = true)
    private String codigoIntegrado;

    public Filial() {}

    public ObjectId getId() {
        return this.id;
    }

    public void setId(final ObjectId id) {
        this.id = id;
    }

    public FilialPK getPk() {
        return this.pk;
    }

    public void setPk(final FilialPK pk) {
        this.pk = pk;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(final String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public void setRazaoSocial(final String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Date getDataCriacao() {
        return this.dataCriacao;
    }

    public void setDataCriacao(final Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Endereco getEndereco() {
		return this.endereco;
	}
    public void setEndereco(final Endereco endereco) {
		this.endereco = endereco;
	}

    public Contato getContato() {
		return this.contato;
	}
    public void setContato(final Contato contato) {
		this.contato = contato;
	}

    public String getCodigoIntegrado() {
        return this.codigoIntegrado;
    }

    public void setCodigoIntegrado(final String codigoIntegrado) {
        this.codigoIntegrado = codigoIntegrado;
    }

    /**
     * Prepara a entidade antes de submeta-la ao banco:<br>
     *
     * - Torna visivel para a integracao com a Intelipost<br>
     * - Gera um id unico com base na pk da entidade<br>
     */
    public void prepararEntidade() {
        this.visivelIntelipost();
        this.codigoIntegrado = valoresConcatenados(this.pk.getCodigo(), this.pk.getEmpresa());
    }

    public void visivelIntelipost() {
        this.integracaoIntelipost = true;
    }

    public void naoVisivelIntelipost() {
        this.integracaoIntelipost = null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((this.cnpj == null) ? 0 : this.cnpj.hashCode());
        result = (prime * result) + ((this.contato == null) ? 0 : this.contato.hashCode());
        result = (prime * result) + ((this.dataCriacao == null) ? 0 : this.dataCriacao.hashCode());
        result = (prime * result) + ((this.endereco == null) ? 0 : this.endereco.hashCode());
        result = (prime * result) + ((this.nome == null) ? 0 : this.nome.hashCode());
        result = (prime * result) + ((this.pk == null) ? 0 : this.pk.hashCode());
        result = (prime * result) + ((this.razaoSocial == null) ? 0 : this.razaoSocial.hashCode());
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
        final Filial other = (Filial) obj;
        if (this.cnpj == null) {
            if (other.cnpj != null) {
                return false;
            }
        } else if (!this.cnpj.equals(other.cnpj)) {
            return false;
        }
        if (this.contato == null) {
            if (other.contato != null) {
                return false;
            }
        } else if (!this.contato.equals(other.contato)) {
            return false;
        }
        if (this.dataCriacao == null) {
            if (other.dataCriacao != null) {
                return false;
            }
        } else if (!this.dataCriacao.equals(other.dataCriacao)) {
            return false;
        }
        if (this.endereco == null) {
            if (other.endereco != null) {
                return false;
            }
        } else if (!this.endereco.equals(other.endereco)) {
            return false;
        }
        if (this.nome == null) {
            if (other.nome != null) {
                return false;
            }
        } else if (!this.nome.equals(other.nome)) {
            return false;
        }
        if (this.pk == null) {
            if (other.pk != null) {
                return false;
            }
        } else if (!this.pk.equals(other.pk)) {
            return false;
        }
        if (this.razaoSocial == null) {
            if (other.razaoSocial != null) {
                return false;
            }
        } else if (!this.razaoSocial.equals(other.razaoSocial)) {
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
