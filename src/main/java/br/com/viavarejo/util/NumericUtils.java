package br.com.viavarejo.util;

import static br.com.viavarejo.util.Utils.isEmpty;
import static br.com.viavarejo.util.Utils.isNotEmpty;
import static br.com.viavarejo.util.Utils.isNotNull;
import static br.com.viavarejo.util.Utils.isNull;
import static br.com.viavarejo.util.Utils.isNumero;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class NumericUtils {

    public static final int SCALE = 6;
    public static final int SCALE_ZERO = 0;
    public static final int SCALE_MONETARIA = 2;
    public static final int SCALE_TOTAL = 10;

    public static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;
    public static final RoundingMode ROUNDING_MODE_DOWN = RoundingMode.DOWN;

    public static final BigDecimal UM = new BigDecimal("1");
    public static final BigDecimal DEZ = new BigDecimal("10");
    public static final BigDecimal CEM = new BigDecimal("100");

    private NumericUtils() {}

    public static BigDecimal converter(final Object value) {
        BigDecimal ret = null;
        if (value != null) {
            if (value instanceof BigDecimal) {
                ret = (BigDecimal) value;
            } else if (value instanceof String) {
                ret = new BigDecimal((String) value);
            } else if (value instanceof BigInteger) {
                ret = new BigDecimal((BigInteger) value);
            } else if (value instanceof Number) {
                ret = new BigDecimal(((Number) value).doubleValue());
            } else {
                throw new ClassCastException(
                                "Not possible to coerce [" + value + "] from class " + value.getClass() + " into a BigDecimal.");
            }
        }
        return ret;
    }

    public static Integer toInt(final BigDecimal value) {
        Integer retorno = null;
        if (value != null) {
            retorno = value.intValue();
        }
        return retorno;
    }

    public static Long toLong(final BigDecimal value) {
        Long retorno = null;
        if (value != null) {
            retorno = value.longValue();
        }
        return retorno;
    }

    public static Long toString(final String value) {
        Long retorno = null;
        if (value != null) {
            retorno = Long.valueOf(value);
        }
        return retorno;
    }

    // ESCALA NORMAL
    public static BigDecimal multiplicar(final BigDecimal multiplicando, final BigDecimal multiplicador) {
        return multiplicando.multiply(multiplicador).setScale(SCALE, ROUNDING_MODE);
    }

    public static BigDecimal dividir(final BigDecimal dividendo, final BigDecimal divisor) {
        return dividendo.divide(divisor, SCALE, ROUNDING_MODE);
    }

    public static BigDecimal porcentagem(final BigDecimal base, final BigDecimal porcentagem) {
        final BigDecimal valorPorcentagem = porcentagem.divide(CEM, SCALE, ROUNDING_MODE);
        return multiplicar(base, valorPorcentagem);
    }

    public static BigDecimal somar(final BigDecimal valor1, final BigDecimal valor2) {
        return valor1.add(valor2).setScale(SCALE, ROUNDING_MODE);
    }

    public static BigDecimal zero() {
        return BigDecimal.ZERO.setScale(SCALE, ROUNDING_MODE);
    }

    public static BigDecimal subtrair(final BigDecimal valor1, final BigDecimal valor2) {
        return valor1.subtract(valor2).setScale(SCALE, ROUNDING_MODE);
    }

    // ESCALA TOTAL
    public static BigDecimal multiplicarScale10(final BigDecimal multiplicando, final BigDecimal multiplicador) {
        return multiplicando.multiply(multiplicador).setScale(SCALE_TOTAL, ROUNDING_MODE);
    }

    public static BigDecimal dividirScale10(final BigDecimal dividendo, final BigDecimal divisor) {
        if (isEmpty(divisor)) {
            return bigDecimalScale10(dividendo);
        }
        return dividendo.divide(divisor, SCALE_TOTAL, ROUNDING_MODE);
    }

    public static BigDecimal porcentagemScale10(final BigDecimal base, final BigDecimal porcentagem) {
        final BigDecimal valorPorcentagem = porcentagem.divide(CEM, SCALE_TOTAL, ROUNDING_MODE);
        return multiplicarScale10(base, valorPorcentagem);
    }

    public static BigDecimal somarScale10(final BigDecimal valor1, final BigDecimal valor2) {
        return valor1.add(valor2).setScale(SCALE_TOTAL, ROUNDING_MODE);
    }

    public static BigDecimal zeroScale10() {
        return BigDecimal.ZERO.setScale(SCALE_TOTAL, ROUNDING_MODE);
    }

    public static BigDecimal subtrairScale10(final BigDecimal valor1, final BigDecimal valor2) {
        return valor1.subtract(valor2).setScale(SCALE_TOTAL, ROUNDING_MODE);
    }

    // ESCALA MONETÁRIA
    public static BigDecimal dividirMonetario(final BigDecimal dividando, final BigDecimal divisor) {
        return dividando.divide(divisor, SCALE_MONETARIA, ROUNDING_MODE);
    }

    public static BigDecimal multiplicarMonetario(final BigDecimal multiplicando, final BigDecimal multiplicador) {
        return multiplicando.multiply(multiplicador).setScale(SCALE_MONETARIA, ROUNDING_MODE);
    }

    public static BigDecimal multiplicarMonetarioRoundDown(final BigDecimal multiplicando, final BigDecimal multiplicador) {
        return multiplicando.multiply(multiplicador).setScale(SCALE_MONETARIA, ROUNDING_MODE_DOWN);
    }

    public static BigDecimal porcentagemMonetario(final BigDecimal base, final BigDecimal porcentagem) {
        final BigDecimal valorPorcentagem = porcentagem.divide(CEM, SCALE_TOTAL, ROUNDING_MODE);
        return multiplicar(base, valorPorcentagem).setScale(SCALE_MONETARIA, ROUNDING_MODE);
    }

    public static BigDecimal somarMonetario(final BigDecimal valor1, final BigDecimal valor2) {
        return valor1.add(valor2).setScale(SCALE_MONETARIA, ROUNDING_MODE);
    }

    public static BigDecimal zeroMonetario() {
        return BigDecimal.ZERO.setScale(SCALE_MONETARIA, ROUNDING_MODE);
    }

    public static BigDecimal cemMonetario() {
        return CEM.setScale(SCALE_MONETARIA, ROUNDING_MODE);
    }

    public static BigDecimal cemScale10() {
        return CEM.setScale(SCALE_TOTAL, ROUNDING_MODE);
    }

    public static BigDecimal dezScale10() {
        return DEZ.setScale(SCALE_TOTAL, ROUNDING_MODE);
    }

    public static BigDecimal umScale10() {
        return UM.setScale(SCALE_TOTAL, ROUNDING_MODE);
    }

    public static BigDecimal subtrairMonetario(final BigDecimal valor1, final BigDecimal valor2) {
        if (isEmpty(valor1)) {
            return zeroMonetario().subtract(valor2).setScale(SCALE_MONETARIA, ROUNDING_MODE);
        }
        return valor1.subtract(valor2).setScale(SCALE_MONETARIA, ROUNDING_MODE);
    }

    public static boolean isMaiorQue(final Number maior, final Number menor) {
        return isMaiorQue(maior, menor, null);
    }

    public static boolean isMaiorQue(final Number maior, final Number menor, final Integer scale) {
        return isMaiorQue(maior, menor, scale, RoundingMode.FLOOR);
    }

    public static boolean isMaiorQue(final Number maior, final Number menor, final Integer scale, final RoundingMode round) {
        if (isNull(maior) || isNull(menor)) {
            return maior == menor;
        }
        return compare(maior, menor, scale, round) > 0;
    }

    public static boolean isMaiorQueOuIgual(final Number maior, final Number menor) {
        return isMaiorQueOuIgual(maior, menor, null);
    }

    public static boolean isMaiorQueOuIgual(final Number maior, final Number menor, final Integer scale) {
        return isMaiorQueOuIgual(maior, menor, scale, RoundingMode.FLOOR);
    }

    public static boolean isMaiorQueOuIgual(final Number maior, final Number menor, final Integer scale, final RoundingMode round) {
        if (isNull(maior) || isNull(menor)) {
            return maior == menor;
        }
        return (compare(maior, menor, scale, round) > 0) || (compare(maior, menor, scale, round) == 0);
    }

    public static boolean isMenorQue(final Number menor, final Number maior) {
        return isMenorQue(menor, maior, null);
    }

    public static boolean isMenorQue(final Number menor, final Number maior, final Integer scale) {
        return isMenorQue(menor, maior, scale, RoundingMode.FLOOR);
    }

    public static boolean isMenorQue(final Number menor, final Number maior, final Integer scale, final RoundingMode round) {
        if (isNull(maior) || isNull(menor)) {
            return maior == menor;
        }
        return compare(menor, maior, scale, round) < 0;
    }

    public static boolean isMenorQueOuIgual(final Number menor, final Number maior) {
        return isMenorQueOuIgual(menor, maior, null);
    }

    public static boolean isMenorQueOuIgual(final Number menor, final Number maior, final Integer scale) {
        return isMenorQueOuIgual(menor, maior, scale, RoundingMode.FLOOR);
    }

    public static boolean isMenorQueOuIgual(final Number menor, final Number maior, final Integer scale, final RoundingMode round) {
        if (isNull(maior) || isNull(menor)) {
            return maior == menor;
        }
        return (compare(menor, maior, scale, round) < 0) || (compare(menor, maior, scale, round) == 0);
    }

    public static boolean isEntre(final Number numero, final Number inferior, final Number superior) {
        return isEntre(numero, inferior, superior, null);
    }

    public static boolean isEntre(final Number numero, final Number inferior, final Number superior, final Integer scale) {
        return isEntre(numero, inferior, superior, scale, RoundingMode.FLOOR);
    }

    public static boolean isEntre(final Number numero, final Number inferior, final Number superior, final Integer scale,
                    final RoundingMode round) {
        return isMaiorQue(numero, inferior, scale, round) && isMenorQue(numero, superior, scale, round);
    }

    public static boolean isIgual(final Number numero, final Number numero2) {
        return isIgual(numero, numero2, null);
    }

    public static boolean isIgual(final Number numero, final Number numero2, final Integer scale) {
        return isIgual(numero, numero2, scale, RoundingMode.FLOOR);
    }

    public static boolean isIgual(final Number numero, final Number numero2, final Integer scale, final RoundingMode round) {
        if (isNull(numero) || isNull(numero2)) {
            return numero == numero2;
        }

        return compare(numero, numero2, scale, round) == 0;
    }

    public static BigDecimal validaZero(final BigDecimal numero) {
        if (isEmpty(numero)) {
            return zero();
        }
        return numero;
    }

    public static BigDecimal validaZeroMonetario(final BigDecimal numero) {
        if (isEmpty(numero)) {
            return zeroMonetario();
        }
        return numero;
    }

    public static BigDecimal validaZeroScale10(final BigDecimal numero) {
        if (isEmpty(numero)) {
            return zeroScale10();
        }
        return bigDecimalScale10(numero);
    }

    private static int compare(final Number numero, final Number numero2, final Integer scale, final RoundingMode round) {

        BigDecimal valor = BigDecimal.valueOf(numero.doubleValue());
        BigDecimal valor2 = BigDecimal.valueOf(numero2.doubleValue());

        if (isNotNull(scale)) {
            valor = valor.setScale(scale, round);
            valor2 = valor2.setScale(scale, round);
        }

        return valor.compareTo(valor2);
    }

    public static String formatarMonetario(final BigDecimal valor) {
        final DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale("pt", "BR"));
        final DecimalFormat df = new DecimalFormat("#,##0.00", dfs);

        return df.format(valor);
    }

    public static String formatarSemMonetario(final BigDecimal valor) {
        final DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale("pt", "BR"));
        final DecimalFormat df = new DecimalFormat("#,##0", dfs);

        return df.format(valor);
    }

    public static String formatarScale10(final BigDecimal valor) {
        final DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale("pt", "BR"));
        final DecimalFormat df = new DecimalFormat("#,##0.0000000000", dfs);

        return df.format(valor);
    }

    public static BigDecimal bigDecimal(final String valor) {
        return new BigDecimal(valor).setScale(SCALE_MONETARIA, ROUNDING_MODE);
    }

    public static BigDecimal bigDecimalScale10(final String valor) {
        return new BigDecimal(valor).setScale(SCALE_TOTAL, ROUNDING_MODE);
    }

    public static Integer integer(final String valor) {

        if (isNumero(valor)) {
            return Integer.valueOf(valor);
        }

        return Integer.valueOf(0);
    }

    public static BigDecimal bigDecimalScale0(final BigDecimal valor) {
        if (isNotEmpty(valor)) {
            return valor.setScale(SCALE_ZERO, ROUNDING_MODE);
        }
        return BigDecimal.ZERO.setScale(SCALE_ZERO, ROUNDING_MODE);
    }

    public static BigDecimal bigDecimalScale0(final Long valor) {
        if (isNotEmpty(valor)) {
            return bigDecimalScale0(BigDecimal.valueOf(valor));
        }
        return BigDecimal.ZERO.setScale(SCALE_ZERO, ROUNDING_MODE);
    }

    public static BigDecimal bigDecimalScale10(final BigDecimal valor) {
        if (isNotEmpty(valor)) {
            return valor.setScale(SCALE_TOTAL, ROUNDING_MODE);
        }
        return zeroScale10();
    }

    public static BigDecimal bigDecimalScale10(final Long valor) {
        if (isNotEmpty(valor)) {
            return bigDecimalScale10(BigDecimal.valueOf(valor));
        }
        return zeroScale10();
    }

    public static BigDecimal multiplicarPorCemEmScale10(final BigDecimal valor) {
        return isNotEmpty(valor) ? multiplicarScale10(valor, cemScale10()) : zeroScale10();
    }

    public static BigDecimal dividirPorCemEmScale10(final BigDecimal valor) {
        return isNotEmpty(valor) ? dividirScale10(valor, cemScale10()) : zeroScale10();
    }

    public static BigDecimal bigDecimalMonetario(final BigDecimal valor) {
        return valor.setScale(SCALE_MONETARIA, ROUNDING_MODE);
    }

    public static BigDecimal multiplicarPorCemMonetario(final BigDecimal valor) {
        return isNotEmpty(valor) ? multiplicarMonetario(valor, cemMonetario()) : zeroMonetario();
    }

    public static <T extends Number> T ifNull(final T valor, final T valorDefault) {
        if (isEmpty(valor)) {
            return valorDefault;
        }
        return valor;
    }

    public static BigDecimal doubleToBigDecimal(final Double doubleValue) {
        if (isEmpty(doubleValue)) {
            return zeroMonetario();
        }
        return bigDecimalMonetario(BigDecimal.valueOf(doubleValue));
    }

}
