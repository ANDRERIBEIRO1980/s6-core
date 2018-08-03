package br.com.viavarejo.domain.model.mongodb;

import static br.com.viavarejo.util.Utils.isNotEmpty;
import static br.com.viavarejo.util.Utils.isNotNull;

import javax.validation.constraints.NotBlank;

import br.com.viavarejo.domain.DomainObject;
import io.swagger.annotations.ApiModelProperty;

public class Endereco implements DomainObject<Endereco> {
    private static final long serialVersionUID = -7366770730838175702L;

    @ApiModelProperty(notes = "Quando não existir país = BR", required = true)
	@NotBlank
    private String pais;

    @ApiModelProperty(notes = "Sigla do Estado", required = true)
	@NotBlank
    private String estado;

    @ApiModelProperty(notes = "Nome da Cidade", required = true)
	@NotBlank
    private String cidade;

    @ApiModelProperty(notes = "Código de Endereçamento Postal", required = true)
	@NotBlank
    private String cep;

    @ApiModelProperty(notes = "Nome do Bairro")
	@NotBlank
    private String bairro;

    @ApiModelProperty(notes = "Logradouro", required = true, example = "Rua Alagoas")
	@NotBlank
    private String logradouro;

    @ApiModelProperty(notes = "Quando não existir número = s/n", required = true, example = "1500")
	@NotBlank
    private String numero;

    @ApiModelProperty(notes = "Complemento do Endereço", required = true, example = "Apto 100")
	@NotBlank
    private String complemento;

    @ApiModelProperty(notes = "Ponto de referência", required = true, example = "Próximo a estação da CPTM")
	@NotBlank
    private String referencia;

    public Endereco() {
        super();

        this.pais = "BR";
        this.numero = "s/n";
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(final String pais) {
        if (isNotNull(pais) && isNotEmpty(pais)) {
            this.pais = pais;
        }
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(final String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(final String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(final String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(final String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public void setLogradouro(final String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(final String numero) {
        if (isNotNull(numero) && !numero.isEmpty()) {
            this.numero = numero;
        }
    }

    public String getComplemento() {
        return this.complemento;
    }

    public void setComplemento(final String complemento) {
        this.complemento = complemento;
    }

    public String getReferencia() {
        return this.referencia;
    }

    public void setReferencia(final String referencia) {
        this.referencia = referencia;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((this.bairro == null) ? 0 : this.bairro.hashCode());
        result = (prime * result) + ((this.cep == null) ? 0 : this.cep.hashCode());
        result = (prime * result) + ((this.cidade == null) ? 0 : this.cidade.hashCode());
        result = (prime * result) + ((this.complemento == null) ? 0 : this.complemento.hashCode());
        result = (prime * result) + ((this.estado == null) ? 0 : this.estado.hashCode());
        result = (prime * result) + ((this.logradouro == null) ? 0 : this.logradouro.hashCode());
        result = (prime * result) + ((this.numero == null) ? 0 : this.numero.hashCode());
        result = (prime * result) + ((this.pais == null) ? 0 : this.pais.hashCode());
        result = (prime * result) + ((this.referencia == null) ? 0 : this.referencia.hashCode());
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
        final Endereco other = (Endereco) obj;
        if (this.bairro == null) {
            if (other.bairro != null) {
                return false;
            }
        } else if (!this.bairro.equals(other.bairro)) {
            return false;
        }
        if (this.cep == null) {
            if (other.cep != null) {
                return false;
            }
        } else if (!this.cep.equals(other.cep)) {
            return false;
        }
        if (this.cidade == null) {
            if (other.cidade != null) {
                return false;
            }
        } else if (!this.cidade.equals(other.cidade)) {
            return false;
        }
        if (this.complemento == null) {
            if (other.complemento != null) {
                return false;
            }
        } else if (!this.complemento.equals(other.complemento)) {
            return false;
        }
        if (this.estado == null) {
            if (other.estado != null) {
                return false;
            }
        } else if (!this.estado.equals(other.estado)) {
            return false;
        }
        if (this.logradouro == null) {
            if (other.logradouro != null) {
                return false;
            }
        } else if (!this.logradouro.equals(other.logradouro)) {
            return false;
        }
        if (this.numero == null) {
            if (other.numero != null) {
                return false;
            }
        } else if (!this.numero.equals(other.numero)) {
            return false;
        }
        if (this.pais == null) {
            if (other.pais != null) {
                return false;
            }
        } else if (!this.pais.equals(other.pais)) {
            return false;
        }
        if (this.referencia == null) {
            if (other.referencia != null) {
                return false;
            }
        } else if (!this.referencia.equals(other.referencia)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Endereco [pais=" + this.pais + ", estado=" + this.estado + ", cidade=" + this.cidade + ", cep=" + this.cep + ", bairro="
            + this.bairro + ", logradouro=" + this.logradouro + ", numero=" + this.numero + ", complemento=" + this.complemento
            + ", referencia=" + this.referencia + "]";
    }

}
