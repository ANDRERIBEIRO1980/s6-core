package br.com.viavarejo.web.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonPropertyOrder(value = {"valido", "entidades", "mensagens", "protocolo"})
public class ResponseDto<T> extends BaseResponseDto {
    private static final long serialVersionUID = 6529380738638755088L;

    private List<T> entidades = new ArrayList<>();

    public ResponseDto() {}

    private ResponseDto(final List<T> entidades) {
        this.entidades = entidades;
    }

    @JsonCreator
    public static <T> ResponseDto<T> create(@JsonProperty("entidades") final List<T> entidades) {
        return new ResponseDto.Builder<T>().comEntidades(entidades).build();
    }

    public static class Builder<T> {
        private List<T> entidades;

        public Builder<T> comEntidades(final List<T> entidades) {
            this.entidades = entidades;
            return this;
        }

        public ResponseDto<T> build() {
            return new ResponseDto<>(this.entidades);
        }
    }

    public List<T> getEntidades() {
        return this.entidades;
    }

    public void setEntidades(final List<T> entidades) {
        this.entidades = entidades;
    }

    @SuppressWarnings("unchecked")
    public void add(final T obj) {
        if (obj instanceof Collection) {
            this.addAll((Collection<T>) obj);
        } else {
            this.entidades.add(obj);
        }
    }

    public void addAll(final Collection<T> objs) {
        this.entidades.addAll(objs);
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
