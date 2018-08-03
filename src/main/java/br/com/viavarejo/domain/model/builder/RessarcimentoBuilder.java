package br.com.viavarejo.domain.model.builder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.viavarejo.domain.model.mongodb.cobranca.MercadoriaRessarcimento;
import br.com.viavarejo.domain.model.mongodb.cobranca.Ressarcimento;

public class RessarcimentoBuilder {

    private Long codigo;
    private String numeroPedidoEnvio;
    private Date dataCriacao;
    private String tipo;
    private String motivo;
    private String motivoCliente;
    private String tipoEntrega;
    private String codigoPontoControle;
    private String descricaoPontoControle;
    private String usuarioPontoControle;
    private Date dataReferenciaFiscal;
    private String referenciaFiscal;
    private String usuario;
    private String statusColeta;
    private Long codigoColeta;
    private Long codigoPedidoInformacao;
    private final List<MercadoriaRessarcimento> mercadorias = new ArrayList<>();

    private RessarcimentoBuilder() {}

    public static RessarcimentoBuilder init() {
        return new RessarcimentoBuilder();
    }

    public RessarcimentoBuilder codigo(final Long codigo) {
        this.codigo = codigo;
        return this;
    }

    public RessarcimentoBuilder numeroPedidoEnvio(final String numeroPedidoEnvio) {
        this.numeroPedidoEnvio = numeroPedidoEnvio;
        return this;
    }

    public RessarcimentoBuilder dataCriacao(final Date dataCriacao) {
        this.dataCriacao = dataCriacao;
        return this;
    }

    public RessarcimentoBuilder tipo(final String tipo) {
        this.tipo = tipo;
        return this;
    }

    public RessarcimentoBuilder motivo(final String motivo) {
        this.motivo = motivo;
        return this;
    }

    public RessarcimentoBuilder motivoCliente(final String motivoCliente) {
        this.motivoCliente = motivoCliente;
        return this;
    }

    public RessarcimentoBuilder tipoEntrega(final String tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
        return this;
    }

    public RessarcimentoBuilder codigoPontoControle(final String codigoPontoControle) {
        this.codigoPontoControle = codigoPontoControle;
        return this;
    }

    public RessarcimentoBuilder descricaoPontoControle(final String descricaoPontoControle) {
        this.descricaoPontoControle = descricaoPontoControle;
        return this;
    }

    public RessarcimentoBuilder usuarioPontoControle(final String usuarioPontoControle) {
        this.usuarioPontoControle = usuarioPontoControle;
        return this;
    }

    public RessarcimentoBuilder dataReferenciaFiscal(final Date dataReferenciaFiscal) {
        this.dataReferenciaFiscal = dataReferenciaFiscal;
        return this;
    }

    public RessarcimentoBuilder referenciaFiscal(final String referenciaFiscal) {
        this.referenciaFiscal = referenciaFiscal;
        return this;
    }

    public RessarcimentoBuilder usuario(final String usuario) {
        this.usuario = usuario;
        return this;
    }

    public RessarcimentoBuilder statusColeta(final String statusColeta) {
        this.statusColeta = statusColeta;
        return this;
    }

    public RessarcimentoBuilder codigoColeta(final Long codigoColeta) {
        this.codigoColeta = codigoColeta;
        return this;
    }

    public RessarcimentoBuilder codigoPedidoInformacao(final Long codigoPedidoInformacao) {
        this.codigoPedidoInformacao = codigoPedidoInformacao;
        return this;
    }

    public RessarcimentoBuilder mercadorias(final MercadoriaRessarcimento mercadoria) {
        this.mercadorias.add(mercadoria);
        return this;
    }

    public Ressarcimento build() {
        final Ressarcimento obj = new Ressarcimento();

        obj.setPk(this.codigo);
        obj.setNumeroPedidoEnvio(this.numeroPedidoEnvio);
        obj.setDataCriacao(this.dataCriacao);
        obj.setTipo(this.tipo);
        obj.setMotivo(this.motivo);
        obj.setMotivoCliente(this.motivoCliente);
        obj.setTipoEntrega(this.tipoEntrega);
        obj.setCodigoPontoControle(this.codigoPontoControle);
        obj.setDescricaoPontoControle(this.descricaoPontoControle);
        obj.setUsuarioPontoControle(this.usuarioPontoControle);
        obj.setDataReferenciaFiscal(this.dataReferenciaFiscal);
        obj.setReferenciaFiscal(this.referenciaFiscal);
        obj.setUsuario(this.usuario);
        obj.setStatusColeta(this.statusColeta);
        obj.setCodigoColeta(this.codigoColeta);
        obj.setCodigoPedidoInformacao(this.codigoPedidoInformacao);
        obj.setMercadorias(this.mercadorias);

        return obj;
    }

}
