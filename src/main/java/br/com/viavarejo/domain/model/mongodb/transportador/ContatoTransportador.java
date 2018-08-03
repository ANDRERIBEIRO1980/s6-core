package br.com.viavarejo.domain.model.mongodb.transportador;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.viavarejo.domain.DomainObject;
import io.swagger.annotations.ApiModelProperty;

public class ContatoTransportador implements DomainObject<ContatoTransportador> {
    private static final long serialVersionUID = -3872776525445578339L;

    @ApiModelProperty(notes = "Nome do contato", allowEmptyValue = true)
    private String nome;

    @ApiModelProperty(notes = "Sobrenome do contato", allowEmptyValue = true)
    private String sobrenome;

    @ApiModelProperty(notes = "Endereço de e-mail do contato", required = true)
    @Email(regexp = ".+@.+\\..+")
    private String email;

    @ApiModelProperty(notes = "Número de telefone do contato", allowEmptyValue = true)
    private String telefone;

	public ContatoTransportador() {
		super();
	}

    public String getNome() {
        return this.nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public void setSobrenome(final String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(final String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((this.email == null) ? 0 : this.email.hashCode());
        result = (prime * result) + ((this.nome == null) ? 0 : this.nome.hashCode());
        result = (prime * result) + ((this.sobrenome == null) ? 0 : this.sobrenome.hashCode());
        result = (prime * result) + ((this.telefone == null) ? 0 : this.telefone.hashCode());
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
        final ContatoTransportador other = (ContatoTransportador) obj;
        if (this.email == null) {
            if (other.email != null) {
                return false;
            }
        } else if (!this.email.equals(other.email)) {
            return false;
        }
        if (this.nome == null) {
            if (other.nome != null) {
                return false;
            }
        } else if (!this.nome.equals(other.nome)) {
            return false;
        }
        if (this.sobrenome == null) {
            if (other.sobrenome != null) {
                return false;
            }
        } else if (!this.sobrenome.equals(other.sobrenome)) {
            return false;
        }
        if (this.telefone == null) {
            if (other.telefone != null) {
                return false;
            }
        } else if (!this.telefone.equals(other.telefone)) {
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
