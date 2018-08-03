package br.com.viavarejo.domain.model.builder;

import static br.com.viavarejo.util.Utils.isNotNull;

import br.com.viavarejo.domain.model.enumerator.TipoAcaoRegistroEnum;
import br.com.viavarejo.domain.model.mongodb.transportador.ContatoTransportador;
import br.com.viavarejo.domain.model.mongodb.transportador.Transportador;
import br.com.viavarejo.domain.model.mongodb.transportador.TransportadorPK;

public class TransportadorBuilder {

    private Integer codigoEmpresa;
    private Integer codigo;

    private ContatoTransportador contatoComercial;
    private ContatoTransportador contatoResponsavel;
    private String nomeArquivoOriginal;
    private String nomeArquivoGeradoZip;
    private String file1ZipBase64;
    private String cnpj;
    private String razaoSocial;
    private int codigoFuncionario;
    private TipoAcaoRegistroEnum tipoAcao;

    private TransportadorBuilder() {}

    public static TransportadorBuilder init() {
        return new TransportadorBuilder();
    }

    public TransportadorBuilder codigoEmpresa(final Integer codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
        return this;
    }

    public TransportadorBuilder codigo(final Integer codigo) {
        this.codigo = codigo;
        return this;
    }

    public TransportadorBuilder contatoComercial(final ContatoTransportador contato) {
        this.contatoComercial = contato;
        return this;
    }

    public TransportadorBuilder contatoResponsavel(final ContatoTransportador contato) {
        this.contatoResponsavel = contato;
        return this;
    }

    public TransportadorBuilder nomeArquivoOriginal(final String nomeArquivoOriginal) {
        this.nomeArquivoOriginal = nomeArquivoOriginal;
        return this;
    }

    public TransportadorBuilder nomeArquivoGeradoZip(final String nomeArquivoGeradoZip) {
        this.nomeArquivoGeradoZip = nomeArquivoGeradoZip;
        return this;
    }

    public TransportadorBuilder file1ZipBase64(final String file1ZipBase64) {
        this.file1ZipBase64 = file1ZipBase64;
        return this;
    }

    public TransportadorBuilder cnpj(final String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public TransportadorBuilder razaoSocial(final String razaoSocial) {
        this.razaoSocial = razaoSocial;
        return this;
    }

    public TransportadorBuilder codigoFuncionarioCasasBahia(final int codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
        return this;
    }

    public TransportadorBuilder tipoAcao(final TipoAcaoRegistroEnum tipoAcao) {
        this.tipoAcao = tipoAcao;
        return this;
    }

    public Transportador build() {

        final Transportador obj = new Transportador();
        final TransportadorPK pk = new TransportadorPK(this.codigoEmpresa, this.codigo);

        obj.setPk(pk);
        obj.setRazaoSocial(this.razaoSocial);
        obj.setCodigoFuncionarioCasasBahia(this.codigoFuncionario);
        obj.setContatoComercial(this.contatoComercial);
        obj.setNomeArquivoOriginal(this.nomeArquivoOriginal);
        obj.setNomeArquivoGeradoZip(this.nomeArquivoGeradoZip);
        obj.setFile1ZipBase64(this.file1ZipBase64);
        obj.setCnpj(this.cnpj);
        obj.setContatoComercial(this.contatoComercial);
        obj.setContatoResponsavel(this.contatoResponsavel);
        obj.setTipoAcao(this.tipoAcao);
        obj.setCodigoIntegrado(this.getCodigoIntegrado());

        return obj;
    }

    private String getCodigoIntegrado() {
        return isNotNull(this.codigoEmpresa) && isNotNull(this.codigo) ? String.valueOf(this.codigoEmpresa).concat(String.valueOf(
                        this.codigo)) : null;
    }
}
