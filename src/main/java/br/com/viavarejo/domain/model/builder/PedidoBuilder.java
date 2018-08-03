package br.com.viavarejo.domain.model.builder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.viavarejo.domain.model.mongodb.filial.FilialPK;
import br.com.viavarejo.domain.model.mongodb.pedido.Cliente;
import br.com.viavarejo.domain.model.mongodb.pedido.Complemento;
import br.com.viavarejo.domain.model.mongodb.pedido.Pedido;
import br.com.viavarejo.domain.model.mongodb.pedido.Volume;
import br.com.viavarejo.domain.model.mongodb.transportador.TransportadorPK;

public class PedidoBuilder {

    private final List<Volume> volumes = new ArrayList<>();
    private Long codigo;
    private String numeroPedidoEnvio;
    private Integer tipoPedidoEnvio;
    private Date dataDespacho;
    private TransportadorPK transportadorPK;
    private Cliente cliente;
    private Complemento complemento;
    private Date dataCriacao;
    private Boolean entregaAgendada;
    private FilialPK embarcador;
    private Date dataEstimadaEntrega;

    private PedidoBuilder() {}

    public static PedidoBuilder init() {
        return new PedidoBuilder();
    }

    public PedidoBuilder codigo(final Long codigo) {
        this.codigo = codigo;
        return this;
    }

    public PedidoBuilder numeroPedidoEnvio(final String numeroPedidoEnvio) {
        this.numeroPedidoEnvio = numeroPedidoEnvio;
        return this;
    }

    public PedidoBuilder tipoPedidoEnvio(final Integer tipoPedidoEnvio) {
        this.tipoPedidoEnvio = tipoPedidoEnvio;
        return this;
    }

    public PedidoBuilder dataDespacho(final Date dataDespacho) {
        this.dataDespacho = dataDespacho;
        return this;
    }

    public PedidoBuilder transportadora(final Integer codigoEmpresa, final Integer codigoFornecedor) {
        this.transportadorPK = new TransportadorPK(codigoEmpresa, codigoFornecedor);
        return this;
    }

    public PedidoBuilder embarcador(final FilialPK embarcador) {
        this.embarcador = embarcador;
        return this;
    }

    public PedidoBuilder embarcador(final Integer codigoEmpresa, final Integer codigo) {
        this.embarcador = new FilialPK(codigoEmpresa, codigo);
        return this;
    }

    public PedidoBuilder comCliente(final Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public PedidoBuilder complemento(final Complemento complemento) {
        this.complemento = complemento;
        return this;
    }

    public PedidoBuilder comVolume(final Volume volume) {
        this.volumes.add(volume);
        return this;
    }

    public PedidoBuilder dataCriacao(final Date dataCriacao) {
        this.dataCriacao = dataCriacao;
        return this;
    }

    public PedidoBuilder entregaAgendada(final Boolean entregaAgendada) {
        this.entregaAgendada = entregaAgendada;
        return this;
    }

    public PedidoBuilder dataEstimadaEntrega(final Date dataEstimadaEntrega) {
        this.dataEstimadaEntrega = dataEstimadaEntrega;
        return this;
    }

    public Pedido build() {
        final Pedido pedido = new Pedido();
        pedido.setPk(this.codigo);
        pedido.setNumeroPedidoEnvio(this.numeroPedidoEnvio);
        pedido.setTipoPedidoEnvio(tipoPedidoEnvio);
        pedido.setDataDespacho(this.dataDespacho);
        pedido.setTransportadorPk(this.transportadorPK);
        pedido.setEmbarcadorPk(this.embarcador);
        pedido.setCliente(this.cliente);
        pedido.setComplemento(this.complemento);
        pedido.setVolumes(this.volumes);
        pedido.setDataCriacao(this.dataCriacao);
        pedido.setEntregaAgendada(this.entregaAgendada);
        pedido.setDataEstimadaEntrega(this.dataEstimadaEntrega);
        return pedido;
    }
}
