package br.com.viavarejo.domain.model.mongodb.sincronizacao;

import static br.com.viavarejo.util.DateUtils.FORMATO_BR_COMPLETO;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.viavarejo.domain.DomainObject;
import br.com.viavarejo.infrastructure.converter.DateDeserializer;
import br.com.viavarejo.infrastructure.converter.DateSerializer;

@Document(collection = "sincronizacao_processo")
public class SincronizacaoProcesso implements DomainObject<SincronizacaoProcesso> {
    private static final long serialVersionUID = -2444430479898578186L;

    @Id
    private String processo;

    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    @JsonFormat(pattern = FORMATO_BR_COMPLETO, locale = "pt_BR")
    @DateTimeFormat(pattern = FORMATO_BR_COMPLETO, iso = DateTimeFormat.ISO.DATE_TIME)
    private Date ultimaSincronizacao;

    public SincronizacaoProcesso() {}

    public SincronizacaoProcesso(final String processo, final Date ultimaSincronizacao) {
        this.processo = processo;
        this.ultimaSincronizacao = ultimaSincronizacao;
    }

    public String getProcesso() {
        return this.processo;
    }

    public void setProcesso(final String processo) {
        this.processo = processo;
    }

    public Date getUltimaSincronizacao() {
        return this.ultimaSincronizacao;
    }

    public void setUltimaSincronizacao(final Date ultimaSincronizacao) {
        this.ultimaSincronizacao = ultimaSincronizacao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((this.processo == null) ? 0 : this.processo.hashCode());
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
        final SincronizacaoProcesso other = (SincronizacaoProcesso) obj;
        if (this.processo == null) {
            if (other.processo != null) {
                return false;
            }
        } else if (!this.processo.equals(other.processo)) {
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
