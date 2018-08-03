package br.com.viavarejo.domain.model.builder;

import br.com.viavarejo.domain.model.mongodb.Endereco;

public class EnderecoBuilder {

    private String logradouro;
    private String numero;
    private String referencia;
    private String bairro;
    private String cep;
    private String complemento;
    private String cidade;
    private String estado;
    private String pais;

    private EnderecoBuilder() {}

    public static EnderecoBuilder init() {
        return new EnderecoBuilder();
    }

    public EnderecoBuilder logradouro(final String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public EnderecoBuilder numero(final String numero) {
        this.numero = numero;
        return this;
    }

    public EnderecoBuilder referencia(final String referencia) {
        this.referencia = referencia;
        return this;
    }

    public EnderecoBuilder bairro(final String bairro) {
        this.bairro = bairro;
        return this;
    }

    public EnderecoBuilder cep(final String cep) {
        this.cep = cep;
        return this;
    }

    public EnderecoBuilder complemento(final String complemento) {
        this.complemento = complemento;
        return this;
    }

    public EnderecoBuilder cidade(final String cidade) {
        this.cidade = cidade;
        return this;
    }

    public EnderecoBuilder estado(final String estado) {
        this.estado = estado;
        return this;
    }

    public EnderecoBuilder pais(final String pais) {
        this.pais = pais;
        return this;
    }

    public Endereco build() {
        final Endereco obj = new Endereco();
        obj.setLogradouro(this.logradouro);
        obj.setNumero(this.numero);
        obj.setReferencia(this.referencia);
        obj.setBairro(this.bairro);
        obj.setCep(this.cep);
        obj.setComplemento(this.complemento);
        obj.setCidade(this.cidade);
        obj.setEstado(this.estado);
        obj.setPais(this.pais);
        return obj;
    }
}
