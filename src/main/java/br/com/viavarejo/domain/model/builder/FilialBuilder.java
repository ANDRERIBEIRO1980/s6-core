package br.com.viavarejo.domain.model.builder;

import java.util.Date;

import br.com.viavarejo.domain.model.mongodb.Contato;
import br.com.viavarejo.domain.model.mongodb.Endereco;
import br.com.viavarejo.domain.model.mongodb.filial.Filial;
import br.com.viavarejo.domain.model.mongodb.filial.FilialPK;

public class FilialBuilder {

    private Integer codigo;
    private Integer codigoEmpresa;
    private String cnpj;
    private Date dataCriacao;
    private String nome;
    private String razaoSocial;
    private Endereco endereco;
    private Contato contato;

    private FilialBuilder() {}

    public static FilialBuilder init() {
        return new FilialBuilder();
    }

    public FilialBuilder codigoEmpresa(final Integer codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
        return this;
    }

    public FilialBuilder codigo(final Integer codigo) {
        this.codigo = codigo;
        return this;
    }

    public FilialBuilder cnpj(final String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public FilialBuilder dataCriacao(final Date dataCriacao) {
        this.dataCriacao = dataCriacao;
        return this;
    }

    public FilialBuilder nome(final String nome) {
        this.nome = nome;
        return this;
    }

    public FilialBuilder razaoSocial(final String razaoSocial) {
        this.razaoSocial = razaoSocial;
        return this;
    }

    public FilialBuilder endereco(final Endereco endereco) {
        this.endereco = endereco;
        return this;
    }

    public FilialBuilder contato(final Contato contato) {
        this.contato = contato;
        return this;
    }

    public Filial build() {
        final Filial filial = new Filial();
        filial.setContato(this.contato);
        filial.setEndereco(this.endereco);
        filial.setPk(new FilialPK(this.codigoEmpresa, this.codigo));
        filial.setCnpj(this.cnpj);
        filial.setDataCriacao(this.dataCriacao);
        filial.setNome(this.nome);
        filial.setRazaoSocial(this.razaoSocial);
        return filial;
    }
}
