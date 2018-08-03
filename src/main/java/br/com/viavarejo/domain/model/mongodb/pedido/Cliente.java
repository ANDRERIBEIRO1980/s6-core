package br.com.viavarejo.domain.model.mongodb.pedido;

import static br.com.viavarejo.util.Utils.isNull;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.viavarejo.domain.DomainObject;
import br.com.viavarejo.domain.model.enumerator.TipoDocumentoEnum;
import br.com.viavarejo.domain.model.enumerator.TipoPessoaEnum;
import br.com.viavarejo.domain.model.mongodb.Contato;
import br.com.viavarejo.domain.model.mongodb.Endereco;
import io.swagger.annotations.ApiModelProperty;

public class Cliente implements DomainObject<Cliente> {
    private static final long serialVersionUID = 6861803555132997297L;

    @ApiModelProperty(notes = "Identifica se o cliente é uma empresa ou uma pessoa - PJ|PF", required = true)
	@NotNull
	@Enumerated(EnumType.STRING)
    private TipoPessoaEnum pessoa;

    @ApiModelProperty(notes = "Quando TipoPessoa = PJ: Razão Social. Quando TipoPessoa = PF: Nome", required = true)
	@NotBlank
    private String nome;

	@ApiModelProperty(notes = "Quando TipoPessoa = PJ: Razão Social. Quando TipoPessoa = PF: SobreNome", required = true)
	@NotBlank
	private String sobreNome;

	@ApiModelProperty(notes = "Indica se a empresa ou não", required = false)
	private Boolean isCompany;

    @ApiModelProperty(notes = "Quando TipoPessoa = PJ: CNPJ. Quando TipoPessoa = PF: CPF", required = true)
	@NotNull
	@Enumerated(EnumType.STRING)
    private TipoDocumentoEnum documento;

	@ApiModelProperty(notes = "Quando TipoPessoa = PJ: CNPJ. Quando TipoPessoa = PF: CPF", required = true)
	@NotBlank
	private String documentoCpfCnpj;

    @ApiModelProperty(notes = "Somente deve ser preenchido quando TipoPessoa = PJ")
    private String inscricaoEstadual;

	@ApiModelProperty(notes = "Contato do Cliente", required = true)
	@Valid
	private Contato contato;

    @ApiModelProperty(notes = "Endereço do Cliente", required = true)
	@Valid
    private Endereco endereco;

    public Cliente() {
        super();
        this.pessoa = TipoPessoaEnum.PF;
    }

    public TipoPessoaEnum getPessoa() {
        return this.pessoa;
    }

    public void setPessoa(final TipoPessoaEnum pessoa) {
        this.pessoa = isNull(pessoa) ? TipoPessoaEnum.PF : pessoa;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public Contato getContato() {
        return this.contato;
    }

    public void setContato(final Contato contato) {
        this.contato = contato;
    }

    public TipoDocumentoEnum getDocumento() {
        return this.documento;
    }

    public void setDocumento(final TipoDocumentoEnum documento) {
        this.documento = documento;
    }

    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }

    public void setInscricaoEstadual(final String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(final Endereco endereco) {
        this.endereco = endereco;
    }

	public String getSobreNome() {
		return this.sobreNome;
	}

	public void setSobreNome(final String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public Boolean getIsCompany() {
		return this.isCompany;
	}

	public void setIsCompany(final Boolean isCompany) {
		this.isCompany = isCompany;
	}

	public String getDocumentoCpfCnpj() {
		return this.documentoCpfCnpj;
	}

	public void setDocumentoCpfCnpj(final String documentoCpfCnpj) {
		this.documentoCpfCnpj = documentoCpfCnpj;
	}

	@Override
	public String toString() {
		return "Cliente [pessoa=" + this.pessoa + ", nome=" + this.nome + ", sobreNome=" + this.sobreNome
				+ ", isCompany=" + this.isCompany + ", contato=" + this.contato + ", documento=" + this.documento
				+ ", documentoCpfCnpj=" + this.documentoCpfCnpj + ", inscricaoEstadual=" + this.inscricaoEstadual
				+ ", endereco=" + this.endereco + "]";
	}



}
