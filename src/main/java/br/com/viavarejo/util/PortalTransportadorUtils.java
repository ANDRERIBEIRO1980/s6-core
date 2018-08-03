package br.com.viavarejo.util;

import static br.com.viavarejo.util.Utils.isEmpty;
import static br.com.viavarejo.util.Utils.isNotNull;
import static br.com.viavarejo.util.Utils.isNull;
import static br.com.viavarejo.util.Utils.preencherZerosEsquerda;

public class PortalTransportadorUtils {

    private static final String SEPARADOR_ID_EXTERNO = "X";
    private static final String ALFA_NUMERICO = "[^a-zA-Z0-9]+";

    /**
     * Numero de incricao padrao: 11.444.777/0001-XX; Resultado apos formatacao: 114447770001XX
     *
     */
    public static String formatarNumeroIncricao(final String inscricao, final String matriz, final String digito) {

        if (isNull(inscricao) || isNull(matriz) || isNull(digito)) {
            return "";
        }

        final StringBuilder sb = new StringBuilder();
        sb.append(preencherZerosEsquerda(inscricao.trim(), 8));
        sb.append(preencherZerosEsquerda(matriz.trim(), 4));
        sb.append(preencherZerosEsquerda(digito.trim(), 2));

        return sb.toString();
    }

    public static String formatarAlfaNumerico(final String entrada) {
        if (isNull(entrada) || isEmpty(entrada)) {
            return null;
        }
        return entrada.replaceAll(ALFA_NUMERICO, "");
    }

    /**
     * Concatena os valores informados, utilizando o toString dos parametros passados
     */
    public static String valoresConcatenados(final Object... entrada) {
        final StringBuilder sb = new StringBuilder(Utils.EMPTY);
        if (isNotNull(entrada)) {
            for (final Object obj : entrada) {
                sb.append(obj.toString().trim());
            }
        }
        return sb.toString();
    }

}
