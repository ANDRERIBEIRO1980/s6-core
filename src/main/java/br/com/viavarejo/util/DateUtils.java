package br.com.viavarejo.util;

import static java.util.Objects.isNull;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

    private static final String AMERICA_SAO_PAULO = "America/Sao_Paulo";

    public static final String FORMATO_HORA = "HH:mm:ss";

    public static final String FORMATO_BR_DATA = "dd/MM/yyyy";
	public static final String FORMATO_BR_COMPLETO = "dd/MM/yyyy HH:mm:ss";

    public static final String FORMATO_DB_COMPLETO = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMATO_DB_DATA = "yyyy-MM-dd";
    public static final String FORMATO_DB_HORA = "HH:mm:ss";

    public static final String FORMATO_ISO_COMPLETO = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public static Date asDate(final LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date asDate(final LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static String dateToDBHour(final Date date) {
        return dateToString(date, FORMATO_HORA);
    }

    public static LocalDateTime toLocalDateFromDB(final String data) {
        return toLocalDateTime(data, FORMATO_DB_COMPLETO);
    }

    public static LocalDateTime toLocalDateFromDB(final String data, final String hora) {
        return toLocalDateTime(data.concat(" ").concat(hora), FORMATO_DB_COMPLETO);
    }

    public static String dateToString(final Date date, final String format) {
        return new SimpleDateFormat(format).format(date);
    }

    public static String getDateFormat(final Date value, final String pattern) {
        if (isNull(value)) {
            return null;
        }
        final LocalDateTime dateTime = LocalDateTime.ofInstant(value.toInstant(), ZoneId.of(AMERICA_SAO_PAULO));
        return dateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDateTime toLocalDateTime(final String data, String format) {
        if (isNull(data) || data.isEmpty()) {
            return null;
        }
        if (isNull(format)) {
            format = FORMATO_BR_COMPLETO;
        }
        return LocalDateTime.parse(data, DateTimeFormatter.ofPattern(format));
    }

    // LOCAL DATE TIME

    public static LocalDateTime toLocalDateBr(final String data) {
        if (isNull(data)) {
            return null;
        }
        return toLocalDateTime(data, FORMATO_BR_DATA);
    }

    public static LocalDateTime toLocalDate(final String data) {
        if (isNull(data)) {
            return null;
        }
        return toLocalDateTime(data, FORMATO_DB_DATA);
    }

    // DATE

    public static Date toDateCompleto(final String data) {
        return asDate(toLocalDateTime(data, FORMATO_BR_COMPLETO));
    }

    public static Date toDate(final String data) {
        return asDate(toLocalDateTime(data, FORMATO_BR_DATA));
    }

    /**
     * Data e hora atual no {@link ZoneId} <code>America/Sao_Paulo</code>
     *
     * @return data e hora atual
     */
    public static LocalDateTime currentLocalDateTimeBr() {
        return LocalDateTime.now(ZoneId.of(AMERICA_SAO_PAULO));
    }

    /**
     * Data atual no {@link ZoneId} <code>America/Sao_Paulo</code>
     *
     * @return data atual
     */
    public static Date currentDateBr() {
        final Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(ZoneId.of(AMERICA_SAO_PAULO)));
        return calendar.getTime();
    }
}
