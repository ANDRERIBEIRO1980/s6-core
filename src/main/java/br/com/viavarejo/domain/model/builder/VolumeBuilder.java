package br.com.viavarejo.domain.model.builder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.viavarejo.domain.model.enumerator.TipoVolumeEnum;
import br.com.viavarejo.domain.model.mongodb.pedido.Mercadoria;
import br.com.viavarejo.domain.model.mongodb.pedido.NotaFiscal;
import br.com.viavarejo.domain.model.mongodb.pedido.Volume;

public class VolumeBuilder {

    private Integer id;
    private String nomeVolume;
    private TipoVolumeEnum tipoVolume;
    private BigDecimal peso;
    private BigDecimal largura;
    private BigDecimal altura;
    private BigDecimal comprimento;
    private String naturezaProduto;
    private Integer quantidade;
    private boolean icmsIsento;

    private NotaFiscal notaFiscal;

    private final List<Mercadoria> mercadorias = new ArrayList<>();

    private VolumeBuilder() {}

    public static VolumeBuilder init() {
        return new VolumeBuilder();
    }

    public VolumeBuilder id(final Integer id) {
        this.id = id;
        return this;
    }

    public VolumeBuilder nome(final String nomeVolume) {
        this.nomeVolume = nomeVolume;
        return this;
    }

    public VolumeBuilder tipo(final TipoVolumeEnum tipoVolume) {
        this.tipoVolume = tipoVolume;
        return this;
    }

    public VolumeBuilder peso(final BigDecimal peso) {
        this.peso = peso;
        return this;
    }

    public VolumeBuilder largura(final BigDecimal largura) {
        this.largura = largura;
        return this;
    }

    public VolumeBuilder altura(final BigDecimal altura) {
        this.altura = altura;
        return this;
    }

    public VolumeBuilder comprimento(final BigDecimal comprimento) {
        this.comprimento = comprimento;
        return this;
    }

    public VolumeBuilder naturezaDoProduto(final String naturezaProduto) {
        this.naturezaProduto = naturezaProduto;
        return this;
    }

    public VolumeBuilder quantidade(final Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public VolumeBuilder icmsIsento(final boolean icmsIsento) {
        this.icmsIsento = icmsIsento;
        return this;
    }

    public VolumeBuilder notaFiscal(final NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
        return this;
    }

    public VolumeBuilder mercadoria(final Mercadoria mercadoria) {
        this.mercadorias.add(mercadoria);
        return this;
    }

    public Volume build() {
        final Volume volume = new Volume();

        volume.setId(this.id);
        volume.setNome(this.nomeVolume);
        volume.setTipo(this.tipoVolume);
        volume.setPeso(this.peso);
        volume.setLargura(this.largura);
        volume.setAltura(this.altura);
        volume.setComprimento(this.comprimento);
        volume.setNaturezaProduto(this.naturezaProduto);
        volume.setQuantidadeProduto(this.quantidade);
        volume.setIcmsIsento(this.icmsIsento);

        volume.setNotaFiscal(this.notaFiscal);

        volume.setMercadorias(this.mercadorias);

        return volume;
    }

}
