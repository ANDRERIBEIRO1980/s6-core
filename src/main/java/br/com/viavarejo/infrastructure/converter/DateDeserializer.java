package br.com.viavarejo.infrastructure.converter;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import br.com.viavarejo.util.DateUtils;

public class DateDeserializer extends StdDeserializer<Date> {
    private static final long serialVersionUID = -6828469631867881186L;

    protected DateDeserializer() {
        super(Date.class);
    }

    @Override
    public Date deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {
        final String as = parser.readValueAs(String.class);
        return DateUtils.toDateCompleto(as);
    }
}
