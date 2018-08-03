package br.com.viavarejo.infrastructure.converter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import br.com.viavarejo.util.DateUtils;

public class LocalDateDeserializer extends StdDeserializer<LocalDateTime> {

    private static final long serialVersionUID = -9030568132730770600L;

    protected LocalDateDeserializer() {
        super(LocalDate.class);
    }

    @Override
    public LocalDateTime deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {
        final String as = parser.readValueAs(String.class);
        return DateUtils.toLocalDateBr(as);
    }
}
