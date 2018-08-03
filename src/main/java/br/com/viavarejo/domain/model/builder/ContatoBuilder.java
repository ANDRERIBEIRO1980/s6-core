package br.com.viavarejo.domain.model.builder;

import br.com.viavarejo.domain.model.mongodb.Contato;

public class ContatoBuilder {

    private String email;
    private String telefoneMovel;
    private String telefoneFixo;

    private ContatoBuilder() {}

    public static ContatoBuilder init() {
        return new ContatoBuilder();
    }

    public ContatoBuilder email(final String email) {
        this.email = email;
        return this;
    }

    public ContatoBuilder telefoneMovel(final String telefoneMovel) {
        this.telefoneMovel = telefoneMovel;
        return this;
    }

    public ContatoBuilder telefoneFixo(final String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
        return this;
    }

    public Contato build() {
        final Contato obj = new Contato();
        obj.setEmail(this.email);
        obj.setTelefoneMovel(this.telefoneMovel);
        obj.setTelefoneFixo(this.telefoneFixo);
        return obj;
    }
}
