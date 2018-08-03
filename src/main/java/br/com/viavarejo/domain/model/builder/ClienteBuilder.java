package br.com.viavarejo.domain.model.builder;

import br.com.viavarejo.domain.model.enumerator.TipoDocumentoEnum;
import br.com.viavarejo.domain.model.enumerator.TipoPessoaEnum;
import br.com.viavarejo.domain.model.mongodb.Contato;
import br.com.viavarejo.domain.model.mongodb.Endereco;
import br.com.viavarejo.domain.model.mongodb.pedido.Cliente;

public class ClienteBuilder {

    private TipoPessoaEnum tipoPessoa;
    private String nome;
    private String sobreNome;
    private TipoDocumentoEnum tipoDocumento;
    private String numeroDocumento;
    private boolean isCompany;
    private Contato contato;
    private Endereco endereco;

    private ClienteBuilder() {}

    public static ClienteBuilder init() {
        return new ClienteBuilder();
    }

    public ClienteBuilder tipoDePessoa(final TipoPessoaEnum tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
        return this;
    }

    public ClienteBuilder nome(final String nome) {
        this.nome = nome;
        return this;
    }

    public ClienteBuilder sobreNome(final String sobreNome) {
        this.sobreNome = sobreNome;
        return this;
    }

    public ClienteBuilder tipoDoDocumento(final TipoDocumentoEnum tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
        return this;
    }

    public ClienteBuilder numeroDoDocumento(final String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
        return this;
    }

    public ClienteBuilder company(final boolean isCompany) {
        this.isCompany = isCompany;
        return this;
    }

    public ClienteBuilder contato(final Contato contato) {
        this.contato = contato;
        return this;
    }

    public ClienteBuilder endereco(final Endereco endereco) {
        this.endereco = endereco;
        return this;
    }

    public Cliente build() {
        final Cliente cliente = new Cliente();
        cliente.setPessoa(this.tipoPessoa);
        cliente.setNome(this.nome);
        cliente.setSobreNome(this.sobreNome);
        cliente.setDocumento(this.tipoDocumento);
        cliente.setDocumentoCpfCnpj(this.numeroDocumento);
        cliente.setContato(this.contato);
        cliente.setEndereco(this.endereco);
        cliente.setIsCompany(this.isCompany);
        return cliente;
    }
}
