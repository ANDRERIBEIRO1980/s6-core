package br.com.viavarejo.domain.model.mongodb;

import javax.validation.constraints.NotBlank;

import br.com.viavarejo.domain.DomainObject;
import io.swagger.annotations.ApiModelProperty;

public class Contato implements DomainObject<Contato> {
    private static final long serialVersionUID = -3872776525445578339L;

    @ApiModelProperty(notes = "Endereço de e-mail", required = true)
	@NotBlank
    private String email;

    @ApiModelProperty(notes = "Número do telefone fixo", required = true)
	@NotBlank
    private String telefoneFixo;

    @ApiModelProperty(notes = "Número do celular", required = true)
	@NotBlank
    private String telefoneMovel;

    public Contato() {
        super();
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getTelefoneFixo() {
        return this.telefoneFixo;
    }

    public void setTelefoneFixo(final String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getTelefoneMovel() {
        return this.telefoneMovel;
    }

    public void setTelefoneMovel(final String telefoneMovel) {
        this.telefoneMovel = telefoneMovel;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((this.email == null) ? 0 : this.email.hashCode());
        result = (prime * result) + ((this.telefoneFixo == null) ? 0 : this.telefoneFixo.hashCode());
        result = (prime * result) + ((this.telefoneMovel == null) ? 0 : this.telefoneMovel.hashCode());
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
        final Contato other = (Contato) obj;
        if (this.email == null) {
            if (other.email != null) {
                return false;
            }
        } else if (!this.email.equals(other.email)) {
            return false;
        }
        if (this.telefoneFixo == null) {
            if (other.telefoneFixo != null) {
                return false;
            }
        } else if (!this.telefoneFixo.equals(other.telefoneFixo)) {
            return false;
        }
        if (this.telefoneMovel == null) {
            if (other.telefoneMovel != null) {
                return false;
            }
        } else if (!this.telefoneMovel.equals(other.telefoneMovel)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Contato [email=" + this.email + ", telefoneFixo=" + this.telefoneFixo + ", telefoneMovel=" + this.telefoneMovel + "]";
    }

}
