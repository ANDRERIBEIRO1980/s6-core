package br.com.viavarejo.infrastructure.converter;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import br.com.viavarejo.util.DateUtils;

public class DateSerializer extends StdSerializer<Date> {
    private static final long serialVersionUID = 1346144792712791935L;

    public DateSerializer() {
        super(Date.class);
    }

    @Override
    public void serialize(final Date value, final JsonGenerator generator, final SerializerProvider provider) throws IOException {
        generator.writeString(DateUtils.dateToString(value, DateUtils.FORMATO_BR_COMPLETO));

    }
}
