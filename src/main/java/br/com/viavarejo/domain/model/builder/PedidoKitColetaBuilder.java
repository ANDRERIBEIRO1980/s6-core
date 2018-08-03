package br.com.viavarejo.domain.model.builder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.viavarejo.domain.model.mongodb.filial.FilialPK;
import br.com.viavarejo.domain.model.mongodb.kitcoleta.PedidoKitColeta;
import br.com.viavarejo.domain.model.mongodb.pedido.Cliente;
import br.com.viavarejo.domain.model.mongodb.pedido.Volume;
import br.com.viavarejo.domain.model.mongodb.transportador.TransportadorPK;

public class PedidoKitColetaBuilder {

    private Long codigo;
    private BigDecimal valorFreteCliente;
    private String numeroPedidoEnvio;
    private Integer tipoPedidoEnvio;
    private String canalVenda;
    private Boolean isEntregaAgendada;
    private String metodoEntrega;
    private Date dataCriacao;
    private Date dataEstimadaEntrega;
    private TransportadorPK transportadorPK;
	private FilialPK embarcador;
    private final List<Volume> volumes;
    private Cliente cliente;
    private String diretorioArquivoDanfe;
    private String nomeArquivoDanfe;
    private String diretorioArquivoLaudo;
    private String nomeArquivoLaudo;

    private PedidoKitColetaBuilder() {
        this.volumes = new ArrayList<>();
    }

    public static PedidoKitColetaBuilder init() {
        return new PedidoKitColetaBuilder();
    }

    public PedidoKitColetaBuilder codigo(final Long codigo) {
        this.codigo = codigo;
        return this;
    }

    public PedidoKitColetaBuilder valorFreteDoCliente(final BigDecimal valorFreteCliente) {
        this.valorFreteCliente = valorFreteCliente;
        return this;
    }

    public PedidoKitColetaBuilder numeroPedidoEnvio(final String numeroPedidoEnvio) {
        this.numeroPedidoEnvio = numeroPedidoEnvio;
        return this;
    }

    public PedidoKitColetaBuilder tipoPedidoEnvio(final Integer tipoPedidoEnvio) {
        this.tipoPedidoEnvio = tipoPedidoEnvio;
        return this;
    }

    public PedidoKitColetaBuilder canalDeVenda(final String canalVenda) {
        this.canalVenda = canalVenda;
        return this;
    }

    public PedidoKitColetaBuilder entregaEhAgendada(final Boolean isEntregaAgendada) {
        this.isEntregaAgendada = isEntregaAgendada;
        return this;
    }

    public PedidoKitColetaBuilder metodoDeEntrega(final String modoEntrega) {
        this.metodoEntrega = modoEntrega;
        return this;
    }

    public PedidoKitColetaBuilder dataCriacao(final Date dataCriacao) {
        this.dataCriacao = dataCriacao;
        return this;
    }

    public PedidoKitColetaBuilder dataEstimadaDeEntrega(final Date dataEstimadaEntrega) {
        this.dataEstimadaEntrega = dataEstimadaEntrega;
        return this;
    }

    public PedidoKitColetaBuilder transportadora(final TransportadorPK transportadorPK) {
        this.transportadorPK = transportadorPK;
        return this;
    }

	public PedidoKitColetaBuilder embarcador(final FilialPK embarcador) {
        this.embarcador = embarcador;
        return this;
    }

    public PedidoKitColetaBuilder addVolume(final Volume volume) {
        this.volumes.add(volume);
        return this;
    }

    public PedidoKitColetaBuilder cliente(final Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public PedidoKitColetaBuilder diretorioArquivoDanfe(final String diretorioArquivoDanfe) {
        this.diretorioArquivoDanfe = diretorioArquivoDanfe;
        return this;
    }

    public PedidoKitColetaBuilder nomeArquivoDanfe(final String nomeArquivoDanfe) {
        this.nomeArquivoDanfe = nomeArquivoDanfe;
        return this;
    }

    public PedidoKitColetaBuilder diretorioArquivoLaudo(final String diretorioArquivoLaudo) {
        this.diretorioArquivoLaudo = diretorioArquivoLaudo;
        return this;
    }

    public PedidoKitColetaBuilder nomeArquivoLaudo(final String nomeArquivoLaudo) {
        this.nomeArquivoLaudo = nomeArquivoLaudo;
        return this;
    }

    public PedidoKitColeta build() {
        final PedidoKitColeta kit = new PedidoKitColeta();
        kit.setCodigo(this.codigo);
        kit.setValorFreteCliente(this.valorFreteCliente);
        kit.setNumeroPedidoEnvio(this.numeroPedidoEnvio);
        kit.setTipoPedidoEnvio(this.tipoPedidoEnvio);
        kit.setCanalVenda(this.canalVenda);
        kit.setEntregaAgendada(this.isEntregaAgendada);
        kit.setMetodoEntrega(this.metodoEntrega);
        kit.setDataCriacao(this.dataCriacao);
        kit.setDataEstimadaEntrega(this.dataEstimadaEntrega);
        kit.setTransportador(this.transportadorPK);
        kit.setEmbarcador(this.embarcador);
        kit.setVolumes(this.volumes);
        kit.setCliente(this.cliente);
        kit.setNomeArquivoDanfe(this.nomeArquivoDanfe);
        kit.setNomeArquivoLaudo(this.nomeArquivoLaudo);
        return kit;
    }


}
