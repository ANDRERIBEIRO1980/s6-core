package br.com.viavarejo.util;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static final String EMPTY = "";

    private Utils() {}

    public static boolean not(final boolean condicao) {
        return !condicao;
    }

    public static boolean isNull(final Object object) {
        return object == null;
    }

    public static boolean isNotNull(final Object object) {
        return not(isNull(object));
    }

    public static boolean isEmpty(final Object obj) {
        if (obj instanceof Collection<?>) {
            return isEmptyCollection((Collection<?>) obj);
        }
        if (obj instanceof String) {
            return isEmptyString((String) obj);
        }
        if (obj instanceof Number) {
            return isEmptyNumber((Number) obj);
        }
        if (obj instanceof Map<?, ?>) {
            return isEmptyMap((Map<?, ?>) obj);
        }
        return isNull(obj);
    }

    public static boolean isNotNullAndNotEmpty(final Object object) {
        return isNotNull(object) && isNotEmpty(object);
    }

    private static boolean isEmptyCollection(final Collection<?> list) {
        return list.isEmpty();
    }

    private static boolean isEmptyMap(final Map<?, ?> map) {
        return map.isEmpty();
    }

    private static boolean isEmptyString(final String value) {
        return value.isEmpty();
    }

    private static boolean isEmptyNumber(final Number number) {
        return Double.doubleToRawLongBits(number.doubleValue()) == 0;
    }

    public static boolean isNotEmpty(final Object obj) {
        return not(isEmpty(obj));
    }

    public static boolean isNullOrEmpty(final Object obj) {
        return isNull(obj) || isEmpty(obj);
    }

    public static String preencherZerosEsquerda(final String numero, final int quantidade) {
        return padLeft(numero, '0', quantidade);
    }

    public static String preencherZerosEsquerda(final Number numero, final int quantidade) {
        return padLeft(String.valueOf(numero), '0', quantidade);
    }

    public static String padLeft(final Object valor, final char caractere, final int quantidade) {
        return padLeft(String.valueOf(valor), caractere, quantidade);
    }

    public static String padLeft(final String valor, final char caractere, final int quantidade) {

        final StringBuilder builder = new StringBuilder();

        if (isNull(valor)) {
            return padLeft("", caractere, quantidade);
        }

        if (valor.length() < quantidade) {
            final int diferenca = quantidade - valor.length();

            for (int i = 0; i < diferenca; i++) {
                builder.append(caractere);
            }
        }

        builder.append(valor);

        return builder.toString();
    }

    public static String preencherZerosDireita(final String numero, final int quantidade) {
        return padRigth(numero, '0', quantidade);
    }

    public static String padRigth(final String valor, final char caractere, final int quantidade) {
        final StringBuilder builder = new StringBuilder(converterString(valor));

        for (int i = builder.length(); i < quantidade; i++) {
            builder.append(caractere);
        }

        return builder.toString();
    }

    public static String converterString(final Object objeto) {
        if (isNull(objeto)) {
            return "";
        }
        return objeto.toString();
    }

    public static final String subString(final String str, final int offset, final int tamanho) {
        final int end = offset + tamanho;

        if (not(isNull(str)) && (str.length() >= offset)) {
            if (str.length() > end) {
                return str.substring(offset, end);
            }
            return str.substring(offset);
        }
        return null;
    }

    public static boolean isNumero(final String valor) {

        if (isNotEmpty(valor)) {

            final Pattern pattern = Pattern.compile("[0-9]+");
            final Matcher matcher = pattern.matcher(valor);

            return matcher.matches();
        }

        return false;
    }

    public static <T> T ifNull(final T obj, final T retorno) {
        return isNull(obj) ? retorno : obj;
    }
}
