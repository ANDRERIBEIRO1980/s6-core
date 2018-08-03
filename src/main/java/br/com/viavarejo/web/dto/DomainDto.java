package br.com.viavarejo.web.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// public class DomainDto<S extends DomainObject<?>> extends BaseDto {
public class DomainDto<S> extends BaseDto {

    private static final long serialVersionUID = 6991551304742750940L;

    @JsonIgnore
    protected final Logger LOG = LoggerFactory.getLogger(this.getClass());

    public void customConvertToDto(final S entity) {}

    public void customConvertToEntity(final S entity) {}

    @Override
    public String toString() {
        final ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        // mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            jsonString = mapper.writeValueAsString(this);
        } catch (final JsonProcessingException e) {
            this.LOG.error("Erro ao tentar serializar o JSON da entidade.", e);
        }
        return jsonString;
    }
}
