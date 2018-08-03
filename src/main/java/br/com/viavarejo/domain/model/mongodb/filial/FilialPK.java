package br.com.viavarejo.domain.model.mongodb.filial;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiModelProperty;

public class FilialPK implements Serializable {

    private static final long serialVersionUID = 3303471180152955624L;

    @ApiModelProperty(notes = "Código empresa", required = true)
	@NotNull
    private Integer empresa;

    @ApiModelProperty(notes = "Código filial", required = true)
	@NotNull
    private Integer codigo;

    public FilialPK() {
        super();
    }

    public FilialPK(final Integer empresa, final Integer codigo) {
        this.empresa = empresa;
        this.codigo = codigo;
    }

    public Integer getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(final Integer empresa) {
        this.empresa = empresa;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public void setCodigo(final Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((this.codigo == null) ? 0 : this.codigo.hashCode());
        result = (prime * result) + ((this.empresa == null) ? 0 : this.empresa.hashCode());
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
        final FilialPK other = (FilialPK) obj;
        if (this.codigo == null) {
            if (other.codigo != null) {
                return false;
            }
        } else if (!this.codigo.equals(other.codigo)) {
            return false;
        }
        if (this.empresa == null) {
            if (other.empresa != null) {
                return false;
            }
        } else if (!this.empresa.equals(other.empresa)) {
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
