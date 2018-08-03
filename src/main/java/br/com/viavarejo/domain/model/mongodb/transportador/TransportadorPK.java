package br.com.viavarejo.domain.model.mongodb.transportador;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiModelProperty;

public class TransportadorPK implements Serializable {
    private static final long serialVersionUID = 1335412852068748539L;

    @ApiModelProperty(notes = "Código da Empresa", required = true)
	@NotNull
    private Integer codigoEmpresa;

    @ApiModelProperty(notes = "Código da Transportadora", required = true)
	@NotNull
    private Integer codigo;

    public TransportadorPK() {
        super();
    }

    public TransportadorPK(final Integer codigoEmpresa, final Integer codigo) {
        this.codigoEmpresa = codigoEmpresa;
        this.codigo = codigo;
    }

    public Integer getCodigoEmpresa() {
        return this.codigoEmpresa;
    }

    public void setCodigoEmpresa(final Integer codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
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
        result = (prime * result) + ((this.codigoEmpresa == null) ? 0 : this.codigoEmpresa.hashCode());
        result = (prime * result) + ((this.codigo == null) ? 0 : this.codigo.hashCode());
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
        final TransportadorPK other = (TransportadorPK) obj;
        if (this.codigoEmpresa == null) {
            if (other.codigoEmpresa != null) {
                return false;
            }
        } else if (!this.codigoEmpresa.equals(other.codigoEmpresa)) {
            return false;
        }
        if (this.codigo == null) {
            if (other.codigo != null) {
                return false;
            }
        } else if (!this.codigo.equals(other.codigo)) {
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
