package br.com.viavarejo.domain.model.builder;

import br.com.viavarejo.domain.model.mongodb.transportador.ContatoTransportador;

public class ContatoTransportadorBuilder {

    private String email;
    private String telefone;
    private String nome;

    private ContatoTransportadorBuilder() {}

    public static ContatoTransportadorBuilder init() {
        return new ContatoTransportadorBuilder();
    }

    public ContatoTransportadorBuilder email(final String email) {
        this.email = email;
        return this;
    }

    public ContatoTransportadorBuilder telefone(final String telefone) {
        this.telefone = telefone;
        return this;
    }

    public ContatoTransportadorBuilder nome(final String nome) {
        this.nome = nome;
        return this;
    }

    public ContatoTransportador build() {
        final ContatoTransportador contato = new ContatoTransportador();
        contato.setNome(this.nome);
        contato.setEmail(this.email);
        contato.setTelefone(this.telefone);
        return contato;
    }
}
